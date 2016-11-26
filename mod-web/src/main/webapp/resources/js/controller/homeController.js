angular.module('mainModule')
    .controller('homeController',observedController);

observedController.$inject=['$scope','$location', '$log'];

function observedController($scope,$location,$log){
    $log.info("homeController");
}

