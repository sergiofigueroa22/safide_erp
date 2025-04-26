package safide.erp.inventory.infrastructure.adapter.input;

import org.springframework.data.repository.CrudRepository;
import safide.erp.inventory.infrastructure.entity.InveProdCataEntity;

public interface IInveProdCataCrudRepository extends CrudRepository<InveProdCataEntity, Long> {
}
