package safide.erp.sale.application.port;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.sale.domain.model.SaleInvoDeta;
import safide.erp.sale.domain.port.ISaleInvoDetaRepository;

public class SaleInvoDetaService extends GeneErpService<SaleInvoDeta, Long> {
    public SaleInvoDetaService(ISaleInvoDetaRepository iSaleInvoDetaRepository) {
        super(iSaleInvoDetaRepository);
    }
}
