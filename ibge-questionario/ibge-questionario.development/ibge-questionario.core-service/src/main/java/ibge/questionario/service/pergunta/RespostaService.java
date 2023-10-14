package ibge.questionario.service.pergunta;

import java.util.List;

import ibge.questionario.core.entity.EntrevistaResposta;

public interface RespostaService {

	public void responder(List<EntrevistaResposta> respostas);
	
	public List<EntrevistaResposta> consultarRespostasDaEntrevista(Integer entrevista);
	
}
