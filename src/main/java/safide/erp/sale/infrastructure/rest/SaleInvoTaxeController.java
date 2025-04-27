package safide.erp.sale.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safide.erp.generic.infrastructure.rest.GeneErpController;
import safide.erp.sale.application.port.SaleInvoTaxeService;
import safide.erp.sale.domain.model.SaleInvoTaxe;

@RestController
@RequestMapping("/api/v1/taxe")
public class SaleInvoTaxeController extends GeneErpController<SaleInvoTaxe, Long> {

    public SaleInvoTaxeController(SaleInvoTaxeService saleInvoTaxeService) {
        super(saleInvoTaxeService);
    }
}
