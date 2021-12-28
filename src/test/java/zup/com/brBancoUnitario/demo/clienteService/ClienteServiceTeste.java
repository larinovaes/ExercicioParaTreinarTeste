package zup.com.brBancoUnitario.demo.clienteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import zup.com.brBancoUnitario.demo.cliente.Cliente;
import zup.com.brBancoUnitario.demo.cliente.ClienteRepository;
import zup.com.brBancoUnitario.demo.cliente.ClienteService;
import zup.com.brBancoUnitario.demo.enums.TipoDeConta;

import java.time.LocalDate;

@SpringBootTest
public class ClienteServiceTeste {

    @MockBean
     private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    public void setup() {
        cliente = new Cliente();
        cliente.setNomeDeCliente("Joao");
        cliente.setCpf("941.832.824-03");
        cliente.setEmail("jooao@gmail.com");
        cliente.setTelefone("(11)95150-5631");
        cliente.setTipoDeConta(TipoDeConta.CONTA_CORRENTE);
        cliente.setDataDeNacimento(LocalDate.now());
        cliente.setId(1);
    }

    @Test
    public void verificarCadastroDeClienteCaminhoPositivo() {
        Mockito.when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);
    }
}
