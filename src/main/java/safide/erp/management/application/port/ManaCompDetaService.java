package safide.erp.management.application.port;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.management.domain.model.ManaCompDeta;
import safide.erp.management.domain.port.IManaCompDetaRepository;

public class ManaCompDetaService extends GeneErpService<ManaCompDeta, Long> {
	public ManaCompDetaService(IManaCompDetaRepository iManaCompDetaRepository) {
		super(iManaCompDetaRepository);
	}
}
