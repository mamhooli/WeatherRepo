    
var app = angular.module('myApp', ['ngResource', 'ngRoute',  'ngMaterial','angularMoment']);


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

app.factory('LocationFactory', function($resource) {
  return $resource("/api/location/");
});

app.service('LocationService', function(LocationFactory) {

    var getLocations = function(cb) {
        LocationFactory.query(function(searchResponse) {
          console.log(searchResponse);
          cb(searchResponse);
        });
    };

    return {
        getLocations: getLocations
    };

});

app.service('WeatherService', function(WeatherFactory) {

  var visitors;

  var registerVisitor = function(visitor) {
    visitors = visitor;
  }

  var notifyAll = function() {
    visitors.visit(searchResult);
  }

  var searchResult;

  var getWeatherDetailByLocation = function(location) {
    WeatherFactory.get({
      'location': location
    }, function(searchResponse) {
      console.log(searchResponse);
      searchResult = searchResponse;
      notifyAll();
    });
  }

  return {
    registerVisitor: registerVisitor,
    getWeatherDetailByLocation: getWeatherDetailByLocation,
  };
});


app.controller("MenuCntrl", function ($scope, $route) {
    console.log("I am MenuCntrl");
    $scope.$route = $route;
});


app.controller("SearchCtrl", function (WeatherService, LocationService, $scope) {
    console.log("I am SearchCtrl");
    $scope.data = {};
    LocationService.getLocations(function(data) {
        $scope.data.availableOptions = data;
        $scope.data.selectedLocation = data[0];
        WeatherService.getWeatherDetailByLocation($scope.data.selectedLocation.locationName);
    })
   
    $scope.searchWeather = function() {
        WeatherService.getWeatherDetailByLocation($scope.data.selectedLocation.locationName);
    };
});

app.controller("SearchResultCtrl", function (WeatherService, $scope,$sce) {
    console.log("I am SearchCtrl");
    WeatherService.registerVisitor(this);
    $scope.data = {};
    this.visit = function(data) {
        console.log("data " + JSON.stringify(data));
        data.updatedTime = new Date(data.updatedTime);
        data.temperature = $sce.trustAsHtml(data.temperature + '&deg;C');
        data.windSpeed = $sce.trustAsHtml(data.windSpeed + 'km/h');
        $scope.data = data;
    }
});


