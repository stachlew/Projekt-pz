var myApp = angular.module('myApp',['ngRoute','ngCookies']);

myApp.config(function($routeProvider, $locationProvider){

    $routeProvider
        .when('/',{
            templateUrl: 'main',
            controller: 'mainController'
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

        .otherwise({templateUrl:'errorPage'});


});

myApp.controller('siteController',['$scope','$log','$cookies',function ($scope,$log,$cookies) {
    $log.info("siteController");
    $scope.userName = $cookies.get('cookieUsername');
}]);

myApp.controller('mainController',['$scope','$location', '$log', function($scope,$location,$log){
    $log.info("mainController");
}]);

myApp.controller('myAdsController',['$scope','$location', '$log', function($scope,$location,$log){
    $log.info("myAdsController");

}]);

myApp.controller('observedController',['$scope','$location', '$log', function($scope,$location,$log){
    $log.info("observedController");

}]);

myApp.controller('notificationsController',['$scope','$location', '$log', function($scope,$location,$log){
    $log.info("notificationsController");

}]);

myApp.controller('loanedController',['$scope','$location', '$log', function($scope,$location,$log){
    $log.info("loanedController");

}]);

myApp.controller('addItemController',['$scope','$location', '$log', function($scope,$location,$log){
    $log.info("addItemController");

}]);

myApp.controller('loginController',['$scope','$location', '$log', function($scope,$location,$log){
    $log.info("loginController");

}]);

myApp.controller('registerController',['$scope','$location', '$log', function($scope,$location,$log){
    $log.info("registerController");

}]);

