<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm" ng-init="refreshFormOptions()" style="padding: 25px">

    <form name="form" ng-show="formVis" ng-submit="updateItem(offer)" role="form" novalidate>
        <div class="row"><%-- szeroki panel--%>
            <div class="col-md-5"><%-- lewo--%>

                <div class="form-group">
                    <label for="category">Category*</label>
                    <select class="form-control" id="category" ng-model="offerCategory">
                        <option  ng-repeat="category in categories" value="{{category}}">{{category}}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="title">Title*</label>
                    <input type="text" name="title" id="title" class="form-control" ng-model="offer.title" ng-minlength="4" ng-maxlength="250" required />
                    <span ng-show="form.title.$touched && form.title.$error.required" class="help-block">Title is required</span>
                    <span ng-show="form.title.$touched && form.title.$error.minlength || form.title.$error.maxlength" class="help-block">Title length 4-250</span>
                </div>

                <div class="form-group">
                    <label for="bailValue">Bail value PLN</label>
                    <input type="number" step="0.01" name="bailValue" id="bailValue" class="form-control" ng-model="offer.bailValue" ng-maxlength="10"/>
                    <span ng-show="form.bailValue.$touched && form.bailValue.$error.maxlength" class="help-block">Max length: 10</span>
                </div>

                <div class="form-group">
                    <label for="chargePerDay">Charge per day PLN</label>
                    <input type="number" step="0.01" name="chargePerDay" id="chargePerDay" class="form-control" ng-model="offer.chargePerDay" ng-maxlength="10"/>
                    <span ng-show="form.chargePerDay.$touched && form.chargePerDay.$error.maxlength" class="help-block">Max length: 10</span>
                </div>

                <div class="form-group" >
                    <label for="region">Region*</label>
                    <select class="form-control" id="region" ng-model="offerRegion" required>
                        <option  ng-repeat="region in regions" value="{{region}}">{{region}}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="city">City*</label>
                    <input type="text" name="city" id="city" class="form-control" ng-model="offer.city" ng-maxlength="30" required/>
                    <span ng-show="form.city.$touched && form.city.$error.maxlength" class="help-block">Max length: 30</span>
                </div>

            </div>
            <div class="col-md-5 col-md-offset-2"><%-- prawo--%>
                <div class="text-right">
                    <h1>Edit offer</h1>
                </div>

                <div class="form-group">
                    <label for="description">Description</label>
                    <textarea style="max-width: 100%" rows="10" cols="30" name="description" id="description" class="form-control" ng-model="offer.description" ng-maxlength="500"></textarea>
                    <span ng-show="form.description.$touched && form.description.$error.maxlength" class="help-block">Max length: 500</span>
                </div>
                </br>
                </br>
                <div class="form-group">
                    <label for="image">Image</label>
                    <input id="image" type="file" class="form-control" />
                </div>
            </div>
        </div>
        </br>

        </br>
        <div class="row">
            <div class="col-md-3 col-md-offset-3">
                <div class="form-group">
                    <button type="submit" ng-disabled="form.$invalid" class="btn btn-lg btn-default btn-block borromColour">
                        <i class="glyphicon glyphicon-ok"></i>&nbspAccept Changes
                    </button>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <button class="btn btn-lg btn-default btn-block borromColour" ng-click="goLink('myAds')">
                        <i class="glyphicon glyphicon-remove"></i>&nbspCancel
                    </button>
                </div>
            </div>
        </div>
    </form>

    <div class="text-center linkBorrom" ng-show="regOk" ng-click='goOffer(offerId)'>
        <h4>
            Ogłoszenie zaktualizowane. Kliknij tutaj by zobaczyć ogłoszenie.
        </h4>
    </div>

    <div class="text-center" ng-show="regError" >
        Wystąpił błąd aktualizacji ogłoszenia.
    </div>

</div>