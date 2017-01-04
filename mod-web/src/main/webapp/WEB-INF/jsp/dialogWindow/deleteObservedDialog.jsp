<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="modal-dialog">
        <div class="modal-header">
            <button type="button" class="close" ng-click="cancel()">&times;</button>
            <h4 class="modal-title"><spring:message code="observed.popup.text.warning"/></h4>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default borromColour" ng-click="cancel()"><spring:message code="observed.popup.button.cancel"/></button>
            <button type="button" class="btn btn-default borromColour" ng-click="ok()"><spring:message code="observed.popup.button.delete"/></button>
        </div>
</div>