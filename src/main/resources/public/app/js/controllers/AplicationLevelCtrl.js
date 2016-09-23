app.controller("AplicationLevelCtrl", [ '$scope', '$rootScope', '$location', '$window', '$q', '$http','authFactory','RestURL',
                    				    function( $scope, $rootScope, $location, $window, $q, $http,authFactory,RestURL) {
	
	if (authFactory.global.loggedIn) {
    	$http.get(RestURL.baseURL + '/user/getuser/')
        .success(function (data) {
        	var user = data;
        	console.log(angular.toJson(user));
            authFactory.setUser(user);
            $scope.username = authFactory.getUser().firstName;
        	//alert($scope.username);
            $location.path('/landing_page-en');
          }).error(function () {
          //callback 
          $location.url("/en/login");
        });
    	
	}
	  else
	  	$location.path('/login');
                    }]);