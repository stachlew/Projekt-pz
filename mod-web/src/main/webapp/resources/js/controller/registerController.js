angular.module('app')
    .controller('registerController',registerController);

registerController.$inject=['$scope','$location', '$log','$http','$cookies'];

function registerController($scope,$location,$log,$http,$cookies){
    $log.info("registerController");

    $scope.regions=[""];
    $scope.formVis=true;
    $scope.regOk=false;
    $scope.regError=false;
    $scope.flagUsernameExist=false;
    $scope.showUsernameExist=false;

    $scope.regexNumber = '[0-9]*';
    $scope.regexUsername = '[a-zA-z0-9]*';

    $scope.refresh = function() {
        $http.get('/rest/pub/simpleData/getRegions')
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
        }).then(
            function (response) {
                var flag = response.data.flag;
                if(flag==true){
                    //console.log("Response true OK");
                    $scope.regOk=true;
                    $scope.formVis=false;
                }else{
                    console.log("Response false FAIL");
                    $scope.regError=true;
                    $scope.formVis=false;
                }
            },
            function () {
                $scope.regError=true;
                $scope.formVis=false;
                console.log("register FAIL");
            });
    }

    $scope.checkUsername = function (user) {
        $scope.showUsernameExist=false;
        if (user.username !== undefined && user.username !== null) {
            //console.log("IF "+user.username);
            $http.get('/rest/pub/simpleData/checkExistUsername/'+user.username)
                .then(
                    function (response) {
                        $scope.flagUsernameExist=response.data.flag;
                        if(user.username.length>3){
                            $scope.showUsernameExist=true;
                        }else{
                            $scope.showUsernameExist=false;
                        }

                    },
                    function () {
                        console.log("Error: checkUsername()");
                    }
                )
        }else{
            console.log("ELSE");
        }
    }

}


