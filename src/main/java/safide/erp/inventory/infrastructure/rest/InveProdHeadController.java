package safide.erp.inventory.infrastructure.rest;

import org.springframework.web.bind.annotation.*;
import safide.erp.generic.infrastructure.rest.GeneErpController;
import safide.erp.inventory.application.port.InveProdHeadService;
import safide.erp.inventory.domain.model.InveProdHead;

@RestController
@RequestMapping("/api/v1/products")
public class InveProdHeadController extends GeneErpController<InveProdHead, Integer> {
    public InveProdHeadController(InveProdHeadService inveProdHeadService) {
        super(inveProdHeadService);
    }
}
