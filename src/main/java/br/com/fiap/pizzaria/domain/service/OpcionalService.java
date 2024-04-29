package br.com.fiap.pizzaria.domain.service;

import br.com.fiap.pizzaria.domain.dto.request.OpcionalRequest;
import br.com.fiap.pizzaria.domain.dto.response.OpcionalResponse;
import br.com.fiap.pizzaria.domain.entity.Opcional;
import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.List;

public class OpcionalService implements ServiceDTO<Opcional, OpcionalResponse, OpcionalRequest>{
    @Override
    public Collection<Opcional> findAll() {
        return List.of();
    }

    @Override
    public Collection<Opcional> findAll(Example<Opcional> example) {
        return List.of();
    }

    @Override
    public Opcional findById(Long id) {
        return null;
    }

    @Override
    public Opcional save(Opcional e) {
        return null;
    }

    @Override
    public Opcional toEntity(OpcionalResponse dto) {
        return null;
    }

    @Override
    public OpcionalRequest toResponse(Opcional e) {
        return null;
    }
}
