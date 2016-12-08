angular.module('app')
    .controller('registerController',registerController);

registerController.$inject=['$scope','$location', '$log','$http','$cookies'];

function registerController($scope,$location,$log,$http,$cookies){
    $log.info("registerController");
    $scope.regions=[""];
    $scope.formVis=true;
    $scope.regOk=false;
    $scope.regError=false;

    $scope.regexNumber = '[0-9]*';

    $scope.refresh = function() {
        $http.get('/rest/pub/register/getRegions')
            .then(
                function (response) {
                    $scope.regions=response.data;
                    $scope.regions.unshift("");
                },
                function () {
                    console.log("Error: refreshRegister()");
                }
            )
    };

    $scope.register = function (user) {

        var newUser = {
            username : user.username,
            password : user.password,
            mail : user.mail,
            regionName : user.region,
            city : user.city,
            phone : user.phone
        };

        $scope.csfr=$cookies.get('XSRF-TOKEN');
        var res = $http({
            method: 'POST',
            url: '/register/createUser',
            data: newUser,
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


