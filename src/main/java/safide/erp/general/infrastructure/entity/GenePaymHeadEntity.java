package safide.erp.general.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Table(name = "gene_paym_head")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenePaymHeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gepahe")
    private Integer id;

    @Column(name = "id_macohe")
    private Integer id_macohe;

    @Column(name = "id_macode")
    private Integer id_macode;

    @Column(name = "name_gepahe", length = 250)
    private String name_gepahe;

    @Column(name = "alterna_gepahe", length = 3)
    private String alterna_gepahe;

    @OneToMany(mappedBy = "genePaymHead", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GenePaymDetaEntity> genePaymDeta;
}
