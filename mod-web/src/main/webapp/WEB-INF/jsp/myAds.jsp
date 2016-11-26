<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resource/js/homeRedirect.js/"></script>

<div class="well well-sm">
        <div class="list-group">
            <a class="list-group-item" ng-click="goLink(1)" data-ng-repeat="i in [1,2,3,4,5]">
                <div class="row">
                    <div class="col-md-1">
                        <img src="<c:url value="/resource/image/150.png"></c:url>" style="max-height:120px" class="img-rounded">
                    </div>
                    <div class="col-md-11">
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">
                                Nunc sodales pretium pulvinar. Pellentesque leo odio, vulputate ut enim eu, ullamcorper ornare lectus.
                            </div>
                        </div>
                        <div class="row">
                            </br></br></br>
                        </div>

                        <div class="row">
                            <div class="col-md-2 col-md-offset-1">
                                kategoria
                            </div>
                            <div class="col-md-2">
                                24.05.2016
                            </div>
                            <div class="col-md-1">
                                253458695425
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
</div>