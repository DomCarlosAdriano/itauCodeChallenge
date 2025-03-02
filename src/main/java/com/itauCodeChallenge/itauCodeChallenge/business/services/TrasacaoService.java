package com.itauCodeChallenge.itauCodeChallenge.business.services;

import com.itauCodeChallenge.itauCodeChallenge.controller.dtos.TransacaoRequestDTO;
import com.itauCodeChallenge.itauCodeChallenge.infrastructure.exeptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrasacaoService {

    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto){
       log.info("Iniciado o processamento de gravar trasaçao");

        if (dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Data e hora maiores que a data atual");
            throw new UnprocessableEntity("Data e hora maiores que a data atual");
        }

        if(dto.valor() < 0){
            log.error("Valor não pode ser menor que zero");
            throw new UnprocessableEntity("Valor não pode ser menor que zero");
        }

        listaTransacoes.add(dto);
    }

    public void limparTransacoes(){
        listaTransacoes.clear();
    }
}
