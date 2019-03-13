angular.module("encurtador",['ngClipboard'])
.controller("encurtadorController", ['$scope','$http','$window','ngClipboard' ,function($scope, $http, $window, ngClipboard){
	
	$scope.origin = $window.location.origin;
	
	$scope.copyToClipBoard = function(urlEncurtada){
		ngClipboard.toClipboard(urlEncurtada);
	}
	
	
	$scope.encurtarUrl = function(urlEncurtada){
		$scope.origin = $window.location.origin;
		console.log($scope.origin);
		$http.post('http://localhost:8080/encurtarUrl/encurtar', urlEncurtada, {'Content-Type' : 'application/json'})
		.then(function(response) {
			$scope.urlEncurtada = response.data.dadosUrl.urlEncurtada;
		}, function(response) {
			console.log(response);
		});
	}
	
	
	
}])
.directive('ngEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if (event.which === 13) {
                scope.$apply(function () {
                    scope.$eval(attrs.ngEnter);
                });
                event.preventDefault();
            }
        });
    };
});
