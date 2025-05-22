package safide.erp.generic.infrastructure.adapter.output;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;

import java.util.Optional;

public abstract class GeneErpCrudRepositoryImpl<D, E, ID> {

    protected final CrudRepository<E, ID> crudRepository;
    protected final GeneErpMapper<D, E> mapper;

    protected GeneErpCrudRepositoryImpl(CrudRepository<E, ID> crudRepository, GeneErpMapper<D, E> mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Transactional
    public D save(D domain) {
        try {
            return mapper.toDomain(crudRepository.save(mapper.toEntity(domain)));
        } catch (DataIntegrityViolationException ex) {
            throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
                    "Error de integridad al guardar datos: " + ex.getMessage(), ex);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar datos: " + ex.getMessage(), ex);
        }
    }

    @Transactional(readOnly = true)
    public Iterable<D> findAll() {
        try {
            return mapper.toDomainList(crudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos", ex);
        }
    }

    @Transactional(readOnly = true)
    public D findById(ID id) {
        Optional<E> optionalEntity = crudRepository.findById(id);
        return mapper.toDomain(optionalEntity.orElseThrow(
                () -> new GeneErrorResponse("NOT_FOUND", "ID: " + id + " no existe en la base de datos")
        ));
    }

    @Transactional
    public D update(ID id, D domain) {
        try {
            if (!crudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND", "ID: " + id + " no existe en la base de datos");
            }
            return mapper.toDomain(crudRepository.save(mapper.toEntity(domain)));
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al actualizar datos: " + ex.getMessage(), ex);
        }
    }

    @Transactional
    public void deleteById(ID id) {
        try {
            if (!crudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND", "ID: " + id + " no existe en la base de datos");
            }
            crudRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al eliminar datos: " + ex.getMessage(), ex);
        }
    }
}
