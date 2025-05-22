package safide.erp.general.infrastructure.entity;

import jakarta.persistence.*;
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
    private Long id_getaty;
    private String name_getahe;
    private BigDecimal amount_getahe;
    private String alterna_getahe;
    private BigDecimal percent_getahe;
}
