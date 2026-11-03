package GusFigue.example.aureum.Conta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "conta")
@Table(name = "conta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String tipo;

    @Column(precision = 19, scale = 2)
    private BigDecimal saldoInicial;

    private Boolean ativo;
}
