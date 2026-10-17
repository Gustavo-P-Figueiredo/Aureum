package GusFigue.example.demo.Renda;
import GusFigue.example.demo.Categoria.CategoriaEntity;
import GusFigue.example.demo.Conta.ContaEntity;
import GusFigue.example.demo.Utils.DiaSemana;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "Renda")
@Table(name = "Renda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private ContaEntity conta;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

    private String descricao;

    private BigDecimal valor;

    private tipoRecorrencia recorrencia;

    private Date diaMes;

    private DiaSemana diaSemana;

    private Date dataPontual;

    private Boolean ativo;
}
