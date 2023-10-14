package ibge.questionario.infra.api.response;

import ibge.questionario.core.entity.EntrevistaResposta;
import lombok.Data;

@Data
public class RespostasEntrevistaResponse {

	private Integer codigoPergunta;
	private String valorResposta;
	private String nivel;

	public static RespostasEntrevistaResponse fromEntity(EntrevistaResposta resposta) {
		RespostasEntrevistaResponse dto = new RespostasEntrevistaResponse();
		dto.setCodigoPergunta(resposta.getQuestao());
		dto.setValorResposta(resposta.getVal_resposta());
		dto.setNivel(resposta.getLevel().toString());
		return dto;
	}
}
