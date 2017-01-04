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
                <i class="glyphicon glyphicon-download"></i>&nbsp<spring:message code="loaned.from.heading.text.borrow"/>
            </tab-heading>

                <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>

                <div class="text-center" ng-show="noBorrowFromItems" >
                    <p style="padding-top: 20px; padding-bottom: 20px"><strong><spring:message code="loaned.from.content.text.noBorrow"/></strong><p>
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
                                        <spring:message code="uniText.offerId"/>:&nbsp {{fromItem.idAdvertisement}} <br>
                                        <spring:message code="uniText.loanId"/>:&nbsp {{fromItem.idLoan}} <br>
                                        <spring:message code="uniText.lender"/>:&nbsp {{fromItem.lender}} <br>

                                    </div>
                                    <div class="col-md-2">
                                        <br>
                                        <spring:message code="uniText.fromUpper"/>:&nbsp {{fromItem.dateFrom | date: 'yyyy-MM-dd'}}<br>
                                        <spring:message code="uniText.toUpper"/>:&nbsp {{fromItem.dateTo | date: 'yyyy-MM-dd'}}
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
                <i class="glyphicon glyphicon-upload"></i>&nbsp<spring:message code="loaned.to.heading.text.lend"/>
            </tab-heading>
            <%--Wypozyczam do--%>
            <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>

            <div class="text-center" ng-show="noBorrowToItems" >
                <p style="padding-top: 20px; padding-bottom: 20px"><strong><spring:message code="loaned.to.content.text.noLend"/></strong><p>
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
                                    <spring:message code="uniText.offerId"/>:&nbsp {{toItem.idAdvertisement}} <br>
                                    <spring:message code="uniText.loanId"/>:&nbsp {{toItem.idLoan}} <br>
                                    <spring:message code="uniText.borrower"/>:&nbsp {{toItem.borrower}} <br>

                                </div>
                                <div class="col-md-2">
                                    <br>
                                    <spring:message code="uniText.fromUpper"/>:&nbsp {{toItem.dateFrom | date: 'yyyy-MM-dd'}}<br>
                                    <spring:message code="uniText.toUpper"/>:&nbsp {{toItem.dateTo | date: 'yyyy-MM-dd'}}
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