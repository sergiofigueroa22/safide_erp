package safide.erp.management.infrastructure.mapper;

import org.mapstruct.Mapper;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;
import safide.erp.management.domain.model.ManaCompHead;
import safide.erp.management.infrastructure.entity.ManaCompHeadEntity;

@Mapper(componentModel = "spring")
public interface ManaCompHeadMapper extends GeneErpMapper<ManaCompHead, ManaCompHeadEntity> {
}
