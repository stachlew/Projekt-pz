<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="text-center" ng-show="noItems" >
       <h3>Brak notyfikacji</h3>
    </div>
    <div class="list-group" ng-init="refreshNotifications()">
        <a class="list-group-item borromColour" ng-repeat="fromItem in borrowList" ng-click="goLoanDetails(fromItem.idLoan)" ng-class="{ newNotification: fromItem.messageWithStatusTwo>0}">
            <div class="row">
                <div class="col-md-1">
                    <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                </div>
                <div class="col-md-11">
                    <div class="row">
                        <div class="col-md-7 col-md-offset-1">
                            <h4><strong>{{fromItem.title}}</strong></h4>
                        </div>
                        <div class="col-md-3 col-md-offset-1">
                            <br>
                            <p><i class="glyphicon glyphicon-info-sign"></i>&nbspSTATUS:&nbsp{{fromItem.loanStatus}}
                            <br>
                            <br>
                            <span ng-if="fromItem.messageWithStatusTwo"><strong>NOWE WIADOMOŚCI! ({{fromItem.messageWithStatusTwo}}) </strong> </span>
                        </div>
                    </div>

                    <div class="row">
                        <br>
                    </div>

                    <div class="row">
                        <div class="col-md-3 col-md-offset-1">
                            Nr ogloszenia: {{fromItem.idAdvertisement}} <br>
                            Nr wypożyczenia: {{fromItem.idLoan}} <br>
                        </div>
                        <div class="col-md-2">
                            Od: {{fromItem.dateFrom | date: 'yyyy-MM-dd'}}<br>
                            Do: {{fromItem.dateTo | date: 'yyyy-MM-dd'}}<br>
                        </div>
                        <div class="col-md-3">
                            Udostępniający: {{fromItem.lender}} <br>
                            Pożyczający: {{fromItem.borrower}} <br>
                        </div>

                    </div>
                </div>
            </div>
        </a>
    </div>
</div>