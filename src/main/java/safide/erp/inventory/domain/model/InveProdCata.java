package safide.erp.inventory.domain.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InveProdCata {
	private Long id;
	private Long id_macohe;
	private Long id_macode;
	private String name_inprca;
	private String alterna_inprca;
}
