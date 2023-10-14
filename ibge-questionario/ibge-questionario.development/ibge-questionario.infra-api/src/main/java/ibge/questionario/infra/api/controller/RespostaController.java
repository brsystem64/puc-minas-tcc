package ibge.questionario.infra.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibge.questionario.core.entity.EntrevistaResposta;
import ibge.questionario.infra.api.request.RespostaRequest;
import ibge.questionario.infra.api.response.RespostasEntrevistaResponse;
import ibge.questionario.service.pergunta.RespostaService;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

	@Autowired
	RespostaService respostaService;
	
	@PostMapping("/entrevista/{entrevistaId}")
	public ResponseEntity<Void> responder(@PathVariable Integer entrevistaId, @RequestBody  List<RespostaRequest> respostas){
		List<EntrevistaResposta> respostasEntity = new ArrayList<>();
		
		respostas.forEach(resposta -> {
			EntrevistaResposta respostaEntity = resposta.toEntity();
			respostaEntity.setEntrevista(entrevistaId);
			respostasEntity.add(respostaEntity);
		});
		
		respostaService.responder(respostasEntity);
		return null;
	}
	
	@GetMapping("/entrevista/{entrevistaId}")
	public ResponseEntity<List<RespostasEntrevistaResponse>> responder(@PathVariable Integer entrevistaId){
		List<RespostasEntrevistaResponse> result = new ArrayList<>();
		List<EntrevistaResposta> entities =	respostaService.consultarRespostasDaEntrevista(entrevistaId);
		entities.forEach(entity -> {
			result.add(RespostasEntrevistaResponse.fromEntity(entity));
		});
		return ResponseEntity.ok(result);
	}
	
}
