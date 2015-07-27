package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Dining;
import org.lifestyle.com.domain.Landmark;
import org.lifestyle.com.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Dinings
 * 
 */
@Service("diningService")
@Transactional
public class DiningService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all Dinings
	 * 
	 * @return a list of Dinings
	 */
	public List<Dining> getAll() {
		logger.debug("Retrieving all Dinings");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  tbl_dining");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves 3 random Dinings
	 * 
	 * @return a list of 3 Dining
	 */
	@SuppressWarnings("unchecked")
	public List<Dining> getRandomEntries() {
		logger.debug("Retrieving 3 random Dinings");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Dining ORDER BY rand()").setMaxResults(3);
		
		// Retrieve all
		return query.list();
	}
	
	/**
	 * Retrieves a single Dining
	 */
	public Dining get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Dining first
		Dining dining = (Dining) session.get(Dining.class, id);
		
		return dining;
	}
	/**
	 * Adds a new Dining
	 */
	public void add(Dining dining) {
		logger.debug("Adding new Dining");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(dining);
	}
	
	/**
	 * Deletes an existing Dining
	 * @param id the id of the existing Dining
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Dining");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Dining first
		Dining dining = (Dining) session.get(Dining.class, id);
		
		// Delete 
		session.delete(dining);
	}
	
	/**
	 * Edits an existing Dining
	 */
	public void edit(Dining dining) {
		logger.debug("Editing existing Dining");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Dining via id
		Dining existingDining = (Dining) session.get(Dining.class, dining.getdining_id());
		
		// Assign updated values to this Dining
		existingDining.setName(dining.getName());
		

		// Save updates
		session.save(existingDining);
	}
}
