package ibge.questionario.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_sessao_pergunta")
public class SessaoPergunta {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_questao;
	
	@OneToOne
	@JoinColumn(name = "cod_pergunta")
	private Pergunta pergunta;
	
	@Column
	private String min_char;

	@Column
	private String max_char;

	@Column
	private String flg_obrigatorio;

	@Column
	private Integer cod_ordem;

	
}
