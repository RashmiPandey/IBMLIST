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
app.controller("Task_Default_Activity", ['$scope', '$rootScope', '$location', '$window', '$q', '$http', 'ListService', '$timeout', 'blockUI', 'authFactory', 'RestURL',
    function($scope, $rootScope, $location, $window, $q, $http, ListService, $timeout, blockUI, authFactory, RestURL) {
		
        $scope.Task = {
            id: '',
            title: '',
            taskowner: '',
            duedate: null,
            completionpercentage: 0,
            attachment: '',
            groupid: '',
            task_status: '',
            task_priority: '',
            listId: ListService.listId
        };
        $scope.listDatas={};
        $scope.username = authFactory.getUser().firstName;
        $scope.userId = authFactory.getUser().id;
        $scope.Task.dueDate = new Date();
        $scope.popupDueDate = {
            opened: false
        };
        
        $scope.dateOptions = {
            formatYear: 'YY',
            startingDay: 1
        };

        $scope.openDuedate = function() {
            $scope.popupDueDate.opened = true;
        };
        $scope.users = [];
        $scope.statuses = '';
        $scope.priorities = '';
        $scope.assigns = '';
        $scope.gridOptions = {
            enableRowSelection: true,
            enableSelectAll: false,
            rowHeight: 50
        };
        $scope.disableMasterList=false;
        $scope.init = function() {
        	$scope.getStatusList();
            $scope.getPriorityList();
            $scope.getAssigns();
            if ($location.path().indexOf('ListTasks-en') > -1) {
            	$scope.getListTasks();
            }else if ($location.path().indexOf('TaskCreate-en') > -1) {
            	if(ListService.listId!=null && ListService.listId!=''){
            		 $scope.disableMasterList=true;
            	}
            }else if ($location.path().indexOf('TaskUpdate-en') > -1) {
                $scope.getTaskDetail();
            }
            else {
                $scope.getUserTask();
                ListService.listId=null;
            }
        }

        $scope.getUserTask = function() {
            $http.get('http://localhost:8080/ListProject_10030/Task_Default_Activity/get_user_Task/' + $scope.userId)
                .success(function(response) {
                    $scope.gridOptions.data = response;
                }).error(function(err) {
                    //alert('You got' + err + 'error');
                });
        }


        /* if (ListService.taskId != null || ListService.taskId != '') {
             console.log("ListService.taskIdListService.taskIdListService.taskIdListService.taskId " + ListService.taskId)
             
         }*/

        $scope.getTaskDetail = function() {
            if ($scope.Task.id == '') {
                $http.get(RestURL.baseURL + '/Task_Default_Activity/get_task_by_id/' + ListService.taskId)
                    .success(function(response) {
                        console.log("RES" + angular.toJson(response));
                        $scope.Task = response;
                        //$scope.selectedPriority = $scope.Task.task_priority;
                        //$scope.selectedStatus = $scope.Task.task_status;
                        
                    }).error(function(err) {
                        //alert('You got' + err + 'error');
                    });
            }
        }

        $scope.gotoCreateTask = function() {
            $location.path("/TaskCreate-en");
        }
        $scope.goBack = function() {
            $location.path("/ListTasks-en");
        }

        $scope.getStatusList = function() {
            var deferred = $q.defer();
            $http.get(RestURL.baseURL + '/Task_Default_Activity/get_status_list')
                .success(function(response) {
                    $scope.statuses = response;
                    deferred.resolve(response);
                }).error(function(err) {
                    alert('You got' + err + 'error');
                    deferred.reject(err);
                });
        }

        $scope.getPriorityList = function() {
            var deferred = $q.defer();
            $http.get(RestURL.baseURL + '/Task_Default_Activity/get_priority_list')
                .success(function(response) {
                    $scope.priorities = response;
                    deferred.resolve(response);
                }).error(function(err) {
                    alert('You got' + err + 'error');
                    deferred.reject(err);
                });
        }

        $scope.getAssigns = function() {
            var deferred = $q.defer();
            $http.get(RestURL.baseURL + '/Task_Default_Activity/get_all_users')
                .success(function(response) {
                    $scope.assigns = response;
                   /* for (var i = 0; i < response.length; i++) {
                        if ($scope.Task.taskowner != '' && $scope.Task.taskowner == response[i].id) {
                            $scope.selectedassign = response[i];
                        }
                    }*/
                    deferred.resolve(response);
                }).error(function(err) {
                    alert('You got' + err + 'error');
                    deferred.reject(err);
                });
        }

        /*function handle_search_result(search_result){
        $scope.gridOptions.data = search_result;
        }*/

        $scope.editRow = function(grid, row) {
            ListService.taskId = row.entity.id;
            ListService.listPage=$location.absUrl();
            $location.path('/TaskUpdate-en');
        }


        $scope.deleteRow = function(grid, row) {

            if (!confirm('Are you sure you want to delete ?')) {
                return;
            }

            
            $http.delete(RestURL.baseURL + '/Task_Default_Activity/delete_Task/' + row.entity.id)
                .success(function(data) {
                	 if ($location.path().indexOf('ListTasks-en') > -1) {
                         $scope.getListTasks();
                     } else {
                         $scope.getUserTask();
                     }
                })
                .error(function(data) {
                    console.log("ERROR: " + data);
                });

        }

        $scope.imageattach = '<div>' +
            '<img src={{row.entity.attachment}}/>' +
            '</div>';

        $scope.authId = authFactory.getUser().id ;
        $scope.actionButtons = '<div style="text-align:center;" data-ng-show="grid.appScope.authId == row.entity.username.id"><button class="btn btn-success btn-sm" ng-click="grid.appScope.editRow(grid,row)" style="margin:2px;">' +
            '<i class="fa"></i>' +
            'edit</button>' +
            '<button class="btn btn-danger btn-sm" ' +
            'ng-click="grid.appScope.deleteRow(grid,row)" style="margin:2px;">' +
            '<i class="fa fa-trash"></i>' +
            '</button></div>';

        $scope.gridOptions.columnDefs = [{
            displayName: 'S.No',
            name: "id"
        }, {
            displayName: 'Title',
            name: "title"
        }, {
            displayName: 'Description',
            name: "description"
        }, {
            displayName: 'Owner',
            name: 'username.firstName'
        }, {
            displayName: 'Assigned To',
            name: "taskOwnerUser.firstName"
        }, {
            displayName: 'Priority',
            name: "task_priority"
        }, {
            displayName: '% Completed',
            name: "completionpercentage"
        }, {
            displayName: 'Status',
            name: "task_status"
        }, {
            name: "attachment",
            field: 'attachment',
            cellTemplate: "<img width=\"50px\" ng-src=\"{{grid.getCellValue(row, col)}}\" lazy-src>"
        }, {
            name: 'Action',
            cellTemplate: $scope.actionButtons
        }];

        $scope.getListTasks = function() {
            var deferred = $q.defer();
            $http.get(RestURL.baseURL + '/Task_Default_Activity/get_all_Task/' + ListService.listId)
                .success(function(response) {
                    console.log("TASKS  " + angular.toJson(response))
                    $scope.gridOptions.data = response;
                    deferred.resolve(response);
                }).error(function(err) {
                    alert('You got' + err + 'error');
                    deferred.reject(err);
                });
        }

        $scope.$on('$viewContentLoaded', function(event) {
            var biggestHeight = 0;
            var height = 0;
            $(".screen").find('*').each(function() {
                height = $(this).position().top + $(this).height() + 100;
                if (height > biggestHeight) {
                    biggestHeight = height;
                }
            });
            $(".screen").height(biggestHeight);
        });


        $scope.create = function() {
            //	alert("data to send" + angular.toJson($scope.Task));
            console.log(JSON.stringify($scope.Task));
            var deferred = $q.defer();
            $http.post(RestURL.baseURL + '/Task_Default_Activity/create_Task/', $scope.Task).success(function(response) {
                alert('Task Saved successfully');
                $scope.Task = {};
                $scope.Task.duedate = '';
                if(ListService.listPage.indexOf('ListTasks-en') > -1){
                	$location.path('/ListTasks-en');
                }else{
                $location.path('/MyTasks-en');
                }
                deferred.resolve(response);
            }).error(function(err) {
                alert('You got' + err + 'error');
                deferred.reject(err);
            });
        }

        $scope.update = function() {
            //	alert("data to send" + angular.toJson($scope.Task));
            //	console.log(JSON.stringify($scope.Task));
            var deferred = $q.defer();
            $http.put(RestURL.baseURL + '/Task_Default_Activity/update_Task/', $scope.Task).success(function(response) {
                alert('Task Saved successfully');
                $scope.Task = {};
                $scope.Task.duedate = '';
                console.log(ListService.listPage);
                if(ListService.listPage.indexOf('ListTasks-en') > -1){
                	$location.path('/ListTasks-en');
                }else{
                $location.path('/MyTasks-en');
                }
                deferred.resolve(response);
            }).error(function(err) {
                alert('You got' + err + 'error');
                deferred.reject(err);
            });
        }

        
        $scope.refreshData= function(){
    		var deferred = $q.defer();
    		 $http.get(RestURL.baseURL+'/Master_List_Default_Activity/get_all_list_data')
    		  .success(function(response) {
    			 // console.log("DATA "+JSON.stringify(response));
    			$scope.listDatas=response;
    		  	 deferred.resolve(response);
    		  }).error(function(err) {
    		  	 alert('You got' + err + 'error');
    		  	 deferred.reject(err);
    		  });
    		};
    		
    		$scope.refreshData();
    		
        $scope.uploadFile = function(input, images) {
            var form_data = new FormData();

            console.log('yaaaay', images);
            form_data.append('uploadfile', images[0]);

            blockUI.start();
            $http.post(RestURL.baseURL + '/Task_Default_Activity/uploadFile', form_data, {
                    transformRequest: angular.identity,
                    headers: {
                        'Content-Type': undefined
                    }
                })
                .success(function(res) {
                    $scope.Task.attachment = res.src;
                    blockUI.stop();
                })
                .error(function(err) {
                    console.error(err);
                })
        };
        $scope.init();
    }
]);