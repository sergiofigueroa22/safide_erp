package safide.erp.management.infrastructure.rest;

import org.springframework.web.bind.annotation.*;
import safide.erp.generic.infrastructure.rest.GeneErpController;
import safide.erp.management.application.port.ManaCompHeadService;
import safide.erp.management.domain.model.ManaCompHead;

@RestController
@RequestMapping("/api/v1/company")
public class ManaCompHeadController extends GeneErpController<ManaCompHead, Integer> {
    public ManaCompHeadController(ManaCompHeadService manaCompHeadService) {
        super(manaCompHeadService);
    }
}
