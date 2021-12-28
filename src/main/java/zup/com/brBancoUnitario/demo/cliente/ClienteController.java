package zup.com.brBancoUnitario.demo.cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zup.com.brBancoUnitario.demo.dtos.ClienteDTO;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO salvarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteService.cadastrarCliente(cliente);
        clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return clienteDTO;
    }
    @GetMapping
    public List<ClienteDTO> exibirClientes() {
        List<ClienteDTO> listaDeClientes = new ArrayList<>();
        for (Cliente clienteReferencia : clienteService.exibirListaDeCliente()) {
            ClienteDTO cliente = modelMapper.map(clienteReferencia, ClienteDTO.class);
            listaDeClientes.add(cliente);
        }
        return listaDeClientes;
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable int id) {
        clienteService.deletarCliente(id);
    }
}
