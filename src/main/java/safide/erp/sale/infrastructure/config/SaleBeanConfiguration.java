package safide.erp.sale.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import safide.erp.sale.application.port.SaleCustHeadService;
import safide.erp.sale.domain.port.ISaleCustHeadRepository;

@Configuration
public class SaleBeanConfiguration {
    @Bean
    SaleCustHeadService saleCustHeadService(ISaleCustHeadRepository isaleCustHeadRepository) {
        return new SaleCustHeadService(isaleCustHeadRepository);
    }
}
