package safide.erp.management.infrastructure.adapter.output;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.management.domain.model.ManaCompDeta;
import safide.erp.management.domain.port.IManaCompDetaRepository;
import safide.erp.management.infrastructure.adapter.input.IManaCompDetaCrudRepository;
import safide.erp.management.infrastructure.mapper.ManaCompDetaMapper;
@Repository
public class ManaCompDetaCrudRepositoryImpl implements IManaCompDetaRepository {

    private final IManaCompDetaCrudRepository iManaCompDetaCrudRepository;
    private final ManaCompDetaMapper manaCompDetaMapper;

    public ManaCompDetaCrudRepositoryImpl(IManaCompDetaCrudRepository iManaCompDetaCrudRepository, ManaCompDetaMapper manaCompDetaMapper) {
        this.iManaCompDetaCrudRepository = iManaCompDetaCrudRepository;
        this.manaCompDetaMapper = manaCompDetaMapper;
    }

    @Override
    @Transactional
    public ManaCompDeta save(ManaCompDeta detaprocata) {
        try {
            return manaCompDetaMapper.toDomain(iManaCompDetaCrudRepository.save(manaCompDetaMapper.toEntity(detaprocata)));
        } catch (DataIntegrityViolationException ex) {
            throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
                    "Error de integridad de datos al guardar sucursal " + ex.getCause(), ex);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar sucursal ManaCompDeta "  + ex.getCause(), ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<ManaCompDeta> findAll() {
        try {
            return manaCompDetaMapper.toDomainList(iManaCompDetaCrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de sucursal ManaCompDeta "  + ex.getCause(), ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ManaCompDeta findById(Long id) {
        return manaCompDetaMapper.toDomain(iManaCompDetaCrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla sucursal ManaCompDeta")
        ));
    }

    @Override
    public ManaCompDeta update(Long id, ManaCompDeta manaCompDeta) {
        try {
            if (!iManaCompDetaCrudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla sucursal ManaCompDeta");
            }
            return manaCompDetaMapper.toDomain(iManaCompDetaCrudRepository.save(manaCompDetaMapper.toEntity(manaCompDeta)));

        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar sucursal ManaCompDeta " + ex.getCause(), ex);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            if (!iManaCompDetaCrudRepository.existsById(id)) {
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla categoria A ManaCompDeta");
            }
            iManaCompDetaCrudRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al eliminar caterogia A ManaCompDeta " + ex.getCause(), ex);
        }
    }
}
