angular.module('app')
    .controller('homeController',homeController);

homeController.$inject=['$scope', '$log','$http','$cookies'];

function homeController($scope,$log,$http,$cookies){
    $log.info("homeController");
    $scope.regions=[""];
    $scope.categories=[""];
    $scope.regexNumber = '[0-9]*';
    $scope.regionName;

    $scope.advanced=false;

    $scope.zeroSearched = false;
    $scope.areSearched = false;

    var pageSize=10;

    $scope.pageCounted=0;
    $scope.countSearched=0;
    $scope.subSearchedOffers=null;


    $scope.countPages = function () {
        var pages = Math.floor($scope.countSearched/pageSize);
        var rem = $scope.countSearched% pageSize;
        if(rem>0){
            $scope.pageCounted=pages+1;
        }
        else {
            $scope.pageCounted=pages;
        }
    }

    $scope.updatePartSearchedList = function (No) {
        $scope.countPages();
        var NoIdx = No-1;
        var pages = $scope.pageCounted;
        if(NoIdx<pages){
            var first = NoIdx*pageSize;
            var last = first + pageSize;
            $scope.subSearchedOffers=$scope.$parent.siteListSearched.slice(first,last)
            $scope.$parent.sitePageNo=$scope.sitePageNo;
        }
    }

    //jesli istnieje wyszukiwanie w pamieci
    if($scope.$parent.siteFlagSearched==true){
        $scope.sitePageNo=$scope.$parent.sitePageNo;
        $scope.searchedOffers=$scope.$parent.siteListSearched;
        $scope.countSearched=$scope.searchedOffers.length;
        $scope.updatePartSearchedList($scope.sitePageNo);
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
        $scope.sitePageNo=1;
        $scope.$parent.sitePageNo=$scope.sitePageNo;
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
                $scope.searchedOffers = response.data;
                $scope.countSearched=$scope.searchedOffers.length;
                if($scope.countSearched == 0){
                    $scope.zeroSearched = true;
                    $scope.$parent.siteFlagSearched=false;
                }
                else{
                    $scope.$parent.siteFlagSearched=true;
                    $scope.$parent.siteListSearched=response.data;
                    $scope.updatePartSearchedList($scope.sitePageNo);
                    $scope.latest = false;
                    $scope.zeroSearched = false;
                    $scope.areSearched = true;
                }
            },
            function () {
                $scope.loading = false;
                $scope.zeroSearched = true;
                console.log("STATUS FAIL");
            });
    }



    $scope.pageSearchPrev = function () {
        if($scope.sitePageNo>1){
            $scope.sitePageNo=$scope.sitePageNo-1;
            $scope.updatePartSearchedList($scope.sitePageNo);
        }
    }
    $scope.pageSearchNext = function () {
        if($scope.sitePageNo<$scope.pageCounted){
            $scope.sitePageNo=$scope.sitePageNo+1;
            $scope.updatePartSearchedList($scope.sitePageNo);
        }
    }

}

