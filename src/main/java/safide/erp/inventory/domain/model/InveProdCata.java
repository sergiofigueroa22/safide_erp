package safide.erp.inventory.domain.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InveProdCata {
	private Integer id;
	private Integer id_macohe;
    private Integer id_macode;
	private String name_inprca;
	private String alterna_inprca;
}
