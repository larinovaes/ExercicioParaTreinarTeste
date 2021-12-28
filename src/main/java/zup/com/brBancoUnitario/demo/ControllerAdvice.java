package zup.com.brBancoUnitario.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import zup.com.brBancoUnitario.demo.exception.EmailJaExiste;
import zup.com.brBancoUnitario.demo.exception.MensagemDeErro;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EmailJaExiste.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro tratarExcessaoDeEmailRepetido(EmailJaExiste exception) {
            return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
        List<MensagemDeErro> erros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            MensagemDeErro mensagemDeErro = new MensagemDeErro(fieldError.getDefaultMessage());
            erros.add(mensagemDeErro);
        }

        return erros;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularErroDeTipoNull(HttpMessageNotReadableException exception) {
        MensagemDeErro mensagemGenerica = new MensagemDeErro("Campo obrigatório não encontrado");

        return mensagemGenerica;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularErrosDeTipoDeConta(MethodArgumentTypeMismatchException exception) {
        MensagemDeErro mensagemGenerica = new MensagemDeErro("Tipo de conta inválido");
        return mensagemGenerica;
    }
}
