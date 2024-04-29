package br.com.fiap.pizzaria.domain.service;

import br.com.fiap.pizzaria.domain.dto.request.ProdutoRequest;
import br.com.fiap.pizzaria.domain.dto.response.ProdutoResponse;
import br.com.fiap.pizzaria.domain.entity.Produto;
import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.List;

public class ProdutoService implements ServiceDTO<Produto, ProdutoResponse, ProdutoRequest>{
    @Override
    public Collection<Produto> findAll() {
        return List.of();
    }

    @Override
    public Collection<Produto> findAll(Example<Produto> example) {
        return List.of();
    }

    @Override
    public Produto findById(Long id) {
        return null;
    }

    @Override
    public Produto save(Produto e) {
        return null;
    }

    @Override
    public Produto toEntity(ProdutoResponse dto) {
        return null;
    }

    @Override
    public ProdutoRequest toResponse(Produto e) {
        return null;
    }
}
