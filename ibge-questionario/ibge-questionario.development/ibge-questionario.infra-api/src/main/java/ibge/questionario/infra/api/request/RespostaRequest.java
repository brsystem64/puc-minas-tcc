package ibge.questionario.infra.api.request;

import ibge.questionario.core.entity.EntrevistaResposta;
import lombok.Data;

@Data
public class RespostaRequest {

	
	private Integer codigoPergunta;
	private String valorResposta;
	private String nivel;
	
	
	public EntrevistaResposta toEntity() {
		EntrevistaResposta entrevistaResposta = new EntrevistaResposta();
		entrevistaResposta.setQuestao(codigoPergunta);
		entrevistaResposta.setLevel(Integer.valueOf(nivel));
		entrevistaResposta.setVal_resposta(valorResposta);
		return entrevistaResposta;
		
	}
}
