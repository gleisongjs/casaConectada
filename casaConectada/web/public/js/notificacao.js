/*
 | -------------------------------------------------------------------
 | Função "removerNotificacao"
 | -------------------------------------------------------------------
 | Função que remove a mensagem de notificacao
 |
 */
function removerNotificacao(seletor) {
    $(seletor).html('');
    $(seletor).removeClass('alert alert-success');
    $(seletor).removeClass('alert');
    $(seletor).removeClass('alert alert-danger');
    $(seletor).removeClass('alert alert-warning');
}


/*
 | -------------------------------------------------------------------
 | Função "notificacao"
 | -------------------------------------------------------------------
 | Função que notificacao, retorna a mensagem de resposta do servidor
 |
 */
function notificacao(msg, seletor) {
    removerNotificacao(seletor);

    $(seletor).html(msg.texto + '<a href="#" onclick="removerNotificacao(\'' + seletor + '\');" class="close" data-dismiss="alert">&times;</a>');
    switch (msg.tipo) {
        case "a":
            $(seletor).addClass('alert alert-warning');
        break;

        case "e":
            $(seletor).addClass('alert alert-danger');
        break;

        case "s":
            $(seletor).addClass('alert alert-success');
        break;
    }

}
