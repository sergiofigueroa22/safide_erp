package safide.erp.general.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import safide.erp.general.domain.model.GenePaymDeta;
import safide.erp.general.infrastructure.entity.GenePaymDetaEntity;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;

@Mapper(componentModel = "spring")
public interface GenePaymDetaMapper extends GeneErpMapper<GenePaymDeta, GenePaymDetaEntity> {
    @Mappings({
            @Mapping(source = "name_gepade", target = "name_gepade"),
            @Mapping(source = "bank_gepade", target = "bank_gepade"),
            @Mapping(source = "alterna_gepade", target = "alterna_gepade"),
            @Mapping(source = "alternb_gepade", target = "alternb_gepade")
    })
    @Override
    GenePaymDeta toDomain(GenePaymDetaEntity entity);

    @Override
    @InheritInverseConfiguration
    GenePaymDetaEntity toEntity(GenePaymDeta domain);
}
