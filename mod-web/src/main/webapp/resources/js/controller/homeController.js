angular.module('mainModule')
    .controller('homeController',observedController);

observedController.$inject=['$scope','$location', '$log','$http'];

function observedController($scope,$location,$log,$http){
    $log.info("homeController");


    $scope.goLink = function(linkId){
        $location.path("/"+linkId);
    }

    $scope.refreshHome = function () {
        $scope.loading = true;
        $http.get('/rest/getLatest')
            .then(
                function (response) {
                    $scope.loading = false;
                    $scope.adsList=response.data;
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshHome()");
                }
            )
    }









}

