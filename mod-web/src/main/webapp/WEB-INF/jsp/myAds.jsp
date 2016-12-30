<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>

<div class="well well-sm">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="text-center" ng-show="noAds" >Aktualnie nie posiadasz żadnych ogłoszeń.</div>
    <div class="list-group" ng-init="refreshMyAds()">
        <a class="list-group-item borromColourNotHover" ng-repeat="ad in adsList" >
            <div class="row">
                <div class="col-md-1">
                    <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <h4><strong>{{ad.title}} (Nr {{ad.idAdvertisement}})</strong></h4>
                        </div>
                    </div>
                    <div class="row">
                        </br></br></br>
                    </div>
                    <div class="row">
                        <div class="col-md-5 col-md-offset-1">
                            Kategoria: {{ad.categoryName}}<br>
                            Dodano: {{ad.dateAdded | date: 'yyyy-MM-dd'}}
                        </div>
                        <div class="col-md-6">
                            Region: {{ad.regionName}}<br>
                            Miasto: {{ad.city}}<br>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <br>
                    <button class="btn btn-default btn-block borromColour" role="button" ng-click="goEditOffer(ad.idAdvertisement)">
                        Edytuj ogłoszenie
                    </button>
                    <button class="btn btn-default btn-block borromColour" role="button" ng-click="goOffer(ad.idAdvertisement)">
                        Podgląd ogłoszenia
                    </button>
                    <button class="btn btn-default btn-block borromColour" role="button" ng-click="">
                        Usuń ogłoszenie
                    </button>
                </div>

            </div>
        </a>
    </div>
</div>
