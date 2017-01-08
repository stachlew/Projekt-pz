angular.module('app')
    .controller('addItemController',addItemController);

addItemController.$inject=['$scope','$log','$http','$cookies'];

function addItemController($scope,$log,$http,$cookies){
    $log.info("addItemController");

    $scope.regions=[""];
    $scope.categories=[""];
    $scope.responseOfferId=null;

    $scope.formVis=true;
    $scope.regOk=false;
    $scope.regError=false;

    $scope.regexNumber = '[0-9]*';
    $scope.regionName;

    $scope.setDefault = function () {
        $http.get('rest/usr/userInfo/getUserDetails')
            .then(
                function (response) {
                    $scope.city=response.data.city;
                    $scope.region=response.data.idRegion.name;
                },
                function () {
                    console.log("Error: refresh regions");
                }
            )
    }

    $scope.refresh = function() {
        $scope.setDefault();

        $http.get('/rest/pub/simpleData/getRegions')
            .then(
                function (response) {
                    $scope.regions=response.data;
                },
                function () {
                    console.log("Error: getRegions()");
                }
            )

        $http.get('/rest/pub/simpleData/getCategories')
            .then(
                function (response) {
                    $scope.categories=response.data;
                    $scope.category=response.data[0];
                },
                function () {
                    console.log("Error: getCategories()");
                }
            )
    };

    $scope.addItem = function () {

        var newItem = {
            title : $scope.title,
            bailValue : $scope.bailValue,
            chargePerDay : $scope.chargePerDay,
            description : $scope.description,
            city : $scope.city,
            region : $scope.region,
            category : $scope.category
        };

        //console.log("newItem: "+newItem.title+" "+newItem.category);


        $scope.csfr=$cookies.get('XSRF-TOKEN');
        var res = $http({
            method: 'POST',
            url: '/addItem/createItem',
            data: newItem,
            headers: {
                'X-CSRF-TOKEN': $scope.csfr,
                'Content-Type': 'application/json'
            }
        }).then(
            function (response) {
                $scope.responseOfferId=response.data.response;
                //console.log("ID: "+$scope.responseOfferId);
                $scope.uploadFoto($scope.responseOfferId);
                $scope.regOk=true;
                $scope.formVis=false;
            },
            function () {
                $scope.regError=true;
                $scope.formVis=false;
            }
        );
    }

    $scope.uploadFoto = function (idOffer) {
        //console.log("uploadFoto"+idOffer);
        var fd = new FormData();
        fd.append('file', $scope.myFile);
        //console.log("Plik: "+$scope.myFile);
        var uploadUrl = "/rest/usr/images/uploadImage/"+idOffer;
        $scope.csfr=$cookies.get('XSRF-TOKEN');

        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {
                'X-CSRF-TOKEN': $scope.csfr,
                'Content-Type': undefined}
        })
            .success(function(){
                //console.log("Upload OK");
            })
            .error(function(){
                console.log("Upload FAIL");
            });
    }


}


