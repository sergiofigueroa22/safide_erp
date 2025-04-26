package safide.erp.sale.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="sale_cust_head")
@Data
@NoArgsConstructor
public class SaleCustHeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sacuhe")
    private Integer id;
    @Column(unique = true, nullable = true)
    private String documea_sacuhe;
    private Integer id_macode;
    private Integer id_macohe;
    private String name_sacuhe;
    private String pseudo_sacuhe;
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
    private String urlweb_sacuhe;
    private String delegat_sacuhe;
    private LocalDateTime date_sacuhe;
    private LocalDateTime date_syst_sacuhe;
    private String observa_sacuhe;
    private String observb_sacuhe;
    private String observc_sacuhe;
    private Integer idrecur_sacuhe;
    private Integer related_sacuhe;
}
