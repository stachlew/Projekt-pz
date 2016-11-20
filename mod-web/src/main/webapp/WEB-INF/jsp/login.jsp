<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Zaloguj się</h3>
            </div>
            <div class="panel-body">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        ${error}
                    </div>
                </c:if>
                <form action="<c:url value="/login"></c:url>" method="post">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="Nazwa użytkownika" name='username' type="text">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Hasło" name='password'  type="password" value="">
                        </div>
                        <input class="btn btn-lg btn-default btn-block" type="submit" value="Zaloguj">
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>

