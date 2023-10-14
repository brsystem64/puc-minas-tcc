package ibge.questionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ibge.questionario")
@EnableAutoConfiguration
public class IBGEQuestionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(IBGEQuestionarioApplication.class, args);
	}

}
