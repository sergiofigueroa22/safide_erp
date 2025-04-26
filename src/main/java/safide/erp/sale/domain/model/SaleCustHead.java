package safide.erp.sale.domain.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleCustHead {
    private Integer id;
    private Integer id_macode;
    private Integer id_macohe;
    private String name_sacuhe;
    private String pseudo_sacuhe;
    private String documea_sacuhe;
    private String streeta_sacuhe;
    private String streetb_sacuhe;
    private String postalc_sacuhe;
    private String contaca_sacuhe;
    private String contacb_sacuhe;
    private String phonea_sacuhe;
    private String phoneb_sacuhe;
    private String movil_sacuhe;
    private String emaila_sacuhe;
    private String emailb_sacuhe;
    private String url_web_sacuhe;
    private String delegat_sacuhe;
    private LocalDateTime date_sacuhe;
    private LocalDateTime date_syst_sacuhe;
    private String observa_sacuhe;
    private String observb_sacuhe;
    private String observc_sacuhe;
    private Integer idrecur_sacuhe;
    private Integer related_sacuhe;
}
