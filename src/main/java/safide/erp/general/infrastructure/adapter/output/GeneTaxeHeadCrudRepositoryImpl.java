package safide.erp.general.infrastructure.adapter.output;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.general.domain.model.GeneTaxeHead;
import safide.erp.general.domain.port.IGeneTaxeHeadRepository;
import safide.erp.general.infrastructure.adapter.input.IGeneTaxeHeadCrudRepository;
import safide.erp.general.infrastructure.mapper.GeneTaxeHeadMapper;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;

@Repository
public class GeneTaxeHeadCrudRepositoryImpl implements IGeneTaxeHeadRepository {
    private final IGeneTaxeHeadCrudRepository icrudRepository;
    private final GeneTaxeHeadMapper mapper;

    public GeneTaxeHeadCrudRepositoryImpl(IGeneTaxeHeadCrudRepository repository, GeneTaxeHeadMapper mapper) {
        this.icrudRepository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public GeneTaxeHead save(GeneTaxeHead entity) {
        try {
            return mapper.toDomain(icrudRepository.save(mapper.toEntity(entity)));
        } catch (DataIntegrityViolationException ex) {
            throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
                    "Error de integridad al guardar datos " + ex.getMessage(), ex);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar datos " + ex.getMessage(), ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<GeneTaxeHead> findAll() {
        try {
            return mapper.toDomainList(icrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos", ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public GeneTaxeHead findById(Long id) {
        return mapper.toDomain(icrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos")
        ));
    }

    @Override
    @Transactional
    public GeneTaxeHead update(Long id, GeneTaxeHead entity) {
        try {
            if(!icrudRepository.existsById(id)){
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos " );
            }
            return mapper.toDomain(icrudRepository.save(mapper.toEntity(entity)));
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar datos " + ex.getCause(), ex);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            if(!icrudRepository.existsById(id)){
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos");
            }
            icrudRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al eliminar datos "+ ex.getCause(), ex);
        }
    }
}
