package safide.erp.sale.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="sale_invo_taxe")
@Data
@NoArgsConstructor
public class SaleInvoTaxeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sainta")
    private Long id;
    private Long id_macohe;
    private Long id_macode;
    private Long id_getahe;
    private Long quantia_sainta;
    @ManyToOne()
    @JoinColumn(name = "id_sainde")
    private SaleInvoDetaEntity saleInvoDetaEntity;
}
