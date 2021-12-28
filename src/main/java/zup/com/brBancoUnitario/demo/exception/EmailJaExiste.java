package zup.com.brBancoUnitario.demo.exception;

public class EmailJaExiste extends RuntimeException{

    public EmailJaExiste(String message) {
        super(message);
    }
}
