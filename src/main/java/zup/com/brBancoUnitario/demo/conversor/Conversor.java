package zup.com.brBancoUnitario.demo.conversor;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Conversor {

    @Bean
    private ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
