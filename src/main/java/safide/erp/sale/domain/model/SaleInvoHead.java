package safide.erp.sale.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

    public SaleInvoHead(){
        saleInvoDetas = new ArrayList<>();
    }
    public void actualizarTotales() {
        this.saleInvoDetas.forEach(SaleInvoDeta::calcularPrecios);
    }
    public BigDecimal getSubtotalInvoice() {
        return this.saleInvoDetas.stream()
                .map(SaleInvoDeta::getValue_sainde)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public void agregarDetalle(SaleInvoDeta detalle) {
        detalle.calcularPrecios(); // Actualiza precios antes de agregar
        this.saleInvoDetas.add(detalle);
    }
}
