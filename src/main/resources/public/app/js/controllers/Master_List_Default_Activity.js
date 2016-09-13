/**
 *
 * @author Schubert Generated Code</br>
 * Date Created: </br>
 * @since  </br>
   build:   </p>
 *
 * code was generated by the Schubert System </br>
 * Schubert system Copyright - NewPortBay LLC copy_right_range</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/

app.controller("Master_List_Default_Activity", [ '$scope', '$rootScope', '$location', '$window', '$q', '$http','ListService',
				    function( $scope, $rootScope, $location, $window, $q, $http , ListService) {

		$scope.Master_List = {
		id: '',
		title : '', 
		description : '', 
		type : '', 
		listtype : null,
		listname : ''
		};

		$scope.edit=false;
		$scope.gotoListCreate = function () {
			$location.path('/MasterList-en');
		};

		$scope.goBack = function(){
			$location.path("/DisplayLists-en");
		}

		$scope.gotoTasks=function(grid,row){
			ListService.listId=row.entity.id;
			$location.path('/ListTasks-en');
		}
		
		$scope.editRow = function(grid,row){
			
		}
		
		$scope.deleteRow = function(grid,row){

			   $http.delete('http://localhost:8080/ListProject_10030/Master_List_Default_Activity/delete_Master_List/'+row.entity.id)
			        .success(function (data) {
			        	$scope.refreshData();
			        })
			        .error(function (data) {
			          console.log("ERROR: " + data);
			      });
			
		}

		
		$scope.links ='<div>' +
        '<a href="" ng-click="grid.appScope.gotoTasks(grid,row)">{{row.entity.listtype}}</a>' +
        '</div>'
		
        $scope.actionButtons='<div style="text-align:center;"><button class="btn btn-success btn-sm" ng-click="grid.appScope.editRow(grid,row)" style="margin:2px;">' +
		'<i class="fa"></i>'+
		'edit</button>'+
		'<button class="btn btn-danger btn-sm" '+
			'ng-click="grid.appScope.deleteRow(grid,row)" style="margin:2px;">'+
			'<i class="fa fa-trash"></i>'+
		'</button></div>';
		
        $scope.create = function () {

		  //this is where the start code goes


		  //this is where the validate code goes


		  //this is where the post code goes
		  var deferred = $q.defer();
		  $http.post('http://localhost:8080/ListProject_10030/Master_List_Default_Activity/create_Master_List/', $scope.Master_List).success(function(response) {
			  $scope.Master_List='';
			  $scope.selectedListType='';
			  $scope.getTypeList();
			  $location.path('/DisplayLists-en');
		  	 deferred.resolve(response);
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  	 deferred.reject(err);
		  });

		  //this is where the server response code goes


		  //this is where the transition code goes

		  //this is where the end code goes 
        };

		$scope.gridOptions = {
		rowHeight:40,
		enableRowSelection: false,
		enableSelectAll: false
		};
		function handle_search_result(search_result){
		$scope.gridOptions.data = search_result;
		}

		$scope.gridOptions.columnDefs = [
		{ displayName: 'S.No.', name: 'id'},
		{ displayName: 'Title', name: 'title'},
		{ displayName: 'Description', name: 'description'},
		{ field: 'href',displayName: 'Type', name: 'listtype',cellTemplate: $scope.links},
		{ name: 'Action', cellTemplate: $scope.actionButtons}
		];
		
		$scope.refreshData= function(){
		var deferred = $q.defer();
		 $http.get('http://localhost:8080/ListProject_10030/Master_List_Default_Activity/get_all_list_data')
		  .success(function(response) {
			  console.log("DATA "+response);
			  $scope.gridOptions.data=response;
		  	 deferred.resolve(response);
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  	 deferred.reject(err);
		  });
		};
		$scope.refreshData();
		
		$scope.$on('$viewContentLoaded', function(event) {
			var biggestHeight = 0;
			var height = 0;
			$(".screen").find('*').each(function(){
				height = $(this).position().top + $(this).height() + 100;
				if (height > biggestHeight ) {
					biggestHeight = height;
				}
			});
			$(".screen").height(biggestHeight);
		});

		$scope.getTypeList= function(){
			 var deferred = $q.defer();
			  $http.get('http://localhost:8080/ListProject_10030/Master_List_Default_Activity/get_all_list_type')
			  .success(function(response) {
				  $scope.listTypes=response;
			  	 deferred.resolve(response);
			  }).error(function(err) {
			  	 alert('You got' + err + 'error');
			  	 deferred.reject(err);
			  });
		}
		
		 $scope.changedValue=function(item){
			$scope.Master_List.listtype=item;
		 }  
		 
		$scope.getTypeList();
}]);


