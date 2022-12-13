package gr.pmm.pmmhr2022.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Configurer {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
