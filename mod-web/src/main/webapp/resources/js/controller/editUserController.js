angular.module('app')
    .controller('editUserController',editUserController);

editUserController.$inject=['$scope', '$log','$http','$cookies'];

function editUserController($scope,$log,$http,$cookies){
    //$log.info("editUserController");

    $scope.regions=[""];
    $scope.formVis=true;
    $scope.editOk=false;
    $scope.editError=false;
    $scope.loadingRequest=false;

    $scope.regexNumber = '[0-9]*';

    $scope.refreshForm = function() {


        $http.get('/rest/pub/simpleData/getRegions')
            .then(
                function (response) {
                    $scope.regions=response.data;
                    $scope.setDefault();
                    $scope.regions.unshift("");
                },
                function () {
                    console.log("Error: refreshForm()");
                }
            )
    };

    $scope.setDefault = function () {
        $http.get('rest/usr/userInfo/getUserDetails')
            .then(
                function (response) {
                    $scope.city=response.data.city;
                    if(response.data.idRegion){
                        $scope.region=response.data.idRegion.name;
                    }
                    $scope.phone=response.data.phone;
                    $scope.accountCreateDate=response.data.accountCreateDate;
                    $scope.mail=response.data.mail;
                },
                function () {
                    console.log("Error: refresh regions");
                }
            )
    }

    $scope.acceptChanges = function (user) {
        //console.log("changeAccount()");
        var editUser = {
            password : $scope.password,
            mail : $scope.mail,
            regionName : $scope.region,
            city : $scope.city,
            phone : $scope.phone
        };

        $scope.loadingRequest=true;
        $scope.csfr=$cookies.get('XSRF-TOKEN');
        var res = $http({
            method: 'POST',
            url: '/rest/usr/account/updateAccount',
            data: editUser,
            headers: {
                'X-CSRF-TOKEN': $scope.csfr,
                'Content-Type': 'application/json'
            }
        });
        res.success(function () {
            //console.log("changeAccount() OK")
            $scope.formVis=false;
            $scope.editOk=true;
            $scope.editError=false;
            $scope.loadingRequest=false;
        });
        res.error(function () {
            console.log("changeAccount() FAIL")
            $scope.formVis=false;
            $scope.editOk=false;
            $scope.editError=true;
            $scope.loadingRequest=false;
        });
    }

    $scope.backToEdit = function () {
        $scope.refreshForm();
        $scope.formVis=true;
        $scope.editOk=false;
        $scope.editError=false;
    }

}