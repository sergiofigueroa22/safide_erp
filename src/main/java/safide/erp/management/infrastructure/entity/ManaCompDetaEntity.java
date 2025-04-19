package safide.erp.management.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mana_comp_deta")
@Data
@NoArgsConstructor
public class ManaCompDetaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_macode")
	private Integer id;
	private Integer id_macohe;
	@Column(unique = true, nullable = true)
	private String name_macode;
	private String pseudon_macode;
	private String address_macode;
	private String phone_macode;
	private String email_macode;
	private String delegat_macode;
	private String documea_macode;
	private String documeb_macode;
	private String documec_macode;
	private String alterna_macode;
}
