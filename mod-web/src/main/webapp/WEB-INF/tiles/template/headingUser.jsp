<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="well well-sm">
    <ul class="nav nav-justified">
        <li role="presentation">
            <h4>
                <a href="#/">
                    <img src="<c:url value="/resources/image/logoBorroomMini.png"></c:url>" class="img-rounded">
                </a>
            </h4>
        </li>

        <li role="presentation"> </li>

        <li role="presentation"> </li>

        <li role="presentation">
            <a href="#/addItem" class="btn btn-default btn-block borromColour" role="button">
                <spring:message code="heading.button.addItem"/>
            </a>
        </li>

        <li role="presentation"> </li>

        <li role="presentation"> </li>

        <li role="presentation">

        </li>

        <li role="presentation">
            <a href="/logout" class="btn btn-default btn-block borromColour" role="button">
                <spring:message code="heading.button.logout"/>
            </a>
        </li>
    </ul>
</div>
