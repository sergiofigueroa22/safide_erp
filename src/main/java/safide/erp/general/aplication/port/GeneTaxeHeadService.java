package safide.erp.general.aplication.port;

import safide.erp.general.domain.model.GeneTaxeHead;
import safide.erp.general.domain.port.IGeneTaxeHeadRepository;
import safide.erp.generic.application.port.GeneErpService;

public class GeneTaxeHeadService extends GeneErpService<GeneTaxeHead, Long> {
    public GeneTaxeHeadService(IGeneTaxeHeadRepository iGeneTaxeHeadRepository) {
        super(iGeneTaxeHeadRepository);
    }
}
