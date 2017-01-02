<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm" ng-init="refreshOffer()">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="text-center" ng-show="noOffer" >Brak ogloszenia o wskazanym id</div>

    <div ng-show="isOffer">
        <%--kategoria, data--%>
            <div class="row">
                <div class="col-md-5"><h4><i class="glyphicon glyphicon-tag"></i>&nbspKategoria: {{offer.categoryName}}</h4></div>
                <div class="col-md-3 col-md-offset-4"><h4 class="text-right"><i class="glyphicon glyphicon-calendar"></i>&nbsp Dodane: {{offer.dateAdded | date: 'yyyy-MM-dd'}}</h4></div>
            </div>
            <div class="row">
                <div class="col-md-5"><h4><i class="glyphicon glyphicon-map-marker"></i>&nbspLokalizacja: {{offer.city}}, {{offer.regionName}}</h4></div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <p>
                        <h4><i class="glyphicon glyphicon-share-alt"></i>&nbspKaucja: {{offer.bailValue}} PLN</h4>
                    </p>
                </div>
                <div class="col-md-5 col-md-offset-3">
                    <p>
                        <h4 class="text-right">
                            <i class="glyphicon glyphicon-th-list"></i>&nbsp Więcej ogłoszeń użytkownika {{offer.username}}.
                        </h4>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <p>
                        <h4><i class="glyphicon glyphicon-time"></i>&nbspCena za dzień: {{offer.chargePerDay}} PLN</h4>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <h2>{{offer.title}}</h2>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <img src="<c:url value="/resources/image/300x300.jpg"></c:url>" height="300" width="300" class="img-rounded img-responsive">
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <h4>
                            {{offer.description}}
                        </h4>
                    </div>
                </div>
            </div>
            <div class="row">
                <br>
                <div class="col-md-12" ng-show="logged && (userName != offer.username)">
                    <div class="btn-group btn-group-justified">
                        <a ng-show="logged" class="btn btn-block btn-default borromColour" role="button" ng-click="goAddLoan(offerId)">
                            Rezerwuj
                        </a>
                        <a class="btn btn-default btn-block borromColour" role="button"  ng-init="refreshObsStatus()" ng-click="addObs()">
                            <span ng-show="addFav"><i class="glyphicon glyphicon-star" ></i>&nbspObserwowane </span>
                            <span ng-show="!addFav"><i class="glyphicon glyphicon-star-empty" ></i> &nbspDodaj do obserwowanych </span>
                        </a>
                    </div>
                </div>
            </div>


    </div>
</div>