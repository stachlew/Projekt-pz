<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm" ng-init="refresh()" style="padding: 25px">

    <form name="form" ng-show="formVis" ng-submit="register(user)" role="form" novalidate>
        <div class="row"><%-- szeroki panel--%>
            <div class="col-md-5"><%-- lewo--%>
                <h1><spring:message code="register.text.title"/></h1>

                <div class="form-group">
                    <label for="username"><spring:message code="register.label.username"/>*</label>
                    <input type="text" name="username" id="username" class="form-control" ng-pattern="regexUsername" ng-blur="checkUsername(user)" ng-model="user.username" ng-minlength="4" ng-maxlength="20" required />
                    <span ng-show="showUsernameExist && !flagUsernameExist" class="help-block"><i class="glyphicon glyphicon-ok"></i>&nbsp<spring:message code="register.text.usernameFree"/>!</span>
                    <span ng-show="form.username.$touched && form.username.$error.required" class="help-block"><spring:message code="validate.inputRequired"/></span>
                    <span ng-show="form.username.$touched && form.username.$error.minlength || form.username.$error.maxlength" class="help-block"><spring:message code="register.label.username"/>:&nbsp <spring:message code="validate.length"/> 4-20</span>
                    <span ng-show="form.username.$touched && form.username.$invalid && !form.username.$error.required && !form.username.$error.minlength && !form.username.$error.maxlength " class="help-block"><spring:message code="validate.alfaNumPattern"/>!</span>
                    <span ng-show="showUsernameExist && flagUsernameExist" class="help-block"><spring:message code="register.text.usernameExist"/>!</span>
                </div>

                <div class="form-group">
                    <label for="mail"><spring:message code="register.label.email"/>*</label>
                    <input type="email" name="mail" id="mail" class="form-control" ng-model="user.mail" required />
                    <span ng-show="form.mail.$valid" class="help-block"><i class="glyphicon glyphicon-ok"></i>&nbsp</span>
                    <span ng-show="form.mail.$touched && form.mail.$error.required" class="help-block"><spring:message code="validate.inputRequired"/></span>
                    <span ng-show="form.mail.$touched && form.mail.$invalid && !form.mail.$error.required" class="help-block"><spring:message code="register.label.email"/>&nbsp <spring:message code="validate.error"/></span>
                </div>

                <div class="form-group">
                    <label for="password"><spring:message code="register.label.password"/>*</label>
                    <input type="password" name="password" id="password" class="form-control" ng-model="user.password" ng-minlength="4" ng-maxlength="20" required />
                    <span ng-show="form.password.$valid" class="help-block"><i class="glyphicon glyphicon-ok"></i>&nbsp</span>
                    <span ng-show="form.password.$touched && form.password.$error.required" class="help-block"><spring:message code="validate.inputRequired"/></span>
                    <span ng-show="form.password.$touched && form.password.$error.minlength || form.password.$error.maxlength" class="help-block"><spring:message code="register.label.password"/>:&nbsp <spring:message code="validate.length"/> 4-20</span>
                </div>

                <div class="form-group">
                    <label for="agree"><spring:message code="register.label.terms"/>* </label>
                    <input type="checkbox" id="agree" ng-model="agree" name="agree" required />
                    <span ng-show="form.agree.$dirty && form.agree.$error.required" class="help-block"><spring:message code="validate.inputRequired"/></span>
                </div>
                <br/>
                <p><spring:message code="register.text.required"/></p>
            </div>
            <div class="col-md-4 col-md-offset-3"><%-- prawo--%>

                <h3><spring:message code="register.text.contactInfo"/> <br></h3>
                <%--<h4>(You can do this after registration)</h4>--%>

                <div class="form-group">
                    <label for="reg1"><spring:message code="uniText.region"/></label>
                    <select class="form-control" id="reg1" ng-model="user.region">
                        <option  ng-repeat="region in regions" value="{{region}}">{{region}}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="city"><spring:message code="uniText.city"/></label>
                    <input type="text" name="city" id="city" class="form-control" ng-model="user.city" ng-maxlength="30"/>
                    <span ng-show="form.city.$error.maxlength" class="help-block">Max &nbsp <spring:message code="validate.length"/>&nbsp: 30</span>
                </div>

                <div class="form-group">
                    <label for="phone"><spring:message code="uniText.phoneNumber"/></label>
                    <input type="text" name="phone" id="phone" class="form-control" ng-pattern="regexNumber" ng-model="user.phone" ng-maxlength="15"/>
                    <span ng-show="form.phone.$error.maxlength" class="help-block">Max &nbsp <spring:message code="validate.length"/>&nbsp: 15</span>
                    <span ng-show="!form.phone.$error.maxlength && form.phone.$invalid" class="help-block"><spring:message code="validate.onlyDigits"/>!</span>
                </div>

            </div>
        </div>

        </br>

        </br>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <button type="submit" ng-disabled="form.$invalid || flagUsernameExist" class="btn btn-lg btn-default btn-block borromColour"><spring:message code="register.button.register"/></button>
                </div>
            </div>
        </div>
    </form>

    <div class="text-center linkBorrom" ng-show="regOk" ng-click='goLink("/login")'>
        <h4>
            <spring:message code="register.text.ok"/>&nbsp {{user.username}}
        </h4>
    </div>

    <div class="text-center" ng-show="regError" >
        <spring:message code="register.text.error"/>
    </div>

</div>