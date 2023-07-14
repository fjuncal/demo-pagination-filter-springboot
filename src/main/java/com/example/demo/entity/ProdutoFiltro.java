package com.example.demo.entity;


import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

import static com.example.demo.entity.ProdutoSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

@Data
public class ProdutoFiltro {
    private Long id;
    private String nome;
    private BigDecimal preco;


    public Specification<Produto> getClausulaWhere() {
        return where(igualPreco(preco))
                .and(igualId(id))
                .and(contemNome(nome));
    }

    public boolean isAtributosNullOuVazio() {
        return ObjectUtils.allNull(id, preco) && ObjectUtils.isEmpty(nome);
    }
}
