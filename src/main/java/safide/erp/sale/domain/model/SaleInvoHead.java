package safide.erp.sale.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import safide.erp.general.domain.model.GeneTaxeHead;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class SaleInvoHead {
    private Long id;
    private Long id_macohe;
    private Long id_sacuhe;
    private Long id_macode;
    private String number_sainhe;
    private LocalDateTime datetra_sainhe;
    private String authori_sainhe;
    private String awba_sainhe;
    private String awbb_sainhe;
    private String dae_sainhe;
    private String purchac_sainhe;
    private String referen_sainhe;
    private String accpass_sainhe;
    private String xmloff_sainhe;
    private String pdfoff_sainhe;
    private String xmlaut_sainhe;
    private String pdfaut_sainhe;
    private LocalDateTime datedel_sainhe;
    private LocalDateTime dateshi_sainhe;
    private LocalDateTime datesys_sainhe;
    private String hoursys_sainhe;
    private String observa_sainhe;
    private String observb_sainhe;
    private String observc_sainhe;
    private String observd_sainhe;
    private String observe_sainhe;
    List<SaleInvoDeta> saleInvoDetas;

    public SaleInvoHead() {
        saleInvoDetas = new ArrayList<>();
    }

    // Método para actualizar los totales de la factura (incluyendo IVA)
    public void actualizarTotales(List<GeneTaxeHead> taxList) {
        // Pasamos la lista de impuestos a cada detalle para que calcule el IVA
        this.saleInvoDetas.forEach(detalle -> detalle.calcularPrecios(taxList));
    }

    // Método para obtener el subtotal de la factura (sin IVA)
    public BigDecimal getSubtotalInvoice() {
        return this.saleInvoDetas.stream()
                .map(SaleInvoDeta::getValue_sainde)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Método para obtener el total de IVA de la factura
    public BigDecimal getTotalIVA() {
        return this.saleInvoDetas.stream()
                .map(SaleInvoDeta::getValtaxe_sainde)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Método para obtener el total de descuento de la factura
    public BigDecimal getTotalDescuento() {
        return this.saleInvoDetas.stream()
                .map(SaleInvoDeta::getValdisc_sainde)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Método para obtener el total de la factura (subtotal + IVA)
    public BigDecimal getTotalInvoice() {
        return getSubtotalInvoice().add(getTotalIVA()).setScale(2, RoundingMode.HALF_UP);
    }

    // Método para agregar un detalle a la factura
    public void agregarDetalle(SaleInvoDeta detalle) {
        detalle.calcularPrecios(new ArrayList<GeneTaxeHead>());  // Puedes pasar la lista de impuestos aquí si la tienes en el contexto
        this.saleInvoDetas.add(detalle);
    }
}