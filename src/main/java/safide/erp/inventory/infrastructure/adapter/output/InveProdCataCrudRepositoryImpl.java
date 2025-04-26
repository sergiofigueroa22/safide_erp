package safide.erp.inventory.infrastructure.adapter.output;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.inventory.domain.model.InveProdCata;
import safide.erp.inventory.domain.port.IInveProdCataRepository;
import safide.erp.inventory.infrastructure.adapter.input.IInveProdCataCrudRepository;
import safide.erp.inventory.infrastructure.mapper.InveProdCataMapper;

import java.awt.print.Pageable;

@Repository
public class InveProdCataCrudRepositoryImpl implements IInveProdCataRepository {

    private final IInveProdCataCrudRepository iInveProdCataCrudRepository;
    private final InveProdCataMapper inveProdCataMapper;

    public InveProdCataCrudRepositoryImpl(IInveProdCataCrudRepository iInveProdCataCrudRepository, InveProdCataMapper inveProdCataMapper) {
        this.iInveProdCataCrudRepository = iInveProdCataCrudRepository;
        this.inveProdCataMapper = inveProdCataMapper;
    }

    @Override
    @Transactional
    public InveProdCata save(InveProdCata inveprocata) {
        try {
            return inveProdCataMapper.toDomain(iInveProdCataCrudRepository.save(inveProdCataMapper.toEntity(inveprocata)));
        } catch (DataIntegrityViolationException ex) {
            throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
                    "Error de integridad de datos al guardar categoria A " + ex.getCause(), ex);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar categoria A InveProdCata "+ex.getCause(), ex);
        }
    }

   @Override
   @Transactional(readOnly = true)
    public Iterable<InveProdCata> findAll() {
       try {
           return inveProdCataMapper.toDomainList(iInveProdCataCrudRepository.findAll());
       } catch (DataAccessException ex) {
           throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de categoria A InveProdCata " + ex.getCause(), ex);
       }
    }

    @Override
    @Transactional(readOnly = true)
    public InveProdCata findById(Long id) {
        return inveProdCataMapper.toDomain(iInveProdCataCrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla categoria A InveProdCata")
        ));
    }

    @Override
    @Transactional
    public InveProdCata update(Long id, InveProdCata inveprocata) {
        try {
            if (!iInveProdCataCrudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla categoria A InveProdCata");
            }
            return inveProdCataMapper.toDomain(iInveProdCataCrudRepository.save(inveProdCataMapper.toEntity(inveprocata)));

        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar caterogia A InveProdCata "  + ex.getCause(), ex);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            if (!iInveProdCataCrudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla categoria A InveProdCata");
            }
            iInveProdCataCrudRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al eliminar caterogia A InveProdCata "  + ex.getCause(), ex);
        }
    }

//    @Override
//    @Transactional(readOnly = true)
//    public Iterable<InveProdCata> findAllPageable(Pageable pageable) {
//        try {
//            return inveProdCataMapper.toInveProdCataList(iInveProdCataCrudRepository.findAllPageable(pageable));
//        } catch (DataAccessException ex) {
//            throw new InveErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de categoria A InveProdCata", ex);
//        }
//    }


}
