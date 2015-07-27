package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Kids;
import org.lifestyle.com.domain.Landmark;
import org.lifestyle.com.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Kids
 * 
 */
@Service("kidsService")
@Transactional
public class KidsService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all Kids
	 * 
	 * @return a list of Kids
	 */
	public List<Kids> getAll() {
		logger.debug("Retrieving all Kidss");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  tbl_kids");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves 3 random Kids
	 * 
	 * @return a list of Kids
	 */
	@SuppressWarnings("unchecked")
	public List<Kids> getRandomEntries() {
		logger.debug("Retrieving 3 random Kids");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Kids ORDER BY rand()").setMaxResults(3);
		
		// Retrieve all
		return query.list();
	}
	
	/**
	 * Retrieves a single Kids
	 */
	public Kids get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Kids first
		Kids kid = (Kids) session.get(Kids.class, id);
		
		return kid;
	}
	/**
	 * Adds a new Kids
	 */
	public void add(Kids kid) {
		logger.debug("Adding new Kids");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(kid);
	}
	
	/**
	 * Deletes an existing Kids
	 * @param id the id of the existing Kids
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Kids");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Kids first
		Kids kid = (Kids) session.get(Kids.class, id);
		
		// Delete 
		session.delete(kid);
	}
	
	/**
	 * Edits an existing person
	 */
	public void edit(Kids kid) {
		logger.debug("Editing existing person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Kids existingKids = (Kids) session.get(Kids.class, kid.getId());
		
		// Assign updated values to this person
		existingKids.setName(kid.getName());
		

		// Save updates
		session.save(existingKids);
	}
}
