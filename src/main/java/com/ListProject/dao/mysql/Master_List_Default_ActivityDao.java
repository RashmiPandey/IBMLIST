package com.ListProject.dao.mysql;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ListProject.domain.core.GpUser;
import com.ListProject.domain.core.Master_List;

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
@Repository("Master_List_Default_ActivityDao")
public class Master_List_Default_ActivityDao {

	private Log log = LogFactory.getLog(getClass());

	@Value("${create_Master_List.sql}")
	private String create_Master_List;
	@Value("${search_for_update_Master_List.sql}")
	private String search_for_update_Master_List;
	@Value("${update_Master_List.sql}")
	private String update_Master_List;
	@Value("${delete_Master_List.sql}")
	private String delete_Master_List;
	@Value("${get_all_Master_List.sql}")
	private String get_all_Master_List;

	@PersistenceContext
	EntityManager entityManager;

	// auths not ready at this time
	public Master_List master_list_search_for_update(long id, GpUser user) throws Exception {

		try {

			Query result = entityManager.createNativeQuery(search_for_update_Master_List, Master_List.class).setParameter("id", id);

			ArrayList<Master_List> Master_List_list = (ArrayList<Master_List>) result.getResultList();

			if (Master_List_list == null) {
				throw new Exception("no Master_List found");
			}

			return (Master_List) Master_List_list.get(0);

		} catch (Exception e) {

			new Exception(e.toString()); // this needs to be changed

		}
		return null;

	}

	// auths not ready at this time
	public ArrayList<Master_List> get_all_master_list() throws Exception {

		try {

			Query result = entityManager.createNativeQuery(get_all_Master_List, Master_List.class);

			ArrayList<Master_List> Master_List_list = (ArrayList<Master_List>) result.getResultList();

			if (Master_List_list.size() < 1) {
				throw new Exception("no Master_List found");
			}

			return (ArrayList<Master_List>) Master_List_list;

		} catch (Exception e) {

			new Exception(e.toString()); // this needs to be changed

		}
		return null;

	}

	// auths not ready at this time
	@Transactional
	public Master_List create_master_list(Master_List Master_List, GpUser user) throws Exception {

		try {
			Query query = entityManager.createNativeQuery(create_Master_List)
					.setParameter("title", Master_List.getTitle())
					.setParameter("description", Master_List.getDescription())
					.setParameter("Listid", Master_List.getListid()).setParameter("listtype", Master_List.getListtype())
					.setParameter("listname", Master_List.getListname())
					.setParameter("created_by", user == null ? 0 : user.getId())
					.setParameter("updated_by", user == null ? 0 : user.getId())
					.setParameter("updated_date", new Date()).setParameter("created_date", new Date());

			int insertedId = query.executeUpdate();
			String lastIndex = "select last_insert_id()";
			Query sql = entityManager.createNativeQuery(lastIndex);
			BigInteger new_id = (BigInteger) sql.getSingleResult();
			Master_List.setId(new_id.longValue());
			System.out.println("create data---" + insertedId);

			return Master_List;

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

	// auths not ready at this time
	@Transactional
	public Master_List update_master_list(Master_List Master_List, GpUser user) throws Exception {

		try {
			Query query = entityManager.createNativeQuery(update_Master_List).setParameter("id", Master_List.getId())
					.setParameter("title", Master_List.getTitle())
					.setParameter("description", Master_List.getDescription())
					.setParameter("listtype", Master_List.getListtype())
					.setParameter("updated_by", user == null ? 0 : user.getId());

			query.executeUpdate();

			return Master_List;

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

	// auths not ready at this time
	@Transactional
	public String delete_master_list(long id, GpUser user) throws Exception {

		try {
			Query query = entityManager.createNativeQuery(delete_Master_List).setParameter("id", id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

}