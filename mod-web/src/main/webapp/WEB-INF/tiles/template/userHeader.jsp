<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="well well-sm">
    <div class ="userInfo">
        Zalogowany jako: ${username}
        <a href="/logout">Wyloguj się</a>
    </div>
    <ul class="nav nav-justified">
        <li role="presentation"><a href="/myAds" class="btn btn-default btn-block" role="button">Moje ogłoszenia</a></li>
        <li role="presentation"><a href="/observed" class="btn btn-default btn-block" role="button">Obserwowane</a></li>
        <li role="presentation"><a href="/notifications" class="btn btn-default btn-block" role="button">Powiadomienia</a></li>
        <li role="presentation"><a href="/loaned" class="btn btn-default btn-block" role="button">Wypożyczane</a></li>
    </ul>
</div>