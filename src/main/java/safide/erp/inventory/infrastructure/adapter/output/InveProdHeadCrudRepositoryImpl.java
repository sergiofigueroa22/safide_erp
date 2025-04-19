package safide.erp.inventory.infrastructure.adapter.output;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.inventory.domain.model.InveProdHead;
import safide.erp.inventory.domain.port.IInveProdHeadRepository;
import safide.erp.inventory.infrastructure.adapter.input.IInveProdHeadCrudRepository;
import safide.erp.inventory.infrastructure.mapper.InveProdHeadMapper;

import java.awt.print.Pageable;
@Repository
public class InveProdHeadCrudRepositoryImpl implements IInveProdHeadRepository {

    private final IInveProdHeadCrudRepository iInveProdHeadCrudRepository;
    private final InveProdHeadMapper inveProdHeadMapper;

    public InveProdHeadCrudRepositoryImpl(IInveProdHeadCrudRepository iInveProdHeadCrudRepository, InveProdHeadMapper inveProdHeadMapper) {
        this.iInveProdHeadCrudRepository = iInveProdHeadCrudRepository;
        this.inveProdHeadMapper = inveProdHeadMapper;
    }

    @Override
    @Transactional
    public InveProdHead save(InveProdHead inveprohead) {
        try {
            return inveProdHeadMapper.toDomain(iInveProdHeadCrudRepository.save(inveProdHeadMapper.toEntity(inveprohead)));
        } catch (DataIntegrityViolationException ex) {
            throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
                    "Error de integridad de datos al guardar producto ", ex);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar producto InveProdHead", ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<InveProdHead> findAll() {
        try {
            return inveProdHeadMapper.toDomainList(iInveProdHeadCrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de producto InveProdHead", ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public InveProdHead findById(Integer id) {
        return inveProdHeadMapper.toDomain(iInveProdHeadCrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","Registro de producto InveProdHead no encontrado con ID: " + id)
        ));
    }

    @Override
    public InveProdHead update(Integer id, InveProdHead inveprohead) {
        try {
            if (!iInveProdHeadCrudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND","Registro de producto InveProdHead no encontrado para actualizar. ID: " + id);
            }
            return inveProdHeadMapper.toDomain(iInveProdHeadCrudRepository.save(inveProdHeadMapper.toEntity(inveprohead)));

        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar caterogia A InveProdHead", ex);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        try {
            if (!iInveProdHeadCrudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND","Registro de producto InveProdHead no encontrado para actualizar. ID: " + id);
            }
            iInveProdHeadCrudRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al eliminar caterogia A InveProdHead", ex);
        }
    }

//    @Override
//    @Transactional(readOnly = true)
//    public Iterable<InveProdHead> findAllPageable(Pageable pageable) {
//        try {
//            return inveProdHeadMapper.toInveProdHeadList(iInveProdHeadCrudRepository.findAllPageable(pageable));
//        } catch (DataAccessException ex) {
//            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de producto InveProdHead", ex);
//        }
//    }
}
