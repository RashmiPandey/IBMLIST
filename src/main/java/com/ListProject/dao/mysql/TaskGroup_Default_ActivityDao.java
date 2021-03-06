package com.ListProject.dao.mysql;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ListProject.domain.core.GpUser;
import com.ListProject.domain.core.TaskGroup;


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
@Repository("TaskGroup_Default_ActivityDao")
public class TaskGroup_Default_ActivityDao   {

	private Log log = LogFactory.getLog(getClass());

	@Value("${create_TaskGroup.sql}")
	private String create_TaskGroup;
	@Value("${search_for_update_TaskGroup.sql}")
	private String search_for_update_TaskGroup;
	@Value("${update_TaskGroup.sql}")
	private String update_TaskGroup;
	@Value("${delete_TaskGroup.sql}")
	private String delete_TaskGroup;
	@Value("${get_all_TaskGroup.sql}")
	private String get_all_TaskGroup;


    @PersistenceContext
	EntityManager entityManager;



	//auths not ready at this time
	public TaskGroup taskgroup_search_for_update(long id, GpUser user) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(search_for_update_TaskGroup,TaskGroup.class)

			.setParameter("id", id);;

			ArrayList<TaskGroup> TaskGroup_list =	(ArrayList<TaskGroup>)result.getResultList();

			if(TaskGroup_list  == null){
				throw new Exception("no TaskGroup found");
			}

			return (TaskGroup) TaskGroup_list.get(0);

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}

	//auths not ready at this time
	public ArrayList<TaskGroup> get_all_taskgroup() throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(get_all_TaskGroup,TaskGroup.class)

;

			ArrayList<TaskGroup> TaskGroup_list =	(ArrayList<TaskGroup>)result.getResultList();

			if(TaskGroup_list .size() < 1){
				throw new Exception("no TaskGroup found");
			}

			return (ArrayList<TaskGroup>) TaskGroup_list;

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}



	//auths not ready at this time
	@Transactional
	public TaskGroup create_taskgroup(TaskGroup TaskGroup, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(create_TaskGroup)
			.setParameter("groupid", TaskGroup.getGroupid())
			.setParameter("groupname", TaskGroup.getGroupname())
			.setParameter("description", TaskGroup.getDescription())
			.setParameter("created_by", user == null ? 0:user.getId())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			int insertedId = query.executeUpdate();
					String lastIndex="select last_insert_id()";
					Query sql = entityManager.createNativeQuery(lastIndex);
					BigInteger new_id = (BigInteger) sql.getSingleResult();
					TaskGroup.setId(new_id.longValue());
					System.out.println("create data---"+insertedId);

			return TaskGroup;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public TaskGroup update_taskgroup(TaskGroup TaskGroup, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(update_TaskGroup)
			.setParameter("id", TaskGroup.getId())
			.setParameter("groupid", TaskGroup.getGroupid())
			.setParameter("groupname", TaskGroup.getGroupname())
			.setParameter("description", TaskGroup.getDescription())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			query.executeUpdate();

			return TaskGroup;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public String  delete_taskgroup(long id, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(delete_TaskGroup)
			.setParameter("id", id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}



}