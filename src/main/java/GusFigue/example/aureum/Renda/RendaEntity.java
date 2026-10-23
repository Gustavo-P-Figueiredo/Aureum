package GusFigue.example.aureum.Renda;
import GusFigue.example.aureum.Categoria.CategoriaEntity;
import GusFigue.example.aureum.Conta.ContaEntity;
import GusFigue.example.aureum.Utils.DiaSemana;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "renda")
@Table(name = "renda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private ContaEntity conta;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

    private String descricao;

    @Column(precision = 19, scale = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private tipoRecorrencia recorrencia;

    private Integer diaMes;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    private LocalDate dataPontual;

    private Boolean ativo;
}
