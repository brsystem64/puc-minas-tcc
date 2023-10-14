package ibge.protocolo.infra.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibge.protocolo.core.entity.Protocolo;

@Repository
public interface ProtocoloRepository extends JpaRepository<Protocolo, String> {

	public Optional<Protocolo> findByTicketAndDocumento(String ticket, String documento);
}
