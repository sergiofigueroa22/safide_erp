package safide.erp.sale.infrastructure.adapter.output;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.sale.domain.model.SaleCustHead;
import safide.erp.sale.domain.port.ISaleCustHeadRepository;
import safide.erp.sale.infrastructure.adapter.input.ISaleCustHeadCrudRepository;
import safide.erp.sale.infrastructure.mapper.SaleCustHeadMapper;

@Repository
public class SaleCustHeadCrudRepositoryImpl implements ISaleCustHeadRepository {

    private final ISaleCustHeadCrudRepository iSaleCustHeadCrudRepository;
    private final SaleCustHeadMapper saleCustHeadMapper;

    public SaleCustHeadCrudRepositoryImpl(ISaleCustHeadCrudRepository iSaleCustHeadCrudRepository, SaleCustHeadMapper saleCustHeadMapper) {
        this.iSaleCustHeadCrudRepository = iSaleCustHeadCrudRepository;
        this.saleCustHeadMapper = saleCustHeadMapper;
    }

    @Override
    @Transactional
    public SaleCustHead save(SaleCustHead saleCustHead) {
        try {
            return saleCustHeadMapper.toDomain(iSaleCustHeadCrudRepository.save(saleCustHeadMapper.toEntity(saleCustHead)));
        } catch (DataIntegrityViolationException ex) {
            throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
                    "Error de integridad de datos al guardar clientes ", ex);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar clientes SaleCustHead", ex);
        }
    }

    @Override
    @Transactional
    public Iterable<SaleCustHead> findAll() {
        try {
            return saleCustHeadMapper.toDomainList(iSaleCustHeadCrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de clientes SaleCustHead", ex);
        }
    }

    @Override
    @Transactional
    public SaleCustHead findById(Integer id) {
        return saleCustHeadMapper.toDomain(iSaleCustHeadCrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla clientes SaleCustHead")
        ));
    }

    @Override
    @Transactional
    public SaleCustHead update(Integer id, SaleCustHead saleCustHead) {
        try {
            if(!iSaleCustHeadCrudRepository.existsById(id)){
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla clientes SaleCustHead");
            }
            return saleCustHeadMapper.toDomain(iSaleCustHeadCrudRepository.save(saleCustHeadMapper.toEntity(saleCustHead)));
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar cliente SaleCustHead", ex);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        try {
            if(!iSaleCustHeadCrudRepository.existsById(id)){
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla clientes SaleCustHead");
            }
            iSaleCustHeadCrudRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar cliente SaleCustHead", ex);
        }
    }
}
