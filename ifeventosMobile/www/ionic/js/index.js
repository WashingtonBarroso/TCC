angular.module('app', ['ionic'])

  .config(function ($stateProvider, $urlRouterProvider) {

    $stateProvider
      .state('eventmenu', {
        url: "/event",
        abstract: true,
        templateUrl: "templates/event-menu.html"
      })
      .state('eventmenu.home', {
        url: "/home",
        views: {
          'menuContent': {
            templateUrl: "templates/home.html",
            controller: "noticiaController"
          }
        }
      })
      .state('eventmenu.palestrantes', {
        url: "/palestrantes",
        views: {
          'menuContent': {
            templateUrl: "templates/palestrantes.html",
            controller: "palestranteController"
          }
        }
      })
      .state('eventmenu.programacao', {
        url: "/programacao/:id",
        views: {
          'menuContent': {
            templateUrl: "templates/programacao.html",
            controller: "programacaoController"
          }
        }
      })
      .state('eventmenu.pgorganizador', {
        url: "/pgorganizador",
        views: {
          'menuContent': {
            templateUrl: "templates/pgorganizador.html",
            controller: "organizadorController"
          }
        }
      })
      .state('eventmenu.pgdetalhesmapa', {
        url: "/pgdetalhesmapa/:id",
        views: {
          'menuContent': {
            templateUrl: "templates/pgdetalhesmapa.html",
            controller: "detalhesMapaController"
          }
        }
      })
      .state('eventmenu.pgmapa', {
        url: "/pgmapa",
        views: {
          'menuContent': {
            templateUrl: "templates/pgmapa.html",
            controller: "mapaController"
          }
        }
      })
      .state('listevento', {
        url: "/listevento",
        templateUrl: "templates/listevento.html",
        controller: "eventoController"
      })
    $urlRouterProvider.otherwise("/listevento");
  });




