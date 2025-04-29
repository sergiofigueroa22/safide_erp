package safide.erp.sale.infrastructure.mapper;

import org.mapstruct.Mapper;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;
import safide.erp.sale.domain.model.SaleInvoTaxe;
import safide.erp.sale.infrastructure.entity.SaleInvoTaxeEntity;

@Mapper(componentModel = "spring")
public interface SaleInvoTaxeMapper extends GeneErpMapper<SaleInvoTaxe, SaleInvoTaxeEntity> {

}
