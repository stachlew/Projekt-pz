angular.module('mainModule')
    .controller('myAdsController',observedController);

observedController.$inject=['$scope','$location', '$log'];

function observedController($scope,$location,$log){
    $log.info("myAdsController");

    $scope.goLink = function(linkId){
        $location.path("/"+linkId);
    }
}

