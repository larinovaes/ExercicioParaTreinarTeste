package zup.com.brBancoUnitario.demo.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zup.com.brBancoUnitario.demo.exception.EmailJaExiste;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        verificarEmail(cliente.getEmail());
       return clienteRepository.save(cliente);
    }

    public void deletarCliente(int id) {
      clienteRepository.deleteById(id);
    }


    public List<Cliente> exibirListaDeCliente() {
        Iterable<Cliente> listaDeClientes = clienteRepository.findAll();
        return (List<Cliente>) listaDeClientes;
    }

    public void verificarEmail(String email) {
        if (clienteRepository.countByEmail(email) > 0) {
           throw new EmailJaExiste("Email já cadastrado");
        }
    }

    public void validacaoCpf(String cpf) {

    }

}
