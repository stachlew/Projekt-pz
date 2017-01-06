angular.module('app')
    .controller('myAdsController',myAdsController);

myAdsController.$inject=['$scope','$location', '$log','$http'];

function myAdsController($scope,$location,$log,$http){
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

    $scope.deleteMyAd = function (idAdvertisement) {
        console.log("deleteMyAd()");
        $http.get('/rest/usr/myOffer/delete/'+idAdvertisement)
            .then(
                function (response) {
                    console.log("OK: refreshMyAds()");
                    $scope.refreshMyAds();
                },
                function () {
                    console.log("Error: refreshMyAds()");
                }
            )
    }
}

