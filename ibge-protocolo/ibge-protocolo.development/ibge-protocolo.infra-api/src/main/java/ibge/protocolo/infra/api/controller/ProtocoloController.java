package ibge.protocolo.infra.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibge.protocolo.core.entity.Entrevista;
import ibge.protocolo.core.entity.Protocolo;
import ibge.protocolo.core.service.EntrevistaService;
import ibge.protocolo.core.service.ProtocoloService;
import ibge.protocolo.infra.api.dto.request.ProtocoloRequest;
import ibge.protocolo.infra.api.dto.response.ProtocoloDetalheResponse;
import ibge.protocolo.infra.api.dto.response.ProtocoloResponse;

@RestController
@RequestMapping("/protocolo")
public class ProtocoloController {

	@Autowired
	ProtocoloService protocoloService;

	@Autowired
	EntrevistaService entrevistaService;
	
	@GetMapping("/{protocoloId}")
	public ResponseEntity<ProtocoloDetalheResponse> getEntrevista(@PathVariable(name = "protocoloId") String protocoloId) {
		Protocolo protocolo   = protocoloService.consultar(protocoloId);
		Entrevista entrevista =  entrevistaService.buscaPorProtocolo(protocoloId);
		return ResponseEntity.ok(ProtocoloDetalheResponse.toDto(protocolo, entrevista));

	}

	@PostMapping
	public ResponseEntity<ProtocoloResponse> novaEntrevista(@RequestBody(required = true) ProtocoloRequest protocolo) {
		Protocolo entity = protocoloService.criar(protocolo.toEntity());
		return new ResponseEntity(ProtocoloResponse.toDto(entity), HttpStatus.CREATED);
	}
	
	@PostMapping("/{protocolId}/autenticar")
	public ResponseEntity<Void> autenticarProtocolo(@PathVariable String protocolId, @RequestHeader String documento){
		Boolean validado = protocoloService.autenticar(protocolId, documento);
		if(validado) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
}
