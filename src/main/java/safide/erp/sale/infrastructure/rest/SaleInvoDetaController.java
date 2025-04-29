package safide.erp.sale.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safide.erp.generic.infrastructure.rest.GeneErpController;
import safide.erp.sale.application.port.SaleInvoDetaService;
import safide.erp.sale.domain.model.SaleInvoDeta;

@RestController
@RequestMapping("/api/v1/invoicedeta")
public class SaleInvoDetaController extends GeneErpController<SaleInvoDeta, Long> {
    public SaleInvoDetaController(SaleInvoDetaService saleInvoDetaService) {
        super(saleInvoDetaService);
    }
}
