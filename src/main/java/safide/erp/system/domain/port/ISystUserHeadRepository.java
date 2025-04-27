package safide.erp.system.domain.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import safide.erp.generic.domain.port.IGeneErpRepository;
import safide.erp.system.domain.model.SystUserHead;
import safide.erp.system.infrastructure.entity.SystUserHeadEntity;

public interface ISystUserHeadRepository extends IGeneErpRepository<SystUserHead, Long> {
}
