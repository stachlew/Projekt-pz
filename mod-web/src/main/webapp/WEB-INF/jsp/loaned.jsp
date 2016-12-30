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

                <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>

                <div class="text-center" ng-show="noBorrowFromItems" >
                    <p style="padding-top: 20px; padding-bottom: 20px"><strong>Niczego nie pożyczasz lub Twoje zapytania są niezaakceptowane.</strong><p>
                </div>
            <%--Wypozyczam od--%>
            <div class="list-group" ng-init="refreshBorrowFrom()">
                    <a class="list-group-item borromColour" ng-repeat="fromItem in borrowFromList" ng-click="goLoanDetails(fromItem.idLoan)" >
                        <div class="row">
                            <div class="col-md-1">
                                <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                            </div>
                            <div class="col-md-11">
                                <div class="row">
                                    <div class="col-md-7 col-md-offset-1">
                                        <h4>{{fromItem.title}}</h4>
                                    </div>
                                    <div class="col-md-3 col-md-offset-1">
                                        <br>
                                        STATUS: {{fromItem.loanStatus}}
                                    </div>
                                </div>

                                <div class="row">
                                    <br>
                                </div>

                                <div class="row">
                                    <div class="col-md-4 col-md-offset-1">
                                        Nr ogloszenia: {{fromItem.idAdvertisement}} <br>
                                        Nr wypożyczenia: {{fromItem.idLoan}} <br>
                                        Udostępniający: {{fromItem.lender}} <br>

                                    </div>
                                    <div class="col-md-2">
                                        <br>
                                        Od: {{fromItem.dateFrom | date: 'yyyy-MM-dd'}}
                                        Do: {{fromItem.dateTo | date: 'yyyy-MM-dd'}}
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

            <div class="text-center" ng-show="noBorrowToItems" >
                <p style="padding-top: 20px; padding-bottom: 20px"><strong>Nie potwierdziłeś wypożyczenia lub nikomu nic nie wypożyczasz.</strong><p>
            </div>

            <div class="list-group" ng-init="refreshBorrowTo()">
                <a class="list-group-item borromColour" ng-repeat="toItem in borrowToList" ng-click="goLoanDetails(toItem.idLoan)" >
                    <div class="row">
                        <div class="col-md-1">
                            <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                        </div>

                        <div class="col-md-11">
                            <div class="row">
                                <div class="col-md-7 col-md-offset-1">
                                    <h4>{{toItem.title}}</h4>
                                </div>
                                <div class="col-md-3 col-md-offset-1">
                                    <br>
                                    STATUS: {{toItem.loanStatus}}
                                </div>
                            </div>

                            <div class="row">
                                <br>
                            </div>

                            <div class="row">
                                <div class="col-md-4 col-md-offset-1">
                                    Nr ogloszenia: {{toItem.idAdvertisement}} <br>
                                    Nr wypożyczenia: {{toItem.idLoan}} <br>
                                    Pobierający: {{toItem.borrower}} <br>

                                </div>
                                <div class="col-md-2">
                                    <br>
                                    Od: {{toItem.dateFrom | date: 'yyyy-MM-dd'}}
                                    Do: {{toItem.dateTo | date: 'yyyy-MM-dd'}}
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