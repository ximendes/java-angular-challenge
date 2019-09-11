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
            ModalDemoCtrl.open(retorno);
        });
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
    scope.toProposta = () => location.path('/proposta');
    //
    // scope.consultarTodos = () => http.get(urlBase).then((retorno) => scope.vm.analises = retorno.data);




}]);