package safide.erp.sale.infrastructure.adapter.input;

import org.springframework.data.repository.CrudRepository;
import safide.erp.sale.infrastructure.entity.SaleInvoTaxeEntity;

public interface ISaleInvoTaxeCrudRepository extends CrudRepository<SaleInvoTaxeEntity, Long> {
}
