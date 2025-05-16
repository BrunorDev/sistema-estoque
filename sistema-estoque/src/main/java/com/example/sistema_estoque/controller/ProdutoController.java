package com.example.sistema_estoque.controller;

import com.example.sistema_estoque.dto.ProdutoRequest;
import com.example.sistema_estoque.dto.ProdutoResponse;
import com.example.sistema_estoque.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    public ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoResponse> save(@RequestBody @Valid ProdutoRequest request) {
        ProdutoResponse produto = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        List<ProdutoResponse> produtos = service.findAll();

        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        ProdutoResponse produto = service.findById(id);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable Long id, @RequestBody ProdutoRequest request) {
        ProdutoResponse produto = service.update(id, request);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/increase-stock")
    public ResponseEntity<Void> increaseStock(@PathVariable Long id, @RequestParam int quantidade) {
        service.increaseStock(id, quantidade);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/decrease-stock")
    public ResponseEntity<Void> decreaseStock(@PathVariable Long id, @RequestParam int quantidade) {
        service.decreaseStock(id, quantidade);
        return ResponseEntity.noContent().build();
    }
}
