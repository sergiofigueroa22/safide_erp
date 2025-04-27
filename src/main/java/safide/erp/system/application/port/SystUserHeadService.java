package safide.erp.system.application.port;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.system.domain.model.SystUserHead;
import safide.erp.system.domain.port.ISystUserHeadRepository;

public class SystUserHeadService extends GeneErpService<SystUserHead, Long> {
	public SystUserHeadService(ISystUserHeadRepository iSystUserHeadRepository) {
		super(iSystUserHeadRepository);
	}

}
