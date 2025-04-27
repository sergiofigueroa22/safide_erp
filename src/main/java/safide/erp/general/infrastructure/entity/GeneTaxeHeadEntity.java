package safide.erp.general.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;
import java.math.BigDecimal;
@Entity
@Table(name="gene_taxe_head")
@Data
@NoArgsConstructor
public class GeneTaxeHeadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_getahe")
    private Long id;
    private Long id_macohe;
    private Long id_macode;
    @Column(length=60, unique = true, nullable = false)
    private String name_getahe;
    private BigDecimal quantia_getahe = BigDecimal.ZERO;
    @Column(length=10,nullable = true)
    private String alterna_getahe;
}
