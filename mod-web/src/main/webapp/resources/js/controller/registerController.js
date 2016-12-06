angular.module('app')
    .controller('registerController',observedController);

observedController.$inject=['$scope','$location', '$log'];

function observedController($scope,$location,$log){
    $log.info("registerController");

    $scope.register = function () {
        $log.info("kogos zarejestrowano");
    }
}

