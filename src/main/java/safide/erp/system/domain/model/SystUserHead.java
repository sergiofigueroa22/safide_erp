package safide.erp.system.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystUserHead {
	private Long id;
    private String name_syushe;
    private String delegat_syushe;
    private String email_syushe;
    private String passwor_syushe;
    private LocalDateTime datacre_syushe;
    private SystUserType sysusertype;
    private Long id_macohe;
    private Long id_macode;
}
