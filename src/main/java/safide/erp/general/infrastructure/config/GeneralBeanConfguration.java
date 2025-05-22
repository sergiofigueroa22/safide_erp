package safide.erp.general.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import safide.erp.general.aplication.port.GenePaymDetaService;
import safide.erp.general.aplication.port.GenePaymHeadService;
import safide.erp.general.aplication.port.GeneTaxeHeadService;
import safide.erp.general.domain.port.IGenePaymDetaRepository;
import safide.erp.general.domain.port.IGenePaymHeadReposirory;
import safide.erp.general.domain.port.IGeneTaxeHeadRepository;

@Configuration
public class GeneralBeanConfguration {
    @Bean
    GeneTaxeHeadService geneTaxeHeadService(IGeneTaxeHeadRepository iGeneTaxeHeadRepository) {
        return new GeneTaxeHeadService(iGeneTaxeHeadRepository);
    }
    @Bean
    GenePaymHeadService genePaymHeadService(IGenePaymHeadReposirory iGenePaymHeadReposirory) {
        return new GenePaymHeadService(iGenePaymHeadReposirory);
    }
    @Bean
    GenePaymDetaService genePaymDetaService(IGenePaymDetaRepository iGenePaymDetaRepository) {
        return new GenePaymDetaService(iGenePaymDetaRepository);
    }
}
