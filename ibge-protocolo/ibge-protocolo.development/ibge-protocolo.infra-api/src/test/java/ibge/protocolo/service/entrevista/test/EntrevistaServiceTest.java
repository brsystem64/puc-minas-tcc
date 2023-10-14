package ibge.protocolo.service.entrevista.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ibge.protocolo.core.entity.Entrevista;
import ibge.protocolo.core.service.impl.EntrevistaServiceImpl;
import ibge.protocolo.infra.repository.EntrevistaRepository;

@ExtendWith(MockitoExtension.class)
public class EntrevistaServiceTest {

	@Mock
	EntrevistaRepository repository;
	
	@InjectMocks
	EntrevistaServiceImpl service;

	
	@Test
	@DisplayName("[Camada Service] Deve consultar dados Entrevista")
	public void  deveConsultarEntrevista() {
		Entrevista entrevista = new Entrevista();
		entrevista.setCod_entrevista(123);
		entrevista.setCod_roteiro(1);
		entrevista.setCod_status("I");
		entrevista.setCod_ultima_sessao(1);
		entrevista.setTicket("Aoizx0z");
		
		when(repository.findByTicket(any())).thenReturn(Optional.of(entrevista));
		Entrevista result = service.buscaPorProtocolo(any());
		assertNotNull(result);
		assertNotNull(result.getTicket());
	}
}
