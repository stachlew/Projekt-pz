<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm" ng-init="refreshNotifications(1)">

    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-center">
            <span class="text-right"><img src="/resources/image/loader.gif" ng-show="loading" height="25" width="25"/></span>
        </div>
        <div class="col-md-4 text-right">
            <span>
                <ul class="list-inline" style="margin: 4px">
                    <li><a  ng-click="pagePrev()"> <i class="glyphicon glyphicon-triangle-left"></i> </a></li>
                    <li style="width: 50px"><input style="padding: 1px 1px" min="1" max={{pageCounted}} type="number" class="form-control" ng-model="pageNo"></li>
                    <li> z {{pageCounted}}</li>
                    <li><a ng-click="refreshNotifications(pageNo)"> <i class="glyphicon glyphicon-repeat"></i> </a></li>
                    <li><a ng-click="pageNext()"> <i class="glyphicon glyphicon-triangle-right"></i> </a></li>
                </ul>
            </span>
        </div>
    </div>


    <div class="row">
        <div class="col-md-12">
            <div class="list-group">
                <a class="list-group-item borromColour" ng-repeat="fromItem in borrowList" ng-click="goLoanDetails(fromItem.idLoan)" ng-class="{ newNotification: fromItem.messageWithStatusTwo>0}">
                    <div class="row">
                        <div class="col-md-1">
                            <img src="<c:url value="/resources/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                        </div>
                        <div class="col-md-11">
                            <div class="row">
                                <div class="col-md-7 col-md-offset-1">
                                    <h4><strong>
                                        <span ng-show="fromItem.borrower == userName">
                                            {{fromItem.title}}
                                            <i class="glyphicon glyphicon-arrow-right" ></i>
                                            <i class="glyphicon glyphicon-home" ></i>
                                        </span>
                                        <span ng-show="fromItem.lender == userName">
                                            {{fromItem.title}}
                                            <i class="glyphicon glyphicon-arrow-right" ></i>
                                            <i class="glyphicon glyphicon-globe" ></i>
                                        </span>

                                    </strong></h4>
                                </div>
                                <div class="col-md-3 col-md-offset-1">
                                    <br>
                                    <p><i class="glyphicon glyphicon-info-sign"></i>&nbspSTATUS:&nbsp{{fromItem.loanStatus}}
                                </div>
                            </div>

                            <div class="row">
                                <br>
                            </div>

                            <div class="row">
                                <div class="col-md-3 col-md-offset-1">
                                    <spring:message code="uniText.offerId"/>:&nbsp {{fromItem.idAdvertisement}} <br>
                                    <spring:message code="uniText.loanId"/>:&nbsp {{fromItem.idLoan}} <br>
                                </div>
                                <div class="col-md-2">
                                    <spring:message code="uniText.fromUpper"/>:&nbsp {{fromItem.dateFrom | date: 'yyyy-MM-dd'}}<br>
                                    <spring:message code="uniText.toUpper"/>:&nbsp {{fromItem.dateTo | date: 'yyyy-MM-dd'}}<br>
                                </div>
                                <div class="col-md-3">
                                    <span ng-class="{ iAmStrong: fromItem.lender === userName}">
                                        <spring:message code="uniText.lender"/>:&nbsp {{fromItem.lender}} <br>
                                    </span>
                                    <span ng-class="{ iAmStrong: fromItem.borrower === userName}">
                                        <spring:message code="uniText.borrower"/>:&nbsp {{fromItem.borrower}} <br>
                                    </span>
                                </div>
                                <div class="col-md-3">
                                    <span ng-if="fromItem.messageWithStatusTwo"><strong><spring:message code="notifications.list.text.newMessage"/> ({{fromItem.messageWithStatusTwo}}) </strong> </span>
                                </div>

                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="text-center" ng-show="noItems" >
                <h3><spring:message code="notifications.content.text.noNotification"/></h3>
            </div>
        </div>
    </div>

</div>