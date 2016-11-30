angular.module('mainModule')
    .controller('myAdsController',observedController);

observedController.$inject=['$scope','$location', '$log','$http'];

function observedController($scope,$location,$log,$http){
    $log.info("myAdsController");

    $scope.goLink = function(linkId){
        $location.path("/"+linkId);
    }

    $scope.refreshMyAds = function () {
        $http.get('/rest/usr/getAll')
            .then(
                function (response) {
                    $scope.adsList=response.data;
                },
                function () {
                    console.log("Error: refreshMyAds()");
                }
            )
    }

    $scope.duplicate = function () {
        $http.get('/rest/duplicate')
            .then(
                function () {
                    $scope.refreshMyAds();
                },
                function () {
                    console.log("Error: duplicate()");
                }
            )
    }
}

