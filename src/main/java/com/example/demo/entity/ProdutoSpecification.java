package com.example.demo.entity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

import static org.springframework.data.jpa.domain.Specification.where;

public interface ProdutoSpecification {

    static Specification<Produto> igualNome(String nome) {
        if(nome == null || StringUtils.isEmpty(nome)) {
            return where(null);
        }
        return (produto, cq, cb) -> cb.equal(produto.get("nome"),nome);
    }

    static Specification<Produto> contemNome(String nome) {
        if(nome == null || StringUtils.isEmpty(nome)) {
            return where(null);
        }
        System.err.println("%" + nome + "%");
        return (produto, cq, cb) -> cb.like(cb.upper(produto.get("nome")), "%" + nome.toUpperCase() + "%");
    }

    static Specification<Produto> igualId(Long id) {
        if(id == null) {
            return where(null);
        }
        return (produto, cq, cb) -> cb.equal(produto.get("id"), id);
    }

    static Specification<Produto> igualPreco(BigDecimal preco) {
        if(preco == null) {
            return where(null);
        }
        return (produto, cq, cb) -> cb.equal(produto.get("preco"),preco);
    }



}
