package ibge.questionario.service.pergunta;

import java.util.List;

import ibge.questionario.core.entity.Pergunta;

public interface PerguntaService {

	public List<Pergunta> consultaPerguntaPorSessao(Integer sessao);
}
