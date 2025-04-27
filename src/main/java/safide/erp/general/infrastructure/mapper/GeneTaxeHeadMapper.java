package safide.erp.general.infrastructure.mapper;

import org.mapstruct.Mapper;
import safide.erp.general.domain.model.GeneTaxeHead;
import safide.erp.general.infrastructure.entity.GeneTaxeHeadEntity;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;

@Mapper(componentModel = "spring")
public interface GeneTaxeHeadMapper extends GeneErpMapper<GeneTaxeHead, GeneTaxeHeadEntity> {
}
