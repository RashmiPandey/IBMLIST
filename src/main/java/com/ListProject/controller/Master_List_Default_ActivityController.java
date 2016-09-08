package com.ListProject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;


import com.ListProject.Enums.ListTypeEnum;
import com.ListProject.domain.core.Master_List;
import com.ListProject.service.Master_List_Default_ActivityService;



/**
 * 
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
   build:   </p> 
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC 2014 - 2015</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/

@Api(value = "/Master_List_Default_Activity", description = "Master_List_Default_Activity of Master_List_Default_Activity", 
produces = "application/json")

@Controller("Master_List_Default_ActivityController")
@RequestMapping("/Master_List_Default_Activity")
public class Master_List_Default_ActivityController extends GpBaseController {


	Master_List_Default_ActivityService Master_List_Default_Activity_service;


	public Master_List_Default_ActivityService get_Master_List_Default_Activity_service() {
		return Master_List_Default_Activity_service;
	}


	@Resource(name="Master_List_Default_ActivityService")
	public void set_Master_List_Default_Activity_service(Master_List_Default_ActivityService Master_List_Default_Activity_service) {
		this.Master_List_Default_Activity_service = Master_List_Default_Activity_service;
	}




	//auths not ready at this time


	@ApiOperation(value = "/create_Master_List", httpMethod = "POST",
	notes = "creates a noun of Master_List")
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST,value = "/create_Master_List" ,headers="Accept=application/json")
    @ResponseBody
	public Master_List create_Master_List(@RequestBody Master_List the_Master_List) throws Exception {

		Master_List a_Master_List;

		a_Master_List = Master_List_Default_Activity_service.create_master_list(the_Master_List, super.getUser());

		return a_Master_List;

	}

	//auths not ready at this time


	@ApiOperation(value = "/update_Master_List", httpMethod = "PUT",
	notes = "updates a noun of Master_List", 
	response = Master_List.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.PUT,value = "/update_Master_List" ,headers="Accept=application/json")
    @ResponseBody
	public Master_List update_Master_List(@RequestBody Master_List the_Master_List) throws Exception {

		Master_List a_Master_List;

		a_Master_List = Master_List_Default_Activity_service.update_master_list(the_Master_List, super.getUser());

		return a_Master_List;

	}

	//auths not ready at this time


	@ApiOperation(value = "/search_for_update_Master_List/{Master_List_id}", httpMethod = "GET",
	notes = "updates a noun of Master_List", 
	response = Master_List.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET,value = "/search_for_update_Master_List/{Master_List_id}" ,headers="Accept=application/json")
    @ResponseBody
	public Master_List search_for_update_Master_List(@PathVariable("Master_List_id")long Master_List_id) throws Exception {

		Master_List the_Master_List = new Master_List();

		the_Master_List = Master_List_Default_Activity_service.master_list_search_for_update(Master_List_id, super.getUser());

		return the_Master_List;

	}

	//auths not ready at this time


	@ApiOperation(value = "/delete_Master_List/{Master_List_id}", httpMethod = "DELETE",
	notes = "deletes a noun of Master_List", 
	response = Master_List.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.DELETE,value = "/delete_Master_List/{Master_List_id}" ,headers="Accept=application/json")
    @ResponseBody
	public String  delete_Master_List(@PathVariable("Master_List_id")long Master_List_id) throws Exception {

		String service_return_msg = "";

		service_return_msg = Master_List_Default_Activity_service.delete_master_list(Master_List_id, super.getUser());

		return service_return_msg;

	}

	//auths not ready at this time


	@ApiOperation(value = "/get_all_Master_List", httpMethod = "GET",
	notes = "special search that gets all values of Master_List", 
	response = Master_List.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET,value = "/get_all_Master_List" ,headers="Accept=application/json")
    @ResponseBody
	public ArrayList<Master_List> get_all_Master_List() throws Exception {

		ArrayList<Master_List> Master_List_list = new ArrayList<Master_List>();

		Master_List_list = Master_List_Default_Activity_service.get_all_master_list();

		return Master_List_list;

	}


	@ApiOperation(value = "/get_all_list_type", httpMethod = "GET",
			notes = "gets all the list types")
		    @ApiResponses(value = { 
		        @ApiResponse(code = 200, message = "The request was fulfilled"),
			    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

			@RequestMapping(method = RequestMethod.GET,value = "/get_all_list_type" ,headers="Accept=application/json")
		    @ResponseBody
			public List<ListTypeEnum> get_all_list_type() throws Exception {

			List<ListTypeEnum> Master_List_list = Arrays.asList(ListTypeEnum.values());
			
				return Master_List_list;

			}


}