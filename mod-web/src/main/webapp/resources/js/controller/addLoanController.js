angular.module('app')
    .controller('addLoanController',addLoanController);

addLoanController.$inject=['$scope','$log','$http','$cookies','$routeParams'];

function addLoanController($scope,$log,$http,$cookies,$routeParams){
    //$log.info("addLoanController");
    $scope.offerId=$routeParams.offerId;

    $scope.isOffer=false;
    $scope.noOffer=false;
    $scope.loading=false;


    $scope.stockDate=new Date();


    $scope.refreshLoan = function () {
        $scope.loading = true;
        $http.get('/rest/pub/offer/'+$scope.offerId)
            .then(
                function (response) {
                    $scope.loading = false;
                    if(response.data){
                        $scope.offer=response.data;
                        $scope.isOffer = true;
                        $scope.formVis = true;
                        $scope.dateFrom =$scope.stockDate;
                        $scope.dateTo=$scope.stockDate;
                    }
                    else{
                        $scope.noOffer = true;
                    }
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshLoan()");
                }
            )
    }

    $scope.addLoan = function () {

        var newLoan = {
            idAdvertisement : $scope.offerId,
            dateFrom : $scope.dateFrom,
            dateTo : $scope.dateTo
        };

        //console.log("newLoan: "+newLoan.idAdvertisement+" "+newLoan.dateFrom +" "+newLoan.dateTo);

        $scope.csfr=$cookies.get('XSRF-TOKEN');
        var res = $http({
            method: 'POST',
            url: '/rest/usr/loaned/createLoanRequest',
            data: newLoan,
            headers: {
                'X-CSRF-TOKEN': $scope.csfr,
                'Content-Type': 'application/json'
            }
        });

        res.success(function () {
            $scope.regOk=true;
            $scope.formVis=false;
        });
        res.error(function () {
            $scope.regError=true;
            $scope.formVis=false;
        });
    }
}


