<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>

<div class="well well-sm" ng-init="refreshLoanDetails()">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="text-center" ng-show="noLoan" >Brak wypożyczenia o wskazanym id</div>
    <div ng-show="isLoan">
        <div class="row">
            <div class="col-md-offset-1 col-md-10">
                Dane 1:
                borrower: {{loanDetails.borrower}}
            </div>
        </div>
        <div class="row">
            <div class="col-md-offset-1 col-md-10">
                Dane 2
            </div>
        </div>
        <div class="row">
            <div class="col-md-offset-1 col-md-10">
                <div class="list-group" ng-init="refreshLoanMessages()">
                    <a class="list-group-item borromColour" ng-repeat="message in messages">
                        Tekst: {{message.text}}
                    </a>
                </div>
            </div>
        </div>

    </div>
</div>

