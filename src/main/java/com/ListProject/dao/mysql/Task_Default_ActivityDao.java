package com.ListProject.dao.mysql;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ListProject.domain.core.GpUser;
import com.ListProject.domain.core.Task;

/**
 *
 * @author Geppetto Generated Code</br>
 *         Date Created: </br>
 * @since </br>
 *        build:
 *        </p>
 *
 *        code was generated by the Geppetto System </br>
 *        Gepppetto system Copyright - Geppetto LLC 2014 - 2015</br>
 *        The generated code is free to use by anyone
 *        </p>
 *
 *
 *
 */
@Transactional
@Repository("Task_Default_ActivityDao")
public class Task_Default_ActivityDao {
	GpUserDAO GpUserDAO;
	
	public GpUserDAO getGpUserDAO() {
		return GpUserDAO;
	}

	@Resource(name = "GpUserDAO")
	public void setGpUserDAO(GpUserDAO gpUserDAO) {
		GpUserDAO = gpUserDAO;
	}

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
	@Value("${get_task_by_id.sql}")
	private String get_task_by_id;
	@Value("${get_user_tasks.sql}")
	private String get_user_tasks;
	
	@PersistenceContext
	EntityManager entityManager;

	// auths not ready at this time
	public Task task_search_for_update(long id, GpUser user) throws Exception {

		try {

			Query result = entityManager.createNativeQuery(search_for_update_Task, Task.class).setParameter("id", id);
			
			ArrayList<Task> Task_list = (ArrayList<Task>) result.getResultList();

			if (Task_list == null) {
				throw new Exception("no Task found");
			}

			return (Task) Task_list.get(0);

		} catch (Exception e) {

			new Exception(e.toString()); // this needs to be changed

		}
		return null;

	}

	// auths not ready at this time
	public ArrayList<Task> get_all_task(Long listid,GpUser gpuser) throws Exception {

		try {

			Query result = entityManager.createNativeQuery(get_all_Task, Task.class).setParameter("listid", listid).setParameter("userid", gpuser.getId());

			ArrayList<Task> Task_list = (ArrayList<Task>) result.getResultList();

			if (Task_list.size() < 1) {
				throw new Exception("no Task found");
			}

			for (Task task : Task_list) {
				task.setTaskOwnerUser(GpUserDAO.get_user_by_id(task.getTaskowner()));
				task.setUsername(GpUserDAO.get_user_by_id(task.getCreated_by()));
			}
			
			return (ArrayList<Task>) Task_list;

		} catch (Exception e) {

			new Exception(e.toString()); // this needs to be changed

		}
		return null;

	}
	
	
	// auths not ready at this time
		public ArrayList<Task> get_user_tasks(Long userId) throws Exception {

			try {

				Query result = entityManager.createNativeQuery(get_user_tasks, Task.class).setParameter("userid", userId);

				ArrayList<Task> Task_list = (ArrayList<Task>) result.getResultList();

				if (Task_list.size() < 1) {
					throw new Exception("no Task found");
				}
				
				for (Task task : Task_list) {
					task.setTaskOwnerUser(GpUserDAO.get_user_by_id(task.getTaskowner()));
					task.setUsername(GpUserDAO.get_user_by_id(task.getCreated_by()));
				}

				
				return (ArrayList<Task>) Task_list;

			} catch (Exception e) {

				new Exception(e.toString()); // this needs to be changed

			}
			return null;

		}
	
	// auths not ready at this time
		public Task get_task_by_id(Long taskId) throws Exception {

			try {

				Query result = entityManager.createNativeQuery(get_task_by_id, Task.class).setParameter("id", taskId);

				ArrayList<Task> task = (ArrayList<Task>) result.getResultList();

				if(task!=null)
				return task.get(0);

			} catch (Exception e) {

				new Exception(e.toString()); // this needs to be changed

			}
			return null;

		}

	// auths not ready at this time
	@Transactional
	public Task create_task(Task Task, GpUser user) throws Exception {

		try {

			
			Query query = entityManager.createNativeQuery(create_Task).setParameter("title", Task.getTitle())
					.setParameter("description", Task.getDescription()).setParameter("taskowner", Task.getTaskowner())
					.setParameter("duedate", Task.getDuedate())
					.setParameter("completionpercentage", Task.getCompletionpercentage())
					.setParameter("attachment", Task.getAttachment()).setParameter("groupid", Task.getGroupid())
					.setParameter("created_by", user == null ? 0 : user.getId())
					.setParameter("updated_by", user == null ? 0 : user.getId())
					.setParameter("Created_date", new Date()).setParameter("Updated_date", new Date())
					.setParameter("task_status", Task.getTask_status())
					.setParameter("task_priority", Task.getTask_priority())
					.setParameter("listId", Task.getListId())
					
			;

			int insertedId = query.executeUpdate();
			String lastIndex = "select last_insert_id()";
			Query sql = entityManager.createNativeQuery(lastIndex);
			BigInteger new_id = (BigInteger) sql.getSingleResult();
			Task.setId(new_id.longValue());
			System.out.println("create data---" + insertedId);
			Task.setAttachment(null);

			return Task;

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

	// auths not ready at this time
	@Transactional
	public Task update_task(Task Task, GpUser user) throws Exception {

		try {
			Query query = entityManager.createNativeQuery(update_Task).setParameter("id", Task.getId())
					.setParameter("title", Task.getTitle()).setParameter("description", Task.getDescription())
					.setParameter("taskowner", Task.getTaskowner()).setParameter("duedate", Task.getDuedate())
					.setParameter("completionpercentage", Task.getCompletionpercentage())
					.setParameter("attachment", Task.getAttachment())
					.setParameter("groupid", Task.getGroupid())
					.setParameter("updated_by", user == null ? 0 : user.getId());

			query.executeUpdate();

			return Task;

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

	// auths not ready at this time
	@Transactional
	public String delete_task(long id, GpUser user) throws Exception {

		try {
			Query query = entityManager.createNativeQuery(delete_Task).setParameter("id", id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

}