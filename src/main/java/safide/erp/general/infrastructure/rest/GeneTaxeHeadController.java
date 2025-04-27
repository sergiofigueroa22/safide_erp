package safide.erp.general.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safide.erp.general.aplication.port.GeneTaxeHeadService;
import safide.erp.general.domain.model.GeneTaxeHead;
import safide.erp.generic.infrastructure.rest.GeneErpController;

@RestController
@RequestMapping("/api/v1/taxe")
public class GeneTaxeHeadController extends GeneErpController<GeneTaxeHead, Long> {
    public GeneTaxeHeadController(GeneTaxeHeadService geneTaxeHeadService) {
        super(geneTaxeHeadService);
    }
}
