package ibge.questionario.api.dto;

import java.util.List;

import lombok.Data;

@Data
public class PerguntaDTO {

	private Integer codigo;
	
	private String pergunta;
	
	private Integer tipo;
	
	private String charMin;
	
	private String charMax;
	
	private boolean obrigatorio;
	
	private List<RespostaDTO> respostas;
}
