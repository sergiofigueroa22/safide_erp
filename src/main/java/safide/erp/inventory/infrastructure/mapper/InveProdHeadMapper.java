package safide.erp.inventory.infrastructure.mapper;

import org.mapstruct.Mapper;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;
import safide.erp.inventory.domain.model.InveProdHead;
import safide.erp.inventory.infrastructure.entity.InveProdHeadEntity;

@Mapper(componentModel = "spring")
public interface InveProdHeadMapper extends GeneErpMapper<InveProdHead, InveProdHeadEntity> {
}
