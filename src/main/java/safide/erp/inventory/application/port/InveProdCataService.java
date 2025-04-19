package safide.erp.inventory.application.port;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.inventory.domain.model.InveProdCata;
import safide.erp.inventory.domain.port.IInveProdCataRepository;

public class InveProdCataService extends GeneErpService<InveProdCata, Integer> {
	public InveProdCataService(IInveProdCataRepository iInveProdCataRepository) {
		super(iInveProdCataRepository);	}

}
