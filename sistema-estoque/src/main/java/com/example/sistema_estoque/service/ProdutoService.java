package com.example.sistema_estoque.service;

import com.example.sistema_estoque.dto.ProdutoRequest;
import com.example.sistema_estoque.dto.ProdutoResponse;
import com.example.sistema_estoque.entity.Produto;
import com.example.sistema_estoque.exception.InsufficientStockException;
import com.example.sistema_estoque.exception.ProductNotFoundException;
import com.example.sistema_estoque.mapper.ProdutoMapper;
import com.example.sistema_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper mapper;

    public ProdutoResponse save(ProdutoRequest request) {
        Produto produto = mapper.toProduto(request);
        Produto produtoCadastrado = repository.save(produto);
        return mapper.toProdutoResponse(produtoCadastrado);
    }

    public List<ProdutoResponse> findAll() {
        List<Produto> produtos = repository.findAll();
        return mapper.toProdutoResponseList(produtos);
    }

    public ProdutoResponse findById(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));

        return mapper.toProdutoResponse(produto);
    }

    public ProdutoResponse update(Long id, ProdutoRequest request) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));

        produto.setNome(request.getNome());
        produto.setDescricao(request.getDescricao());
        produto.setPreco(request.getPreco());
        produto.setQuantidade(request.getQuantidade());

        repository.save(produto);

        return mapper.toProdutoResponse(produto);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException("Produto não encontrado.");
        }
        repository.deleteById(id);
    }

    public void decreaseStock(Long id, int quantidade) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));

        if (produto.getQuantidade() < quantidade) {
            throw new InsufficientStockException("Estoque insuficiente.");
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        repository.save(produto);
    }

    public void increaseStock(Long id, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade para reposição deve ser maior que zero.");
        }

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado."));

        produto.setQuantidade(produto.getQuantidade() + quantidade);
        repository.save(produto);
    }

}
