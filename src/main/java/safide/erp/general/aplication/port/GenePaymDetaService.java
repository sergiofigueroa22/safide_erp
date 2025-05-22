package safide.erp.general.aplication.port;

import safide.erp.general.domain.model.GenePaymDeta;
import safide.erp.general.domain.port.IGenePaymDetaRepository;
import safide.erp.generic.application.port.GeneErpService;
import safide.erp.generic.domain.port.IGeneErpRepository;

public class GenePaymDetaService extends GeneErpService<GenePaymDeta, Long> {
    public GenePaymDetaService(IGenePaymDetaRepository iGenePaymDetaRepository) {
        super(iGenePaymDetaRepository);
    }
}
