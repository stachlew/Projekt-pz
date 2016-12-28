<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8" />
    <title><tiles:insertAttribute name="title" /></title>
    <link href="favicon.ico" rel="shortcut icon" >
    <base href="/">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <script	src="//code.angularjs.org/1.4.1/angular.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.12.1/ui-bootstrap-tpls.min.js"></script>

    <script	src="//code.angularjs.org/1.4.1/angular-route.js"></script>
    <script src="//code.angularjs.org/1.4.1/angular-cookies.js"></script>


    <link rel="stylesheet" href="resources/css/style.css" type="text/css" />
    <link rel="stylesheet" href="resources/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.1/angular-animate.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.1/angular-sanitize.js"></script>

    <script src="/resources/js/app.js"></script>
    <script src="/resources/js/controller/siteController.js"></script>
    <script src="/resources/js/controller/addItemController.js"></script>
    <script src="/resources/js/controller/homeController.js"></script>
    <script src="/resources/js/controller/loanedController.js"></script>
    <script src="/resources/js/controller/loginController.js"></script>
    <script src="/resources/js/controller/myAdsController.js"></script>
    <script src="/resources/js/controller/notificationsController.js"></script>
    <script src="/resources/js/controller/observedController.js"></script>
    <script src="/resources/js/controller/registerController.js"></script>
    <script src="/resources/js/controller/offerController.js"></script>
    <script src="/resources/js/controller/loanDetailsController.js"></script>

    <script src="/resources/js/controller/dialogController/dialogObservedController.js"></script>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>



    <![endif]-->
</head>

<body>

<div class="container" ng-app="app" ng-controller="siteController">
    <%--<meta name="csrf-token" content="{{ csrf_token() }}">--%>
    <div id="i18Bar" class="row ">
        <div class="pull-right" style="padding-right: 10px">
            <a href="?language=pl">
                <img src="<c:url value="/resources/image/icon/flag_pl.png"></c:url>" class="img-rounded">
            </a>
            |
            <a href="?language=en">
                <img src="<c:url value="/resources/image/icon/flag_en.png"></c:url>" class="img-rounded">
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



<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>--%>
</body>
</html>