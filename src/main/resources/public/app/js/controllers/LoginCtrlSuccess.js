/**
 * @author Adonay
 * @date Mar'15 2016
 *
 */

app.controller('LoginCtrlSuccess', ['$log', '$scope', '$http', '$location','authFactory',
    function ($log, $scope, $http, $location ,authFactory) {

        var self = $scope;
        authFactory.global.loggedIn = true;
        $location.path('/');
    }]);
