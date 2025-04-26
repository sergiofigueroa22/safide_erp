package safide.erp.sale.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safide.erp.generic.infrastructure.rest.GeneErpController;
import safide.erp.sale.application.port.SaleCustHeadService;
import safide.erp.sale.domain.model.SaleCustHead;

@RestController
@RequestMapping("/api/v1/customer")
public class SaleCustHeadController extends GeneErpController<SaleCustHead, Integer> {
    public SaleCustHeadController(SaleCustHeadService saleCustHeadService) {
        super(saleCustHeadService);
    }
}
