package zup.com.brBancoUnitario.demo.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zup.com.brBancoUnitario.demo.enums.TipoDeConta;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nomeDeCliente;

    private String cpf;
    private String telefone;
    private Integer idade;
    private LocalDate dataDeNacimento;
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoDeConta tipoDeConta;

}
