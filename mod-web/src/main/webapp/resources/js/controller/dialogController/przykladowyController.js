angular.module('app').controller('dialogObservedController',dialogObservedController);

function dialogObservedController ($scope, $modalInstance, items) {
    $scope.items = ['item11', 'item22', 'item33'];
    $scope.items = items;
    $scope.selected = {
        item: $scope.items[0]
    };

    $scope.ok = function () {
        $modalInstance.close($scope.selected.item);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};