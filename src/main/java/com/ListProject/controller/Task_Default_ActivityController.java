package com.ListProject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ListProject.Enums.TaskPriority;
import com.ListProject.Enums.TaskStatus;
import com.ListProject.domain.core.GpUser;
import com.ListProject.domain.core.Task;
import com.ListProject.domain.core.TaskGroup;
import com.ListProject.service.Gp_Default_ActivityService;
import com.ListProject.service.Task_Default_ActivityService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * 
 * @author Geppetto Generated Code</br> Date Created: </br>
 * @since </br> build: </p>
 *
 *        code was generated by the Geppetto System </br> Gepppetto system
 *        Copyright - Geppetto LLC 2014 - 2015</br> The generated code is free
 *        to use by anyone</p>
 *
 *
 *
 */

@Api(value = "/Task_Default_Activity", description = "Task_Default_Activity of Task_Default_Activity", produces = "application/json")
@Controller("Task_Default_ActivityController")
@RequestMapping("/Task_Default_Activity")
public class Task_Default_ActivityController extends GpBaseController {

	Task_Default_ActivityService Task_Default_Activity_service;

	private Gp_Default_ActivityService gp_Default_ActivityService;

	public Task_Default_ActivityService get_Task_Default_Activity_service() {
		return Task_Default_Activity_service;
	}

	@Resource(name = "Task_Default_ActivityService")
	public void set_Task_Default_Activity_service(
			Task_Default_ActivityService Task_Default_Activity_service) {
		this.Task_Default_Activity_service = Task_Default_Activity_service;
	}

	public Gp_Default_ActivityService get_Gp_Default_ActivityService() {
		return gp_Default_ActivityService;
	}

	@Resource(name = "Gp_Default_ActivityService")
	public void set_Gp_Default_ActivityService(
			Gp_Default_ActivityService gp_Default_ActivityService) {
		this.gp_Default_ActivityService = gp_Default_ActivityService;
	}

	// auths not ready at this time

	@ApiOperation(value = "/create_Task", httpMethod = "POST", notes = "creates a noun of Task", response = Task.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.POST, value = "/create_Task", headers = "Accept=application/json")
	@ResponseBody
	public Task create_Task(@RequestBody Task the_Task) throws Exception {

		Task a_Task;

		a_Task = Task_Default_Activity_service.create_task(the_Task,
				super.getUser());

		return a_Task;

	}

	// auths not ready at this time

	@ApiOperation(value = "/update_Task", httpMethod = "PUT", notes = "updates a noun of Task", response = Task.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.PUT, value = "/update_Task", headers = "Accept=application/json")
	@ResponseBody
	public Task update_Task(@RequestBody Task the_Task) throws Exception {

		Task a_Task;

		a_Task = Task_Default_Activity_service.update_task(the_Task,
				super.getUser());

		return a_Task;

	}

	// auths not ready at this time

	@ApiOperation(value = "/search_for_update_Task/{Task_id}", httpMethod = "GET", notes = "updates a noun of Task", response = Task.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/search_for_update_Task/{Task_id}", headers = "Accept=application/json")
	@ResponseBody
	public Task search_for_update_Task(@PathVariable("Task_id") long Task_id)
			throws Exception {

		Task the_Task = new Task();

		the_Task = Task_Default_Activity_service.task_search_for_update(
				Task_id, super.getUser());

		return the_Task;

	}

	// auths not ready at this time

	@ApiOperation(value = "/delete_Task/{Task_id}", httpMethod = "DELETE", notes = "deletes a noun of Task", response = Task.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete_Task/{Task_id}", headers = "Accept=application/json")
	@ResponseBody
	public String delete_Task(@PathVariable("Task_id") long Task_id)
			throws Exception {

		String service_return_msg = "";

		service_return_msg = Task_Default_Activity_service.delete_task(Task_id,
				super.getUser());

		return service_return_msg;

	}

	// auths not ready at this time

	@ApiOperation(value = "/get_all_Task", httpMethod = "GET", notes = "special search that gets all values of Task", response = Task.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/get_all_Task", headers = "Accept=application/json")
	@ResponseBody
	public ArrayList<Task> get_all_Task() throws Exception {

		ArrayList<Task> Task_list = new ArrayList<Task>();

		Task_list = Task_Default_Activity_service.get_all_task();

		return Task_list;

	}

	@ApiOperation(value = "/get_status_list", httpMethod = "GET", notes = "gets the list of statuses", response = TaskStatus.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/get_status_list", headers = "Accept=application/json")
	@ResponseBody
	public List<TaskStatus> get_status_list() throws Exception {

		List<TaskStatus> status_list = Arrays.asList(TaskStatus.values());

		return status_list;

	}

	@ApiOperation(value = "/get_priority_list", httpMethod = "GET", notes = "gets the list of statuses", response = TaskStatus.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/get_priority_list", headers = "Accept=application/json")
	@ResponseBody
	public List<TaskPriority> get_priority_list() throws Exception {

		List<TaskPriority> priority = Arrays.asList(TaskPriority.values());

		return priority;

	}
	
	@ApiOperation(value = "/get_all_users", httpMethod = "GET", notes = "special search that gets all values of Task", response = GpUser.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/get_all_users", headers = "Accept=application/json")
	@ResponseBody
	public ArrayList<GpUser> get_all_users() throws Exception {

		ArrayList<GpUser> Task_list = new ArrayList<GpUser>();

		Task_list = Task_Default_Activity_service.get_all_users();

		return Task_list;

	}

}