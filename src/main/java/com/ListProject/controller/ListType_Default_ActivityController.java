package com.ListProject.controller;

import java.util.ArrayList;

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


import com.ListProject.domain.core.ListType;

import com.ListProject.service.ListType_Default_ActivityService;



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

@Api(value = "/ListType_Default_Activity", description = "ListType_Default_Activity of ListType_Default_Activity", 
produces = "application/json")

@Controller("ListType_Default_ActivityController")
@RequestMapping("/ListType_Default_Activity")
public class ListType_Default_ActivityController extends GpBaseController {


	ListType_Default_ActivityService ListType_Default_Activity_service;


	public ListType_Default_ActivityService get_ListType_Default_Activity_service() {
		return ListType_Default_Activity_service;
	}


	@Resource(name="ListType_Default_ActivityService")
	public void set_ListType_Default_Activity_service(ListType_Default_ActivityService ListType_Default_Activity_service) {
		this.ListType_Default_Activity_service = ListType_Default_Activity_service;
	}




	//auths not ready at this time


	@ApiOperation(value = "/create_ListType", httpMethod = "POST",
	notes = "creates a noun of ListType", 
	response = ListType.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST,value = "/create_ListType" ,headers="Accept=application/json")
    @ResponseBody
	public ListType create_ListType(@RequestBody ListType the_ListType) throws Exception {

		ListType a_ListType;

		a_ListType = ListType_Default_Activity_service.create_listtype(the_ListType, super.getUser());

		return a_ListType;

	}

	//auths not ready at this time


	@ApiOperation(value = "/update_ListType", httpMethod = "PUT",
	notes = "updates a noun of ListType", 
	response = ListType.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.PUT,value = "/update_ListType" ,headers="Accept=application/json")
    @ResponseBody
	public ListType update_ListType(@RequestBody ListType the_ListType) throws Exception {

		ListType a_ListType;

		a_ListType = ListType_Default_Activity_service.update_listtype(the_ListType, super.getUser());

		return a_ListType;

	}

	//auths not ready at this time


	@ApiOperation(value = "/search_for_update_ListType/{ListType_id}", httpMethod = "GET",
	notes = "updates a noun of ListType", 
	response = ListType.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET,value = "/search_for_update_ListType/{ListType_id}" ,headers="Accept=application/json")
    @ResponseBody
	public ListType search_for_update_ListType(@PathVariable("ListType_id")long ListType_id) throws Exception {

		ListType the_ListType = new ListType();

		the_ListType = ListType_Default_Activity_service.listtype_search_for_update(ListType_id, super.getUser());

		return the_ListType;

	}

	//auths not ready at this time


	@ApiOperation(value = "/delete_ListType/{ListType_id}", httpMethod = "DELETE",
	notes = "deletes a noun of ListType", 
	response = ListType.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.DELETE,value = "/delete_ListType/{ListType_id}" ,headers="Accept=application/json")
    @ResponseBody
	public String  delete_ListType(@PathVariable("ListType_id")long ListType_id) throws Exception {

		String service_return_msg = "";

		service_return_msg = ListType_Default_Activity_service.delete_listtype(ListType_id, super.getUser());

		return service_return_msg;

	}

	//auths not ready at this time


	@ApiOperation(value = "/get_all_ListType", httpMethod = "GET",
	notes = "special search that gets all values of ListType", 
	response = ListType.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET,value = "/get_all_ListType" ,headers="Accept=application/json")
    @ResponseBody
	public ArrayList<ListType> get_all_ListType() throws Exception {

		ArrayList<ListType> ListType_list = new ArrayList<ListType>();

		ListType_list = ListType_Default_Activity_service.get_all_listtype();

		return ListType_list;

	}

	//auths not ready at this time


	@ApiOperation(value = "/get_ListType_by_parent_id", httpMethod = "GET",
	notes = "get by parent id of ListType", 
	response = ListType.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET,value = "/get_ListType_by_parent_id" )
    @ResponseBody
	public ListType get_ListType_by_parent_id(@RequestParam(required = false, value = "Master_List_id", defaultValue = "0") long Master_List_id) throws Exception {

		ListType a_ListType;

		a_ListType = ListType_Default_Activity_service.get_listtype_by_parent_id(Master_List_id);

		return a_ListType;

	}

	//auths not ready at this time


	@ApiOperation(value = "/delete_ListType_by_parent_id", httpMethod = "DELETE",
	notes = "delete by parent of ListType", 
	response = ListType.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.DELETE,value = "/delete_ListType_by_parent_id" )
    @ResponseBody
	public String  delete_ListType_by_parent_id(@RequestParam(required = false, value = "Master_List_id", defaultValue = "0") long Master_List_id) throws Exception {

		String service_return_msg = "";

		service_return_msg = ListType_Default_Activity_service.delete_listtype_by_parent_id(Master_List_id);

		return service_return_msg;

	}




}