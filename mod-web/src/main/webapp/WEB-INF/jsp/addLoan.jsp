<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm" ng-init="refreshLoan()" style="padding: 25px">

    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="text-center" ng-show="noOffer" ><spring:message code="uniText.noOfferId"/></div>

    <div ng-show="isOffer">

        <form name="form" ng-show="formVis" ng-submit="addLoan()" role="form" novalidate>
            <div class="row">
                <div class="col-md-5">
                    <p>
                        <h4><u><spring:message code="loanProposition.title"/></u> </h4>
                        <h3>{{offer.title}} (<spring:message code="uniText.offerId"/>&nbsp {{offerId}})</h3>
                    </p>
                </div>
                <div class="col-md-3 col-md-offset-4" >
                    <p>
                        <i class="glyphicon glyphicon-user"></i>&nbsp<spring:message code="uniText.borrower"/>:&nbsp  <strong>{{userName}}</strong><br>
                        <i class="glyphicon glyphicon-user"></i>&nbsp<spring:message code="uniText.owner"/>:&nbsp  <strong>{{offer.username}}</strong><br>
                        <i class="glyphicon glyphicon-share-alt"></i>&nbsp<spring:message code="uniText.bailValue"/>:&nbsp  <strong>{{offer.bailValue}} <spring:message code="uniText.pln"/></strong><br>
                        <i class="glyphicon glyphicon-time"></i>&nbsp<spring:message code="uniText.price"/>:&nbsp  <strong>{{offer.chargePerDay}} <spring:message code="uniText.PLNperDay"/></strong><br>
                    </p>
                </div>
            </div>

            </br>

            <div class="row">
                <div class="col-md-4">
                    <p><i class="glyphicon glyphicon-calendar"></i>&nbsp <spring:message code="loanProposition.pickDate"/>&nbsp </p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label for="dateFrom"><spring:message code="uniText.fromUpper"/></label>
                    <input class="borromColour form-control" type="date" name="dateFrom" id="dateFrom" ng-model="dateFrom" min={{stockDate}} required>
                    <br>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label for="dateTo"><spring:message code="uniText.toUpper"/></label>
                    <input class="borromColour form-control" type="date" name="dateTo" id="dateFrom" ng-model="dateTo" min={{dateFrom}} required>
                </div>
                <div class="col-md-3 col-md-offset-2">
                    <div class="form-group">
                        <button type="button" ng-click="goOffer(offerId)" class="btn btn-lg btn-default btn-block borromColour">
                            <i class="glyphicon glyphicon-remove"></i>&nbsp<spring:message code="loanProposition.cancel"/>
                        </button>
                    </div>
                </div>
                <div class="col-md-3 ">
                    <div class="form-group">
                        <button type="submit" ng-disabled="form.$invalid" class="btn btn-lg btn-default btn-block borromColour">
                            <i class="glyphicon glyphicon-ok"></i>&nbsp<spring:message code="loanProposition.addLoan"/>
                        </button>
                    </div>
                </div>
            </div>

        </form>

        <div class="text-center linkBorrom" ng-show="regOk" ng-click='goOffer(offerId)'>
            <h4>
                <spring:message code="loanProposition.afterOk"/>&nbsp {{offerId}}.
            </h4>
        </div>
        <div class="text-center" ng-show="regError" >
            <spring:message code="loanProposition.afterError"/>
        </div>

    </div>

</div>