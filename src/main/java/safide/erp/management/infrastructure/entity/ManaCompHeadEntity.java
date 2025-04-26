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
@Table(name="mana_comp_head")
@Data
@NoArgsConstructor
public class ManaCompHeadEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_macohe")
	private Long id;
	@Column(unique = true, nullable = true)
	private String name_macohe;
	private String pseudon_macohe;
	private String address_macode;
	private String phone_macode;
	private String delegat_macohe;
	private String url_web_macohe;
	private String documea_macohe;
	private String logo_macohe;
	private String documeb_macohe;
	private String documec_macohe;
	private String alterna_macohe;
	private String alternb_macohe;
}
