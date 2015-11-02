'use strict';

var app = angular.module('myApp.controllers', []);

var baseUrl = 'http://localhost\\:8080/checkout-webapp/';

app.controller('MainCtrl', ['$scope', 'CartDelete', 'CartAdd', 'CartList', 'CatalogueList',

    function ($scope, CartDelete, CartAdd, CartList, CatalogueList) {

        // fetch catalogue
        $scope.items = CatalogueList.get();

        // fetch cart
        $scope.cart = CartList.get();

        // call back for add item button
        $scope.add = function(sku) {
            CartAdd.create(sku);
            $scope.cart = CartList.get();
        }

        // call back for remove item button
        $scope.remove = function(itemId) {
            CartDelete.remove({id: itemId})
            $scope.cart = CartList.get();
        }
    }
]);