package br.com.fiap.pizzaria.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Data
@Entity()
@Table(name = "TBL_OPCIONAL",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_SABOR_OPCIONAL", columnNames = {"NM_OPCIONAL", "SABOR"})
        }
)
public class Opcional {

    @Id
    @SequenceGenerator(name = "SQ_OPCIONAL", sequenceName = "SQ_OPCIONAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OPCIONAL")
    @Column(name = "ID_OPCIONAL")
    private Long id;

    @Column(name = "NM_OPCIONAL")
    private String nome;

    @Column(name = "VALUE_OPCIONAL")
    private BigDecimal preco;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "SABOR",
            referencedColumnName = "ID_SABOR",
            foreignKey = @ForeignKey(
                    name = "FK_SABOR_OPCIONAL"
            )
    )
    private Sabor sabor;
}
