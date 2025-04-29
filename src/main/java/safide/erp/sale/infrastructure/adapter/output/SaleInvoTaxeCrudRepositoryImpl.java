package safide.erp.sale.infrastructure.adapter.output;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.sale.domain.model.SaleInvoTaxe;
import safide.erp.sale.domain.port.ISaleInvoTaxeRepository;
import safide.erp.sale.infrastructure.adapter.input.ISaleInvoTaxeCrudRepository;
import safide.erp.sale.infrastructure.mapper.SaleInvoTaxeMapper;

@Repository
public class SaleInvoTaxeCrudRepositoryImpl implements ISaleInvoTaxeRepository {
    private final ISaleInvoTaxeCrudRepository icrudRepository;
    private final SaleInvoTaxeMapper mapper;

    public SaleInvoTaxeCrudRepositoryImpl(ISaleInvoTaxeCrudRepository icrudRepository, SaleInvoTaxeMapper mapper) {
        this.icrudRepository = icrudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public SaleInvoTaxe save(SaleInvoTaxe entity) {
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
    public Iterable<SaleInvoTaxe> findAll() {
        try {
            return mapper.toDomainList(icrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos", ex);
        }
    }

    @Override
    @Transactional
    public SaleInvoTaxe findById(Long id) {
        return mapper.toDomain(icrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos")
        ));
    }

    @Override
    @Transactional
    public SaleInvoTaxe update(Long id, SaleInvoTaxe entity) {
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
