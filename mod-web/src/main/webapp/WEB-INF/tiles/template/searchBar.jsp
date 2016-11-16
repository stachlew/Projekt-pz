<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="well well-sm">
    <div style="overflow: hidden">
        <form class="form-horizontal">
            <div class="form-group">
                <div class="col-sm-5">
                    <label class ="myLabel" for="co">Co:</label>
                    <input class="form-control" id="co" type="text">
                </div>
                <div class="col-sm-5">
                    <label class ="myLabel" for="gdzie">Gdzie</label>
                    <input class="form-control" id="gdzie" type="text">
                </div>
                <div class="col-sm-2">
                    <label class ="myLabel" for="Szukaj"> &nbsp </label>
                    <button type="submit" class="btn btn-default btn-block"  id="Szukaj">Szukaj!</button>
                </div>
            </div>
        </form>
    </div>
</div>