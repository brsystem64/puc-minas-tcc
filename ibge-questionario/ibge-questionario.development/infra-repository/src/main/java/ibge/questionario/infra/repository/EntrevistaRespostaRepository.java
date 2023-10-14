package ibge.questionario.infra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibge.questionario.core.entity.EntrevistaResposta;

@Repository
public interface EntrevistaRespostaRepository extends JpaRepository<EntrevistaResposta, Void>{

	public Optional<EntrevistaResposta> findByEntrevistaAndQuestaoAndLevel(Integer cod_entrevista, Integer cod_questao, Integer cod_level);

	public Optional<List<EntrevistaResposta>> findByEntrevista(Integer cod_entrevista);
}
