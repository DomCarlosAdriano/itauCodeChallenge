package com.itauCodeChallenge.itauCodeChallenge.controller;

import com.itauCodeChallenge.itauCodeChallenge.business.services.TrasacaoService;
import com.itauCodeChallenge.itauCodeChallenge.controller.dtos.TransacaoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;


@RestController
@RequestMapping("/transacao")
public class TrasacaoController {


    @Autowired
    private TrasacaoService trasacaoService;


    @PostMapping
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto){

        System.out.println(dto);

        trasacaoService.adicionarTransacoes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

   @DeleteMapping
    public ResponseEntity<Void> deletarTransacoes(){
        trasacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
   }

   @GetMapping
   public List<TransacaoRequestDTO> listar(){
        return trasacaoService.exibir();
   }
}
