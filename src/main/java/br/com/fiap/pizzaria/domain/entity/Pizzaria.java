package br.com.fiap.pizzaria.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Data
@Entity()
@Table(name = "TBL_PIZZARIA",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_NM_PIZZARIA", columnNames = "NM_PIZZARIA")
        }
)
public class Pizzaria {

    @Id
    @SequenceGenerator(name = "SQ_PIZZARIA", sequenceName = "SQ_PIZZARIA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PIZZARIA")
    @Column(name = "ID_PIZZARIA")
    private Long id;

    @Column(name = "NM_PIZZARIA")
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TBL_PIZZARIA_PRODUTO",
            joinColumns = {
                    @JoinColumn(
                            name = "PIZZARIA",
                            referencedColumnName = "ID_PIZZARIA",
                            foreignKey = @ForeignKey(
                                    name = "FK_PIZZARIA_PRODUTO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_PRODUTO_PIZZARIA"
                            )
                    )
            }
    )
    private Set<Produto> cardapio = new LinkedHashSet<>();
}
