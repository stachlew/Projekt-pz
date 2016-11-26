angular.module('mainModule')
    .controller('notificationsController',observedController);

observedController.$inject=['$scope','$location', '$log'];

function observedController($scope,$location,$log){
    $log.info("notificationsController");
}

