package com.itauCodeChallenge.itauCodeChallenge.controller.dtos;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(Double valor, OffsetDateTime dataHora ) {
}
