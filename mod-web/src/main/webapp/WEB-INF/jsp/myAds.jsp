<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>

<div class="well well-sm">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="text-center" ng-show="noAds" >Aktualnie nie posiadasz żadnych ogłoszeń.</div>
        <div class="list-group" ng-init="refreshMyAds()">
            <a class="list-group-item borromColour" ng-repeat="ad in adsList" ng-click="goLink(ad.idAdvertisement)" >
                <div class="row">
                    <div class="col-md-1">
                        <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                    </div>
                    <div class="col-md-11">
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">
                                {{ad.title}}
                            </div>
                        </div>
                        <div class="row">
                            </br></br></br>
                        </div>

                        <div class="row">
                            <div class="col-md-2 col-md-offset-1">
                                {{ad.categoryNamePL}}
                            </div>
                            <div class="col-md-2">
                                {{ad.dateAdded}}
                            </div>
                            <div class="col-md-1">
                                {{ad.idAdvertisement}}
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
</div>