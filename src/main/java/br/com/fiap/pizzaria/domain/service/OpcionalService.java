package br.com.fiap.pizzaria.domain.service;

import br.com.fiap.pizzaria.domain.dto.request.OpcionalRequest;
import br.com.fiap.pizzaria.domain.dto.response.OpcionalResponse;
import br.com.fiap.pizzaria.domain.entity.Opcional;
import br.com.fiap.pizzaria.domain.repository.OpcionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OpcionalService implements ServiceDTO<Opcional, OpcionalRequest, OpcionalResponse> {

    @Autowired
    private OpcionalRepository repo;

    @Autowired
    private SaborService saborService;

    @Override
    public Collection<Opcional> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Opcional> findAll(Example<Opcional> example) {
        return repo.findAll(example);
    }

    @Override
    public Opcional findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Opcional save(Opcional e) {
        return repo.save(e);
    }

    @Override
    public Opcional toEntity(OpcionalRequest r) {
        var sabor = saborService.findById(r.sabor().id());
        return Opcional.builder()
                .nome(r.nome())
                .preco(r.preco())
                .sabor(sabor)
                .build();
    }

    @Override
    public OpcionalResponse toResponse(Opcional e) {
        return OpcionalResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .preco(e.getPreco())
                .sabor(saborService.toResponse(e.getSabor()))
                .build();
    }
}
