angular.module('app')
    .controller('homeController',homeController);

homeController.$inject=['$scope','$location', '$log','$http','$cookies'];

function homeController($scope,$location,$log,$http,$cookies){
    $log.info("homeController");

    $scope.advanced=false;

    $scope.zeroSearched = false;
    $scope.areSearched = false;

    $scope.regions=[""];
    $scope.categories=[""];

    $scope.regexNumber = '[0-9]*';
    $scope.regionName;

    $scope.countSearched=0;

    if($scope.$parent.siteFlagSearched==true){
        $scope.searchedOffers=$scope.$parent.siteListSearched;
        $scope.countSearched=$scope.searchedOffers.length;
        $scope.latest = false;
        $scope.zeroSearched = false;
        $scope.areSearched = true;
    }else{
        $scope.latest = true;
    }

    $scope.refreshHome = function () {
        $scope.loading = true;
        $http.get('/rest/pub/home/getLatest')
            .then(
                function (response) {
                    $scope.loading = false;
                    $scope.adsList=response.data;
                },
                function () {
                    $scope.loading = false;
                    console.log("Error: refreshHome()");
                }
            )
    }

    $scope.refreshForm = function() {

        $http.get('/rest/pub/simpleData/getRegions')
            .then(
                function (response) {
                    $scope.regions=response.data;
                    $scope.regions.unshift("");
                },
                function () {
                    console.log("Error: getRegions()");
                }
            )

        $http.get('/rest/pub/simpleData/getCategories')
            .then(
                function (response) {//jesli wypelnil
                    $scope.categories=response.data;
                    $scope.categories.unshift("");
                },
                function () {
                    console.log("Error: getCategories()");
                }
            )
    };

    $scope.showAdvancedSearch = function () {
        if($scope.advanced){
            $scope.advanced=false;
        }
        else {
            $scope.advanced=true;
        }
    }

    $scope.clearForm = function () {
        $scope.title="";
        $scope.category="";
        $scope.region="";
        $scope.city="";
        $scope.chargePerDayFrom="";
        $scope.chargePerDayTo="";
        $scope.bailValueFrom="";
        $scope.bailValueTo="";
    }

    $scope.returnLatest = function () {
        $scope.$parent.siteFlagSearched=false;
        $scope.$parent.siteListSearched=null;
        $scope.latest = true;
        $scope.zeroSearched = false;
        $scope.areSearched = false;
    }

    $scope.search = function ()
    {
        var searchProperties = {
            title : $scope.title,
            category : $scope.category,
            region : $scope.region,
            city : $scope.city,
            chargePerDayFrom : $scope.chargePerDayFrom,
            chargePerDayTo : $scope.chargePerDayTo,
            bailValueFrom : $scope.bailValueFrom,
            bailValueTo : $scope.bailValueTo
        };

        $scope.loading = true;
        $scope.latest = false;
        $scope.zeroSearched = false;
        $scope.areSearched = false;

        $scope.csfr=$cookies.get('XSRF-TOKEN');

        var res = $http({
            method: 'POST',
            url: '/rest/pub/search/doSearch',
            data: searchProperties,
            headers: {
                'X-CSRF-TOKEN': $scope.csfr,
                'Content-Type': 'application/json'
            }
        }).then(
            function (response) {
                $scope.loading = false;
                //console.log("STATUS OK");
                $scope.searchedOffers = response.data;
                $scope.countSearched=$scope.searchedOffers.length;
                if($scope.countSearched == 0){
                    $scope.zeroSearched = true;
                    $scope.$parent.siteFlagSearched=false;
                }
                else{
                    $scope.latest = false;
                    $scope.zeroSearched = false;
                    $scope.areSearched = true;
                    $scope.$parent.siteFlagSearched=true;
                    $scope.$parent.siteListSearched=response.data;
                }
            },
            function () {
                $scope.loading = false;
                $scope.zeroSearched = true;
                console.log("STATUS FAIL");
            });
    }

}

