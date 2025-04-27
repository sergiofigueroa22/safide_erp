package safide.erp.general.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import safide.erp.general.aplication.port.GeneTaxeHeadService;
import safide.erp.general.domain.port.IGeneTaxeHeadRepository;

@Configuration
public class GeneralBeanConfguration {
    @Bean
    GeneTaxeHeadService geneTaxeHeadService(IGeneTaxeHeadRepository geneTaxeHeadRepository) {
        return new GeneTaxeHeadService(geneTaxeHeadRepository);
    }
}
