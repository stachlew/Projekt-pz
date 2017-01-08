<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<script src="/resources/js/homeRedirect.js/"></script>

<div class="well well-sm">
    <div class="text-center linkBorrom" ng-click='goLink("/register")'>
        <h4>
            <spring:message code="login.text.newRegister"/>
        </h4>
    </div>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <spring:message code="login.text.title"/>
                </h3>
            </div>
            <div class="panel-body">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        <spring:message code="login.text.error"/>
                    </div>
                </c:if>
                <form action="<c:url value="/login"></c:url>" method="post">
                    <fieldset>
                        <div class="form-group">
                            <spring:message code="login.input.username" var="loginUsername"/>
                            <input class="form-control" placeholder="${loginUsername}" name='username' type="text">
                        </div>
                        <div class="form-group">
                            <spring:message code="login.input.password" var="loginPassword"/>
                            <input class="form-control" placeholder="${loginPassword}" name='password'  type="password" value="">
                        </div>
                        <spring:message code="login.button.login" var="loginButtonLogin"/>
                        <input class="btn btn-lg btn-default btn-block borromColour" type="submit" value="${loginButtonLogin}">
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>

