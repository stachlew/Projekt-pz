angular.module('app')
    .controller('loanedController',loanedController);

loanedController.$inject=['$scope', '$log','$http'];

function loanedController($scope,$log,$http){
    //$log.info("loanedController");

    $scope.noBorromFrom= false;
    $scope.noBorrowFromItems = false;

    $scope.noBorrowTo = false;
    $scope.noBorrowToItems = false;

    $scope.loading = false;

    //od kogos
    $scope.refreshBorrowFrom = function () {
        $scope.loading = true;
        $http.get('/rest/usr/loaned/getBorrower') //TUTAJ
            .then(
                function (response) {
                    $scope.loading = false;
                    $scope.borrowFromList=response.data;
                    if($scope.borrowFromList.length == 0){
                        $scope.noBorrowFromItems = true;
                    }
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshBorrowFrom()");
                }
            )
    }
    //komus
    $scope.refreshBorrowTo = function () {
        $scope.loading = true;
        $http.get('/rest/usr/loaned/getLender') //TUTAJ
            .then(
                function (response) {
                    $scope.loading = false;
                    $scope.borrowToList=response.data;
                    if($scope.borrowToList.length == 0){
                        $scope.noBorrowToItems = true;
                    }
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshBorrowTo()");
                }
            )
    }
}

