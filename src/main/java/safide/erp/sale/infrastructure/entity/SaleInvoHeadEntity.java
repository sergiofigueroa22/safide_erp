package safide.erp.sale.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="sale_invo_head")
@Data
@NoArgsConstructor
public class SaleInvoHeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sainhe")
    private Long id;
    private Long id_macohe;
    private Long id_sacuhe;
    private Long id_macode;
    private String number_sainhe;
    @CreationTimestamp
    private LocalDateTime datetra_sainhe;
    private String authori_sainhe;
    private String awba_sainhe;
    private String awbb_sainhe;
    private String dae_sainhe;
    private String purchac_sainhe;
    private String referen_sainhe;
    private String accpass_sainhe;
    private String xmloff_sainhe;
    private String pdfoff_sainhe;
    private String xmlaut_sainhe;
    private String pdfaut_sainhe;
    @CreationTimestamp
    private LocalDateTime datedel_sainhe;
    @CreationTimestamp
    private LocalDateTime dateshi_sainhe;
    @CreationTimestamp
    private LocalDateTime datesys_sainhe;
    private String hoursys_sainhe;
    private String observa_sainhe;
    private String observb_sainhe;
    private String observc_sainhe;
    private String observd_sainhe;
    private String observe_sainhe;
    @OneToMany(mappedBy = "saleInvoHeadEntity", cascade = CascadeType.PERSIST)
    private List<SaleInvoDetaEntity> saleInvoDetas;


}
