<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm">
        <form class="form-horizontal">
            <div class="form-group" style="margin-bottom: 0">
                <div class="col-sm-6">
                    <input class="form-control" id="what" type="text" placeholder="<spring:message code="searchBar.what"/>">
                </div>
                <div class="col-sm-4">
                    <input class="form-control" id="where" type="text" placeholder="<spring:message code="searchBar.where"/>">
                </div>
                <div class="col-sm-2">
                    <button type="submit" class="btn btn-default btn-block borromColour"  id="search">
                        <i class="glyphicon glyphicon-search"></i>
                    </button>
                </div>
            </div>
        </form>
</div>

<div class="well well-sm">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="flex-row row" ng-init="refreshHome()">

        <div class="col-lg-3 col-sm-4 col-xs-6"  ng-repeat="ad in adsList" ng-click="goOffer(ad.idAdvertisement)">
            <div class="thumbnail borromColour">
                <div class="caption">
                    <img src="<c:url value="/resources/image/150.png"></c:url>" class="img-rounded">
                    <h3><b>
                        {{ad.title}}
                    </b></h3>
                    <p class="flex-text text-muted">
                        {{ad.regionName}}
                        </br>
                        {{br.categoryNamePL}}
                    </p>

                </div>

            </div>

        </div>
    </div>

</div>
