package safide.erp.sale.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SaleInvoTaxe {
    private Long id;
    private Long id_macohe;
    private Long id_macode;
    private Long id_getahe;
    private BigDecimal quantia_sainta;
}
