package safide.erp.management.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import safide.erp.management.application.port.ManaCompDetaService;
import safide.erp.management.application.port.ManaCompHeadService;
import safide.erp.management.domain.port.IManaCompDetaRepository;
import safide.erp.management.domain.port.IManaCompHeadRepository;

@Configuration
public class ManaBeanConfiguration {
    @Bean
    ManaCompDetaService manaCompDetaService(IManaCompDetaRepository iManaCompDetaRepository) {
        return new ManaCompDetaService(iManaCompDetaRepository);
    }

    @Bean
    ManaCompHeadService manaCompHeadService(IManaCompHeadRepository iManaCompHeadRepository) {
        return new ManaCompHeadService(iManaCompHeadRepository);
    };
}
