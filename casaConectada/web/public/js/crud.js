/*
 | -------------------------------------------------------------------
 | Função "salvar_alterar"
 | -------------------------------------------------------------------
 | Função que envia requisições para o servidor, com o proposito de gravar ou alterar o registro
 |
 */
function salvar_alterar(id_form, metodo, datatype, antesEnviar, retorno) {
    var form = $(id_form).serialize();//recupera os dados do formulario
    var url = $(id_form).attr("action");//recupera a url
    enviar(form, url + '/' + metodo, datatype, antesEnviar, retorno);
}

/*
 | -------------------------------------------------------------------
 | Função "consultar"
 | -------------------------------------------------------------------
 | Função que envia requisições para o servidor, com o proposito 
 | de consultar uma lista de registro 
 |
 */
function consultar(id_form, metodo, datatype, antesEnviar, retorno) {
    var form = $(id_form).serialize();//recupera os dados do formulario
    var url = $(id_form).attr("action");//recupera a url
    enviar(form, url + '/' + metodo, datatype, antesEnviar, retorno);
}

/*
 | -------------------------------------------------------------------
 | Função "excluir"
 | -------------------------------------------------------------------
 | Função que envia requisições para o servidor, com o proposito 
 | de excluir um registro 
 |
 */
function ativar_inativar(id_form, metodo, datatype, antesEnviar, retorno) {
    var form = $(id_form).serialize();//recupera os dados do formulario
    var url = $(id_form).attr("action");//recupera a url
    enviar(form, url + '/' + metodo, datatype, antesEnviar, retorno);
}

/*
 | -------------------------------------------------------------------
 | Função "pesquisar"
 | -------------------------------------------------------------------
 | Função que envia requisições para o servidor, com o proposito 
 | de pesquisar um registro 
 */
function visualizar(id_form, metodo, datatype, antesEnviar, retorno) {
    var url = $(id_form).attr("action");//recupera a url
    $.ajax({
        type: 'post',
        url: url + '/' + metodo,
        dataType: datatype,
        beforeSend: antesEnviar,
        error: mostraErro, //essa função de encontra no arquivo "principal.js"
        success: retorno
    });
}

/*
 | -------------------------------------------------------------------
 | Função "antesEnviar"
 | -------------------------------------------------------------------
 | Função Generica de BeforeSend, apenas limpa a resposta do servidor
 | alem de exibir um load.
 |
 */
function antesEnviar(id_resposta, id_load) {
    removerNotificacao(id_resposta);
    loading(id_load, 1);
    $('.btn-disable').attr("disabled", "enabled");
}

/*
 | -------------------------------------------------------------------
 | Funções "retornoConsulta"
 | -------------------------------------------------------------------
 | Função que retorna resultado da função 'consultar'
 */
function retornoConsulta(ret) {
    $('#resposta_consulta').html(ret);
    loading('#load_consulta', 0);
}