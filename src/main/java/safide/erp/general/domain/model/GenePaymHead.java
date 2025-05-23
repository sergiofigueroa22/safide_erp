package safide.erp.general.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class GenePaymHead {
    private Integer id;
    private Integer id_macohe;
    private Integer id_macode;
    private String name_gepahe;
    private String alterna_gepahe;
    List<GenePaymDeta> genePaymDetas;
}
