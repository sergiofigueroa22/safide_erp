package safide.erp.general.infrastructure.adapter.input;

import org.springframework.data.repository.CrudRepository;
import safide.erp.general.infrastructure.entity.GeneTaxeHeadEntity;

public interface IGeneTaxeHeadCrudRepository extends CrudRepository<GeneTaxeHeadEntity, Long> {
}
