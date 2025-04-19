package safide.erp.system.infrastructure.adapter.output;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.inventory.domain.model.InveProdHead;
import safide.erp.system.domain.model.SystUserHead;
import safide.erp.system.domain.port.ISystUserHeadRepository;
import safide.erp.system.infrastructure.adapter.input.ISystUserHeadCrudRepository;
import safide.erp.system.infrastructure.mapper.SystUserHeadMapper;

@Repository
public class SystUserHeadCrudRepositoryImpl implements ISystUserHeadRepository {
	
	private final ISystUserHeadCrudRepository iSystUserHeadCrudRepository;
	private final SystUserHeadMapper systUserHeadMapper;
	
	public SystUserHeadCrudRepositoryImpl(ISystUserHeadCrudRepository iSystUserHeadCrudRepository, SystUserHeadMapper systUserHeadMapper) {
		this.iSystUserHeadCrudRepository=iSystUserHeadCrudRepository;
		this.systUserHeadMapper = systUserHeadMapper;		
	}

	@Override
	public SystUserHead save(SystUserHead systuserhead) {
		// TODO Auto-generated method stub
		return systUserHeadMapper.toDomain(iSystUserHeadCrudRepository.save(systUserHeadMapper.toEntity(systuserhead)));
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<SystUserHead> findAll() {
		try {
			return systUserHeadMapper.toDomainList(iSystUserHeadCrudRepository.findAll());
		} catch (DataAccessException ex) {
			throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de producto InveProdHead", ex);
		}
	}

	@Override
	public SystUserHead findById(Integer id) {
		// TODO Auto-generated method stub
		//return systUserHeadMapper.toDomain(iSystUserHeadCrudRepository.findById(id).get());
		return systUserHeadMapper.toDomain(iSystUserHeadCrudRepository.findById(id).orElseThrow(
				()-> new GeneErrorResponse("NOT_FOUND","Registro de producto InveProdHead no encontrado con ID: " + id)
		));
	}

	@Override
	public SystUserHead update(Integer integer, SystUserHead entity) {
		return null;
	}

	@Override
	public SystUserHead findByEmail(String emailsyushe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
