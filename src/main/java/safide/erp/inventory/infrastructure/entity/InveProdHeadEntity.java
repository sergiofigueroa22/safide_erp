package safide.erp.inventory.infrastructure.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="inve_prod_head")
@Data
@NoArgsConstructor
public class InveProdHeadEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inprhe")
	private Long id;
	@Column(unique = true, nullable = true)
	private String name_inprhe;
	private String descrip_inprhe;
	private String barcode_inprhe;
	private String sequent_inprhe;
	private String model_inprhe;
	private String observa_inprhe;
    private BigDecimal rate_inprhe;
    private BigDecimal pricea_inprhe;
    private BigDecimal priceb_inprhe;
    private BigDecimal pricec_inprhe;
    private BigDecimal discoun_inprhe;
    @CreationTimestamp
    private LocalDateTime date_inprhe;
    private String serie_inprhe;
    private Integer idrecur_inprhe;
    private String brand_inprhe;
    private BigDecimal stock_inprhe;
    private Long id_inprca;
    private Long id_macohe;
    private Long id_macode;
    private Long id_getahe;
}
