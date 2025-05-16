package com.example.sistema_estoque.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;
}
