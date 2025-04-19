package safide.erp.management.infrastructure.mapper;

import org.mapstruct.Mapper;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;
import safide.erp.management.domain.model.ManaCompDeta;
import safide.erp.management.infrastructure.entity.ManaCompDetaEntity;

@Mapper(componentModel = "spring")
public interface ManaCompDetaMapper extends GeneErpMapper<ManaCompDeta, ManaCompDetaEntity> {
}
