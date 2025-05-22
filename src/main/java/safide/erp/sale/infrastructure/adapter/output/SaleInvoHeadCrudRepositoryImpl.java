package safide.erp.sale.infrastructure.adapter.output;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import safide.erp.general.domain.model.GeneTaxeHead;
import safide.erp.general.domain.port.IGeneTaxeHeadRepository;
import safide.erp.generic.infrastructure.exception.GeneErrorResponse;
import safide.erp.sale.domain.model.SaleInvoHead;
import safide.erp.sale.domain.port.ISaleInvoHeadRepository;
import safide.erp.sale.infrastructure.adapter.input.ISaleInvoHeadCrudRepository;
import safide.erp.sale.infrastructure.entity.SaleInvoDetaEntity;
import safide.erp.sale.infrastructure.entity.SaleInvoHeadEntity;
import safide.erp.sale.infrastructure.mapper.SaleInvoHeadMapper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleInvoHeadCrudRepositoryImpl implements ISaleInvoHeadRepository {

    private final ISaleInvoHeadCrudRepository iSaleInvoHeadCrudRepository;
    private final SaleInvoHeadMapper saleInvoHeadMapper;
    private final IGeneTaxeHeadRepository geneTaxeHeadRepository;

    public SaleInvoHeadCrudRepositoryImpl(
            ISaleInvoHeadCrudRepository iSaleInvoHeadCrudRepository,
            SaleInvoHeadMapper saleInvoHeadMapper,
            IGeneTaxeHeadRepository geneTaxeHeadRepository
    ) {
        this.iSaleInvoHeadCrudRepository = iSaleInvoHeadCrudRepository;
        this.saleInvoHeadMapper = saleInvoHeadMapper;
        this.geneTaxeHeadRepository = geneTaxeHeadRepository;
    }

    @Override
    @Transactional
    public SaleInvoHead save(SaleInvoHead saleinvohead) {
        try {
            // Obtener la lista de impuestos disponibles
            List<GeneTaxeHead> taxList = new ArrayList<>();
            geneTaxeHeadRepository.findAll().forEach(taxList::add);  // Convertir Iterable a List

            // Pasar la lista de impuestos a cada detalle para que calcule el IVA
            saleinvohead.actualizarTotales(taxList);

            // Convertir la entidad de dominio SaleInvoHead a su correspondiente entidad JPA
            SaleInvoHeadEntity saleinvoheadEntity = saleInvoHeadMapper.toEntity(saleinvohead);

            // Establecer la relación entre los detalles y la cabecera (solo con entidades JPA)
            for (SaleInvoDetaEntity detalleEntity : saleinvoheadEntity.getSaleInvoDetas()) {
                // Aquí solo estamos configurando la relación entre el detalle y la cabecera (no los impuestos aún)
                detalleEntity.setSaleInvoHeadEntity(saleinvoheadEntity);
            }

            // Guardamos la cabecera de la factura, junto con los detalles e impuestos asociados
            return saleInvoHeadMapper.toDomain(iSaleInvoHeadCrudRepository.save(saleinvoheadEntity));

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
    public Iterable<SaleInvoHead> findAll() {
        try {
            return saleInvoHeadMapper.toDomainList(iSaleInvoHeadCrudRepository.findAll());
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR", "Error al acceder a los datos de cabecera de factura SaleInvoHead", ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public SaleInvoHead findById(Long id) {
        return saleInvoHeadMapper.toDomain(iSaleInvoHeadCrudRepository.findById(id).orElseThrow(
                ()-> new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla cabecera de factura SaleInvoHead")
        ));
    }

    @Override
    @Transactional
    public SaleInvoHead update(Long id, SaleInvoHead saleinvohead) {
        try {
            if(!iSaleInvoHeadCrudRepository.existsById(id)){
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla cabecera de factura SaleInvoHead");
            }
            return saleInvoHeadMapper.toDomain(iSaleInvoHeadCrudRepository.save(saleInvoHeadMapper.toEntity(saleinvohead)));
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar cliente SaleInvoHead", ex);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            if(!iSaleInvoHeadCrudRepository.existsById(id)){
                throw new GeneErrorResponse("NOT_FOUND","ID: " + id + " no existe en la base de datos, tabla cabecera de factura SaleInvoHead");
            }
            iSaleInvoHeadCrudRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new GeneErrorResponse("DATABASE_ERROR","Error al actualizar cliente SaleInvoHead", ex);
        }
    }
}