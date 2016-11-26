angular.module('mainModule')
    .controller('registerController',observedController);

observedController.$inject=['$scope','$location', '$log'];

function observedController($scope,$location,$log){
    $log.info("registerController");
}

