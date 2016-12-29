<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm" ng-init="refreshLoan()" style="padding: 25px">

    <div class="text-center"><img src="/resources/image/loader.gif" ng-show="loading" height="42" width="42"/></div>
    <div class="text-center" ng-show="noOffer" >Brak ogloszenia o wskazanym id</div>

    <div ng-show="isOffer">

        <form name="form" ng-show="formVis" ng-submit="addLoan()" role="form" novalidate>
            <div class="row">
                <div class="col-md-5">
                    <p>
                        <h4><u>Składanie propozycji do ogłoszenia:</u> </h4>
                        <h3>{{offer.title}} (Nr {{offerId}})</h3>
                    </p>
                </div>
                <div class="col-md-3 col-md-offset-4" >
                    <p>
                        <i class="glyphicon glyphicon-user"></i>&nbspNadawca: <strong>{{userName}}</strong><br>
                        <i class="glyphicon glyphicon-user"></i>&nbspOdbiorca: <strong>{{offer.username}}</strong><br>
                        <i class="glyphicon glyphicon-share-alt"></i>&nbspKaucja: <strong>{{offer.bailValue}} PLN</strong><br>
                        <i class="glyphicon glyphicon-time"></i>&nbspStawka: <strong>{{offer.chargePerDay}} PLN/dzień</strong><br>
                    </p>
                </div>
            </div>

            </br>

            <div class="row">
                <div class="col-md-4">
                    <p><i class="glyphicon glyphicon-calendar"></i>&nbsp Wybierz termin:</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label for="dateFrom">Od</label>
                    <input class="borromColour form-control" type="date" name="dateFrom" id="dateFrom" ng-model="dateFrom" required>
                    <br>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label for="dateTo">Do</label>
                    <input class="borromColour form-control" type="date" name="dateTo" id="dateFrom" ng-model="dateTo" required>
                </div>
                <div class="col-md-6 col-md-offset-2">
                    <div class="form-group">
                        <button type="submit" ng-disabled="form.$invalid" class="btn btn-lg btn-default btn-block borromColour">Add loan</button>
                    </div>
                </div>
            </div>

        </form>

        <div class="text-center linkBorrom" ng-show="regOk" ng-click='goOffer(offerId)'>
            <h4>
                Pomyślnie wysłano propozycję. Powrót do ogłoszenia {{offerId}}.
            </h4>
        </div>
        <div class="text-center" ng-show="regError" >
            Wystąpił błąd wysyłania propozycji.
        </div>

    </div>

</div>