package ibge.protocolo.infra.api.controller.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import ibge.protocolo.core.entity.Entrevista;
import ibge.protocolo.core.entity.Protocolo;
import ibge.protocolo.core.service.EntrevistaService;
import ibge.protocolo.core.service.ProtocoloService;
import ibge.protocolo.infra.api.controller.ProtocoloController;
import ibge.protocolo.infra.api.dto.request.ProtocoloRequest;
import ibge.protocolo.infra.api.dto.response.ProtocoloDetalheResponse;
import ibge.protocolo.infra.api.dto.response.ProtocoloResponse;

@ExtendWith(MockitoExtension.class)
public class ProtocoloControllerTest {

	
	@Mock
	private ProtocoloService protocoloService;
	
	@Mock
	private EntrevistaService entrevistaService;
	
	@InjectMocks
	private ProtocoloController controller;
	

	
	@Test
	@DisplayName("[Camada Controller] Criando uma nova entrevista - gerando novo protocolo")
	public void deveCriarNovoProtocolo() {
		
		ProtocoloRequest request = new ProtocoloRequest();
		request.setTipoDocumento("CPF");
		request.setCodigoDocumento("33244569102");
		request.setNomeEntrevistado("Richard Gomes");
		request.setCodigoRecenseador("123");
		request.setCodigoSessao(1);
		
		ProtocoloResponse responseMock = new ProtocoloResponse();
		responseMock.setTipoDocumento(request.getTipoDocumento());
		responseMock.setCodigoDocumento(request.getCodigoDocumento());
		responseMock.setNomeEntrevistado(request.getNomeEntrevistado());
		responseMock.setCodigoRecenseador(request.getCodigoRecenseador());
		responseMock.setProtocolo("XzoiASx");

		when(protocoloService.criar(any())).thenReturn(request.toEntity().ticket("XzoiASx"));

		ResponseEntity<ProtocoloResponse> response =  controller.novaEntrevista(request);
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response.getBody().getProtocolo());
		assertEquals(response.getBody().getProtocolo(), "XzoiASx");
	}
	
	@Test
	@DisplayName("[Camada Controller] Deve autenticar o protocolo Valido")
	public void  deveAutenticarProtocoloValido() {
		when(protocoloService.autenticar(any(), any())).thenReturn(true);
		
		ResponseEntity<Void> response = controller.autenticarProtocolo(any(), any());
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}
	
	@Test
	@DisplayName("[Camada Controller] Não Deve autenticar o protocolo Valido")
	public void  naoDeveAutenticarProtocoloValido() {
		when(protocoloService.autenticar(any(), any())).thenReturn(false);
		
		ResponseEntity<Void> response = controller.autenticarProtocolo(any(), any());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	@Test
	@DisplayName("[Camada Controller] Deve consultar protocolo")
	public void  deveConsultarProtocolo() {
		Protocolo protocolo = new Protocolo();
		protocolo.setCod_recenseador("123");
		protocolo.setDat_criacao(new Date());
		protocolo.setDocumento("33164877723");
		protocolo.setTicket(protocoloService.gerarNovoProtocolo(null));
		protocolo.setTip_documento("CPF");
		protocolo.setTxt_nome_entrevistado("Entevistado teste");
		
		Entrevista entrevista = new Entrevista();
		entrevista.setTicket(protocolo.getTicket());
		entrevista.setCod_roteiro(1);
		entrevista.setCod_entrevista(1);
		entrevista.setCod_status("I");
		entrevista.setCod_ultima_sessao(1);
		entrevista.setDat_conclusao(null);
		entrevista.setDat_inicio(new Date());
		
		
		when(protocoloService.consultar(any())).thenReturn(protocolo);
		when(entrevistaService.buscaPorProtocolo(any())).thenReturn(entrevista);
		
		ResponseEntity<ProtocoloDetalheResponse> response = controller.getEntrevista(any());
		
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response.getBody());
		assertEquals(protocolo, protocolo);
		assertEquals(entrevista, entrevista);
		

	
	} 
}
