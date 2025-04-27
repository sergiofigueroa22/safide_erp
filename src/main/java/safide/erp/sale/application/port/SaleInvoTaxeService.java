package safide.erp.sale.application.port;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.sale.domain.model.SaleInvoTaxe;
import safide.erp.sale.domain.port.ISaleInvoTaxeRepository;

public class SaleInvoTaxeService extends GeneErpService<SaleInvoTaxe, Long> {
    public SaleInvoTaxeService(ISaleInvoTaxeRepository iSaleInvoTaxeRepository) {
        super(iSaleInvoTaxeRepository);
    }
}
