package ibge.protocolo.core.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_ticket")
@Getter@Setter
public class Protocolo {

	@Column(name = "cod_ticket")
	@Id
	private String ticket;
	
	@Column
	private String tip_documento;
	
	@Column(name = "cod_documento")
	private String documento;
	
	@Column
	private String txt_nome_entrevistado;
	
	@Column
	private String cod_recenseador;
	
	@Column
	private Date dat_criacao;
	
	
	public Protocolo ticket(String ticket) {
		this.ticket = ticket;
		return this;
	}
}
