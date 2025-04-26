package safide.erp.inventory.infrastructure.adapter.input;

import org.springframework.data.repository.CrudRepository;
import safide.erp.inventory.infrastructure.entity.InveProdHeadEntity;

public interface IInveProdHeadCrudRepository extends CrudRepository<InveProdHeadEntity, Long> {

}
