    
var app = angular.module('myApp', ['ngResource', 'ngRoute',  'ngMaterial']);


app.config(
        function ($routeProvider) {
            $routeProvider.
                    when('/search', {
                        controller: 'SearchCtrl',
                        templateUrl: 'assets/view/show-weather.html',
                        activetab: 'task_1'
                    })
                    .otherwise({
                        redirectTo: '/search'
                    });
        }
);

app.factory('WeatherFactory', function($resource) {
  return $resource("/api/weather/:location");
});

app.service('WeatherService', function(WeatherFactory) {

  var visitors;

  var registerVisitor = function(visitor) {
    visitors = visitor;
  }

  var notifyAll = function() {
    visitors.visit();
  }

  var searchResult;

  var getWeatherDetailByLocation = function(location) {
    WeatherFactory.get({
      'location': location
    }, function(searchResponse) {
      console.log(searchResponse);
      searchResult = searchResponse;
    });
  }

  return {
    getWeatherDetailByLocation: getWeatherDetailByLocation
  };
});


app.controller("MenuCntrl", function ($scope, $route) {
    console.log("I am MenuCntrl");
    $scope.$route = $route;
});


app.controller("SearchCtrl", function (WeatherService, $scope) {
    console.log("I am SearchCtrl");
    $scope.search = function() {
        WeatherService.getWeatherDetailByLocation($scope.searchLocation);
    };
});

app.controller("SearchResultCtrl", ['$scope', function ($scope) {
    console.log("I am SearchResultCtrl");
}]);

