angular.module('app.listagem', ['ngRoute']).controller('ListagemController', ['$scope', '$http', '$location', function (scope, http, location) {
    scope.vm = {};
    const urlBase = 'http://localhost:8080/app/proposta';

    scope.inicializar = () => {
        http.get(urlBase + "/findAll").then((retorno) => scope.vm.propostas = retorno.data);
        // scope.consultarTodos();
    };

    scope.avaliarProposta = (idProposta) => {
        let url = urlBase + "/avaliar";
        http.post(url, idProposta).then((retorno) => {
            scope.inicializar();
            openModal(retorno.data)
        });
    };

    scope.toProposta = () => location.path('/proposta');

    function openModal(retorno){
        var element = angular.element(templateModal(retorno));
        element.modal({
            backdrop: 'static',
            keyboard: true,
        });
    }

    function templateModal(retorno){
        return `<div class="modal fade" tabindex="-1" role="dialog" id="my_modal_popup">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Resultado Avaliação de Crédito</h4>
                            </div>
                            <div class="modal-body">
                                <p>Resultado Análise : ${retorno.statusProposta}</p>
                                <p>Limite: ${retorno.descricaoStatus}</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
                            </div>
                        </div>
                    </div>
                </div>`
    }

    // scope.consultarCpf = (cpf) => {
    //     http.get(urlBase + '/filtrar', {
    //         params: {cpf: cpf}
    //     }).then((retorno) => scope.vm.analises = retorno.data);
    // };
    //
    // scope.consultar = (cpf) => {
    //     console.log('cpf', cpf);
    //     if (cpf) {
    //         scope.consultarCpf(cpf);
    //     } else {
    //         scope.consultarTodos();
    //     }
    // };
    //
    // scope.toProposta = () => window.location.href = '/#!/cadastro';

}]);