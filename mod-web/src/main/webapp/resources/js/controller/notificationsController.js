angular.module('app')
    .controller('notificationsController',notificationsController);

notificationsController.$inject=['$scope','$location', '$log'];

function notificationsController($scope,$location,$log){
    $log.info("notificationsController");
}

