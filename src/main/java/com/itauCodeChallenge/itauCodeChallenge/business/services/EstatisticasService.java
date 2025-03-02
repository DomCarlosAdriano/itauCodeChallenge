package com.itauCodeChallenge.itauCodeChallenge.business.services;

import com.itauCodeChallenge.itauCodeChallenge.controller.dtos.EstatisticasResponseDTO;
import com.itauCodeChallenge.itauCodeChallenge.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasService {
    public final TrasacaoService trasacaoService;


    public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca){
       List<TransacaoRequestDTO> trasacoes = trasacaoService.buscarTransacoes(intervaloBusca);

       DoubleSummaryStatistics estatisticasTrasacoes = trasacoes.stream()
               .mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        return new EstatisticasResponseDTO(estatisticasTrasacoes.getCount(),
                estatisticasTrasacoes.getSum(), estatisticasTrasacoes.getAverage(),
                estatisticasTrasacoes.getMin(), estatisticasTrasacoes.getMax());
    }
}
