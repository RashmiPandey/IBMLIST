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



import com.ListProject.domain.core.TaskStatus;
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
@Repository("TaskStatus_Default_ActivityDao")
public class TaskStatus_Default_ActivityDao   {

	private Log log = LogFactory.getLog(getClass());

	@Value("${create_TaskStatus.sql}")
	private String create_TaskStatus;
	@Value("${search_for_update_TaskStatus.sql}")
	private String search_for_update_TaskStatus;
	@Value("${update_TaskStatus.sql}")
	private String update_TaskStatus;
	@Value("${delete_TaskStatus.sql}")
	private String delete_TaskStatus;
	@Value("${get_all_TaskStatus.sql}")
	private String get_all_TaskStatus;
	@Value("${get_by_parent_id_TaskStatus.sql}")
	private String get_by_parent_id_TaskStatus;
	@Value("${delete_by_parent_id_TaskStatus.sql}")
	private String delete_by_parent_id_TaskStatus;


    @PersistenceContext
	EntityManager entityManager;



	//auths not ready at this time
	public TaskStatus taskstatus_search_for_update(long id, GpUser user) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(search_for_update_TaskStatus,TaskStatus.class)

			.setParameter("id", id);;

			ArrayList<TaskStatus> TaskStatus_list =	(ArrayList<TaskStatus>)result.getResultList();

			if(TaskStatus_list  == null){
				throw new Exception("no TaskStatus found");
			}

			return (TaskStatus) TaskStatus_list.get(0);

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}

	//auths not ready at this time
	public ArrayList<TaskStatus> get_all_taskstatus() throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(get_all_TaskStatus,TaskStatus.class)

;

			ArrayList<TaskStatus> TaskStatus_list =	(ArrayList<TaskStatus>)result.getResultList();

			if(TaskStatus_list .size() < 1){
				throw new Exception("no TaskStatus found");
			}

			return (ArrayList<TaskStatus>) TaskStatus_list;

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}

	//auths not ready at this time
	public TaskStatus get_taskstatus_by_parent_id(long Task_id) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(get_by_parent_id_TaskStatus,TaskStatus.class)

			.setParameter("Task_id", Task_id == 0 ? "%%" : Task_id);

			ArrayList<TaskStatus> TaskStatus_list =	(ArrayList<TaskStatus>)result.getResultList();

			if(TaskStatus_list  == null){
				throw new Exception("no TaskStatus found");
			}

			return (TaskStatus) TaskStatus_list.get(0);

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}



	//auths not ready at this time
	@Transactional
	public TaskStatus create_taskstatus(TaskStatus TaskStatus, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(create_TaskStatus)
			.setParameter("name", TaskStatus.getName())
			.setParameter("Task_id", TaskStatus.getTask_id())
			.setParameter("created_by", user == null ? 0:user.getId())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			int insertedId = query.executeUpdate();
					String lastIndex="select last_insert_id()";
					Query sql = entityManager.createNativeQuery(lastIndex);
					BigInteger new_id = (BigInteger) sql.getSingleResult();
					TaskStatus.setId(new_id.longValue());
					System.out.println("create data---"+insertedId);

			return TaskStatus;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public TaskStatus update_taskstatus(TaskStatus TaskStatus, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(update_TaskStatus)
			.setParameter("id", TaskStatus.getId())
			.setParameter("name", TaskStatus.getName())
			.setParameter("Task_id", TaskStatus.getTask_id())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			query.executeUpdate();

			return TaskStatus;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public String  delete_taskstatus(long id, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(delete_TaskStatus)
			.setParameter("id", id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public String  delete_taskstatus_by_parent_id(long Task_id) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(delete_by_parent_id_TaskStatus)
			.setParameter("Task_id", Task_id == 0 ? "%%" : Task_id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}



}