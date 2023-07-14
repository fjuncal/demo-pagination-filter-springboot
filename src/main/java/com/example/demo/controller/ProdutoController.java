package com.example.demo.controller;

import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> list(Pageable pageable){

        return new ResponseEntity<>(produtoRepository.findAll(pageable), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listaToda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listaToda(){

        return new ResponseEntity<>(produtoRepository.findAll(), HttpStatus.OK);
    }
}
