package com.ListProject.dao.mysql;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Query;
import javax.persistence.Transient;
import javax.sound.midi.SysexMessage;
import javax.sql.DataSource;
import javax.transaction.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.transaction.Transactional;
import javax.persistence.Query;


import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;



import com.ListProject.domain.core.Task;
import com.ListProject.domain.core.GpUser;


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
@Transactional
@Repository("Task_Default_ActivityDao")
public class Task_Default_ActivityDao   {

	private Log log = LogFactory.getLog(getClass());

	@Value("${create_Task.sql}")
	private String create_Task;
	@Value("${search_for_update_Task.sql}")
	private String search_for_update_Task;
	@Value("${update_Task.sql}")
	private String update_Task;
	@Value("${delete_Task.sql}")
	private String delete_Task;
	@Value("${get_all_Task.sql}")
	private String get_all_Task;


    @PersistenceContext
	EntityManager entityManager;



	//auths not ready at this time
	public Task task_search_for_update(long id, GpUser user) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(search_for_update_Task,Task.class)

			.setParameter("id", id);;

			ArrayList<Task> Task_list =	(ArrayList<Task>)result.getResultList();

			if(Task_list  == null){
				throw new Exception("no Task found");
			}

			return (Task) Task_list.get(0);

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}

	//auths not ready at this time
	public ArrayList<Task> get_all_task() throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(get_all_Task,Task.class)

;

			ArrayList<Task> Task_list =	(ArrayList<Task>)result.getResultList();

			if(Task_list .size() < 1){
				throw new Exception("no Task found");
			}

			return (ArrayList<Task>) Task_list;

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}



	//auths not ready at this time
	@Transactional
	public Task create_task(Task Task, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(create_Task)
			.setParameter("taskid", Task.getTaskid())
			.setParameter("title", Task.getTitle())
			.setParameter("description", Task.getDescription())
			.setParameter("taskowner", Task.getTaskowner())
			.setParameter("duedate", Task.getDuedate())
			.setParameter("completionpercentage", Task.getCompletionpercentage())
			.setParameter("attachment", Task.getAttachment())
			.setParameter("groupid", Task.getGroupid())
			.setParameter("created_by", user == null ? 0:user.getId())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			int insertedId = query.executeUpdate();
					String lastIndex="select last_insert_id()";
					Query sql = entityManager.createNativeQuery(lastIndex);
					BigInteger new_id = (BigInteger) sql.getSingleResult();
					Task.setId(new_id.longValue());
					System.out.println("create data---"+insertedId);
					Task.setAttachment(null);

			return Task;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public Task update_task(Task Task, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(update_Task)
			.setParameter("id", Task.getId())
			.setParameter("taskid", Task.getTaskid())
			.setParameter("title", Task.getTitle())
			.setParameter("description", Task.getDescription())
			.setParameter("taskowner", Task.getTaskowner())
			.setParameter("duedate", Task.getDuedate())
			.setParameter("completionpercentage", Task.getCompletionpercentage())
			.setParameter("groupid", Task.getGroupid())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			query.executeUpdate();

			return Task;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public String  delete_task(long id, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(delete_Task)
			.setParameter("id", id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}



}