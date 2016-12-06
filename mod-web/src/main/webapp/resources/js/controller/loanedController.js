angular.module('app')
    .controller('loanedController',observedController);

observedController.$inject=['$scope','$location', '$log'];

function observedController($scope,$location,$log){
    $log.info("loanedController");
}

