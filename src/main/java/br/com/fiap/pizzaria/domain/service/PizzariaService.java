package br.com.fiap.pizzaria.domain.service;

import br.com.fiap.pizzaria.domain.dto.request.PizzariaRequest;
import br.com.fiap.pizzaria.domain.dto.response.PizzariaResponse;
import br.com.fiap.pizzaria.domain.entity.Pizzaria;
import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.List;

public class PizzariaService implements ServiceDTO<Pizzaria, PizzariaRequest, PizzariaResponse>{
    @Override
    public Collection<Pizzaria> findAll() {
        return List.of();
    }

    @Override
    public Collection<Pizzaria> findAll(Example<Pizzaria> example) {
        return List.of();
    }

    @Override
    public Pizzaria findById(Long id) {
        return null;
    }

    @Override
    public Pizzaria save(Pizzaria e) {
        return null;
    }

    @Override
    public Pizzaria toEntity(PizzariaRequest dto) {
        return null;
    }

    @Override
    public PizzariaResponse toResponse(Pizzaria e) {
        return null;
    }
}
