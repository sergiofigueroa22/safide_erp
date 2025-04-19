package safide.erp.system.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import safide.erp.system.application.port.SystUserHeadService;
import safide.erp.system.domain.port.ISystUserHeadRepository;

@Configuration
public class BeanConfigurationSystem {
    @Bean
    SystUserHeadService systUserHeadService(ISystUserHeadRepository iSystUserHeadRepository) {
		return new SystUserHeadService(iSystUserHeadRepository);
	}

}
