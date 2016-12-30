<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>

<div class="well well-sm" ng-init="refreshLoanDetails()">
    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="text-center" ng-show="noLoan" >Brak wypożyczenia o wskazanym id</div>
    <div ng-show="isLoan">

        <div class="row">
            <div class="col-md-6"><%--Lewa--%>

                    <div class="row">
                        <div class="col-md-10 col-md-offset-1 ">
                            <h3>Dotyczy ogłoszenia (nr {{loanDetails.idAdvertisement}})</h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p><strong><i class="glyphicon glyphicon-hand-right"></i>&nbsp{{loanDetails.title}}</strong></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p><i class="glyphicon glyphicon-share-alt"></i>&nbspKaucja: <strong>{{loanDetails.bailValue}} PLN</strong></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p><i class="glyphicon glyphicon-time"></i>&nbspStawka: <strong>{{loanDetails.chargePerDay}} PLN/dzień</strong></p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p><h4>Status: <strong>{{loanDetails.loanStatus}}</strong></h4></p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p style="margin-top: 20px"></p>
                        </div>
                    </div>


                    <div class="row" ng-show="isLender">
                        <div class="col-md-10 col-md-offset-1">
                            <form class="form-inline" name="form" ng-submit="changeStatus()" ng-init="refreshLoanStatuses()" role="form" novalidate>
                                 <div class="form-group">
                                     <label for="status">Zmiana statusu: </label>
                                     <select class="form-control" id="status" ng-model="status">
                                         <option  ng-repeat="status in statuses" value="{{status}}">{{status}}</option>
                                     </select>
                                 </div>
                                <button type="submit" ng-disabled="form.$invalid" class="btn btn-default  borromColour">Change status</button>

                            <form>
                        </div>
                    </div>

            </div><%--/Lewa--%>
            <div class="col-md-6"><%--Prawa--%>

                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p><h3>Oferta wypożyczenia (nr {{loanDetails.idLoan}})</h3></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p><i class="glyphicon glyphicon-user"></i>&nbspOdbiorca: <strong>{{loanDetails.borrower}}</strong></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p><i class="glyphicon glyphicon-user"></i>&nbspUdostępniający: <strong>{{loanDetails.lender}}</strong></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p><i class="glyphicon glyphicon-calendar"></i>&nbspOd: <strong>{{loanDetails.dateFrom}}</strong></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <p><i class="glyphicon glyphicon-calendar"></i>&nbspDo: <strong>{{loanDetails.dateTo}}</strong></p>
                        </div>
                    </div>

            </div><%--/Prawa--%>
        </div>

        <div class="row">
            <p><br></p>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary"  ng-init="refreshLoanMessages()" >
                    <div class="panel-heading" style="padding:0 0 0 8px;">
                        <span class="glyphicon glyphicon-comment" style="color:#333333"></span>
                        <h6 class="panel-title" style="display:inline; color:#333333">Chat</h6>
                        <div class="clearfix"></div>
                    </div>
                    <div class="panel-body" style="padding:0 4px;">
                        <div class="row">
                            <div class="col-md-12" style="max-height:300px;max-width:98.5%;overflow-y:auto;overflow-x:hidden;">
                                <table class="table table-condensed" style="font-size: 17px;">
                                    <tr ng-hide="messages.length === 0" ng-repeat="chat in messages" style="min-width:100%;max-width:100%;width:100%;" ng-class="{ success: chat.sender !== userName}">
                                        <td>
                                            <h6>{{chat.sender}}</h6>
                                        </td>
                                        <td>
                                            <p class="word-wrap:break-word"><small>{{chat.text}}</small></p>
                                        </td>
                                    </tr>
                                    <tr ng-show="messages.length === 0">
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
                                  <button class="btn btn-primary borromColour" style="color: #333333" type="submit" ng-click="sendText(varText)"><strong>Send</strong></button>
                                </span>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
