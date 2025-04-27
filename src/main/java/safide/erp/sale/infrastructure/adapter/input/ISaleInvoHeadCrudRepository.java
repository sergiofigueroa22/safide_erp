package safide.erp.sale.infrastructure.adapter.input;

import org.springframework.data.repository.CrudRepository;
import safide.erp.sale.infrastructure.entity.SaleInvoHeadEntity;

public interface ISaleInvoHeadCrudRepository extends CrudRepository<SaleInvoHeadEntity, Long> {
    //Page<SaleCustHeadEntity> findAll(Pageable pageable);
}
