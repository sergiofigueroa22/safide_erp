package safide.erp.inventory.infrastructure.mapper;

import org.mapstruct.Mapper;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;
import safide.erp.inventory.domain.model.InveProdCata;
import safide.erp.inventory.infrastructure.entity.InveProdCataEntity;

@Mapper(componentModel = "spring")
public interface InveProdCataMapper extends GeneErpMapper<InveProdCata, InveProdCataEntity> {
}
