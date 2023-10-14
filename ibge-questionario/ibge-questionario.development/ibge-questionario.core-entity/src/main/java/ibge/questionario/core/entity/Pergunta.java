package ibge.questionario.core.entity;

import java.util.List;

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
@Table(name = "tb_pergunta")
public class Pergunta {

	@Column(name = "cod_pergunta")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "txt_pergunta")
	private String description;

	@Column(name = "cod_tipo_pergunta")
	private String type;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "tb_pergunta_resposta", joinColumns = @JoinColumn(name = "cod_pergunta"), inverseJoinColumns = @JoinColumn(name = "cod_resposta"))
	private List<Resposta> respostas;
}
