'use strict';
var app = angular.module('app', [
    'ngRoute',
    'app.proposta',
    'app.listagem',
    'ui.utils.masks'
]).config(['$locationProvider', '$routeProvider', '$httpProvider', function ($locationProvider, $routeProvider, $httpProvider) {

    $routeProvider.when('/proposta', {
        templateUrl: 'views/proposta.html',
        controller: 'PropostaController'
    });

    $routeProvider.when('/', {
        templateUrl: 'views/listagem.html',
        controller: 'ListagemController'
    }).otherwise({redirectTo: '/'});
}]);


