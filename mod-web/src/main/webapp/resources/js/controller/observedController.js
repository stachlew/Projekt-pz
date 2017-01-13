angular.module('app')
.controller('observedController',observedController);

observedController.$inject=['$scope', '$log','$http','$modal'];

function observedController($scope,$log,$http,$modal){
    //$log.info("observedController");
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

    $scope.open = function (idAdvertisement,idx) {
        //otwarcie okienka
        var modalInstance = $modal.open({
            templateUrl: 'dialogWindow/deleteObservedDialog',
            controller: dialogObservedController,
            resolve: {
                items: function () {
                    return $scope.items;
                }
            }
        });

        //funkcja zwroconych rezultatow
        modalInstance.result.then(
            function () {
                $scope.deleteObsRest(idAdvertisement,idx);
            },
            function () {

            }
        );
    };

    $scope.deleteObsRest = function(idAdvertisement,idx){
        $http.get('rest/usr/observation/deleteObs/'+idAdvertisement)
            .then(
                function () {
                    $scope.observationList.splice(idx,1);
                    if($scope.observationList.length==0){
                        $scope.noObs=true;
                    }
                },
                function () {
                    console.log("Error: deleteObs()");
                }
            )
        //$scope.refreshObserved();
    }

    $scope.deleteObs= function (idAdvertisement,idx) {
        $scope.open(idAdvertisement,idx);
    }
}




