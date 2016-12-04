angular.module('mainModule')
    .controller('myAdsController',observedController);

observedController.$inject=['$scope','$location', '$log','$http'];

function observedController($scope,$location,$log,$http){
    $log.info("myAdsController");
    $scope.noAds = false;
    $scope.goLink = function(linkId){
        $location.path("/"+linkId);
    }

    $scope.refreshMyAds = function () {
        $scope.loading = true;
        $http.get('/rest/usr/getMyAll')
            .then(
                function (response) {
                    $scope.loading = false;
                    $scope.adsList=response.data;
                    if($scope.adsList.length == 0){
                        $scope.noAds = true;
                    }
                },
                function () {
                    $scope.loading = false;
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

