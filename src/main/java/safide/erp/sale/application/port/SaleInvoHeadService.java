package safide.erp.sale.application.port;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.sale.domain.model.SaleInvoHead;
import safide.erp.sale.domain.port.ISaleInvoHeadRepository;

public class SaleInvoHeadService extends GeneErpService<SaleInvoHead, Long> {
    public SaleInvoHeadService(ISaleInvoHeadRepository iSaleInvoHeadRepository) {
        super(iSaleInvoHeadRepository);
    }
}
