package safide.erp.inventory.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="inve_prod_cata")
@Data
@NoArgsConstructor
public class InveProdCataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inprca")
	private Integer id;
    @Column(unique = true, nullable = true)
	private String name_inprca;
	private String alterna_inprca;
	private Integer id_macohe;
	private Integer id_macode;
}
