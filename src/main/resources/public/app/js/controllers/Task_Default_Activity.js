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

app.controller("Task_Default_Activity", [ '$scope', '$rootScope', '$location', '$window', '$q', '$http', 'ListService','$timeout',
				    function( $scope, $rootScope, $location, $window, $q, $http, ListService,$timeout) {

		$scope.Task = {
		id: '',
		title : '', 
		taskowner : '', 
		duedate : null, 
		completionpercentage : 0, 
		attachment : '', 
		groupid : '', 
		task_status : '', 
		task_priority : '',
		listId : ListService.listId
		};

		$scope.DueDate = '';
		$scope.popupDueDate = { 
				opened: false
		};
		 $scope.dateOptions = {
	        	    formatYear: 'dd',
	        	    startingDay: 1
	        	  };
		
		 $scope.openStartdate = function() {
	            $scope.popupDueDate.opened = true;
	        };
	        $scope.users = [];
	    $scope.init=function(){
	    	
	    	if($scope.Task.id == ''){
			  $http.get('http://localhost:8080/ListProject_10030/Task_Default_Activity/get_task_by_id/'+ListService.taskId)
			  .success(function(response) {
				  console.log("RES"+angular.toJson(response));
				  $scope.Task=response;
				  $scope.selectedassign=$scope.Task.Taskowner;
				  $scope.selectedPriority=$scope.Task.task_priority;
				  $scope.selectedStatus=$scope.Task.task_status;
				  ListService.taskId='';
				  /*$timeout(function () {
				  $http.get('http://localhost:8080/ListProject_10030/Task_Default_Activity/get_user_by_id/'+$scope.Task.taskowner)
				  .success(function(response) {
					  //$scope.users[1] = response;
					  $scope.selectedassign=response;
					  console.log("USER"+angular.toJson($scope.selectedassign));
				  }).error(function(err) {
				  	 //alert('You got' + err + 'error');
				  });
				  }, 500);*/
			  }).error(function(err) {
			  	 //alert('You got' + err + 'error');
			  });
	    	}
	    	
	    	
	    }
	    if(ListService.taskId!=null || ListService.taskId!=''){
	    	console.log("ListService.taskIdListService.taskIdListService.taskIdListService.taskId "+ListService.taskId)
	    $scope.init();
	    }
	    
		$scope.statuses='';
		$scope.priorities='';
		$scope.assigns='';
		$scope.gotoCreateTask = function(){
			$location.path("/TaskCreate-en");
		}
		$scope.goBack = function(){
			$location.path("/ListTasks-en");
		}
		
        $scope.getStatusList= function(){
			 var deferred = $q.defer();
			  $http.get('http://localhost:8080/ListProject_10030/Task_Default_Activity/get_status_list')
			  .success(function(response) {
				  $scope.statuses=response;
			  	 deferred.resolve(response);
			  }).error(function(err) {
			  	 alert('You got' + err + 'error');
			  	 deferred.reject(err);
			  });
		}
        
        $scope.getPriorityList= function(){
			 var deferred = $q.defer();
			  $http.get('http://localhost:8080/ListProject_10030/Task_Default_Activity/get_priority_list')
			  .success(function(response) {
				  $scope.priorities=response;
			  	 deferred.resolve(response);
			  }).error(function(err) {
			  	 alert('You got' + err + 'error');
			  	 deferred.reject(err);
			  });
		}
        
        $scope.getAssigns= function(){
			 var deferred = $q.defer();
			  $http.get('http://localhost:8080/ListProject_10030/Task_Default_Activity/get_all_users')
			  .success(function(response) {
				$scope.assigns=response;
				for(var i=0;i<response.length;i++){
				if($scope.Task.taskowner!='' && $scope.Task.taskowner==response[i].id){
					$scope.selectedassign=response[i];
				}
				}
			  	 deferred.resolve(response);
			  }).error(function(err) {
			  	 alert('You got' + err + 'error');
			  	 deferred.reject(err);
			  });
		}
        
       
        $scope.getStatusList();
        $scope.getPriorityList();
        $scope.getAssigns();
        
        $scope.changedstatus=function(item){
			$scope.Task.task_status=item;
		 } 
        
        $scope.changedpriority=function(item){
        	$scope.Task.task_priority=item;
        }
        
        $scope.changedassign=function(item){
        	alert(angular.toJson(item.id));
        	$scope.Task.taskowner=item.id;
        }

		$scope.gridOptions = {
		enableRowSelection: true,
		enableSelectAll: false
		};
		/*function handle_search_result(search_result){
		$scope.gridOptions.data = search_result;
		}*/

		$scope.editRow = function(grid,row){
			ListService.taskId = row.entity.id;
			$location.path('/TaskUpdate-en');
		}
		
		
		$scope.deleteRow = function(grid,row){
			   
			   if(!confirm('Are you sure you want to delete ?')){ 
			    return;
			   }

			   $http.delete('http://localhost:8080/ListProject_10030/Task_Default_Activity/delete_Task/'+row.entity.id)
			        .success(function (data) {
			        	$scope.refreshData();
			        })
			        .error(function (data) {
			          console.log("ERROR: " + data);
			      });
			  
		}
		
		
		$scope.actionButtons='<div style="text-align:center;"><button class="btn btn-success btn-sm" ng-click="grid.appScope.editRow(grid,row)" style="margin:2px;">' +
		'<i class="fa"></i>'+
		'edit</button>'+
		'<button class="btn btn-danger btn-sm" '+
			'ng-click="grid.appScope.deleteRow(grid,row)" style="margin:2px;">'+
			'<i class="fa fa-trash"></i>'+
		'</button></div>';
		
		$scope.gridOptions.columnDefs = [
		{ displayName: 'S.No',name:"id"},
		{ displayName: 'Title',name:"title"},
		{ displayName: 'Description',name:"description"},
		{ displayName: 'Assigned To',name:"taskowner"},
		{ displayName: 'Priority',name:"task_priority"},
		{ displayName: '% Completed',name:"completionpercentage"},
		{ displayName: 'Status',name:"task_status"},
		{ name: 'Action',cellTemplate: $scope.actionButtons}
		];
		
		$scope.refreshData= function(){
			var deferred = $q.defer();
		 $http.get('http://localhost:8080/ListProject_10030/Task_Default_Activity/get_all_Task')
		  .success(function(response) {
			  console.log("TASKS  "+angular.toJson(response))
			  $scope.gridOptions.data=response;
		  	 deferred.resolve(response);
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  	 deferred.reject(err);
		  });
		}
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
		
		
		$scope.create= function(){
		//	alert("data to send" + angular.toJson($scope.Task));
			console.log(JSON.stringify($scope.Task));
			var deferred = $q.defer();
			  $http.post('http://localhost:8080/ListProject_10030/Task_Default_Activity/create_Task/', $scope.Task).success(function(response) {
				  alert('Task Saved successfully');
				  $scope.Task={};
				  $scope.selectedStatus='';
				  $scope.selectedassign='';
				  $scope.selectedPriority='';
				  $scope.Task.duedate='';
				  $location.path('/ListTasks-en');
			  	 deferred.resolve(response);
			  }).error(function(err) {
			  	 alert('You got' + err + 'error');
			  	 deferred.reject(err);
			  });
		}
		
		$scope.update= function(){
			//	alert("data to send" + angular.toJson($scope.Task));
			//	console.log(JSON.stringify($scope.Task));
				var deferred = $q.defer();
				  $http.put('http://localhost:8080/ListProject_10030/Task_Default_Activity/update_Task/', $scope.Task).success(function(response) {
					  alert('Task Saved successfully');
					  $scope.Task={};
					  $scope.selectedStatus='';
					  $scope.selectedassign='';
					  $scope.selectedPriority='';
					  $scope.Task.duedate='';
					  $location.path('/ListTasks-en');
				  	 deferred.resolve(response);
				  }).error(function(err) {
				  	 alert('You got' + err + 'error');
				  	 deferred.reject(err);
				  });
			}

}]);


