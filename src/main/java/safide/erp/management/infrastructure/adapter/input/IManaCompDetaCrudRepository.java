package safide.erp.management.infrastructure.adapter.input;

import org.springframework.data.repository.CrudRepository;
import safide.erp.management.infrastructure.entity.ManaCompDetaEntity;

public interface IManaCompDetaCrudRepository extends CrudRepository<ManaCompDetaEntity, Long> {
}
