package safide.erp.general.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneTaxeHead {
    private Long id_getahe;
    private Long id_macohe;
    private Long id_macode;
    private Long id_getaty;
    private Long name_getahe;
    private Long amount_getahe;
    private Long alterna_getahe;

}
