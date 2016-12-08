angular.module('app')
    .controller('siteController',observedController);

observedController.$inject=['$scope','$location', '$log','$cookies'];

function observedController($scope,$location,$log,$cookies){
    $log.info("siteController");
    $scope.userName = $cookies.get('cookieUsername');

    $scope.goOffer = function(linkId){
        $location.path("/offer/"+linkId);
    }

    $scope.goLink = function(linkId){
        $location.path(linkId);
    }
}

