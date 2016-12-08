<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="well well-sm">
    <div class ="userInfo">
        <spring:message code="userHeader.loggedAs"/>
        {{userName}}
        <i class="glyphicon glyphicon-user"></i>
    </div>
    <ul class="nav nav-justified">
        <li role="presentation">
            <a href="#/" class="btn btn-default borromColour" role="button">
                <i class="glyphicon glyphicon-search"></i>&nbsp
                <spring:message code="userHeader.search"/>
            </a>
        </li>

        <li role="presentation" >
            <a ng-href="#/myAds" class="btn btn-default borromColour" role="button">
                <i class="glyphicon glyphicon-folder-open"></i>&nbsp
                <spring:message code="userHeader.myAds"/>
            </a>
        </li>

        <li role="presentation" >
            <a href="#/observed" class="btn btn-default borromColour" role="button">
                <i class="glyphicon glyphicon-eye-open"></i>&nbsp
                <spring:message code="userHeader.observed"/>
            </a>
        </li>

        <li role="presentation" >
            <a href="#/notifications" class="btn btn-default borromColour" role="button">
                <i class="glyphicon glyphicon-envelope"></i>&nbsp
                <spring:message code="userHeader.notifications"/>
            </a>
        </li>

        <li role="presentation" >
            <a href="#/loaned" class="btn btn-default borromColour" role="button">
                <i class="glyphicon glyphicon-list"></i>&nbsp
                <spring:message code="userHeader.loaned"/>
            </a>
        </li>
    </ul>
</div>