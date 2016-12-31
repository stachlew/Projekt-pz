angular.module('app')
    .controller('siteController',siteController);

siteController.$inject=['$scope','$location', '$log','$cookies','$http'];

function siteController($scope,$location,$log,$cookies,$http){
    $log.info("siteController");
    $scope.userName = $cookies.get('cookieUsername');
    $scope.logged=false;
    $scope.newNotifications=false;

    $scope.$on('$routeChangeStart', function () {
        if($scope.logged){
            $scope.checkNewNotifications();
        }
    });

    $scope.isLogged = function () {
        $http.get('/rest/pub/login/isLogged')
            .then(
                function (response) {
                    $scope.logged=response.data;
                },
                function () {
                    $scope.logged=false;
                }
            )
    }
    $scope.isLogged();

    $scope.checkNewNotifications = function () {
        //console.log("checkNotifications!")
        $http.get('/rest/usr/notifications/checkNotifications')
            .then(
                function (response) {
                    $scope.newNotifications=response.data.flag;
                },
                function () {
                    $scope.newNotifications=false;
                }
            )
    }
    $scope.checkNewNotifications();



    $scope.goOffer = function(linkId){
        $location.path("/offer/"+linkId);
    }

    $scope.goEditOffer = function(linkId){
        $location.path("/editoffer/"+linkId);
    }

    $scope.goAddLoan = function(linkId){
        $location.path("/addLoan/"+linkId);
    }

    $scope.goLoanDetails = function(linkId){
        $location.path("/loandetails/"+linkId);
    }

    $scope.goLink = function(linkId){
        $location.path(linkId);
    }

    $scope.isLogged = function () {
        $http.get('/rest/pub/login/isLogged')
            .then(
                function (response) {
                    $scope.logged=response.data;
                },
                function () {
                    $scope.logged=false;
                }
            )
        console.log("isLogged() return  koncowy"+$scope.logged);
    }
}

