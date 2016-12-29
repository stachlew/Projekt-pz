angular.module('app')
    .controller('loanDetailsController',loanDetailsController);

loanDetailsController.$inject=['$scope', '$log','$routeParams','$http','$cookies'];

function loanDetailsController($scope,$log,$routeParams,$http,$cookies){
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

    $scope.sendText = function (varText) {
        if(undefined != varText){
            if(varText.length>0 ){
                var newText = {
                    text : varText,
                    idLoan : $scope.idLoan
                };

                 $scope.csfr=$cookies.get('XSRF-TOKEN');
                 var res = $http({
                 method: 'POST',
                 url: '/rest/usr/loaned/messages/createMessage',
                 data: newText,
                 headers: {
                 'X-CSRF-TOKEN': $scope.csfr,
                 'Content-Type': 'application/json'
                 }
                 });

                 res.success(function () {
                 $scope.refreshLoanMessages();
                 console.log("Wyslano wiadomosc poprawnie");
                 $scope.varText="";
                 });
                 res.error(function () {
                 $scope.refreshLoanMessages();
                 console.log("Blad wysylania wiadomosci");
                 });
            }
        }



    }

}




