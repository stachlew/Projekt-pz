<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="text-center" ng-show="noAds" >Aktualnie nie posiadasz żadnych wypożyczeń.</div>
    <div class="list-group" ng-init="refreshBorrow()">
        <a class="list-group-item borromColour" ng-repeat="fromItem in borrowList" ng-click="goLoanDetails(fromItem.idLoan)" >
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
                            STATUS: {{fromItem.loanStatus}} {{fromItem.messageWithStatusTwo}}
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
</div>