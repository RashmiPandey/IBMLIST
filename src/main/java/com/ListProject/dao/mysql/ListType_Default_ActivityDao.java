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



import com.ListProject.domain.core.ListType;
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
@Repository("ListType_Default_ActivityDao")
public class ListType_Default_ActivityDao   {

	private Log log = LogFactory.getLog(getClass());

	@Value("${create_ListType.sql}")
	private String create_ListType;
	@Value("${search_for_update_ListType.sql}")
	private String search_for_update_ListType;
	@Value("${update_ListType.sql}")
	private String update_ListType;
	@Value("${delete_ListType.sql}")
	private String delete_ListType;
	@Value("${get_all_ListType.sql}")
	private String get_all_ListType;
	@Value("${get_by_parent_id_ListType.sql}")
	private String get_by_parent_id_ListType;
	@Value("${delete_by_parent_id_ListType.sql}")
	private String delete_by_parent_id_ListType;


    @PersistenceContext
	EntityManager entityManager;



	//auths not ready at this time
	public ListType listtype_search_for_update(long id, GpUser user) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(search_for_update_ListType,ListType.class)

			.setParameter("id", id);;

			ArrayList<ListType> ListType_list =	(ArrayList<ListType>)result.getResultList();

			if(ListType_list  == null){
				throw new Exception("no ListType found");
			}

			return (ListType) ListType_list.get(0);

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}

	//auths not ready at this time
	public ArrayList<ListType> get_all_listtype() throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(get_all_ListType,ListType.class)

;

			ArrayList<ListType> ListType_list =	(ArrayList<ListType>)result.getResultList();

			if(ListType_list .size() < 1){
				throw new Exception("no ListType found");
			}

			return (ArrayList<ListType>) ListType_list;

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}

	//auths not ready at this time
	public ListType get_listtype_by_parent_id(long Master_List_id) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(get_by_parent_id_ListType,ListType.class)

			.setParameter("Master_List_id", Master_List_id == 0 ? "%%" : Master_List_id);

			ArrayList<ListType> ListType_list =	(ArrayList<ListType>)result.getResultList();

			if(ListType_list  == null){
				throw new Exception("no ListType found");
			}

			return (ListType) ListType_list.get(0);

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}



	//auths not ready at this time
	@Transactional
	public ListType create_listtype(ListType ListType, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(create_ListType)
			.setParameter("name", ListType.getName())
			.setParameter("Master_List_id", ListType.getMaster_List_id())
			.setParameter("created_by", user == null ? 0:user.getId())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			int insertedId = query.executeUpdate();
					String lastIndex="select last_insert_id()";
					Query sql = entityManager.createNativeQuery(lastIndex);
					BigInteger new_id = (BigInteger) sql.getSingleResult();
					ListType.setId(new_id.longValue());
					System.out.println("create data---"+insertedId);

			return ListType;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public ListType update_listtype(ListType ListType, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(update_ListType)
			.setParameter("id", ListType.getId())
			.setParameter("name", ListType.getName())
			.setParameter("Master_List_id", ListType.getMaster_List_id())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			query.executeUpdate();

			return ListType;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public String  delete_listtype(long id, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(delete_ListType)
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
	public String  delete_listtype_by_parent_id(long Master_List_id) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(delete_by_parent_id_ListType)
			.setParameter("Master_List_id", Master_List_id == 0 ? "%%" : Master_List_id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}



}