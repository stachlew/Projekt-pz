angular.module('app')
    .controller('myAdsController',observedController);

observedController.$inject=['$scope','$location', '$log','$http'];

function observedController($scope,$location,$log,$http){
    $log.info("myAdsController");
    $scope.noAds = false;

    $scope.refreshMyAds = function () {
        $scope.loading = true;
        $http.get('/rest/usr/myOffer/getMyAll')
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

    /*
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
    */
}

