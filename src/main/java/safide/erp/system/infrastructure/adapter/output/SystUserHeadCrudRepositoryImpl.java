package safide.erp.system.infrastructure.adapter.output;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		try {
			return systUserHeadMapper.toDomain(iSystUserHeadCrudRepository.save(systUserHeadMapper.toEntity(systuserhead)));
		} catch (DataIntegrityViolationException ex) {
			throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
					"Error de integridad de datos al guardar usuario " + ex.getCause(), ex);
		} catch (DataAccessException ex) {
			throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar usuario SystUserHead "  + ex.getCause(), ex);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<SystUserHead> findAll() {
		try {
			return systUserHeadMapper.toDomainList(iSystUserHeadCrudRepository.findAll());
		} catch (DataAccessException ex) {
			throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de usuario SystUserHead " + ex.getCause(), ex);
		}
	}

	@Override
	public SystUserHead findById(Long id) {
		// TODO Auto-generated method stub
		//return systUserHeadMapper.toDomain(iSystUserHeadCrudRepository.findById(id).get());
		return systUserHeadMapper.toDomain(iSystUserHeadCrudRepository.findById(id).orElseThrow(
				()-> new GeneErrorResponse("NOT_FOUND","Registro de usuario SystUserHead no encontrado con ID: " + id)
		));
	}

	@Override
	public SystUserHead update(Long id, SystUserHead systuserhead) {
		try {
			if (!iSystUserHeadCrudRepository.existsById(id)) {
				throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla usuario SystUserHead");
			}
			return systUserHeadMapper.toDomain(iSystUserHeadCrudRepository.save(systUserHeadMapper.toEntity(systuserhead)));
		} catch (DataAccessException ex) {
			throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar usuario SystUserHead "  + ex.getCause(), ex);
		}
	}

	@Override
	public void deleteById(Long id) {
		try {
			if (!iSystUserHeadCrudRepository.existsById(id)) {
				throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla usuario SystUserHead");
			}
			iSystUserHeadCrudRepository.deleteById(id);
		} catch (DataAccessException ex) {
			throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar usuario SystUserHead "  + ex.getCause(), ex);
		}
	}
}
