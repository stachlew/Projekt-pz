<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="modal-dialog">
        <div class="modal-header borromColourNotHover">
            <button type="button" class="close" ng-click="cancel()">&times;</button>
            <h4 class="modal-title">{{title}}</h4>
        </div>
        <div class="modal-footer">
            <img style="height: 100%;width: 100%" class="img-rounded img-responsive" ng-src="rest/pub/images/getImage/{{idAdvertisement}}" alt="Offer foto" />
        </div>
</div>