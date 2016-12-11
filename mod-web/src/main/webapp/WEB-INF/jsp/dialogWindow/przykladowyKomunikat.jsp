<div class="modal-dialog">
    <%--<div class="modal-content">--%>
        <div class="modal-header">
            <button type="button" class="close" ng-click="cancel()">&times;</button>
            <h4 class="modal-title">Modal title</h4>
        </div>
        <div class="modal-body">
            <ul>
                <li ng-repeat="item in items">
                    <a ng-click="selected.item=item">{{item}}</a>
                </li>
            </ul>
            <div>Selected Item: {{selected.item}}</div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" ng-click="cancel()">Close</button>
            <button type="button" class="btn btn-primary" ng-click="ok()">Save changes</button>
        </div>
    <%--</div><!-- /.modal-content -->--%>
</div><!-- /.modal-dialog -->