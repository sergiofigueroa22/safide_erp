package safide.erp.inventory.domain.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InveProdHead {
	private Long id;
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
    private LocalDateTime date_inprhe;
    private String serie_inprhe;
    private Long idrecur_inprhe;
    private String brand_inprhe;
    private BigDecimal stock_inprhe;
    private Long id_inprca;
    private Long id_macohe;
    private Long id_macode;
}
