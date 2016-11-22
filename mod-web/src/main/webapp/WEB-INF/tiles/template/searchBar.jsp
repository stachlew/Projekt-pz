<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="well well-sm">
    <div style="overflow: hidden">
        <form class="form-horizontal">
            <div class="form-group">
                <div class="col-sm-5">
                    <label class ="myLabel" for="what">
                        <spring:message code="searchBar.what"/>
                    </label>
                    <input class="form-control" id="what" type="text">
                </div>
                <div class="col-sm-5">
                    <label class ="myLabel" for="where">
                        <spring:message code="searchBar.where"/>
                    </label>
                    <input class="form-control" id="where" type="text">
                </div>
                <div class="col-sm-2">
                    <label class ="myLabel" for="search"> &nbsp </label>
                    <button type="submit" class="btn btn-default btn-block"  id="search">
                        <spring:message code="searchBar.search"/>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>