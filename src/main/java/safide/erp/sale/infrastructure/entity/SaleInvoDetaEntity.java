package safide.erp.sale.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="sale_invo_deta")
@Data
@NoArgsConstructor
public class SaleInvoDetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sainde")
    private Long id;
    private Long id_macohe;
    private Long id_inprhe;
    private Long id_macode;
    private BigDecimal quantia_sainde;
    private BigDecimal discoun_sainde;
    private BigDecimal pricea_sainde;
    private BigDecimal priceb_sainde;
    private BigDecimal value_sainde;
    private BigDecimal quantib_sainde;
    private BigDecimal quantic_sainde;
    private String nandina_sainde;
    private String sequent_sainde;
    private String observa_sainde;
    private String observb_sainde;
    private String observc_sainde;
    @ManyToOne()
    @JoinColumn(name = "id_sainhe")
    private SaleInvoHeadEntity saleInvoHeadEntity;

    @OneToMany(mappedBy = "saleInvoDetaEntity", cascade = CascadeType.PERSIST)
    private List<SaleInvoTaxeEntity> saleInvoTaxes;

}
