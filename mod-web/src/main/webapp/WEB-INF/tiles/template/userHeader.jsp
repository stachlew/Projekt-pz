<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="well well-sm">
    <div class ="userInfo">
        Zalogowany jako: USER1
    </div>
    <ul class="nav nav-justified">
        <li role="presentation"><button type="button" class="btn btn-default btn-block">Moje ogłoszenia</button></li>
        <li role="presentation"><button type="button" class="btn btn-default btn-block">Obserwowane</button></li>
        <li role="presentation"><button type="button" class="btn btn-default btn-block">Powiadomienia</button></li>
        <li role="presentation"><button type="button" class="btn btn-default btn-block">Wypożyczane</button></li>
    </ul>
</div>