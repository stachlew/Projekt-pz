angular.module('app').controller('dialogImageController',dialogImageController);

function dialogImageController ($scope, $modalInstance, idOffer, title) {
    $scope.idAdvertisement = idOffer;
    $scope.title = title;

    $scope.ok = function () {
        $modalInstance.close(true);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};