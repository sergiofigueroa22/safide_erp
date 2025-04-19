package safide.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SafideApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafideApplication.class, args);
	}
	
	@GetMapping
	public String hola() {
		return "Hola Safide ERP Web";
	}
	

}
