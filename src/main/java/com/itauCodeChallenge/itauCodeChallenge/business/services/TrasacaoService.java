package com.itauCodeChallenge.itauCodeChallenge.business.services;

import com.itauCodeChallenge.itauCodeChallenge.controller.dtos.TransacaoRequestDTO;
import com.itauCodeChallenge.itauCodeChallenge.infrastructure.exeptions.UnprocessableEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class TrasacaoService {

    private List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto){

        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            throw new UnprocessableEntity("Data e hora maiores que a data e hora atuais");
        }
        if(dto.valor() < 0){
            throw new UnprocessableEntity("Valor não pode ser menor que 0");
        }


        listaTransacoes.add(dto);
    }

    public void limparTransacoes(){
        listaTransacoes.clear();

    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca){
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);
        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo)).toList();
    }

    public List<TransacaoRequestDTO> exibir(){
        return listaTransacoes;
    }
}
