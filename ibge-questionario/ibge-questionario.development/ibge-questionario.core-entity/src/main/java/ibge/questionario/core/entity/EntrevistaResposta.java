package ibge.questionario.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_entrevista_respostas")
@Data
public class EntrevistaResposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_entrevista_resposta;;
	
	@Column(name = "cod_entrevista")
	private Integer entrevista;
	@Column(name = "cod_questao")
	private Integer questao;
	@Column(name = "val_level")
	private Integer level;
	
	@Column
	private String val_resposta;
}
