package safide.erp.management.infrastructure.rest;

import org.springframework.web.bind.annotation.*;
import safide.erp.generic.infrastructure.rest.GeneErpController;
import safide.erp.management.application.port.ManaCompDetaService;
import safide.erp.management.domain.model.ManaCompDeta;

@RestController
@RequestMapping("/api/v1/agency")
public class ManaCompDetaController extends GeneErpController<ManaCompDeta, Integer> {
    public ManaCompDetaController(ManaCompDetaService manaCompDetaService) {
        super(manaCompDetaService);
    }
}
