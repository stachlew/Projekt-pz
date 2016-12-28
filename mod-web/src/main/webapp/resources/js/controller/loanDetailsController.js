angular.module('app')
    .controller('loanDetailsController',loanDetailsController);

loanDetailsController.$inject=['$scope', '$log','$routeParams','$http'];

function loanDetailsController($scope,$log,$routeParams,$http){
    $log.info("loanDetailsController");
    $scope.idLoan=$routeParams.idLoan;
    $scope.noLoan = false;
    $scope.isLoan = false;

    $scope.refreshLoanDetails = function () {
        $scope.loading = true;
        $http.get('/rest/usr/loaned/details/'+$scope.idLoan)
            .then(
                function (response) {
                    $scope.loading = false;
                    if(response.data){
                        $scope.loanDetails=response.data;
                        $scope.isLoan = true;
                    }
                    else{
                        $scope.noLoan = true;
                    }
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshLoanDetails()");
                }
            )
    }

    $scope.refreshLoanMessages = function () {
        $http.get('/rest/usr/loaned/messages/'+$scope.idLoan)
            .then(
                function (response) {
                    if(response.data){
                        $scope.messages=response.data;
                    }
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshLoanMessages()");
                }
            )
    }

}




