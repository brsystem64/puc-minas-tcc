package ibge.questionario.core.entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_sessao")
public class Sessao {

	@Column(name = "cod_sessao")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_sessao;

	@Column
	private String txt_sessao;

	@Column
	private String flg_composto;

	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	/*@JoinTable(name = "tb_sessao_pergunta", joinColumns = @JoinColumn(name = "cod_sessao"), inverseJoinColumns = @JoinColumn(name = "cod_pergunta"))
	private List<Pergunta> perguntas;*/

	@OneToMany
	@JoinColumn(name = "cod_sessao")
	private List<SessaoPergunta> perguntas;

}
