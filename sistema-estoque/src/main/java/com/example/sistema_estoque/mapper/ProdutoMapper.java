package com.example.sistema_estoque.mapper;

import com.example.sistema_estoque.dto.ProdutoRequest;
import com.example.sistema_estoque.dto.ProdutoResponse;
import com.example.sistema_estoque.entity.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoMapper {

    @Autowired
    public ModelMapper modelMapper;

    public Produto toProduto(ProdutoRequest request){
        return modelMapper.map(request, Produto.class);
    }

    public ProdutoResponse toProdutoResponse(Produto produto){
        return modelMapper.map(produto, ProdutoResponse.class);
    }

    public List<ProdutoResponse> toProdutoResponseList(List<Produto> produtos){
        return produtos.stream().map(this::toProdutoResponse).toList();
    }
}
