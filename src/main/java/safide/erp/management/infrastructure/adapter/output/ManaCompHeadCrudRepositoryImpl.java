package safide.erp.management.infrastructure.adapter.output;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.management.domain.model.ManaCompHead;
import safide.erp.management.domain.port.IManaCompHeadRepository;
import safide.erp.management.infrastructure.adapter.input.IManaCompHeadCrudRepository;
import safide.erp.management.infrastructure.mapper.ManaCompHeadMapper;
@Repository
public class ManaCompHeadCrudRepositoryImpl implements IManaCompHeadRepository {

    private final IManaCompHeadCrudRepository iManaCompHeadCrudRepository;
    private final ManaCompHeadMapper manaCompHeadMapper;

    public ManaCompHeadCrudRepositoryImpl(IManaCompHeadCrudRepository iManaCompHeadCrudRepository, ManaCompHeadMapper manaCompHeadMapper) {
        this.iManaCompHeadCrudRepository = iManaCompHeadCrudRepository;
        this.manaCompHeadMapper = manaCompHeadMapper;
    }

    @Override
    @Transactional
    public ManaCompHead save(ManaCompHead manaCompHead) {
        try {
            return manaCompHeadMapper.toDomain(iManaCompHeadCrudRepository.save(manaCompHeadMapper.toEntity(manaCompHead)));
        } catch (DataIntegrityViolationException ex) {
            throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
                    "Error de integridad de datos al guardar compania ", ex);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar compania ManaCompHead "  + ex.getCause(), ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<ManaCompHead> findAll() {
        try {
            return manaCompHeadMapper.toDomainList(iManaCompHeadCrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de compania ManaCompHead "  + ex.getCause(), ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ManaCompHead findById(Long id) {
        return manaCompHeadMapper.toDomain(iManaCompHeadCrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla compania ManaCompHead")
        ));
    }

    @Override
    public ManaCompHead update(Long id, ManaCompHead manaCompHead) {
        try {
            if (!iManaCompHeadCrudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla compania ManaCompHead");
            }
            return manaCompHeadMapper.toDomain(iManaCompHeadCrudRepository.save(manaCompHeadMapper.toEntity(manaCompHead)));

        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar compania ManaCompHead " + ex.getCause(), ex);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            if (!iManaCompHeadCrudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla compania ManaCompHead");
            }
            iManaCompHeadCrudRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al eliminar compania ManaCompHead "  + ex.getCause(), ex);
        }
    }
}
