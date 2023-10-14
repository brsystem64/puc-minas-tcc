package ibge.questionario.service.pergunta.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibge.questionario.core.entity.Pergunta;
import ibge.questionario.infra.repository.PerguntaRepository;
import ibge.questionario.service.pergunta.PerguntaService;
import lombok.extern.java.Log;

@Service
@Log
public class PerguntaServiceImpl implements PerguntaService {

	@Autowired
	private PerguntaRepository perguntaRepository;

	@Autowired
	public void teste() {
		Optional<Pergunta> p = perguntaRepository.findById(1);
		log.info(p.get().getDescription());
	}

	@Override
	public List<Pergunta> consultaPerguntaPorSessao(Integer sessao) {
		log.info("");
		Optional<Pergunta> p = perguntaRepository.findById(7);
		return Arrays.asList(p.get());
	}

}
