<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm">

    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>

    <div class="text-center" ng-show="noObs" >
        <h3><spring:message code="observed.content.text.noObserved"/></h3>
    </div>

    <div class="list-group" ng-init="refreshObserved()">
        <a class="list-group-item borromColour" ng-repeat="ob in observationList" >
            <div class="row">
                <div class="col-md-1">
                    <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                </div>
                <div class="col-md-10" ng-click="goOffer(ob.idAdvertisement)" >
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <h4><strong>{{ob.title}} (<spring:message code="uniText.offerId"/>&nbsp{{ob.idAdvertisement}})</strong></h4>
                        </div>
                    </div>
                    <div class="row">
                        </br></br></br>
                    </div>

                    <div class="row">
                        <div class="col-md-3 col-md-offset-1">
                            <spring:message code="uniText.category"/>:&nbsp {{ob.categoryName}}<br>
                            <spring:message code="uniText.added"/>:&nbsp {{ob.dateAdded | date: 'yyyy-MM-dd'}}
                        </div>
                        <div class="col-md-4 ">
                            <spring:message code="uniText.region"/>:&nbsp {{ob.regionName}}<br>
                            <spring:message code="uniText.city"/>:&nbsp {{ob.city}}<br>
                        </div>
                        <div class="col-md-4">
                            <spring:message code="uniText.owner"/>:&nbsp  {{ob.username}}
                        </div>
                    </div>
                </div>
                <div class="col-md-1">
                        <span class="glyphicon glyphicon-remove " role="button" style="font-size:1.5em;" ng-click="deleteObs(ob.idAdvertisement,$index)"> </span>
                </div>

            </div>


        </a>


    </div>




</div>