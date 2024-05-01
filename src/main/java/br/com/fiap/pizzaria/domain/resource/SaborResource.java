package br.com.fiap.pizzaria.domain.resource;

import br.com.fiap.pizzaria.domain.dto.request.SaborRequest;
import br.com.fiap.pizzaria.domain.dto.response.SaborResponse;
import br.com.fiap.pizzaria.domain.service.SaborService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
@RequestMapping(value = "/sabores")
public class SaborResource implements ResourceDTO<SaborRequest, SaborResponse> {

    @Autowired
    private SaborService service;

    @GetMapping
    public ResponseEntity<Collection<SaborResponse>> findAll() {
        // Incompleto
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<SaborResponse> findById(@PathVariable Long id) {
        var sabor = service.findById(id);

        if (sabor == null) {
            return ResponseEntity.notFound().build();
        } else {
            var response = service.toResponse(sabor);
            return ResponseEntity.ok(response);
        }
    }

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<SaborResponse> save(@RequestBody @Valid SaborRequest r) {

        var entity = service.toEntity(r);
        service.save(entity);
        var response = service.toResponse(entity);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
