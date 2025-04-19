package safide.erp.system.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import safide.erp.generic.infrastructure.mapper.GeneErpMapper;
import safide.erp.management.domain.model.ManaCompDeta;
import safide.erp.management.infrastructure.entity.ManaCompDetaEntity;
import safide.erp.system.domain.model.SystUserHead;
import safide.erp.system.infrastructure.entity.SystUserHeadEntity;

@Mapper(componentModel = "spring")
public interface SystUserHeadMapper extends GeneErpMapper<SystUserHead, SystUserHeadEntity> {
}

