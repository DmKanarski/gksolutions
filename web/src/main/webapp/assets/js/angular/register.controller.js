angular
    .module('indexModule')
    .controller('registerController', function ($scope, Register) {
        const vm = this;
        vm.registerate = function () {
            Register.query(vm.user,
                function () {
          });
        };
    });
