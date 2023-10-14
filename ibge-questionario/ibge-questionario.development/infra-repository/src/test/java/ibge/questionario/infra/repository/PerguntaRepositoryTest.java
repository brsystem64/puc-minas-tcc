package ibge.questionario.infra.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ibge.questionario.core.entity.Pergunta;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {PerguntaRepositoryTest.class})
public class PerguntaRepositoryTest {

	//@Autowired
	private PerguntaRepository perguntaRepository;
	private Optional<Pergunta> findById;
	

	
	//@Test
	public void deveRetornarPerguntaPorIdentificador () throws Exception {
		findById = perguntaRepository.findById(1);
		Integer id = findById.get().getId();
		assertEquals(id, 1);
	}
	
	
	
}
