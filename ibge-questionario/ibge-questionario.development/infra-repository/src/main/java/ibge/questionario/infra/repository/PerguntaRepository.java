package ibge.questionario.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibge.questionario.core.entity.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Integer>{

}
