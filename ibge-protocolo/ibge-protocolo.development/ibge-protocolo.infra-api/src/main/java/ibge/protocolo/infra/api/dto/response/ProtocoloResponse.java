package ibge.protocolo.infra.api.dto.response;

import java.util.Date;

import ibge.protocolo.core.entity.Protocolo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProtocoloResponse {

	private String protocolo;
	private String tipoDocumento;
	private String codigoDocumento;
	private String nomeEntrevistado;
	private String codigoRecenseador;
	private Date   dataCriacao; 
	
	
	public static ProtocoloResponse toDto(Protocolo entity) {
		ProtocoloResponse dto = new ProtocoloResponse();
		dto.setTipoDocumento(entity.getTip_documento());
		dto.setCodigoDocumento(entity.getDocumento());
		dto.setNomeEntrevistado(entity.getTxt_nome_entrevistado());
		dto.setCodigoRecenseador(entity.getCod_recenseador());
		dto.setDataCriacao(entity.getDat_criacao());
		dto.setProtocolo(entity.getTicket());
		
		return dto;
	}
}
