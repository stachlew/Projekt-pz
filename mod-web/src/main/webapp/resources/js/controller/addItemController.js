angular.module('app')
    .controller('addItemController',observedController);

observedController.$inject=['$scope','$location', '$log'];

function observedController($scope,$location,$log){
    $log.info("addItemController");
}


