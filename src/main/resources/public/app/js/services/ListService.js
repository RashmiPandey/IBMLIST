app.service('ListService', function() {
  // private variable
  var listId = '';
  var taskId = '';
  var editTaskData= {};
  var editListData= {};
  var listPage='';
  
  this.listId = listId;
  this.taskId = taskId;
  this.editTaskData = editTaskData;
  this.editListData = editListData;
  this.listPage = listPage;
});