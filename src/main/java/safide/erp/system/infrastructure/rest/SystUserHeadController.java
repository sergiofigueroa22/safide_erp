package safide.erp.system.infrastructure.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import safide.erp.generic.application.port.GeneErpService;
import safide.erp.generic.infrastructure.rest.GeneErpController;
import safide.erp.system.application.port.SystUserHeadService;
import safide.erp.system.domain.model.SystUserHead;

@RestController
@RequestMapping("/api/v1/users")
public class SystUserHeadController extends GeneErpController<SystUserHead, Long> {
	public SystUserHeadController(SystUserHeadService systUserHeadService) {
		super(systUserHeadService);
	}
}