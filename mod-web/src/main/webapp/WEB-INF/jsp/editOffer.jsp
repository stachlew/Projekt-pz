<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm" ng-init="refreshFormOptions()" style="padding: 25px">

    <form name="form" ng-show="formVis" ng-submit="updateItem(offer)" role="form" novalidate>
        <div class="row"><%-- szeroki panel--%>
            <div class="col-md-5"><%-- lewo--%>

                <div class="form-group">
                    <label for="category"><spring:message code="uniText.category"/>*</label>
                    <select class="form-control" id="category" ng-model="offerCategory">
                        <option  ng-repeat="category in categories" value="{{category}}">{{category}}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="title"><spring:message code="uniText.title"/>*</label>
                    <input type="text" name="title" id="title" class="form-control" ng-model="offer.title" ng-minlength="4" ng-maxlength="250" required />
                    <span ng-show="form.title.$touched && form.title.$error.required" class="help-block"><spring:message code="uniText.title"/>&nbsp <spring:message code="validate.required"/></span>
                    <span ng-show="form.title.$touched && form.title.$error.minlength || form.title.$error.maxlength" class="help-block"><spring:message code="uniText.title"/>:&nbsp <spring:message code="validate.length"/> 4-250</span>
                </div>

                <div class="form-group">
                    <label for="bailValue"><spring:message code="uniText.bailValue"/>&nbsp <spring:message code="uniText.pln"/></label>
                    <input type="number" step="0.01" name="bailValue" id="bailValue" class="form-control" ng-model="offer.bailValue" ng-maxlength="10"/>
                    <span ng-show="form.bailValue.$touched && form.bailValue.$error.maxlength" class="help-block">Max &nbsp <spring:message code="validate.length"/>&nbsp: 10</span>
                </div>

                <div class="form-group">
                    <label for="chargePerDay"><spring:message code="uniText.price"/>&nbsp <spring:message code="uniText.PLNperDay"/></label>
                    <input type="number" step="0.01" name="chargePerDay" id="chargePerDay" class="form-control" ng-model="offer.chargePerDay" ng-maxlength="10"/>
                    <span ng-show="form.chargePerDay.$touched && form.chargePerDay.$error.maxlength" class="help-block">Max &nbsp <spring:message code="validate.length"/>&nbsp: 10</span>
                </div>

                <div class="form-group" >
                    <label for="region"><spring:message code="uniText.region"/>*</label>
                    <select class="form-control" id="region" ng-model="offerRegion" required>
                        <option  ng-repeat="region in regions" value="{{region}}">{{region}}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="city"><spring:message code="uniText.city"/>*</label>
                    <input type="text" name="city" id="city" class="form-control" ng-model="offer.city" ng-maxlength="30" required/>
                    <span ng-show="form.city.$touched && form.city.$error.maxlength" class="help-block">Max &nbsp <spring:message code="validate.length"/>&nbsp: 30</span>
                </div>

                <div class="form-group">
                    <label for="description"><spring:message code="uniText.description"/></label>
                    <textarea style="max-width: 100%" rows="10" cols="30" name="description" id="description" class="form-control" ng-model="offer.description" ng-maxlength="500"></textarea>
                    <span ng-show="form.description.$touched && form.description.$error.maxlength" class="help-block">Max &nbsp <spring:message code="validate.length"/>&nbsp: 500</span>
                </div>

            </div>
            <div class="col-md-5 col-md-offset-2"><%-- prawo--%>

                <div class="row">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="text-center">
                            <h1><spring:message code="editOffer.text.title"/></h1>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-5 col-md-offset-1">
                        <div class="form-group">
                            <button type="submit" ng-disabled="form.$invalid" class="btn btn-lg btn-default btn-block borromColour">
                                <i class="glyphicon glyphicon-ok"></i>&nbsp<spring:message code="editOffer.button.accept"/>
                            </button>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="form-group">
                            <button class="btn btn-lg btn-default btn-block borromColour" ng-click="goLink('myAds')">
                                <i class="glyphicon glyphicon-remove"></i>&nbsp<spring:message code="editOffer.button.cancel"/>
                            </button>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-10 col-md-offset-1">
                        <br>
                        <br>
                        <br>
                        <br>
                        <div class="form-group">
                            <label for="image"><spring:message code="uniText.image"/></label>
                            <input id="image" type="file" file-model="myFile" class="form-control" />
                        </div>
                        <div class="form-group text-center">
                            <br>
                            <br>
                            <p ng-show="showPhoto">
                                <strong><spring:message code="editOffer.text.actualPhoto"/></strong>
                                <img  height="400" width="400" class="img-rounded img-responsive" ng-src="rest/pub/images/getImage/{{offerId}}" alt="Offer foto" />
                                <button type="button" class="btn btn-default borromColour" ng-click="removePhotoRequest()">
                                    <i class="glyphicon glyphicon-remove"></i>&nbsp<spring:message code="editOffer.text.removePhoto"/>
                                </button>
                            </p>
                            <p ng-show="!showPhoto">
                                <strong><spring:message code="editOffer.text.noPhoto"/></strong>
                            </p>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        </br>

    </form>

    <div class="text-center linkBorrom" ng-show="regOk" ng-click='goOffer(offerId)'>
        <h4>
            <spring:message code="editOffer.text.ok"/>
        </h4>
    </div>

    <div class="text-center" ng-show="regError" >
        <spring:message code="editOffer.text.error"/>
    </div>

</div>