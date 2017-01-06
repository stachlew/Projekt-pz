angular.module('app')
    .controller('homeController',homeController);

homeController.$inject=['$scope','$location', '$log','$http','$cookies'];

function homeController($scope,$location,$log,$http,$cookies){
    $log.info("homeController");

    $scope.advanced=false;

    $scope.latest = true;
    $scope.zeroSearched = false;
    $scope.areSearched = false;

    $scope.regions=[""];
    $scope.categories=[""];

    $scope.regexNumber = '[0-9]*';
    $scope.regionName;

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
        console.log("IDZIE: "+$scope.city);

        /*console.log("Szukaj zaawansowano: ");
        console.log(searchProperties.title);
        console.log(searchProperties.category);
        console.log(searchProperties.region);
        console.log(searchProperties.city);
        console.log(searchProperties.chargePerDayFrom);
        console.log(searchProperties.chargePerDayTo);
        console.log(searchProperties.bailValueFrom);
        console.log(searchProperties.bailValueTo);
        */

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
                if($scope.searchedOffers.length == 0){
                    $scope.zeroSearched = true;
                    //console.log("ile: "+$scope.searchedOffers.length);
                }
                else{
                    $scope.latest = false;
                    $scope.zeroSearched = false;
                    $scope.areSearched = true;
                    //console.log("ile: "+$scope.searchedOffers.length);
                }
            },
            function () {
                $scope.loading = false;
                $scope.zeroSearched = true;
                console.log("STATUS FAIL");
            });
    }

}

