<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm">
    <div style="overflow: hidden">
        <form class="form-horizontal">
            <div class="form-group">
                <div class="col-sm-5">
                    <label class ="myLabel" for="what">
                        <spring:message code="searchBar.what"/>
                    </label>
                    <input class="form-control" id="what" type="text">
                </div>
                <div class="col-sm-5">
                    <label class ="myLabel" for="where">
                        <spring:message code="searchBar.where"/>
                    </label>
                    <input class="form-control" id="where" type="text">
                </div>
                <div class="col-sm-2">
                    <label class ="myLabel" for="search"> &nbsp </label>
                    <button type="submit" class="btn btn-default btn-block borromColour"  id="search">
                        <spring:message code="searchBar.search"/>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="well well-sm">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="flex-row row" ng-init="refreshHome()">

        <div class="col-lg-3 col-sm-4 col-xs-6"  ng-repeat="ad in adsList" ng-click="goLink(ad.idAdvertisement)">
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
