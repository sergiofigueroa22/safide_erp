package safide.erp.general.infrastructure.adapter.output;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.general.domain.model.GenePaymHead;
import safide.erp.general.domain.port.IGenePaymHeadReposirory;
import safide.erp.general.infrastructure.adapter.input.IGenePaymHeadCrudRepository;
import safide.erp.general.infrastructure.entity.GenePaymDetaEntity;
import safide.erp.general.infrastructure.entity.GenePaymHeadEntity;
import safide.erp.general.infrastructure.mapper.GenePaymHeadMapper;
import safide.erp.generic.infrastructure.adapter.output.GeneErpCrudRepositoryImpl;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;

@Repository
public class GenePaymHeadCrudRepositoryImpl implements IGenePaymHeadReposirory {
    private final IGenePaymHeadCrudRepository icrudRepository;
    private final GenePaymHeadMapper mapper;

    public GenePaymHeadCrudRepositoryImpl(IGenePaymHeadCrudRepository icrudRepository, GenePaymHeadMapper mapper) {
        this.icrudRepository = icrudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public GenePaymHead save(GenePaymHead entity) {
        try {
            GenePaymHeadEntity genePaymHeadEntity = mapper.toEntity(entity);
            for (GenePaymDetaEntity genePaymDetaEntity : genePaymHeadEntity.getGenePaymDetas()){
                genePaymDetaEntity.setGenePaymHeadEntity(genePaymHeadEntity);
            }
            return mapper.toDomain(icrudRepository.save(genePaymHeadEntity));
        } catch (DataIntegrityViolationException ex) {
            throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
                    "Error de integridad de datos al guardar cabecera de factura " + ex.getCause(), ex);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR",
                    "Error al guardar cabecera de factura SaleInvoHead " + ex.getMessage(), ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<GenePaymHead> findAll() {
        try {
            return mapper.toDomainList(icrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos", ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public GenePaymHead findById(Long id) {
        return mapper.toDomain(icrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos")
        ));
    }

    @Override
    @Transactional
    public GenePaymHead update(Long id, GenePaymHead entity) {
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
