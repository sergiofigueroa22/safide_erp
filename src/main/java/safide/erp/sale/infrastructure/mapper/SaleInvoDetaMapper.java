package safide.erp.sale.infrastructure.mapper;

import org.mapstruct.Mapper;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;
import safide.erp.sale.domain.model.SaleInvoDeta;
import safide.erp.sale.infrastructure.entity.SaleInvoDetaEntity;

@Mapper(componentModel = "spring")
public interface SaleInvoDetaMapper extends GeneErpMapper<SaleInvoDeta, SaleInvoDetaEntity> {
}
