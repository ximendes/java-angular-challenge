'use strict';
var app = angular.module('app', [
    'ngRoute',
    'app.proposta',
    'app.listagem',
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
    }).otherwise({redirectTo: '/listagem'});

    $routeProvider.when('/', {
        templateUrl: 'views/listagem.html',
        controller: 'ListagemController'
    }).otherwise({redirectTo: '/'});


    // $routeProvider.when('/login', {
    //     controller: 'LoginController',
    //     templateUrl: 'views/login.html'
    // }).otherwise({redirectTo: '/login'});

    $httpProvider.defaults.withCredentials = true;
    // $routeProvider.otherwise({redirectTo: '/proposta'});
}]).run(['$rootScope', '$location', '$http', '$window', function run($rootScope, $location, $http, $window) {

    // $rootScope.$on('$locationChangeStart', function (event, next, current) {
    //     var restrictedPage = $.inArray($location.path(), ['/login']) === -1;
    //     var loggedIn = $window.sessionStorage.getItem('userData');
    //     if (restrictedPage && !loggedIn) {
    //         $location.path('/login');
    //     }
    // });
}]);


