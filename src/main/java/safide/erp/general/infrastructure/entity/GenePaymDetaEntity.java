package safide.erp.general.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gene_paym_deta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenePaymDetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gepade")
    private Integer id;

    @Column(name = "id_macohe")
    private Integer id_macohe;

    @Column(name = "id_macode")
    private Integer id_macode;

    @Column(name = "name_gepade", length = 250, nullable = false)
    private String name_gepade;

    @Column(name = "bank_gepade")
    private Integer bank_gepade;

    @Column(name = "alterna_gepade",length = 3)
    private String alterna_gepade;

    @Column(name = "alternb_gepade", length = 3)
    private String alternb_gepade;

    @ManyToOne()
    @JoinColumn(name = "id_gepahe")
    private GenePaymHeadEntity genePaymHeadEntity;


}
