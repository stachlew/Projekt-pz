var app = angular.module('app',['ngRoute','ngCookies','ui.bootstrap','ngAnimate', 'ngSanitize']);



app.config(['$routeProvider',function($routeProvider){


    $routeProvider
        .when('/',{
            templateUrl: 'home',
            controller: 'homeController'
        })

        .when('/myAds',{
            templateUrl: 'myAds',
            controller: 'myAdsController'
        })

        .when('/observed',{
            templateUrl: 'observed',
            controller: 'observedController'
        })

        .when('/notifications',{
            templateUrl: 'notifications',
            controller: 'notificationsController'
        })

        .when('/loaned',{
            templateUrl: 'loaned',
            controller: 'loanedController'
        })

        .when('/addItem',{
            templateUrl: 'addItem',
            controller: 'addItemController'
        })

        .when('/login',{
            templateUrl: 'login',
            controller: 'loginController'
        })

        .when('/loginfailed',{
            templateUrl: 'loginfailed',
            controller: 'loginController'
        })

        .when('/register',{
            templateUrl: 'register',
            controller: 'registerController'
        })

        .when('/offer/:idOffer',{
            templateUrl: 'offer',
            controller: 'offerController'
        })

        .when('/loandetails/:idLoan',{
            templateUrl: 'loanDetails',
            controller: 'loanDetailsController'
        })

        .otherwise({templateUrl:'errorPage'});
}]);



