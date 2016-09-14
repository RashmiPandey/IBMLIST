package com.ListProject.domain.core;

import javax.persistence.Transient;

/**
 *
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
 * build:   </p>
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC 2014 - 2015</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity

@Table(name = "master_list")

@JsonIgnoreProperties(ignoreUnknown = true)

@ApiModel(value = "Master_List", description = "Master_List")
@JsonInclude(Include.NON_NULL)
public class Master_List {

	@ApiModelProperty(value = "The standard id attribute - System generated", required = true)
	@Id
	@GeneratedValue
	long Id;

	@ApiModelProperty(value = "created date", required = true)
	@Column
	String Created_date;

	@ApiModelProperty(value = "created by value", required = true)
	@Column
	long Created_by;

	@ApiModelProperty(value = "updated date", required = true)
	@Column
	String Updated_date;

	@ApiModelProperty(value = "updated by value", required = true)
	@Column
	long Updated_by;

	@ApiModelProperty(value = "description", required = true)
	@Column
	String Title;

	@ApiModelProperty(value = "description", required = true)
	@Column
	String Description;

	@ApiModelProperty(value = "description", required = true)
	@Column
	long listId;

	@ApiModelProperty(value = "Parent noun", required = false)
	@Column
	String listType;

	public void setId(long Id) {
		this.Id = Id;
	}

	public long getId() {
		return Id;
	}

	public void setCreated_date(String Created_date) {
		this.Created_date = Created_date;
	}

	public String getCreated_date() {
		return Created_date;
	}

	public void setCreated_by(long Created_by) {
		this.Created_by = Created_by;
	}

	public long getCreated_by() {
		return Created_by;
	}

	public void setUpdated_date(String Updated_date) {
		this.Updated_date = Updated_date;
	}

	public String getUpdated_date() {
		return Updated_date;
	}

	public void setUpdated_by(long Updated_by) {
		this.Updated_by = Updated_by;
	}

	public long getUpdated_by() {
		return Updated_by;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getTitle() {
		return Title;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getDescription() {
		return Description;
	}

	public void setListid(long listId) {
		this.listId = listId;
	}

	public long getListid() {
		return listId;
	}

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

}