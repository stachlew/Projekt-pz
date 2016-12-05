angular.module('mainModule')
    .controller('offerController',offerController);

offerController.$inject=['$scope','$location', '$log','$routeParams','$http'];

function offerController($scope,$location,$log,$routeParams,$http){
    $log.info("offerController");
    $scope.offerId=$routeParams.idOffer;
    $scope.noOffer = false;
    $scope.isOffer = false;
    $scope.refreshOffer = function () {
        $scope.loading = true;
        $http.get('/rest/pub/offer/'+$scope.offerId)
            .then(
                function (response) {
                    $scope.loading = false;
                    if(response.data){
                        $scope.offer=response.data;
                        $scope.isOffer = true;
                    }
                    else{
                        $scope.noOffer = true;
                    }
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshOffer()");
                }
            )
    }
}




