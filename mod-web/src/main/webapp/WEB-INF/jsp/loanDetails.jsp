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
            <div class="col-md-12">
                <div class="panel panel-primary"  ng-init="refreshLoanMessages()" >
                            <div class="panel-heading" style="padding:0 0 0 8px;">
                                <span class="glyphicon glyphicon-user"></span>
                                <h6 class="panel-title" style="display:inline; color:#333333">Chat</h6>
                                <div class="clearfix"></div>
                            </div>
                            <div class="panel-body" style="padding:0 4px;">
                                <div class="row">
                                    <div class="col-xs-12" style="max-height:300px;max-width:100%;overflow-y:auto;overflow-x:hidden;">
                                        <table class="table table-hover table-condensed" style="">
                                            <tr ng-hide="chatMessages.length === 0" ng-repeat="chat in messages" style="min-width:100%;max-width:100%;width:100%;">
                                                <td><img src="{{chat.icon}}" alt="" style="margin-top:8px;"/></td>
                                                <td>
                                                    <h6>{{chat.sender}}</h6>
                                                </td>
                                                <td>
                                                    <p class="word-wrap:break-word"><small>{{chat.text}}</small></p>
                                                </td>
                                            </tr>
                                            <tr ng-show="chatMessages.length === 0">
                                                <td>
                                                    <p>Brak wiadomosci <strong>Napisz cos!</strong></p>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <form>
                                    <div class="input-group input-group-sm">
                                        <input type="text" class="form-control" ng-model="varText" placeholder="..."/>
                                        <span class="input-group-btn">
                                          <button class="btn btn-primary" type="submit" ng-click="sendText(varText)">Send</button>
                                        </span>
                                    </div>
                                </form>
                            </div>
                </div>
            </div>
        </div>
    </div>
</div>
