package safide.erp.general.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneTaxeHead {
    private Long id;
    private Long id_macohe;
    private Long id_macode;
    private Long id_getaty;
    private String name_getahe;
    private BigDecimal amount_getahe;
    private String alterna_getahe;
    private BigDecimal percent_getahe;
}
