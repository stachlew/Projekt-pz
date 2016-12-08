angular.module('app')
.controller('observedController',observedController);

observedController.$inject=['$scope', '$log','$http'];

function observedController($scope,$log,$http){
    $log.info("observedController");
    $scope.noObs=false;
    $scope.loading=false;

    $scope.refreshObserved = function () {
        $scope.loading=true;
        $http.get('rest/usr/observation/getObserviation')
            .then(
            function (response) {
                $scope.loading=false;
                $scope.observationList=response.data;
                if($scope.observationList.length==0){
                    $scope.noObs=true;
                }
            },
            function () {
                console.log("Error: refreshObserved()");
                $scope.loading=false;
            }
        )
    };

    $scope.deleteObs= function (idAdvertisement) {
        $http.get('rest/usr/observation/deleteObs/'+idAdvertisement)
            .then(
                function () {
                    console.log("OK: deleteObs()");
                },
                function () {
                    console.log("Error: deleteObs()");
                }
            )
        $scope.refreshObserved();

    }
}




