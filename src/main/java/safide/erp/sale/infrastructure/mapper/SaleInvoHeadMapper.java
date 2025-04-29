package safide.erp.sale.infrastructure.mapper;

import org.mapstruct.Mapper;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;
import safide.erp.sale.domain.model.SaleInvoHead;
import safide.erp.sale.infrastructure.entity.SaleInvoHeadEntity;

@Mapper(componentModel = "spring", uses = {SaleInvoDetaMapper.class, SaleInvoTaxeMapper.class})
public interface SaleInvoHeadMapper extends GeneErpMapper<SaleInvoHead, SaleInvoHeadEntity> {

}
