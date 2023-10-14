package ibge.protocolo.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibge.protocolo.core.entity.Entrevista;
import ibge.protocolo.core.service.EntrevistaService;
import ibge.protocolo.infra.repository.EntrevistaRepository;

@Service
public class EntrevistaServiceImpl implements EntrevistaService {

	@Autowired
	EntrevistaRepository entrevistaRepository;
	
	@Override
	public Entrevista buscaPorProtocolo(String protocolo) {
		
		Optional<Entrevista> result = entrevistaRepository.findByTicket(protocolo);
		if(!result.isPresent()) {
			return new Entrevista();
		}
		return result.get();
	}

}
