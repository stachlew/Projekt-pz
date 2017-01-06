angular.module('app')
    .controller('notificationsController',notificationsController);

notificationsController.$inject=['$scope', '$log','$http'];

function notificationsController($scope,$log,$http){
    $log.info("notificationsController");
    $log.info("loanedController");

    $scope.noItems = false;
    $scope.loading = false;
    $scope.pageNo=0;

    $scope.refreshNotifications = function (pageNo) {
        $scope.loading = true;
        $http.get('/rest/usr/notifications/getNotifications/'+pageNo) //TUTAJ
            .then(
                function (response) {
                    $scope.loading = false;
                    $scope.borrowList=response.data;
                    if($scope.borrowList.length == 0){
                        $scope.noItems = true;
                    }
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshNotifications()");
                }
            )
    }

}

