package safide.erp.general.aplication.port;

import safide.erp.general.domain.model.GenePaymHead;
import safide.erp.general.domain.port.IGenePaymHeadReposirory;
import safide.erp.generic.application.port.GeneErpService;
import safide.erp.generic.domain.port.IGeneErpRepository;

public class GenePaymHeadService extends GeneErpService<GenePaymHead, Long> {
    public GenePaymHeadService(IGenePaymHeadReposirory iGenePaymHeadReposirory) {
        super(iGenePaymHeadReposirory);
    }
}
