app.controller("AplicationLevelCtrl", [ '$scope', '$rootScope', '$location', '$window', '$q', '$http','authFactory',
                    				    function( $scope, $rootScope, $location, $window, $q, $http,authFactory) {
	if (authFactory.global.loggedIn) {
	  	$location.path('/landing_page-en');}
	  else
	  	$location.path('/login');
                    }]);