package ibge.questionario.api.dto;

import lombok.Data;

@Data
public class RespostaDTO {

	private Integer codigo;
	private String descricao;
	private String valor;
}
