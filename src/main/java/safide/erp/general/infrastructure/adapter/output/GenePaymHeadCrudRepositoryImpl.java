package safide.erp.general.infrastructure.adapter.output;

import org.springframework.stereotype.Repository;
import safide.erp.general.domain.model.GenePaymHead;
import safide.erp.general.domain.port.IGenePaymHeadReposirory;
import safide.erp.general.infrastructure.adapter.input.IGenePaymHeadCrudRepository;
import safide.erp.general.infrastructure.entity.GenePaymHeadEntity;
import safide.erp.general.infrastructure.mapper.GenePaymHeadMapper;
import safide.erp.generic.infrastructure.adapter.output.GeneErpCrudRepositoryImpl;

@Repository
public class GenePaymHeadCrudRepositoryImpl extends GeneErpCrudRepositoryImpl<GenePaymHead, GenePaymHeadEntity, Long>
    implements IGenePaymHeadReposirory {
    public GenePaymHeadCrudRepositoryImpl(IGenePaymHeadCrudRepository icrudRepository, GenePaymHeadMapper mapper) {
        super(icrudRepository, mapper);
    }
}
