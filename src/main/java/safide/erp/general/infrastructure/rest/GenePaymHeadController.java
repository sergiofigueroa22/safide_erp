package safide.erp.general.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safide.erp.general.aplication.port.GenePaymHeadService;
import safide.erp.general.domain.model.GenePaymHead;
import safide.erp.generic.infrastructure.rest.GeneErpController;

@RestController
@RequestMapping("/api/v1/payment")
public class GenePaymHeadController extends GeneErpController<GenePaymHead, Long> {
    public GenePaymHeadController(GenePaymHeadService genePaymHeadService) {
        super(genePaymHeadService);
    }
}
