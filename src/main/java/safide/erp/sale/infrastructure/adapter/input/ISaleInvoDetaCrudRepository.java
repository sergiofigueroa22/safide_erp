package safide.erp.sale.infrastructure.adapter.input;

import org.springframework.data.repository.CrudRepository;
import safide.erp.sale.infrastructure.entity.SaleInvoDetaEntity;

public interface ISaleInvoDetaCrudRepository extends CrudRepository<SaleInvoDetaEntity, Long> {
    //Page<SaleCustHeadEntity> findAll(Pageable pageable);
}
