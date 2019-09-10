'use strict';
var app = angular.module('app', [
    'ngRoute',
    'app.proposta',
    'app.listagem',
    'app.login',
    'ui.utils.masks'
]).config(['$locationProvider', '$routeProvider', '$httpProvider', function ($locationProvider, $routeProvider, $httpProvider) {
    $locationProvider.hashPrefix('!');

    $routeProvider.when('/proposta', {
        templateUrl: 'views/proposta.html',
        controller: 'PropostaController'
    });

    $routeProvider.when('/listagem', {
        templateUrl: 'views/listagem.html',
        controller: 'ListagemController'
    });

    $httpProvider.defaults.withCredentials = true;
    // $routeProvider.otherwise({redirectTo: '/proposta'});
}]).run(['$rootScope', '$location', '$http', '$window', function run($rootScope, $location, $http, $window) {
    var userData = $window.sessionStorage.getItem('userData');
    if (userData) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + JSON.parse(userData).authData;
    }

    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        var restrictedPage = $.inArray($location.path(), ['/login']) === -1;
        var loggedIn = $window.sessionStorage.getItem('userData');
        if (restrictedPage && !loggedIn) {
            $location.path('/login');
        }
    });
}]);


