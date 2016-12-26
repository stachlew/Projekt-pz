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
                <div class="col-md-4"><h4><i class="glyphicon glyphicon-tag"></i>&nbspKategoria: {{offer.categoryName}}</h4></div>
                <div class="col-md-3 col-md-offset-5"><h4><i class="glyphicon glyphicon-calendar"></i>&nbsp Dodane: {{offer.dateAdded | date: 'yyyy-MM-dd HH:mm'}}</h4></div>
            </div>

            <%--miasto, region--%>
            <div class="row">
                <div class="col-md-4"><h4><i class="glyphicon glyphicon-map-marker"></i>&nbspLokalizacja: {{offer.city}}, {{offer.regionName}}</h4></div>
            </div>

            <%--fota, opis--%>
            <div class="row">
                <div class="col-md-3">
                    <img src="<c:url value="/resources/image/300x300.jpg"></c:url>" height="300" width="300" class="img-rounded img-responsive">
                </div>
                <div class="col-md-8 col-md-offset-1">
                    <div class="row"><h2>{{offer.title}}</h2></div>
                    </br>
                    <div class="row"><h4><i class="glyphicon glyphicon-time"></i>&nbspCena za dzień: {{offer.chargePerDay}} PLN</h4></div>
                    <div class="row"><h4><i class="glyphicon glyphicon-share-alt"></i>&nbspKaucja: {{offer.bailValue}} PLN </h4></div>
                    </br>
                    <div class="row">
                        <h4>
                            <a class="btn btn-default borromColour" role="button">
                                Rezerwuj
                            </a>
                            <a class="btn btn-default borromColour" role="button" ng-show="logged" ng-click="addObs()">
                                <span ng-show="addFav"><i class="glyphicon glyphicon-star" ></i>&nbspDodano do obserwowanych </span>
                                <span ng-show="!addFav"><i class="glyphicon glyphicon-star-empty" ></i> &nbspDodaj do obserwowanych </span>
                            </a>
                        </h4>
                    </div>
                </div>
            </div>
            </br>
            <%--kalendarz, opis--%>
            <div class="row">
                <div class="col-md-3">
                    <img src="<c:url value="/resources/image/calendar300.png"></c:url>" height="300" width="300" class="img-rounded img-responsive">
                </div>
                <div class="col-md-8 col-md-offset-1">
                    <h4>
                        {{offer.description}}
                    </h4>
                </div>
            </div>

            <%--wiecej od usera--%>
            <div class="row">
                <div class="text-center">
                    <h4>
                        <i class="glyphicon glyphicon-th-list"></i>&nbsp Więcej ogłoszeń użytkownika {{offer.username}}.
                    </h4>
                </div>
            </div>
    </div>
</div>