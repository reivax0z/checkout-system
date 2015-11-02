'use strict';

var baseUrl = 'http://localhost\\:8080/checkout-webapp/';

var services = angular.module('myApp.services', ['ngResource']);

services.factory('CartDelete', function ($resource) {
    return $resource(baseUrl + 'cart/delete/:id', {},
       {
           remove:
           {
               method:'DELETE', params: { id: '@id' }
           }
       });
});

services.factory('CartAdd', function ($resource) {
    return $resource(baseUrl + 'cart/add/', {},
       {
           create:
           {
               method:'POST', data: { sku: '@sku' }
           }
       });
});

services.factory('CartList', function ($resource) {
    return $resource(baseUrl + 'cart/', {},
       {
           get:
           {
               method:'GET'
           }
       });
});

services.factory('CatalogueList', function ($resource) {
    return $resource(baseUrl + 'catalogue/', {},
       {
           get:
           {
               method:'GET', isArray: true
           }
       });
});