angular.module('app')
    .controller('editOfferController',editOfferController);

editOfferController.$inject=['$scope', '$log','$routeParams','$http','$cookies'];

function editOfferController($scope,$log,$routeParams,$http,$cookies){
    $log.info("editOfferController");
    $scope.offerId=$routeParams.idOffer;
    $scope.formVis=true;

    $scope.regions=[""];
    $scope.categories=[""];

    $scope.offerRegion="";
    $scope.offerCategory="";

    $scope.regexNumber = '[0-9]*';
    $scope.regionName;

    $scope.showPhoto=true;
    $scope.removeFlag=false;

    $scope.refreshFormOptions = function() {
        $scope.refreshOffer();

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
                },
                function () {
                    console.log("Error: getCategories()");
                }
            )
    };

    $scope.refreshOffer = function () {
        $scope.loading = true;
        $http.get('/rest/pub/offer/'+$scope.offerId)
            .then(
                function (response) {
                    $scope.loading = false;
                    $scope.offer=response.data;
                    $scope.offerRegion=$scope.offer.regionName;
                    $scope.offerCategory=$scope.offer.categoryName;
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshOfferData()");
                }
            )
    }

    $scope.updateItem = function (offer) {

        var newItem = {
            title : offer.title,
            bailValue : offer.bailValue,
            chargePerDay : offer.chargePerDay,
            description : offer.description,
            city : offer.city,
            region : $scope.offerRegion,
            category : $scope.offerCategory
        };

        $scope.csfr=$cookies.get('XSRF-TOKEN');
        var res = $http({
            method: 'POST',
            url: '/rest/usr/myOffer/updateOffer/'+$scope.offerId,
            data: newItem,
            headers: {
                'X-CSRF-TOKEN': $scope.csfr,
                'Content-Type': 'application/json'
            }
        });

        res.success(function () {
            if($scope.myFile){
                $scope.uploadFoto($scope.offerId);
            }
            if($scope.removeFlag){
                $scope.removePhoto();
            }
            $scope.regOk=true;
            $scope.formVis=false;
        });
        res.error(function () {
            $scope.regError=true;
            $scope.formVis=false;
        });
    }

    $scope.uploadFoto = function (idOffer) {
        $scope.removeFlag=false;
        var fd = new FormData();
        fd.append('file', $scope.myFile);
        var uploadUrl = "/rest/usr/images/uploadImage/"+idOffer;
        $scope.csfr=$cookies.get('XSRF-TOKEN');

        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {
                'X-CSRF-TOKEN': $scope.csfr,
                'Content-Type': undefined}
        })
            .success(function(){
            })
            .error(function(){
                console.log("Upload FAIL");
            });
    }

    $scope.removePhotoRequest = function () {
        $scope.removeFlag=true;
        $scope.showPhoto=false;
    }

    $scope.removePhoto = function () {
        $http.get('/rest/usr/images/deleteImage/'+$scope.offerId)
            .then(
                function (response) {

                },
                function () {
                    console.log("Error: refreshOfferData()");
                }
            )
    }



}




