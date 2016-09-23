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

app.controller("Master_List_Default_Activity", [ '$scope', '$rootScope', '$location', '$window', '$q', '$http','ListService','authFactory','RestURL'
				    function( $scope, $rootScope, $location, $window, $q, $http , ListService,authFactory,RestURL) {

	//alert(authFactory.getUser().id);
		$scope.Master_List = {
		id: '',
		title : '', 
		description : '', 
		type : '', 
		listtype : null,
		listname : '',
		createdBy:authFactory.getUser().id
		};

		$scope.username = authFactory.getUser().firstName;
		$scope.gotoListCreate = function () {
			$location.path('/MasterList-en');
		};

		$scope.goBack = function(){
			$location.path("/DisplayLists-en");
		}

		$scope.gotoTasks=function(grid,row){
			if(row.entity.listType!='TASK'){
				alert("Not available");
				return false;
			}
			ListService.listId=row.entity.id;
			$location.path('/ListTasks-en');
		}
		
		$scope.editRow = function(grid,row){
			ListService.listId = row.entity.id;
			$location.path('/MasterListUpdate-en');
		}
		
		$scope.deleteRow = function(grid,row){
			   if(!confirm('Are you sure you want to delete ?')){ 
				    return;
				   }

			   $http.delete(RestURL.baseURL+'/Master_List_Default_Activity/delete_Master_List/'+row.entity.id)
			        .success(function (data) {
			        	$scope.refreshData();
			        })
			        .error(function (data) {
			          console.log("ERROR: " + data);
			      });
			
		}
		
		
		 $scope.init=function(){
		    	
		    	if($scope.Master_List.id == ''){
				  $http.get(RestURL.baseURL+'/Master_List_Default_Activity/search_for_update_Master_List/'+ListService.listId)
				  .success(function(response) {
					  $scope.Master_List=response;
					  $scope.selectedListType=response.listType;
					  ListService.listId='';
					
				  }).error(function(err) {
				  	 //alert('You got' + err + 'error');
				  });
		    	}
		    }

		 $scope.init();
		
		$scope.links ='<div>' +
        '<a href="" ng-click="grid.appScope.gotoTasks(grid,row)">{{row.entity.listType}}</a>' +
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
		  $http.post(RestURL.baseURL+'/Master_List_Default_Activity/create_Master_List/', $scope.Master_List).success(function(response) {
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
		{ displayName: 'Owner', name: 'created_by'},
		{ field: 'href',displayName: 'Type', name: 'listType',cellTemplate: $scope.links},
		{ name: 'Action', cellTemplate: $scope.actionButtons}
		];
		
		$scope.refreshData= function(){
		var deferred = $q.defer();
		 $http.get(RestURL.baseURL+'/Master_List_Default_Activity/get_all_list_data')
		  .success(function(response) {
			  //console.log("DATA "+response);
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

		$scope.update= function(){
			//	alert("data to send" + angular.toJson($scope.Task));
			//	console.log(JSON.stringify($scope.Task));
				var deferred = $q.defer();
				  $http.put(RestURL.baseURL+'/Master_List_Default_Activity/update_Master_List/', $scope.Master_List).success(function(response) {
					  alert('Task Saved successfully');
					 $scope.Master_List='';
					 $scope.selectedListType='';
					 $location.path('/DisplayLists-en');
				  	 deferred.resolve(response);
				  }).error(function(err) {
				  	 alert('You got' + err + 'error');
				  	 deferred.reject(err);
				  });
			}
		
		$scope.getTypeList= function(){
			 var deferred = $q.defer();
			  $http.get(RestURL.baseURL+'/Master_List_Default_Activity/get_all_list_type')
			  .success(function(response) {
				  $scope.listTypes=response;
			  	 deferred.resolve(response);
			  }).error(function(err) {
			  	 alert('You got' + err + 'error');
			  	 deferred.reject(err);
			  });
		}
		
		 $scope.changedValue=function(item){
			$scope.Master_List.listType=item;
		 }  
		 
		$scope.getTypeList();
}]);


