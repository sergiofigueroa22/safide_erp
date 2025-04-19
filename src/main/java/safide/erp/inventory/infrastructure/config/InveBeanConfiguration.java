package safide.erp.inventory.infrastructure.config;

import  org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import safide.erp.inventory.application.port.InveProdCataService;
import safide.erp.inventory.application.port.InveProdHeadService;
import safide.erp.inventory.domain.port.IInveProdCataRepository;
import safide.erp.inventory.domain.port.IInveProdHeadRepository;

@Configuration
public class InveBeanConfiguration {
    @Bean
    InveProdCataService inveProdCataService(IInveProdCataRepository iInveProdCataRepository) {
        return new InveProdCataService(iInveProdCataRepository);
    }

    @Bean
    InveProdHeadService inveProdHeadService(IInveProdHeadRepository iInveProdHeadRepository) {
        return new InveProdHeadService(iInveProdHeadRepository);
    };

}
