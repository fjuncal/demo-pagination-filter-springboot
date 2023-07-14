package com.example.demo.controller;

import com.example.demo.entity.Produto;
import com.example.demo.entity.ProdutoFiltro;
import com.example.demo.repository.ProdutoRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> list(@RequestBody(required = false) ProdutoFiltro produtoFiltro, Pageable pageable){

        if(produtoFiltro.isAtributosNullOuVazio()) {
            return new ResponseEntity<>(produtoRepository.findAll(pageable), HttpStatus.OK);
        }

        return new ResponseEntity<>(produtoRepository.findAll(Objects.requireNonNull(produtoFiltro).getClausulaWhere(), pageable), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listaToda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listaToda(){

        return new ResponseEntity<>(produtoRepository.findAll(), HttpStatus.OK);
    }
}
