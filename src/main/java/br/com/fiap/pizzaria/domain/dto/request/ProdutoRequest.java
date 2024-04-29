package br.com.fiap.pizzaria.domain.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequest(
        @NotNull(message = "O nome é um campo obrigatório")
        String nome,
        AbstractRequest sabor,
        BigDecimal preco
) {
}