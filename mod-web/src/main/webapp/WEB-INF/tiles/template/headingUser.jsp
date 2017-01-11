<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="#headingUser" class="well well-sm">
    <ul class="nav nav-justified">
        <li role="presentation">
            <h4>
                <a href="#/">
                    <img src="<c:url value="/resources/image/logoBorroomMiniTrans.png"></c:url>" class="img-rounded">
                </a>
            </h4>
        </li>

        <li role="presentation"> </li>

        <li role="presentation"> </li>

        <li role="presentation">
            <a href="#/addItem" class="btn btn-default btn-block borromColour" role="button">
                <i class="glyphicon glyphicon-plus"></i>&nbsp<spring:message code="tile.heading.button.addItem"/>
            </a>
        </li>

        <li role="presentation"> </li>

        <li role="presentation"> </li>

        <li role="presentation">

        </li>

        <li role="presentation">
            <a href="/logout" class="btn btn-default btn-block borromColour" role="button">
                <i class="glyphicon glyphicon-off"></i>&nbsp
                <spring:message code="tile.heading.button.logout"/>
            </a>
        </li>
    </ul>
</div>
