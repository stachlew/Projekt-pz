/*Kontroler do okna dialogowego usuwania ogłoszenia z listy obserwowanych*/
angular.module('app').controller('dialogObservedController',dialogObservedController);

function dialogObservedController ($scope, $modalInstance, items) {
    $scope.ok = function () {
        $modalInstance.close(true);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};