package safide.erp.sale.application.port;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.sale.domain.model.SaleCustHead;
import safide.erp.sale.domain.port.ISaleCustHeadRepository;

public class SaleCustHeadService extends GeneErpService<SaleCustHead, Long> {
    public SaleCustHeadService(ISaleCustHeadRepository iSaleCustHeadRepository) {
        super(iSaleCustHeadRepository);
    }
}
