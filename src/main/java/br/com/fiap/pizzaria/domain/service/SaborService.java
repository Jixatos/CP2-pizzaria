package br.com.fiap.pizzaria.domain.service;

import br.com.fiap.pizzaria.domain.dto.request.SaborRequest;
import br.com.fiap.pizzaria.domain.dto.response.SaborResponse;
import br.com.fiap.pizzaria.domain.entity.Sabor;
import br.com.fiap.pizzaria.domain.repository.SaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SaborService implements ServiceDTO<Sabor, SaborRequest, SaborResponse>{

    @Autowired
    private SaborRepository repo;

    @Override
    public Collection<Sabor> findAll() {
        return List.of();
    }

    @Override
    public Collection<Sabor> findAll(Example<Sabor> example) {
        return List.of();
    }

    @Override
    public Sabor findById(Long id) {
        return null;
    }

    @Override
    public Sabor save(Sabor e) {
        return null;
    }

    @Override
    public Sabor toEntity(SaborRequest dto) {
        return null;
    }

    @Override
    public SaborResponse toResponse(Sabor e) {
        return null;
    }
}
