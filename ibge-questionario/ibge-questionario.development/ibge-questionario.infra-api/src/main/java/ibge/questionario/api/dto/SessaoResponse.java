package ibge.questionario.api.dto;

import java.util.List;

import ibge.questionario.core.entity.Pergunta;
import lombok.Data;

@Data
public class SessaoResponse {

	private Integer codigo;
	private String descricao;
	private List<PerguntaDTO> perguntas;
	
}
