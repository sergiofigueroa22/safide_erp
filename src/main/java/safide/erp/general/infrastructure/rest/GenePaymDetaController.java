package safide.erp.general.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safide.erp.general.aplication.port.GenePaymDetaService;
import safide.erp.general.domain.model.GenePaymDeta;
import safide.erp.generic.application.port.GeneErpService;
import safide.erp.generic.infrastructure.rest.GeneErpController;

@RestController
@RequestMapping("/api/v1/paymentdetail")
public class GenePaymDetaController extends GeneErpController<GenePaymDeta, Long> {
    public GenePaymDetaController(GenePaymDetaService genePaymDetaService) {
        super(genePaymDetaService);
    }
}
