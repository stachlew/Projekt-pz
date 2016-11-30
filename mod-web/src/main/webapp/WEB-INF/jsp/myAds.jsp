<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resource/js/homeRedirect.js/"></script>

<div class="well well-sm">
    <a class="btn btn-default" role="button" ng-click="duplicate()">
        Jakaś angularowa akcja związana z przyciskiem.
    </a>
        <div class="list-group" ng-init="refreshMyAds()">
            <a class="list-group-item" ng-click="goLink(1)" ng-repeat="ad in adsList">
                <div class="row">
                    <div class="col-md-1">
                        <img src="<c:url value="/resource/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
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