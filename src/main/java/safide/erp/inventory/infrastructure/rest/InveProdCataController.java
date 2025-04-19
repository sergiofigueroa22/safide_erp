package safide.erp.inventory.infrastructure.rest;

import org.springframework.web.bind.annotation.*;
import safide.erp.generic.infrastructure.rest.GeneErpController;
import safide.erp.inventory.application.port.InveProdCataService;
import safide.erp.inventory.domain.model.InveProdCata;

@RestController
@RequestMapping("/api/v1/categorya")
public class InveProdCataController extends GeneErpController<InveProdCata, Integer> {
    public InveProdCataController(InveProdCataService inveProdCataService) {
        super(inveProdCataService);
    }
}
