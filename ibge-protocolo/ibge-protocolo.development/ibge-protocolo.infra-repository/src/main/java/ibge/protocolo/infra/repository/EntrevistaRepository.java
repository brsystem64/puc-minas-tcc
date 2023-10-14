package ibge.protocolo.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibge.protocolo.core.entity.Entrevista;

@Repository
public interface EntrevistaRepository extends JpaRepository<Entrevista, Integer>{

	public Optional<Entrevista> findByTicket(String cod_ticket);
}
