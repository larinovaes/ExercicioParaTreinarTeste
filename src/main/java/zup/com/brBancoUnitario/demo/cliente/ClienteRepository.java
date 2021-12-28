package zup.com.brBancoUnitario.demo.cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {
   Integer countByEmail (String email);

   Integer countBycpf (String cpf);

}
