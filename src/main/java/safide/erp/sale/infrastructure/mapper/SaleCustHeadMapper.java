package safide.erp.sale.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;
import safide.erp.sale.domain.model.SaleCustHead;
import safide.erp.sale.infrastructure.entity.SaleCustHeadEntity;

@Mapper(componentModel = "spring")
public interface SaleCustHeadMapper extends GeneErpMapper<SaleCustHead, SaleCustHeadEntity> {


     }
