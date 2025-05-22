package safide.erp.general.infrastructure.adapter.output;

import org.springframework.stereotype.Repository;
import safide.erp.general.domain.model.GenePaymDeta;
import safide.erp.general.domain.port.IGenePaymDetaRepository;
import safide.erp.general.infrastructure.adapter.input.IGenePaymDetaCrudRepository;
import safide.erp.general.infrastructure.entity.GenePaymDetaEntity;
import safide.erp.general.infrastructure.mapper.GenePaymDetaMapper;
import safide.erp.generic.infrastructure.adapter.output.GeneErpCrudRepositoryImpl;

@Repository
public class GenePaymDetaCrudRepositoryImpl extends GeneErpCrudRepositoryImpl<GenePaymDeta, GenePaymDetaEntity, Long>
    implements IGenePaymDetaRepository {
    public GenePaymDetaCrudRepositoryImpl(IGenePaymDetaCrudRepository icrudRepository, GenePaymDetaMapper mapper) {
        super(icrudRepository, mapper);
    }
}
