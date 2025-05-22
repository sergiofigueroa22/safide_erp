package safide.erp.sale.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    @Column(columnDefinition = "NUMERIC(22,15)")
    private BigDecimal quantia_sainde;
    @Column(columnDefinition = "NUMERIC(22,15)")
    private BigDecimal perdisc_sainde;
    @Column(columnDefinition = "NUMERIC(22,15)")
    private BigDecimal pricea_sainde;
    @Column(columnDefinition = "NUMERIC(22,15)")
    private BigDecimal priceb_sainde;
    @Column(columnDefinition = "NUMERIC(22,15)")  
    private BigDecimal value_sainde;
    @Column(columnDefinition = "NUMERIC(22,15)")
    private BigDecimal quantib_sainde;
    @Column(columnDefinition = "NUMERIC(22,15)")
    private BigDecimal quantic_sainde;
    private String nandina_sainde;
    private String sequent_sainde;
    private String observa_sainde;
    private String observb_sainde;
    private String observc_sainde;
    private Long id_getahe;
    @Column(columnDefinition = "NUMERIC(22,15)")
    private BigDecimal  valtaxe_sainde;
    @Column(columnDefinition = "NUMERIC(22,15)")
    private BigDecimal  valdisc_sainde;
    @ManyToOne()
    @JoinColumn(name = "id_sainhe")
    private SaleInvoHeadEntity saleInvoHeadEntity;

}
