package safide.erp.system.infrastructure.adapter.input;

import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import safide.erp.system.infrastructure.entity.SystUserHeadEntity;

import java.util.Optional;

public interface ISystUserHeadCrudRepository extends CrudRepository<SystUserHeadEntity, Long> {
    Page<SystUserHeadEntity> findAll(Pageable pageable);
}
