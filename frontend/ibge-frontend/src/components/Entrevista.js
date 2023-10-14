import { useState } from 'react';
import Header from './Header.js';
import Sessao from './Sessao.js';

function Entrevista(){

    const  [sessaoId, setSessaoId] = useState(1);
    

    function mudaSessao(i){
        setSessaoId(sessaoId+i);

    }
    return(
        <>
            <Header/>
            <div class="container">
            <Sessao sessaoId={sessaoId} mudaSessao={mudaSessao}/>
            </div>
            <button class="btn btn-chatbot right">chatbot</button>
        </>
    );
}


export default  Entrevista;