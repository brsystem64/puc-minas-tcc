package ibge.protocolo.core.entity.enums;

public enum StatusProtocolo {

	INICIADO("I"),
	FINALIZADO("F"),
	CANCELADO("C");
	
	private String status;
	
	StatusProtocolo(String status){
		this.status = status;
	}
	
	
	public static StatusProtocolo findByCodigo(String codigo) {
		for(StatusProtocolo status : StatusProtocolo.values()) {
			if(status.getStatus().equals(codigo)) {
				return status;
			}
		}
		return null;
	}
	
	public String getStatus() {
		return this.status;
	}
}
