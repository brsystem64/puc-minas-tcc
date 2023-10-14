import { useState } from "react";
import Pergunta from "./Pergunta";


function Sessao({sessaoId, mudaSessao}){
    
    const [sessao, setSessao] = useState({"codigo":null,"descricao":null,"perguntas":[null]});

    const [respostas, setResposta] = useState([]);



    function mudaSessaoTeste(id){
        if(id==1){
            setSessao({"codigo":2,"descricao":"CARACTERISTICA DO DOMICILIO","perguntas":[{"codigo":9,"pergunta":"QUAL A PRINCIPAL FORMA DE ABASTECIMENTO DE\r\nÁGUA UTILIZADA NESTE DOMICÍLIO?","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[{"codigo":23,"descricao":"DOMICÍLIO PARTICULAR PERMANENTE OCUPADO","valor":"1"},{"codigo":24,"descricao":"DOMICÍLIO PARTICULAR IMPROVISADO OCUPADO","valor":"5"},{"codigo":25,"descricao":"DOMICÍLIO COLETIVO COM MORADOR","valor":"6"},{"codigo":26,"descricao":"REDE GERAL DE DISTRIBUIÇÃO","valor":"1"},{"codigo":27,"descricao":"PROFUNDO OU ARTESIANO","valor":"2"},{"codigo":28,"descricao":"RASO, FREÁTICO OU CACIMBA","valor":"3"},{"codigo":29,"descricao":"FONTE, NASCENTE OU MINA","valor":"4"},{"codigo":30,"descricao":"CARRO-PIPA","valor":"5"},{"codigo":31,"descricao":"ÁGUA DA CHUVA ARMAZENADA","valor":"6"},{"codigo":32,"descricao":"RIOS, AÇUDES, CÓRREGOS, LAGOS E IGARAPÉS","valor":"7"},{"codigo":33,"descricao":"OUTRA","valor":"8"}]},{"codigo":10,"pergunta":"O DOMICÍLIO TEM ACESSO À REDE GERAL DE DISTRIBUIÇÃO\r\nDE ÁGUA?","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[{"codigo":34,"descricao":"SIM","valor":"S"},{"codigo":35,"descricao":"NAO","valor":"N"}]},{"codigo":11,"pergunta":"A ÁGUA UTILIZADA NO DOMICÍLIO CHEGA:","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[{"codigo":36,"descricao":"ENCANADA ATÉ DENTRO DA CASA, APARTAMENTO OU HABITAÇÃO","valor":"1"},{"codigo":37,"descricao":"ENCANADA, MAS APENAS NO TERRENO","valor":"2"},{"codigo":38,"descricao":"NÃO CHEGA ENCANADA","valor":"3"}]},{"codigo":12,"pergunta":"PARA ONDE VAI O ESGOTO DO BANHEIRO?","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[{"codigo":39,"descricao":"REDE GERAL OU PLUVIAL","valor":"1"},{"codigo":40,"descricao":"LIGADA À REDE","valor":"2"},{"codigo":41,"descricao":"NÃO LIGADA À REDE","valor":"3"},{"codigo":42,"descricao":"FOSSA RUDIMENTAR OU BURACO","valor":"4"},{"codigo":43,"descricao":"VALA","valor":"5"},{"codigo":44,"descricao":"RIO, LAGO, CÓRREGO OU MAR","valor":"6"},{"codigo":45,"descricao":"OUTRA FORMA","valor":"7"}]},{"codigo":13,"pergunta":"O LIXO DESTE DOMICÍLIO É:","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[{"codigo":46,"descricao":"COLETADO NO DOMICÍLIO POR SERVIÇO DE LIMPEZA","valor":"1"},{"codigo":47,"descricao":"DEPOSITADO EM CAÇAMBA DE SERVIÇO DE LIMPEZA","valor":"2"},{"codigo":48,"descricao":"QUEIMADO NA PROPRIEDADE","valor":"3"},{"codigo":49,"descricao":"ENTERRADO NA PROPRIEDADE","valor":"4"},{"codigo":50,"descricao":"JOGADO EM TERRENO BALDIO, ENCOSTA OU ÁREA PÚBLICA","valor":"5"},{"codigo":51,"descricao":"OUTRO DESTINO","valor":"6"}]}]});
        }else if(id==2){
            setSessao({"codigo":1,"descricao":"IDENTIFICACAO DO DOMICILIO","perguntas":[{"codigo":1,"pergunta":"UF","tipo":2,"charMin":"2","charMax":"2","obrigatorio":true,"respostas":null},{"codigo":2,"pergunta":"MUNICIPIO","tipo":2,"charMin":"2","charMax":"100","obrigatorio":true,"respostas":null},{"codigo":3,"pergunta":"BAIRRO","tipo":2,"charMin":"2","charMax":"100","obrigatorio":true,"respostas":null},{"codigo":4,"pergunta":"RUA","tipo":2,"charMin":"2","charMax":"100","obrigatorio":true,"respostas":null},{"codigo":5,"pergunta":"NUMERO","tipo":2,"charMin":"3","charMax":"6","obrigatorio":true,"respostas":null},{"codigo":6,"pergunta":"COMPLEMENTO","tipo":2,"charMin":"0","charMax":"100","obrigatorio":false,"respostas":null},{"codigo":7,"pergunta":"ESPECIE DE DOMICILIO","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[{"codigo":23,"descricao":"DOMICÍLIO PARTICULAR PERMANENTE OCUPADO","valor":"1"},{"codigo":24,"descricao":"DOMICÍLIO PARTICULAR IMPROVISADO OCUPADO","valor":"5"},{"codigo":25,"descricao":"DOMICÍLIO COLETIVO COM MORADOR","valor":"6"}]},{"codigo":8,"pergunta":"TIPO","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[{"codigo":1,"descricao":"CASA","valor":"11"},{"codigo":2,"descricao":"CASA DE VILA OU EM CONDOMÍNIO","valor":"12"},{"codigo":3,"descricao":"APARTAMENTO","valor":"13"},{"codigo":4,"descricao":"HABITAÇÃO EM CASA DE CÔMODOS OU CORTIÇO","valor":"14"},{"codigo":5,"descricao":"HABITAÇÃO INDÍGENA SEM PAREDES OU MALOCA","valor":"15"},{"codigo":6,"descricao":"ESTRUTURA RESIDENCIAL PERMANENTE DEGRADADA OU INACABADA","valor":"106"},{"codigo":7,"descricao":"TENDA OU BARRACA DE LONA, PLÁSTICO OU TECIDO","valor":"51"},{"codigo":8,"descricao":"DENTRO DO ESTABELECIMENTO EM FUNCIONAMENTO","valor":"52"},{"codigo":9,"descricao":"OUTROS (ABRIGOS NATURAIS E OUTRAS ESTRUTURAS IMPROVISADAS)","valor":"53"},{"codigo":10,"descricao":"ESTRUTURA IMPROVISADA EM LOGRADOURO PÚBLICO, EXCETO TENDA OU BARRACA","valor":"504"},{"codigo":11,"descricao":"ESTRUTURA NÃO RESIDENCIAL PERMANENTE DEGRADADA OU INACABADA","valor":"505"},{"codigo":12,"descricao":"VEÍCULOS (CARROS, CAMINHÕES, TRAILERS, BARCOS ETC.)","valor":"506"},{"codigo":13,"descricao":"ASILO OU OUTRA INSTITUIÇÃO DE LONGA PERMANÊNCIA PARA IDOSOS","valor":"61"},{"codigo":14,"descricao":"HOTEL OU PENSÃO","valor":"62"},{"codigo":15,"descricao":"ALOJAMENTO","valor":"63"},{"codigo":16,"descricao":"PENITENCIÁRIA, CENTRO DE DETENÇÃO E SIMILAR","valor":"64"},{"codigo":17,"descricao":"OUTRO","valor":"65"},{"codigo":18,"descricao":"ABRIGO, ALBERGUE OU CASA DE PASSAGEM PARA POPULAÇÃO EM SITUAÇÃO DE RUA","valor":"606"},{"codigo":19,"descricao":"CLÍNICA PSIQUIÁTRICA, COMUNIDADE TERAPÊUTICA E SIMILAR","valor":"608"},{"codigo":20,"descricao":"ORFANATO E SIMILAR","valor":"609"},{"codigo":21,"descricao":"UNIDADE DE INTERNAÇÃO DE MENORES","valor":"610"},{"codigo":22,"descricao":"QUARTEL OU OUTRA ORGANIZAÇÃO MILITAR","valor":"611"}]}]});
        }
        else{
            setSessao({"codigo":3,"descricao":"INFORMAÇÕES SOBRE MORADORES","perguntas":[{"codigo":14,"pergunta":"DIA ANIVERSARIO","tipo":2,"charMin":"2","charMax":"2","obrigatorio":true,"respostas":null},{"codigo":15,"pergunta":"MES ANIVERSARIO","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[{"codigo":52,"descricao":"JANEIRO","valor":"1"},{"codigo":53,"descricao":"FEVEREIRO","valor":"2"},{"codigo":54,"descricao":"MARCO","valor":"3"},{"codigo":55,"descricao":"ABRIL","valor":"4"},{"codigo":56,"descricao":"MAIO","valor":"5"},{"codigo":57,"descricao":"JUNHO","valor":"6"},{"codigo":58,"descricao":"JULHO","valor":"7"},{"codigo":59,"descricao":"AGOSTO","valor":"8"},{"codigo":60,"descricao":"SETEMBRO","valor":"9"},{"codigo":61,"descricao":"OUTUBRO","valor":"10"},{"codigo":62,"descricao":"NOVEMBRO","valor":"11"},{"codigo":63,"descricao":"DEZEMBRO","valor":"12"}]},{"codigo":16,"pergunta":"ANO ANIVERSARIO","tipo":2,"charMin":"4","charMax":"4","obrigatorio":true,"respostas":null},{"codigo":17,"pergunta":"NOME COMPLETO","tipo":2,"charMin":"2","charMax":"150","obrigatorio":true,"respostas":null},{"codigo":18,"pergunta":"SEXO","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[]},{"codigo":19,"pergunta":"QUAL É A RELAÇÃO DE PARENTESCO OU DE CONVIVÊNCIA COM A PESSOA RESPONSÁVEL PELO DOMICÍLIO?","tipo":1,"charMin":null,"charMax":null,"obrigatorio":true,"respostas":[{"codigo":66,"descricao":"PESSOA RESPONSÁVEL PELO DOMICÍLIO","valor":"1"},{"codigo":67,"descricao":"CÔNJUGE OU COMPANHEIRO(A) DE SEXO DIFERENTE","valor":"2"},{"codigo":68,"descricao":"CÔNJUGE OU COMPANHEIRO(A) DO MESMO SEXO","valor":"3"},{"codigo":69,"descricao":"FILHO(A) DO RESPONSÁVEL E DO CÔNJUGE","valor":"4"},{"codigo":70,"descricao":"FILHO(A) SOMENTE DO RESPONSÁVEL","valor":"5"},{"codigo":71,"descricao":"ENTEADO(A)","valor":"6"},{"codigo":72,"descricao":"GENRO OU NORA","valor":"7"},{"codigo":73,"descricao":"PAI, MÃE, PADRASTO OU MADRASTA","valor":"8"},{"codigo":74,"descricao":"SOGRO(A)","valor":"9"},{"codigo":75,"descricao":"NETO(A)","valor":"10"},{"codigo":76,"descricao":"BISNETO(A)","valor":"11"},{"codigo":77,"descricao":"IRMÃO OU IRMÃ","valor":"12"},{"codigo":78,"descricao":"AVÔ OU AVÓ","valor":"13"},{"codigo":79,"descricao":"OUTRO PARENTE","valor":"14"},{"codigo":80,"descricao":"AGREGADO(A)","valor":"15"},{"codigo":81,"descricao":"CONVIVENTE","valor":"16"},{"codigo":82,"descricao":"PENSIONISTA","valor":"17"},{"codigo":83,"descricao":"EMPREGADO(A) DOMÉSTICO(A)","valor":"18"},{"codigo":84,"descricao":"PARENTE DO(A) EMPREGADO(A) DOMÉSTICO(A)","valor":"19"},{"codigo":85,"descricao":"INDIVIDUAL EM DOMICÍLIO COLETIVO","valor":"20"}]}]});
        }
        console.log(respostas);
    }

    function setRespostas(codigo){
                setResposta([...respostas, {"pergunta": codigo, "resposta": null}]);
    }

    

    
    return(
        <div class="sessao">
            <div>
                <h4 id={sessao.codigo}>{sessao.descricao}</h4>
                <span>As perguntas a seguir são referentes à {sessao.descricao}. Qualquer dúvida referente as perguntas, utilize o chatbot no canto inferior direito.</span>
            </div>
            <div class="perguntas">
              {
                sessao.perguntas.map(function(pergunta){
                    if(pergunta != null && pergunta != undefined ){
               //         setRespostas(pergunta.codigo, null);
                    }
                    
                    return(<Pergunta pergunta={pergunta} />);
                })
              }
            </div>
            <div class="botoes">
                <button class="btn left" onClick={() => {mudaSessao(-1); mudaSessaoTeste(sessaoId)}}>Voltar</button>
                <button class="btn right" onClick={() =>{ mudaSessao(1); mudaSessaoTeste(sessaoId)}}>Continuar</button>
            </div>
            <div class="row"/>
        </div>
    )
}

export default Sessao;



