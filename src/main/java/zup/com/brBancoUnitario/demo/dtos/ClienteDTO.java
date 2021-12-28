package zup.com.brBancoUnitario.demo.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import zup.com.brBancoUnitario.demo.enums.TipoDeConta;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ClienteDTO {

    private int id;

    @NotBlank
    private String nomeDeCliente;

    @CPF
    private String cpf;

    // Expressão regular para validar telefone
    // as ? é para dizer que é opcional ter parentes ou não.
    // ^ inicio de linha e $ para finalizar a linha
    // as "\" caractere de escape
    @Pattern(regexp = "^\\(?\\d{2}\\)? \\d{5}-\\d{4}$", message = "Número inválido")
    private String telefone;

    @NotNull
    private Integer idade;

    private LocalDate dataDeNacimento;

    @Email
    private String email;

    @NotNull
    private TipoDeConta tipoDeConta;

}
