angular.module('app')
    .controller('homeController',homeController);

homeController.$inject=['$scope','$location', '$log','$http'];

function homeController($scope,$location,$log,$http){
    $log.info("homeController");

    $scope.refreshHome = function () {
        $scope.loading = true;
        $http.get('/rest/pub/home/getLatest')
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

