package safide.erp.sale.infrastructure.adapter.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import safide.erp.sale.infrastructure.entity.SaleCustHeadEntity;

public interface ISaleCustHeadCrudRepository extends CrudRepository<SaleCustHeadEntity, Long> {
    //Page<SaleCustHeadEntity> findAll(Pageable pageable);
}
