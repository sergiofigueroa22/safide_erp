package safide.erp.sale.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safide.erp.generic.infrastructure.rest.GeneErpController;
import safide.erp.sale.application.port.SaleInvoHeadService;
import safide.erp.sale.domain.model.SaleInvoHead;

@RestController
@RequestMapping("/api/v1/invoice")
public class SaleInvoHeadController extends GeneErpController<SaleInvoHead, Long> {
    public SaleInvoHeadController(SaleInvoHeadService saleInvoHeadService) {
        super(saleInvoHeadService);
    }
}
