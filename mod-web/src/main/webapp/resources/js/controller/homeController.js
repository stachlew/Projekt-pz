angular.module('mainModule')
    .controller('homeController',observedController);

observedController.$inject=['$scope','$location', '$log','$http'];

function observedController($scope,$location,$log,$http){
    $log.info("homeController");

    $scope.goLink = function(linkId){
        $location.path("/"+linkId);
    }

    $scope.refreshHome = function () {
        $http.get('/rest/getLatest')
            .then(
                function (response) {
                    $scope.adsList=response.data;
                },
                function () {
                    console.log("Error: refreshHome()");
                }
            )
    }









}

