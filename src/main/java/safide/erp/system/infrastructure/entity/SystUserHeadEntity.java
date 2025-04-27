package safide.erp.system.infrastructure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import safide.erp.system.domain.model.SystUserType;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="syst_user_head")
@Data
@NoArgsConstructor
public class SystUserHeadEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_syushe")
	private Long id;
	@Column(unique = true, nullable = true)
    private String name_syushe;
    private String delegat_syushe;
    @Email(message = "El formato del correo electrónico no es válido")
    @Column(name = "email_syushe", unique = true, nullable = true)
    private String email_syushe;
    private String passwor_syushe;
    private LocalDateTime datacre_syushe;
    @Enumerated(EnumType.STRING)
    private SystUserType sysusertype;
    private Long id_macohe;
    private Long id_macode;

}
