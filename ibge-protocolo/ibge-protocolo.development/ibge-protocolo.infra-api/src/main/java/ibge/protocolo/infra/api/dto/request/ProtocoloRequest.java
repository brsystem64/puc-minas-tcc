package ibge.protocolo.infra.api.dto.request;

import ibge.protocolo.core.entity.Protocolo;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProtocoloRequest {

	private Integer codigoSessao;
	private String tipoDocumento;
	private String codigoDocumento;
	private String nomeEntrevistado;
	private String codigoRecenseador;
	
	
	public Protocolo toEntity() {		
		Protocolo protocolo = new Protocolo();
		protocolo.setTip_documento(tipoDocumento);
		protocolo.setDocumento(codigoDocumento);
		protocolo.setCod_recenseador(codigoRecenseador);
		protocolo.setTxt_nome_entrevistado(nomeEntrevistado);

		return protocolo;
	}
}
