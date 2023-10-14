package ibge.questionario.service.pergunta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibge.questionario.core.entity.Sessao;
import ibge.questionario.infra.repository.SessaoRepository;

@Service
public class SessaoService {
@Autowired
SessaoRepository sessaoRepository;

	
	public Sessao consultaPerguntasDaSessao(Integer sessaoId){
		Optional<Sessao> result =sessaoRepository.findById(sessaoId);
		return result.get();
	}
	
	
}
