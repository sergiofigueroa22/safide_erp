package safide.erp.general.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenePaymDeta {
    private Integer id;
    private Integer id_macohe;
    private Integer id_macode;
    private String name_gepade;
    private Integer bank_gepade;
    private String alterna_gepade;
    private String alternb_gepade;
    private Integer id_gepahe;
}
