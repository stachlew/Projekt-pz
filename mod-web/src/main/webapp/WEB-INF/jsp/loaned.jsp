<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>

<style type="text/css">
    form.tab-form-demo .tab-pane {
        margin: 20px 20px;
    }
</style>

<div class="well well-sm">

    <tabset justified="true">
        <tab active="true" select="alertMe()">
            <tab-heading>
                <i class="glyphicon glyphicon-download"></i>&nbspWypożyczam od
            </tab-heading>
            <%--Wypozyczam od--%>
                <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
                <div class="text-center" ng-show="noAds" >Aktualnie nie posiadasz żadnych ogłoszeń.</div>
                <div class="list-group" ng-init="refreshBorrowFrom()">
                    <a class="list-group-item borromColour" ng-repeat="fromItem in borrowFromList" ng-click="goOffer(fromItem.idAdvertisement)" >
                        <div class="row">
                            <div class="col-md-1">
                                <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                            </div>
                            <div class="col-md-11">
                                <div class="row">
                                    <div class="col-md-10 col-md-offset-1">
                                        {{fromItem.title}}
                                    </div>
                                </div>
                                <div class="row">
                                    </br></br></br>
                                </div>

                                <div class="row">
                                    <div class="col-md-2 col-md-offset-1">
                                        {{fromItem.idLoan}}
                                    </div>
                                    <div class="col-md-2">
                                        {{fromItem.dateTo | date: 'yyyy-MM-dd HH:mm'}}
                                    </div>
                                    <div class="col-md-1">
                                        {{fromItem.idAdvertisement}}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            <%--Wypozyczam od--%>
        </tab>
        <tab select="alertMe()">
            <tab-heading>
                <i class="glyphicon glyphicon-upload"></i>&nbspWypożyczam do
            </tab-heading>
            <%--Wypozyczam do--%>
            <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
            <div class="text-center" ng-show="noAds" >Aktualnie nie posiadasz żadnych ogłoszeń.</div>
            <div class="list-group" ng-init="refreshBorrowTo()">
                <a class="list-group-item borromColour" ng-repeat="toItem in borrowToList" ng-click="goOffer(toItem.idAdvertisement)" >
                    <div class="row">
                        <div class="col-md-1">
                            <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                        </div>
                        <div class="col-md-11">
                            <div class="row">
                                <div class="col-md-10 col-md-offset-1">
                                    {{toItem.title}}
                                </div>
                            </div>
                            <div class="row">
                                </br></br></br>
                            </div>

                            <div class="row">
                                <div class="col-md-2 col-md-offset-1">
                                    {{toItem.idLoan}}
                                </div>
                                <div class="col-md-2">
                                    {{toItem.dateFrom | date: 'yyyy-MM-dd HH:mm'}}
                                </div>
                                <div class="col-md-1">
                                    {{toItem.idAdvertisement}}
                                </div>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <%--Wypozyczam do--%>
        </tab>
    </tabset>

</div>