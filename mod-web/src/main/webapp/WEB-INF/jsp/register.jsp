<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/homeRedirect.js/"></script>


<div class="well well-sm" ng-init="refresh()" style="padding: 25px">

    <form name="form" ng-submit="register(user)" role="form" novalidate>

        <div class="row"><%-- szeroki panel--%>
            <div class="col-md-5"><%-- lewo--%>
                <h1>Register new account</h1>
                <p>* - required</p>

                <div class="form-group">
                    <label for="username">Username*</label>
                    <input type="text" name="username" id="username" class="form-control" ng-model="user.username" ng-minlength="4" ng-maxlength="20" required />
                    <span ng-show="form.username.$touched && form.username.$error.required" class="help-block">Username name is required</span>
                    <span ng-show="form.username.$touched && form.username.$error.minlength || form.username.$error.maxlength" class="help-block">Username length 4-20</span>
                </div>

                <div class="form-group">
                    <label for="mail">E-mail*</label>
                    <input type="email" name="mail" id="mail" class="form-control" ng-model="user.mail" required />
                    <span ng-show="form.mail.$touched && form.mail.$error.required" class="help-block">E-mail is required</span>
                    <span ng-show="form.mail.$touched && form.mail.$invalid && !form.mail.$error.required" class="help-block">E-mail is invalid</span>
                </div>

                <div class="form-group">
                    <label for="password">Password*</label>
                    <input type="password" name="password" id="password" class="form-control" ng-model="user.password" ng-minlength="4" ng-maxlength="20" required />
                    <span ng-show="form.password.$touched && form.password.$error.required" class="help-block">Password is required</span>
                    <span ng-show="form.password.$touched && form.password.$error.minlength || form.password.$error.maxlength" class="help-block">Password length 4-20</span>
                </div>

                <div class="form-group">
                    <label for="password">Confirm password* </label>
                    <input type="password" name="passwordConf" id="passwordConf" class="form-control" ng-model="passwordConf" ng-minlength="4" ng-maxlength="20" required />
                    <span ng-show="form.passwordConf.$touched && form.passwordConf.$error.required" class="help-block">Password is required</span>
                    <span ng-show="form.passwordConf.$touched && form.passwordConf.$error.minlength || form.passwordConf.$error.maxlength" class="help-block">Password length 4-20</span>
                    <%--<span ng-show="form.passwordConf.$touched && form.passwordConf != form.password" class="help-block">Password are different!</span>--%>
                </div>

                <div class="form-group">
                    <label for="agree">I agree the Borroom terms and conditions.* </label>
                    <input type="checkbox" id="agree" ng-model="agree" name="agree" required />
                    <span ng-show="form.agree.$dirty && form.agree.$error.required" class="help-block">Agree is required</span>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-3"><%-- prawo--%>
                </br>
                </br>
                <h3>Contact info</h3>
                <h4>(You can do this after registration)</h4>

                <div class="form-group">
                    <label for="reg1">Województwo</label>
                    <select class="form-control" id="reg1" ng-model="user.region">
                        <option  ng-repeat="region in regions" value="{{region}}">{{region}}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="city">City</label>
                    <input type="text" name="city" id="city" class="form-control" ng-model="user.city"/>
                </div>

                <div class="form-group">
                    <label for="phone">Phone no</label>
                    <input type="text" name="phone" id="phone" class="form-control" ng-model="user.phone"/>
                </div>

            </div>
        </div>

        </br>

        </br>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <button type="submit" ng-disabled="form.$invalid" class="btn btn-lg btn-default btn-block borromColour">Register</button>
                </div>
            </div>
        </div>



    </form>

</div>