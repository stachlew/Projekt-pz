<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm"> <%--Wyszukiwarka--%>
        <form class="form-horizontal" role="form" ng-submit="search()" novalidate>
            <div class="form-group" style="margin-bottom: 0">
                <div class="col-sm-7">
                    <div class="input-group">
                        <span class="input-group-addon"><spring:message code="searchBar.what"/></span>
                        <input class="form-control" ng-model="title" id="title" type="text" placeholder="Szukaj w tytule ogłoszenia">
                    </div>
                </div>
                <div class="col-sm-2">
                    <button type="button" ng-click="showAdvancedSearch()" class="btn btn-default btn-block borromColour"  id="search">
                        Filtry &nbsp
                        <i ng-show="advanced" class="glyphicon glyphicon-chevron-down"></i>
                        <i ng-show="!(advanced)" class="glyphicon glyphicon-chevron-up"></i>
                    </button>
                </div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-default btn-block borromColour"  id="search">
                        <span ng-show="advanced"><i class="glyphicon glyphicon-search"></i>&nbspWyszukaj wg: </span>
                        <span ng-show="!(advanced)"><i class="glyphicon glyphicon-search"></i>&nbspWyszukaj </span>
                    </button>

                </div>

            </div>
            <div id="advanced" ng-show="advanced" class="animate-show" ng-init="refreshForm()"> <%--Kryteria zaawansowane--%>
                <div class="row">
                    <br>
                </div>
                <div class="form-group" style="margin-bottom: 0">
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon">Kategoria</span>
                            <select class="form-control" id="category" ng-model="category">
                                <option  ng-repeat="category in categories" value="{{category}}">{{category}}</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-2 col-md-offset-3">
                        <button type="button" ng-click="clearForm()" class="btn btn-default btn-block borromColour">
                            Reset &nbsp <i class="glyphicon glyphicon-erase"></i>
                        </button>
                    </div>
                </div>
                <div class="row">
                    <br>
                </div>
                <div class="form-group" style="margin-bottom: 0">
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon">Region</span>
                            <select class="form-control" id="region" ng-model="region" required>
                                <option  ng-repeat="region in regions" value="{{region}}">{{region}}</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon">Stawka od</span>
                            <span class="input-symbol-pln">
                                <input type="number" step="0.01" name="chargePerDay" id="chargePerDay" class="form-control" ng-model="chargePerDayFrom" min="0" max="999999" ng-maxlength="10"/>
                            </span>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon">Kaucja od</span>
                            <span class="input-symbol-pln">
                            <input type="number" step="0.01" name="bailValue" id="bailValue" class="form-control" ng-model="bailValueFrom" min="0" max="999999" ng-maxlength="10"/>
                        </div>
                    </div>
                </div>
                <div class="form-group" style="margin-bottom: 0">
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon">City</span>
                            <input type="text" name="city" id="city" class="form-control" ng-model="city" ng-maxlength="30" required/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon">Stawka do</span>
                            <span class="input-symbol-pln">
                            <input type="number" step="0.01" name="chargePerDay" id="chargePerDay" class="form-control" ng-model="chargePerDayTo" min="0" max="999999" ng-maxlength="10"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon">Kaucja do</span>
                            <span class="input-symbol-pln">
                            <input type="number" step="0.01" name="bailValue" id="bailValue" class="form-control" ng-model="bailValueTo" min="0" max="999999" ng-maxlength="10"/>
                        </div>
                    </div>
                </div>

            </div>

        </form>
</div>

<div class="well well-sm">

    <%--Ladowanie--%>
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>

    <%--Brak znalezionych--%>
    <div ng-show="zeroSearched">
        <div class="row">
            <div class="col-md-4 col-md-offset-4 text-center" style="margin-bottom: 20px;margin-top: 20px">
                <h4>Brak ogłoszeń spełniających kryteria</h4>
                <h5><a ng-click="returnLatest()">Powrót do najnowszych ogłoszeń</a></h5>
            </div>
        </div>

    </div>
    <%--Najnowsze--%>
    <div class="flex-row row" ng-init="refreshHome()" ng-show="latest">

        <div class="col-md-3 col-sm-4 col-xs-12"  ng-repeat="ad in adsList" ng-click="goOffer(ad.idAdvertisement)">
            <div class="thumbnail borromColour">
                <div class="caption">
                    <img src="<c:url value="/resources/image/150.png"></c:url>" class="img-rounded">
                    <h3><b>
                        {{ad.title}}
                    </b></h3>
                    <p class="flex-text text-muted">
                        <i class="glyphicon glyphicon-map-marker"></i>&nbsp&nbsp{{ad.city}},&nbsp{{ad.regionName}}
                        </br>
                        <i class="glyphicon glyphicon-tag"></i>&nbsp&nbsp{{ad.categoryName}}
                    </p>

                </div>

            </div>

        </div>
    </div>

    <%--Wyszukiwanie--%>
    <div class="list-group" ng-show="areSearched">
        <a class="list-group-item borromColour" ng-repeat="ob in searchedOffers" >
            <div class="row">
                <div class="col-md-1">
                    <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                </div>
                <div class="col-md-10" ng-click="goOffer(ob.idAdvertisement)" >
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <h4><strong>{{ob.title}} (Nr {{ob.idAdvertisement}})</strong></h4>
                        </div>
                    </div>
                    <div class="row">
                        </br></br></br>
                    </div>

                    <div class="row">
                        <div class="col-md-3 col-md-offset-1">
                            Kategoria: {{ob.categoryName}}<br>
                            Dodano: {{ob.dateAdded | date: 'yyyy-MM-dd'}}
                        </div>
                        <div class="col-md-3 ">
                            Region: {{ob.regionName}}<br>
                            Miasto: {{ob.city}}<br>
                        </div>
                        <div class="col-md-3">
                            Właściciel: {{ob.username}}
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
</div>
