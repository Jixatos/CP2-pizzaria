package br.com.fiap.pizzaria.domain.service;

import br.com.fiap.pizzaria.domain.dto.request.ProdutoRequest;
import br.com.fiap.pizzaria.domain.dto.response.ProdutoResponse;
import br.com.fiap.pizzaria.domain.entity.Produto;
import br.com.fiap.pizzaria.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService implements ServiceDTO<Produto, ProdutoRequest, ProdutoResponse> {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private SaborService saborService;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public Collection<Produto> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Produto> findAll(Example<Produto> example) {
        return repo.findAll(example);
    }

    @Override
    public Produto findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Produto save(Produto e) {
        return repo.save(e);
    }

    @Override
    public Produto toEntity(ProdutoRequest r) {
        var sabor = saborService.findById(r.sabor().id());

        return Produto.builder()
                .nome(r.nome())
                .preco(r.preco())
                .sabor(sabor)
                .opcionais() // Necessário tratar por se tratar de um Set<>
                .build();
    }

    @Override
    public ProdutoResponse toResponse(Produto e) {
        return ProdutoResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .preco(e.getPreco())
                .sabor(saborService.toResponse(e.getSabor()))
                .opcionais()  // Necessário tratar por se tratar de um Set<>
                .build();
    }
}
