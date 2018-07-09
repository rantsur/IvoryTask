var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {
    var ctrl = this;
    ctrl.editBtnFlag = false;
    ctrl.enterAllData = function () {
        $http.get("http://localhost:8080/allData")
            .then(function (response) {
                $scope.data = response.data;
            });
    };
    ctrl.register = function () {
        var customer = $scope.customer;
        $http.post("http://localhost:8080/register", customer)
            .then(function (response) {
                window.alert('Customer Added Successfully');
                window.location = "index.html";
            });
    };
    ctrl.edit = function (customer) {
        ctrl.editCustomer = angular.copy(customer);
        ctrl.editBtnFlag = true;
    };

    ctrl.modalClosed = function () {
        ctrl.editBtnFlag = false;
    };

    ctrl.update = function () {
        $http.post("http://localhost:8080/edit", ctrl.editCustomer)
            .then(function (response) {
                window.alert('Customer Details Updated Successfully');
                $('#myModal').modal('hide');
                ctrl.editBtnFlag = false;
                location.reload();
            });
    };
});
