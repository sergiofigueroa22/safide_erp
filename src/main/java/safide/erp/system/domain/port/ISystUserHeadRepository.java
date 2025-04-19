package safide.erp.system.domain.port;

import safide.erp.generic.domain.port.IGeneErpRepository;
import safide.erp.system.domain.model.SystUserHead;

public interface ISystUserHeadRepository extends IGeneErpRepository<SystUserHead, Integer> {
	SystUserHead findByEmail(String emailsyushe);
}
