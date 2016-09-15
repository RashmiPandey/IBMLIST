app.service('ListService', function() {
  // private variable
  var listId = '';
  var taskId = '';
  var editTaskData= {};
  var editListData= {};
 
  
  this.listId = listId;
  this.taskId = taskId;
  this.editTaskData = editTaskData;
  this.editListData = editListData;
});