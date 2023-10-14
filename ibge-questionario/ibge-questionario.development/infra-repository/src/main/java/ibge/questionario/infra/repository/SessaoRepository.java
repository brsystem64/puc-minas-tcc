package ibge.questionario.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibge.questionario.core.entity.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer>{

}
