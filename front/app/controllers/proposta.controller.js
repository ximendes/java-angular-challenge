angular.module('app.proposta', ['ngRoute']).controller('PropostaController', ['$scope', '$http', '$location', function (scope, http, location) {
    scope.vm = {};
    const urlBase = 'http://localhost:8080/app/proposta';

    scope.inicializar = () => {
        // http.get(urlBase + '/estados-civis').then((retorno) => scope.vm.estadosCivis = retorno.data);
        // http.get(urlBase + '/estados').then((retorno) => scope.vm.estados = retorno.data);
        // http.get(urlBase + '/sexos').then((retorno) => scope.vm.sexos = retorno.data);
    };

    scope.salvar = (proposta) => {
        http.post(urlBase, proposta).then(() => scope.toListagem());
    };

    scope.toListagem = () => location.path('/listagem');

}]);