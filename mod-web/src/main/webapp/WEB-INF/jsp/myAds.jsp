<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>

<div class="well well-sm">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading && firstOpen" height="42" width="42"/></div>

    <div class="text-center" ng-show="noAds" >
        <h3><spring:message code="myAds.content.text.noAds"/></h3>
    </div>

    <div class="list-group" ng-init="refreshMyAds()">
        <a class="list-group-item borromColourNotHover" ng-repeat="ad in adsList" >
            <div class="row">
                <div class="col-md-1">
                    <img style="height:120px;width: 120px" class="img-rounded" ng-src="rest/pub/images/getImage/{{ad.idAdvertisement}}" alt="Offer foto" />
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <h4><strong>{{ad.title}} (<spring:message code="uniText.offerId"/>&nbsp {{ad.idAdvertisement}})</strong></h4>
                        </div>
                    </div>
                    <div class="row">
                        </br></br></br>
                    </div>
                    <div class="row">
                        <div class="col-md-5 col-md-offset-1">
                            <spring:message code="uniText.category"/>:&nbsp {{ad.categoryName}}<br>
                            <spring:message code="uniText.added"/>:&nbsp {{ad.dateAdded | date: 'yyyy-MM-dd'}}
                        </div>
                        <div class="col-md-6">
                            <spring:message code="uniText.region"/>:&nbsp {{ad.regionName}}<br>
                            <spring:message code="uniText.city"/>:&nbsp {{ad.city}}<br>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <br>
                    <button class="btn btn-default btn-block borromColour" role="button" ng-click="goEditOffer(ad.idAdvertisement)">
                        <i class="glyphicon glyphicon-edit"></i>&nbsp<spring:message code="myAds.list.button.editAd"/>
                    </button>
                    <button class="btn btn-default btn-block borromColour" role="button" ng-click="goOffer(ad.idAdvertisement)">
                        <i class="glyphicon glyphicon-question-sign"></i>&nbsp<spring:message code="myAds.list.button.showAd"/>
                    </button>
                    <button class="btn btn-default btn-block borromColour" role="button" ng-click="deleteMyAd(ad.idAdvertisement)">
                        <i class="glyphicon glyphicon-trash"></i>
                        &nbsp<spring:message code="myAds.list.button.deleteAd"/>
                        &nbsp<i ng-show="loadingRemove && (idRemove==ad.idAdvertisement)" class="glyphicon glyphicon-refresh fa-spin"></i>
                    </button>
                </div>

            </div>
        </a>
    </div>
</div>
