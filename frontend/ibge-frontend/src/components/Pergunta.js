
function PerguntaEscolha({pergunta}){

    return(
        <div class="input-field col s12 l6">
     <h6 id={pergunta.codigo} class="pergunta">{pergunta.pergunta}</h6>
{pergunta.respostas.map(function(resposta){
    return(
        <div class="row">
        <div class="input-field col s12 l12">
         <label>
        <input name={pergunta.codigo} type="radio" id={resposta.codigo} value={resposta.valor} />
        <span>{resposta.descricao}</span>
      </label>
      </div>
        </div>

    );
})}
     </div> 
    )   
}

function PerguntaTextoAberto({pergunta}){
    return(
        <div class="input-field col s3 l3">
            <label id={pergunta.codigo} class="pergunta">{pergunta.pergunta}{pergunta.obrigatorio ? <span class="text-red">*</span> : ""}</label>
            <input type="text" minLength={pergunta.charMin} maxLength={pergunta.charMax} required={pergunta.obrigatorio ? "required" : ""}></input>
        </div>
    )

}


function Pergunta({pergunta}){
    if(pergunta == null || pergunta == undefined){
        return(<></>);
    }
    if(pergunta.tipo == 1){
        return (
        <div class="row">
            <PerguntaEscolha pergunta={pergunta}/>
         </div>
        )
    }
    else{
        return <PerguntaTextoAberto pergunta={pergunta}/>
    }
}

export default Pergunta;