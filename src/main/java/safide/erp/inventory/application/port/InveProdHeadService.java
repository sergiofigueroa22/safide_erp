package safide.erp.inventory.application.port;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.inventory.domain.model.InveProdHead;
import safide.erp.inventory.domain.port.IInveProdHeadRepository;

public class InveProdHeadService extends GeneErpService<InveProdHead, Integer> {
	public InveProdHeadService(IInveProdHeadRepository iInveProdHeadRepository) {
		super(iInveProdHeadRepository);
	}
}
