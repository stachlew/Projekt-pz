<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<head>
    <title><tiles:insertAttribute name="title" /></title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="resource/css/style.css" type="text/css" />
    <link rel="stylesheet" href="resource/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <script	src="//code.angularjs.org/1.4.1/angular.min.js"></script>
    <script	src="//code.angularjs.org/1.4.1/angular-route.js"></script>
    <script src="//code.angularjs.org/1.4.1/angular-cookies.js"></script>
    <script src="/resource/js/app.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container" ng-app="myApp" ng-controller="siteController">
    <div id="i18Bar" class="row ">
        <div class="pull-right" style="padding-right: 10px">
            <a href="?language=pl">
                <img src="<c:url value="/resource/image/icon/flag_pl.png"></c:url>" class="img-rounded">
            </a>
            |
            <a href="?language=en">
                <img src="<c:url value="/resource/image/icon/flag_en.png"></c:url>" class="img-rounded">
            </a>
        </div>
    </div>

    <div id="header" class="row ">
        <sec:authorize access="hasRole('ROLE_USER')"><tiles:insertAttribute name="headingUser" /></sec:authorize>
        <sec:authorize access="hasRole('ROLE_ANONYMOUS')"><tiles:insertAttribute name="headingGuest" /></sec:authorize>
    </div>

    <div id="menuUser " class="row">
        <sec:authorize access="hasRole('ROLE_USER')"><tiles:insertAttribute name="menuUser" /></sec:authorize>
    </div>

    <div id="content" class="row">
        <div ng-view></div>
        <tiles:insertAttribute name="content" />
    </div>

    <div id="footer" class=row">
        <tiles:insertAttribute name="footer" />
    </div>

</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</body>
</html>