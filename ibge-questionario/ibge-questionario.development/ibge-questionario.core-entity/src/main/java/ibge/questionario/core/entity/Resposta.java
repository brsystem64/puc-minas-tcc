package ibge.questionario.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_resposta")
public class Resposta {

	@Column(name = "cod_resposta")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_resposta;
	
	@Column(name = "txt_resposta")
	private String txt_resposta;
	
	@Column(name= "val_resposta")
	private String val_resposta;
	
}
