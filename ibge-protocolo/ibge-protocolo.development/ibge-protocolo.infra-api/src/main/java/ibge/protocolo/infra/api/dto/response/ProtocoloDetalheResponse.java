package ibge.protocolo.infra.api.dto.response;

import java.util.Date;

import ibge.protocolo.core.entity.Entrevista;
import ibge.protocolo.core.entity.Protocolo;
import ibge.protocolo.core.entity.enums.StatusProtocolo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProtocoloDetalheResponse {

	private String protocolo;
	private Integer codigoEntrevista;
	private String tipoDocumento;
	private String codigoDocumento;
	private String nomeEntrevistado;
	private String codigoRecenseador;
	private Date   dataCriacao;
	
	private Integer codigoRoteiro;
	private Integer codigoUltimaSessao;
	private String status;
	private Date dataConclusao;
	private Date dataInicio;
	
	public static ProtocoloDetalheResponse toDto(Protocolo entity, Entrevista entity2) {
		
		ProtocoloDetalheResponse dto = new ProtocoloDetalheResponse();
		dto.setCodigoEntrevista(entity2.getCod_entrevista());
		dto.setTipoDocumento(entity.getTip_documento());
		dto.setCodigoDocumento(entity.getDocumento());
		dto.setNomeEntrevistado(entity.getTxt_nome_entrevistado());
		dto.setCodigoRecenseador(entity.getCod_recenseador());
		dto.setDataCriacao(entity.getDat_criacao());
		dto.setProtocolo(entity.getTicket());
		dto.setCodigoRoteiro(entity2.getCod_roteiro());
		dto.setCodigoUltimaSessao(entity2.getCod_ultima_sessao());
		dto.setStatus(StatusProtocolo.findByCodigo(entity2.getCod_status()).name());
		dto.setDataInicio(entity2.getDat_inicio());
		dto.setDataConclusao(entity2.getDat_conclusao());
		return dto;
	}
}
