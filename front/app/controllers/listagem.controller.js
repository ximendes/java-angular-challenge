angular.module('app.listagem', ['ngRoute']).controller('ListagemController', ['$scope', '$http', '$window', function (scope, http, window) {
    scope.vm = {};
    const urlBase = 'http://localhost:8400/analise';

    scope.inicializar = () => {
        scope.consultarTodos();
        http.get(urlBase + "/limites").then((retorno) => scope.vm.limties = retorno.data);

    };

    scope.consultarCpf = (cpf) => {
        http.get(urlBase + '/filtrar', {
            params: {cpf: cpf}
        }).then((retorno) => scope.vm.analises = retorno.data);
    };

    scope.consultar = (cpf) => {
        console.log('cpf', cpf);
        if (cpf) {
            scope.consultarCpf(cpf);
        } else {
            scope.consultarTodos();
        }
    };

    scope.toProposta = () => window.location.href = '/#!/cadastro';

    scope.consultarTodos = () => http.get(urlBase).then((retorno) => scope.vm.analises = retorno.data);


}]);