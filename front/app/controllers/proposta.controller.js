angular.module('app.proposta', ['ngRoute']).controller('PropostaController', ['$scope', '$http', '$location', function (scope, http, location) {
    scope.vm = {};
    const urlBase = 'http://localhost:8080/app/proposta';

    scope.inicializar = () => {
    };

    scope.salvar = (proposta) => {
        http.post(urlBase, proposta).then(response => {
            scope.toListagem()
        }).catch(response => {
            $('.toast-message').empty();
            let html = toast(response.data.errors);
            $('.toast-message').append(html);
            $('.toast').toast('show');
        });
    };


    function toast(errors){
        return `<div role="alert" aria-live="assertive" aria-atomic="true" class="toast" data-autohide="false" >
                    <div class="toast-header">
                        <strong class="mr-auto">Campos Obrigatórios</strong>
                        <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="toast-body">
                        ${errors.join('\n')}
                    </div>
                </div>`
    }

    scope.toListagem = () => location.path('/listagem');

}]);