angular.module('app')
    .controller('notificationsController',notificationsController);

notificationsController.$inject=['$scope', '$log','$http'];

function notificationsController($scope,$log,$http){
    $log.info("notificationsController");
    $log.info("loanedController");

    $scope.noBorromItems = false;
    $scope.loading = false;

    //od kogos
    $scope.refreshBorrow = function () {
        $scope.loading = true;
        $http.get('/rest/usr/notifications/getLoan') //TUTAJ
            .then(
                function (response) {
                    $scope.loading = false;
                    $scope.borrowList=response.data;
                    if($scope.borrowList.length == 0){
                        $scope.noBorromItems = true;
                    }
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshBorrow()");
                }
            )
    }

}

