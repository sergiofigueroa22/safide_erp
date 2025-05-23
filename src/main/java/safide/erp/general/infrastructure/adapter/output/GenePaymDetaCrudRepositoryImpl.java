package safide.erp.general.infrastructure.adapter.output;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.general.domain.model.GenePaymDeta;
import safide.erp.general.domain.port.IGenePaymDetaRepository;
import safide.erp.general.infrastructure.adapter.input.IGenePaymDetaCrudRepository;
import safide.erp.general.infrastructure.entity.GenePaymDetaEntity;
import safide.erp.general.infrastructure.mapper.GenePaymDetaMapper;
import safide.erp.generic.infrastructure.adapter.output.GeneErpCrudRepositoryImpl;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;

@Repository
public class GenePaymDetaCrudRepositoryImpl implements IGenePaymDetaRepository {
   private final IGenePaymDetaCrudRepository icrudRepository;
   private final GenePaymDetaMapper mapper;

    public GenePaymDetaCrudRepositoryImpl(IGenePaymDetaCrudRepository icrudRepository, GenePaymDetaMapper mapper) {
        this.icrudRepository = icrudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public GenePaymDeta save(GenePaymDeta entity) {
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
    public Iterable<GenePaymDeta> findAll() {
        try {
            return mapper.toDomainList(icrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos", ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public GenePaymDeta findById(Long id) {
        return mapper.toDomain(icrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos")
        ));
    }

    @Override
    @Transactional
    public GenePaymDeta update(Long id, GenePaymDeta entity) {
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
