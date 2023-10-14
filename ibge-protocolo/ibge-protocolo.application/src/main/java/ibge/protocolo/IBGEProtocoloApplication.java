package ibge.protocolo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ibge.protocolo")
@EnableAutoConfiguration
public class IBGEProtocoloApplication {

	public static void main(String[] args) {
		SpringApplication.run(IBGEProtocoloApplication.class, args);
	}

}
