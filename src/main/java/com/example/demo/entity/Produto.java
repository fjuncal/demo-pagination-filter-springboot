package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "PRODUTO")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
