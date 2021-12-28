package zup.com.brBancoUnitario.demo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MensagemDeErro {
    private String mensagem;

    public MensagemDeErro(String mensagem) {
        this.mensagem = mensagem;
    }
}
