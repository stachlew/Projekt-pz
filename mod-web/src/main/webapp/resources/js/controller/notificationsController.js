angular.module('app')
    .controller('notificationsController',notificationsController);

notificationsController.$inject=['$scope', '$log','$http'];

function notificationsController($scope,$log,$http){
    $log.info("notificationsController");
    $log.info("loanedController");

    $scope.noItems = false;
    $scope.loading = false;
    $scope.pageNo=1;
    $scope.pageCounted=0;

    $scope.pagePrev = function () {
        if($scope.pageNo>1){
            $scope.pageNo=$scope.pageNo-1;
            $scope.refreshNotifications($scope.pageNo);
        }
    }

    $scope.pageNext = function () {
        if($scope.pageNo<$scope.pageCounted){
            $scope.pageNo=$scope.pageNo+1;
            $scope.refreshNotifications($scope.pageNo);
        }
    }

    $scope.countPages = function () {
        $http.get('/rest/usr/notifications/getNumberOfPages')
            .then(
                function (response) {
                    $scope.pageCounted=response.data.response;
                },
                function () {
                    console.log("Error: getNumberOfPages()");
                }
            )
    }


    $scope.refreshNotifications = function (pageNo) {
        $scope.loading = true;
        var pageNumberForRequest = pageNo-1;
        $http.get('/rest/usr/notifications/getNotifications/'+pageNumberForRequest) //TUTAJ
            .then(
                function (response) {
                    $scope.loading = false;
                    $scope.borrowList=response.data;
                    if($scope.borrowList.length == 0){
                        $scope.noItems = true;
                    }
                    else{
                        $scope.noItems = false;
                        $scope.countPages();
                    }
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshNotifications()");
                }
            )
    }

}

