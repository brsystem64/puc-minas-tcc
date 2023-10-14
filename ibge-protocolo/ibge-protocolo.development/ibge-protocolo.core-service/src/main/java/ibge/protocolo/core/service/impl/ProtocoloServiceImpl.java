package ibge.protocolo.core.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibge.protocolo.core.entity.Entrevista;
import ibge.protocolo.core.entity.Protocolo;
import ibge.protocolo.core.service.ProtocoloService;
import ibge.protocolo.infra.repository.EntrevistaRepository;
import ibge.protocolo.infra.repository.ProtocoloRepository;
import jakarta.transaction.Transactional;

@Service
public class ProtocoloServiceImpl implements ProtocoloService {

	
	
	@Autowired
	ProtocoloRepository protocoloRepository;
	
	@Autowired
	EntrevistaRepository entrevistaRepository;
	
	@Override
	public Protocolo consultar(String protocolo) {
		return protocoloRepository.findById(protocolo).get();
	}

	@Override
	@Transactional
	public Protocolo criar(Protocolo protocolo) {
		String ticket = gerarNovoProtocolo(protocolo.getDocumento());
		protocolo.setTicket(ticket);
		protocolo.setDat_criacao(new Date());
		
		Entrevista entrevista = new Entrevista(ticket);	
		
		protocoloRepository.save(protocolo);
		entrevistaRepository.save(entrevista);
		
		return protocolo;
	}

	@Override
	public Boolean autenticar(String protocolId, String documento) {
		Optional<Protocolo> protocolo = protocoloRepository.findByTicketAndDocumento(protocolId, documento);
		return protocolo.isPresent();
	}

	
}
