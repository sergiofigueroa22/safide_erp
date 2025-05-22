package safide.erp.sale.domain.model;

import jakarta.persistence.Column;
import lombok.*;
import safide.erp.general.domain.model.GeneTaxeHead;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


@Builder
@Data
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

    private BigDecimal quantia_sainde = BigDecimal.ZERO;
    private BigDecimal perdisc_sainde = BigDecimal.ZERO;
    private BigDecimal pricea_sainde = BigDecimal.ZERO;
    private BigDecimal priceb_sainde = BigDecimal.ZERO;
    private BigDecimal value_sainde = BigDecimal.ZERO;
    private Long id_getahe;
    private BigDecimal  valtaxe_sainde = BigDecimal.ZERO;
    private BigDecimal  valdisc_sainde = BigDecimal.ZERO;
    // Aquí calculamos los precios y el IVA antes de enviar al save
    public void calcularPrecios(List<GeneTaxeHead> taxList) {
        validarDatosParaCalculo();
        validarDescuento();
        // Calcular precios con descuento
        BigDecimal factorDescuento = BigDecimal.ONE.subtract(
                perdisc_sainde.divide(MAX_DISCOUNT, CALC_SCALE, ROUND_MODE)
        );
        this.priceb_sainde = pricea_sainde.multiply(factorDescuento)
                .setScale(FINAL_SCALE, ROUND_MODE);

        // Calcular el valor base de la factura
        this.value_sainde = priceb_sainde.multiply(quantia_sainde)
                .setScale(FINAL_SCALE, ROUND_MODE);

        // Calcular el valor del descuento (total de descuento aplicado)
        this.valdisc_sainde = pricea_sainde.subtract(priceb_sainde)
                .multiply(quantia_sainde)
                .setScale(FINAL_SCALE, ROUND_MODE);

        // Calcular el IVA de los impuestos asociados
        calcularIVA(taxList);


    }

    // Método para calcular el IVA según el porcentaje del impuesto asociado
    private void calcularIVA(List<GeneTaxeHead> taxList) {
        if (id_getahe != null) {
            // Buscar el tipo de impuesto correspondiente
            GeneTaxeHead geneTaxeHead = taxList.stream()
                    .filter(taxe -> taxe.getId().equals(id_getahe))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Impuesto no encontrado"));

            // Obtener el porcentaje de IVA
            BigDecimal ivaPercent = geneTaxeHead.getPercent_getahe();

            // Calcular el valor del IVA
            if (ivaPercent != null && ivaPercent.compareTo(BigDecimal.ZERO) > 0) {
                this.valtaxe_sainde = value_sainde.multiply(ivaPercent.divide(BigDecimal.valueOf(100), FINAL_SCALE, ROUND_MODE))
                        .setScale(FINAL_SCALE, ROUND_MODE);
            } else {
                this.valtaxe_sainde = BigDecimal.ZERO;
            }
        } else {
            this.valtaxe_sainde = BigDecimal.ZERO;
        }
    }

    // Métodos de validación
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
        if (perdisc_sainde.compareTo(BigDecimal.ZERO) < 0 ||
                perdisc_sainde.compareTo(MAX_DISCOUNT) > 0) {
            throw new IllegalArgumentException("Porcentaje de descuento debe estar entre 0 y 100%");
        }
    }

}
