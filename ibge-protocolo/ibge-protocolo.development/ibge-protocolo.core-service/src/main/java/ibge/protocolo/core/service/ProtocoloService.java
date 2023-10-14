package ibge.protocolo.core.service;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

import ch.qos.logback.core.testUtil.RandomUtil;
import ibge.protocolo.core.entity.Protocolo;

public interface ProtocoloService {

	
	default String gerarNovoProtocolo(String documento) {
		return RandomStringUtils.randomAlphanumeric(8);
	}
	 
	public Protocolo consultar(String protocolo);
	
	public Protocolo criar(Protocolo protocolo);

	public Boolean autenticar(String protocolId, String documento);
}
