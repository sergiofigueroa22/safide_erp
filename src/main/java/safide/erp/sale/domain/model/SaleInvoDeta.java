package safide.erp.sale.domain.model;

import jakarta.persistence.Column;
import lombok.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleInvoDeta {

    private static final int CALC_SCALE = 22;
    private static final int FINAL_SCALE = 2;
    private static final RoundingMode ROUND_MODE = RoundingMode.HALF_UP;
    private static final BigDecimal MAX_DISCOUNT = BigDecimal.valueOf(100);

    private Long id;
    private Long id_macohe;
    private Long id_inprhe;
    private Long id_macode;
    @Column(columnDefinition = "NUMERIC(22,15)")
    @Builder.Default
    private BigDecimal quantia_sainde = BigDecimal.ZERO;
    @Column(columnDefinition = "NUMERIC(22,15)")
    @Builder.Default
    private BigDecimal discoun_sainde = BigDecimal.ZERO;
    @Column(columnDefinition = "NUMERIC(22,15)")
    @Builder.Default
    private BigDecimal pricea_sainde = BigDecimal.ZERO;
    @Column(columnDefinition = "NUMERIC(22,15)")
    @Builder.Default
    private BigDecimal priceb_sainde = BigDecimal.ZERO;
    @Column(columnDefinition = "NUMERIC(22,15)")
    @Builder.Default
    private BigDecimal value_sainde = BigDecimal.ZERO;
    List<SaleInvoTaxe> saleInvoTaxes;
    public void calcularPrecios() {
        validarDatosParaCalculo();
        validarDescuento();
        BigDecimal factorDescuento = BigDecimal.ONE.subtract(
                discoun_sainde.divide(MAX_DISCOUNT, CALC_SCALE, ROUND_MODE)
        );
        this.priceb_sainde = pricea_sainde.multiply(factorDescuento)
                .setScale(FINAL_SCALE, ROUND_MODE);
        this.value_sainde = priceb_sainde.multiply(quantia_sainde)
                .setScale(FINAL_SCALE, ROUND_MODE);
    }

    private void validarDatosParaCalculo() {
        if (pricea_sainde == null || quantia_sainde == null) {
            throw new IllegalStateException("Precio base y cantidad son requeridos");
        }
        if (pricea_sainde.compareTo(BigDecimal.ZERO) < 0 ||
                quantia_sainde.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Precio y cantidad no pueden ser negativos");
        }
    }
    private void validarDescuento() {
        if (discoun_sainde.compareTo(BigDecimal.ZERO) < 0 ||
                discoun_sainde.compareTo(MAX_DISCOUNT) > 0) {
            throw new IllegalArgumentException("Descuento debe estar entre 0 y 100%");
        }
    }
    public void setPricea_sainde(BigDecimal pricea_sainde) {
        this.pricea_sainde = pricea_sainde.setScale(FINAL_SCALE, ROUND_MODE);
        calcularPrecios();
    }
    public void setQuantia_sainde(BigDecimal quantia_sainde) {
        this.quantia_sainde = quantia_sainde.setScale(CALC_SCALE, ROUND_MODE);
        calcularPrecios();
    }
    public void setDiscoun_sainde(BigDecimal discoun_sainde) {
        this.discoun_sainde = discoun_sainde.setScale(FINAL_SCALE, ROUND_MODE);
        calcularPrecios();
    }
}