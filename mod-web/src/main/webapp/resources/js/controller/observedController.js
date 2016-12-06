angular.module('app')
.controller('observedController',observedController);

observedController.$inject=['$scope','$location', '$log'];

function observedController($scope,$location,$log){
    $log.info("observedController");
}




