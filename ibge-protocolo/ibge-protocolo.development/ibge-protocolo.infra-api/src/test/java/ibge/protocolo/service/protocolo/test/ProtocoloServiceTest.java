package ibge.protocolo.service.protocolo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ibge.protocolo.core.entity.Protocolo;
import ibge.protocolo.core.service.impl.ProtocoloServiceImpl;
import ibge.protocolo.infra.repository.EntrevistaRepository;
import ibge.protocolo.infra.repository.ProtocoloRepository;

@ExtendWith(MockitoExtension.class)
public class ProtocoloServiceTest {

	@Mock
	ProtocoloRepository protocoloRepository;
	
	@Mock
	EntrevistaRepository entrevistaRepository;
	
	@InjectMocks
	ProtocoloServiceImpl service;
	
	@Test
	@DisplayName("[Camada Service] Gerando novo protocolo")
	public void deveCriarNovoProtocolo() {
		

		Protocolo protocolo = new Protocolo();
		protocolo.setCod_recenseador("123");
		protocolo.setDocumento("11122233344");
		protocolo.setTip_documento("CPF");
		protocolo.setTxt_nome_entrevistado("Entrevistado 1");
		
		Protocolo result = service.criar(protocolo);
		
		assertNotNull(result);
		assertNotNull(result.getTicket());
	}
	
	@Test
	@DisplayName("[Camada Service] Autenticando Protocolo Invalido")
	public void autenticandoProtocoloInValido() {
		when(protocoloRepository.findByTicketAndDocumento(any(), any())).thenReturn(Optional.of(new Protocolo()));
		boolean result = service.autenticar(any(), any());
		assertEquals(!result, false);
	}
	@Test
	@DisplayName("[Camada Service] Autenticando Protocolo Valido")
	public void autenticandoProtocoloValido() {
		when(protocoloRepository.findByTicketAndDocumento(any(), any())).thenReturn(Optional.of(new Protocolo()));
		boolean result= service.autenticar(any(), any());
		assertEquals(result, true);
	}
	
}
