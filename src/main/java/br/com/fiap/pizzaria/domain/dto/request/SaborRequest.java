package br.com.fiap.pizzaria.domain.dto.request;

import jakarta.validation.constraints.NotNull;

public record SaborRequest(
        String descricao,
        @NotNull(message = "O nome é um campo obrigatório")
        String nome

) {
}
