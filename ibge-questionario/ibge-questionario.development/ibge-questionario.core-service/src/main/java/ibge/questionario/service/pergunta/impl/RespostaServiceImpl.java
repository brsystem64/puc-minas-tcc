package ibge.questionario.service.pergunta.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibge.questionario.core.entity.EntrevistaResposta;
import ibge.questionario.infra.repository.EntrevistaRespostaRepository;
import ibge.questionario.service.pergunta.RespostaService;

@Service
public class RespostaServiceImpl implements RespostaService {

	@Autowired
	EntrevistaRespostaRepository entrevistaRespostaRepository;

	@Override
	public void responder(List<EntrevistaResposta> respostas) {
		respostas.forEach(resposta -> {
			Optional<EntrevistaResposta> enty = 	entrevistaRespostaRepository.findByEntrevistaAndQuestaoAndLevel(resposta.getEntrevista(), resposta.getQuestao(), Integer.valueOf(resposta.getLevel()));
			if(enty.isPresent()) {
				EntrevistaResposta entity = enty.get();
				entity.setVal_resposta(resposta.getVal_resposta());
				entrevistaRespostaRepository.save(entity);
			}else {
				entrevistaRespostaRepository.save(resposta);
			}
				
		});
		
	}

	@Override
	public List<EntrevistaResposta> consultarRespostasDaEntrevista(Integer entrevista) {
		Optional<List<EntrevistaResposta>> opt = entrevistaRespostaRepository.findByEntrevista(entrevista);
		return opt.get();
	}

}
