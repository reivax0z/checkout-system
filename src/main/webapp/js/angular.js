function Items($scope, $http) {
    $http.get('http://localhost:8080/checkout-webapp/products/').
        success(function(data) {
            $scope.items = data;
        });

        $scope.add = function(sku) {
            $http.post('http://localhost:8080/checkout-webapp/cart/add/', sku).
                success(function() {
                    cartDetails($scope, $http);
                });
        }

        $scope.getCart = function() {
            cartDetails($scope, $http);
        }
}
/*
function AddToCart($scope, $http) {
    $scope.add = function(sku) {
        $http.post('http://localhost:8080/checkout-webapp/cart/add/', sku).
            success(function() {
                cartDetails($scope, $http);
            });
    }
}*/

function cartDetails($scope, $http) {
    $http.get('http://localhost:8080/checkout-webapp/cart/').
        success(function(data) {
            $scope.cart = data;
        });
}