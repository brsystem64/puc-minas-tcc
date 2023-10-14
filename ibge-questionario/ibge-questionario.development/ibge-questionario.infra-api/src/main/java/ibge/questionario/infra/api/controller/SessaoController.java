package ibge.questionario.infra.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibge.questionario.api.dto.PerguntaDTO;
import ibge.questionario.api.dto.RespostaDTO;
import ibge.questionario.api.dto.SessaoResponse;
import ibge.questionario.core.entity.Resposta;
import ibge.questionario.core.entity.Sessao;
import ibge.questionario.core.entity.SessaoPergunta;
import ibge.questionario.service.pergunta.SessaoService;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

	@Autowired
	SessaoService service;
	

	@GetMapping("/{sessaoId}/perguntas")
	public SessaoResponse consultaPerguntasDaSessao(@PathVariable Integer sessaoId) {
		Sessao sessao = service.consultaPerguntasDaSessao(sessaoId);
		return montaSessao(sessao);
	}
	
	@GetMapping("sessao/{sessaoId}/resposta/entrevista/{entrevistaId}")
	public Void consultarRespostasDaSessao(@PathVariable Integer sessaoId, @PathVariable String entrevistaId) {
		
		return null;
	}
	

	private SessaoResponse montaSessao(Sessao sessao) {
		SessaoResponse response = new SessaoResponse();
		response.setCodigo(sessao.getCod_sessao());
		response.setDescricao(sessao.getTxt_sessao());
		response.setPerguntas(montaPerguntas(sessao.getPerguntas()));
		
		return response;
	}

	private List<PerguntaDTO> montaPerguntas(List<SessaoPergunta> list) {
		List<PerguntaDTO> perguntasDto = new ArrayList<>();

		list.forEach(pergunta -> {
			PerguntaDTO perguntadto = new PerguntaDTO();
			perguntadto.setCodigo(pergunta.getPergunta().getId());
			perguntadto.setPergunta(pergunta.getPergunta().getDescription());
			perguntadto.setTipo(Integer.valueOf(pergunta.getPergunta().getType()));
			perguntadto.setCharMax(pergunta.getMax_char());
			perguntadto.setCharMin(pergunta.getMin_char());
			perguntadto.setObrigatorio("S".equals(pergunta.getFlg_obrigatorio()));
			if (perguntadto.getTipo().equals(1))
				perguntadto.setRespostas(montaResposta(pergunta.getPergunta().getRespostas()));

			perguntasDto.add(perguntadto);
		});

		return perguntasDto;
	}

	private List<RespostaDTO> montaResposta(List<Resposta> respostas) {
		List<RespostaDTO> respostasDto = new ArrayList<>();
		respostas.forEach(resposta -> {
			RespostaDTO respostadto = new RespostaDTO();
			respostadto.setCodigo(resposta.getCod_resposta());
			respostadto.setDescricao(resposta.getTxt_resposta());
			respostadto.setValor(resposta.getVal_resposta());

			respostasDto.add(respostadto);
		});

		return respostasDto;
	}
}
