package safide.erp.sale.infrastructure.adapter.output;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.sale.domain.model.SaleInvoDeta;
import safide.erp.sale.domain.port.ISaleInvoDetaRepository;
import safide.erp.sale.infrastructure.adapter.input.ISaleInvoDetaCrudRepository;
import safide.erp.sale.infrastructure.entity.SaleInvoDetaEntity;
import safide.erp.sale.infrastructure.mapper.SaleInvoDetaMapper;

@Repository
public class SaleInvoDetaCrudRepositoryImpl implements ISaleInvoDetaRepository {

    private final ISaleInvoDetaCrudRepository iSaleInvoDetaCrudRepository;
    private final SaleInvoDetaMapper saleInvoDetaMapper;

    public SaleInvoDetaCrudRepositoryImpl(ISaleInvoDetaCrudRepository iSaleInvoDetaCrudRepository, SaleInvoDetaMapper saleInvoDetaMapper) {
        this.iSaleInvoDetaCrudRepository = iSaleInvoDetaCrudRepository;
        this.saleInvoDetaMapper = saleInvoDetaMapper;
    }

    @Override
    @Transactional
    public SaleInvoDeta save(SaleInvoDeta saleinvodeta) {
        try {
            SaleInvoDetaEntity saleinvodetaEntity = saleInvoDetaMapper.toEntity(saleinvodeta);
            return saleInvoDetaMapper.toDomain(iSaleInvoDetaCrudRepository.save(saleInvoDetaMapper.toEntity(saleinvodeta)));
        } catch (DataIntegrityViolationException ex) {
            throw new GeneErrorResponse("DATA_INTEGRITY_VIOLATION",
                    "Error de integridad de datos al guardar clientes " + ex.getCause(), ex);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al guardar clientes detalle de factura " + ex.getMessage(), ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<SaleInvoDeta> findAll() {
        try {
            return saleInvoDetaMapper.toDomainList(iSaleInvoDetaCrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de clientes detalle de factura", ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public SaleInvoDeta findById(Long id) {
        return saleInvoDetaMapper.toDomain(iSaleInvoDetaCrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla clientes detalle de factura")
        ));
    }

    @Override
    @Transactional
    public SaleInvoDeta update(Long id, SaleInvoDeta saleinvodeta) {
        try {
            if(!iSaleInvoDetaCrudRepository.existsById(id)){
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla clientes detalle de factura");
            }
            return saleInvoDetaMapper.toDomain(iSaleInvoDetaCrudRepository.save(saleInvoDetaMapper.toEntity(saleinvodeta)));
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar cliente detalle de factura", ex);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            if(!iSaleInvoDetaCrudRepository.existsById(id)){
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla clientes detalle de factura");
            }
            iSaleInvoDetaCrudRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar cliente detalle de factura", ex);
        }
    }
}
