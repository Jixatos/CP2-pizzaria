package br.com.fiap.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Opcional extends JpaRepository<Opcional, Long> {
}
