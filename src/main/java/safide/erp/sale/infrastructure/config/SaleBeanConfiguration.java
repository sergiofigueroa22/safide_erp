package safide.erp.sale.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import safide.erp.sale.application.port.SaleCustHeadService;
import safide.erp.sale.application.port.SaleInvoDetaService;
import safide.erp.sale.application.port.SaleInvoHeadService;
import safide.erp.sale.domain.port.ISaleCustHeadRepository;
import safide.erp.sale.domain.port.ISaleInvoDetaRepository;
import safide.erp.sale.domain.port.ISaleInvoHeadRepository;

@Configuration
public class SaleBeanConfiguration {
    @Bean
    SaleCustHeadService saleCustHeadService(ISaleCustHeadRepository isaleCustHeadRepository) {
        return new SaleCustHeadService(isaleCustHeadRepository);
    }
    @Bean
    SaleInvoHeadService saleInvoHeadService(ISaleInvoHeadRepository isaleInvoHeadRepository) {
        return new SaleInvoHeadService(isaleInvoHeadRepository);
    }
    @Bean
    SaleInvoDetaService saleInvoDetaService(ISaleInvoDetaRepository isaleInvoDetaRepository) {
        return new SaleInvoDetaService(isaleInvoDetaRepository);
    }
}
