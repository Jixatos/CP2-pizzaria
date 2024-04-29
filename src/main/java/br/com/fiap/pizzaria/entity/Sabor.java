package br.com.fiap.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Data
@Entity()
@Table(name = "TBL_SABOR",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_NM_SABOR", columnNames = "NM_SABOR")
        }
)
public class Sabor {

    @Id
    @SequenceGenerator(name = "SQ_SABOR", sequenceName = "SQ_SABOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SABOR")
    @Column(name = "ID_SABOR")
    private Long id;

    @Column(name = "NM_SABOR")
    private String nome;

    private String descricao;
}
