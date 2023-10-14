package ibge.protocolo.core.entity;

import java.util.Date;

import ibge.protocolo.core.entity.enums.StatusProtocolo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_entrevista")
@Getter@Setter
@NoArgsConstructor
public class Entrevista {

	private static final Integer PRIMEIRA_SESSAO = 1;
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_entrevista;

	@Column
	private Integer cod_roteiro;

	@Column(name = "cod_ticket")
	private String ticket;

	@Column
	private String cod_status;

	@Column
	private Date dat_inicio;

	@Column
	private Date dat_conclusao;

	@Column
	private Integer cod_ultima_sessao;
	
	
	public Entrevista(String ticket) {
		this.setTicket(ticket);
		this.setCod_status(StatusProtocolo.INICIADO.getStatus());
		this.setDat_inicio(new Date());
		this.setCod_roteiro(PRIMEIRA_SESSAO);
		this.setCod_ultima_sessao(PRIMEIRA_SESSAO);
	}

}
