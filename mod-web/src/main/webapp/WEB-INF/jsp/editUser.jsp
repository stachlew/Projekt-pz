<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm" ng-init="refreshForm()" style="padding: 25px">

    <form name="form" ng-show="formVis" ng-submit="acceptChanges()" role="form" novalidate>
        <div class="row"><%-- szeroki panel--%>
            <div class="col-md-5"><%-- lewo--%>
                <p><spring:message code="editUser.text.accountCreateDate"/>: {{accountCreateDate}}</p>
                <h1>
                    <spring:message code="editUser.text.title"/>
                    &nbsp<i ng-show="loadingRequest" class="glyphicon glyphicon-refresh fa-spin"></i>
                </h1>


                <div class="form-group">
                    <label for="mail"><spring:message code="editUser.text.newMail"/></label>
                    <input type="email" name="mail" id="mail" class="form-control" ng-model="mail"  />
                    <span ng-show="form.mail.$valid" class="help-block"><i class="glyphicon glyphicon-ok"></i>&nbsp</span>
                    <span ng-show="form.mail.$touched && form.mail.$invalid && !form.mail.$error.required" class="help-block"><spring:message code="register.label.email"/>&nbsp <spring:message code="validate.error"/></span>
                </div>

                <div class="form-group">
                    <label for="password"><spring:message code="editUser.text.password"/></label>
                    <input type="password" name="password" id="password" class="form-control" ng-model="password" ng-minlength="4" ng-maxlength="20" />
                    <span ng-show="form.password.$valid" class="help-block"><i class="glyphicon glyphicon-ok"></i>&nbsp</span>
                    <span ng-show="form.password.$touched && form.password.$error.minlength || form.password.$error.maxlength" class="help-block"><spring:message code="register.label.password"/>:&nbsp <spring:message code="validate.length"/> 4-20</span>
                </div>

            </div>
            <div class="col-md-4 col-md-offset-3"><%-- prawo--%>

                <div class="form-group">
                    <label for="reg1"><spring:message code="uniText.region"/></label>
                    <select class="form-control" id="reg1" ng-model="region">
                        <option  ng-repeat="region in regions" value="{{region}}">{{region}}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="city"><spring:message code="uniText.city"/></label>
                    <input type="text" name="city" id="city" class="form-control" ng-model="city"/>
                </div>

                <div class="form-group">
                    <label for="phone"><spring:message code="uniText.phoneNumber"/></label>
                    <input type="text" name="phone" id="phone" class="form-control" ng-pattern="regexNumber" ng-model="phone" ng-maxlength="20"/>
                    <span ng-show="form.phone.$error.maxlength" class="help-block">Max &nbsp <spring:message code="validate.length"/>&nbsp: 20</span>
                    <span ng-show="!form.phone.$error.maxlength && form.phone.$invalid" class="help-block"><spring:message code="validate.onlyDigits"/>!</span>
                </div>

            </div>
        </div>

        </br>

        </br>

        <div class="row">
            <div class="col-md-3 col-md-offset-3">
                <div class="form-group">
                    <button type="submit" ng-disabled="form.$invalid" class="btn btn-lg btn-default btn-block borromColour">
                        <i class="glyphicon glyphicon-ok"></i>
                        &nbsp<spring:message code="editUser.button.accept"/>
                    </button>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <button type="button" ng-click='goLink("/")' class="btn btn-lg btn-default btn-block borromColour"><i class="glyphicon glyphicon-remove"></i>&nbsp<spring:message code="editOffer.button.cancel"/></button>
                </div>
            </div>
        </div>
    </form>

    <div class="text-center" ng-show="editOk">
        <h4>
            <span class="linkBorrom"><spring:message code="editUser.text.accountEditOk"/></span>
        </h4>
        <h5>
            <span ng-click='goLink("/")' class="linkBorrom"><spring:message code="editUser.text.returnHome"/></span>
        </h5>
        <h5>
            <span ng-click='backToEdit()' class="linkBorrom"><spring:message code="editUser.text.returnEdit"/></span>
        </h5>
    </div>

    <div class="text-center" ng-show="editError" >
        <spring:message code="register.text.error"/>
    </div>

</div>
