angular.module('mainModule')
    .controller('loginController',observedController);

observedController.$inject=['$scope','$location', '$log'];

function observedController($scope,$location,$log){
    $log.info("loginController");
}

