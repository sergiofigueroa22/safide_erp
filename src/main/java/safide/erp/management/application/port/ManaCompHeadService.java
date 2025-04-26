package safide.erp.management.application.port;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.management.domain.model.ManaCompHead;
import safide.erp.management.domain.port.IManaCompHeadRepository;

public class ManaCompHeadService extends GeneErpService<ManaCompHead, Long> {
	public ManaCompHeadService(IManaCompHeadRepository iManaCompHeadRepository) {
		super(iManaCompHeadRepository);
	}
}
