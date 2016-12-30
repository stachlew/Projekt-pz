angular.module('app')
    .controller('offerController',offerController);

offerController.$inject=['$scope', '$log','$routeParams','$http'];

function offerController($scope,$log,$routeParams,$http){
    $log.info("offerController");
    $scope.offerId=$routeParams.idOffer;
    $scope.noOffer = false;
    $scope.isOffer = false;
    $scope.addFav = false;

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
                    console.log("Error: refreshOfferData()");
                }
            )
    }

    $scope.refreshObsStatus = function (){
        $http.get('rest/usr/observation/checkObservation/'+$scope.offerId)
            .then(
                function (response) {
                    $scope.addFav=response.data.flag;
                },
                function () {
                    console.log("Error: refreshOfferObsStatus()");
                }
            )
    }

    $scope.addObs= function () {
        if($scope.addFav==false){
            $http.get('rest/usr/observation/createObs/'+$scope.offerId)
                .then(
                    function () {
                        $scope.addFav=true;
                        //console.log("OK: addObs()");
                    },
                    function () {
                        console.log("Error: addObs()");
                    }
                );
        }
    }



}




