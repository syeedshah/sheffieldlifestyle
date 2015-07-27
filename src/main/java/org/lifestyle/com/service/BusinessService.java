package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Business;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Businesss
 * 
 */
@Service("businessService")
@Transactional
public class BusinessService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all Businesss
	 * 
	 * @return a list of Businesss
	 */
	public List<Business> getAll() {
		logger.debug("Retrieving all Businesss");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  tbl_business");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves 3 random Businesss
	 * 
	 * @return a list of 3 Business
	 */
	@SuppressWarnings("unchecked")
	public List<Business> getRandomEntries() {
		logger.debug("Retrieving 3 random Businesss");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Business ORDER BY rand()").setMaxResults(3);
		
		// Retrieve all
		return query.list();
	}
	
	/**
	 * Retrieves a single Business
	 */
	public Business get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Business first
		Business business = (Business) session.get(Business.class, id);
		
		return business;
	}
	/**
	 * Adds a new Business
	 */
	public void add(Business business) {
		logger.debug("Adding new Business");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(business);
	}
	
	/**
	 * Deletes an existing Business
	 * @param id the id of the existing Business
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Business");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Business first
		Business business = (Business) session.get(Business.class, id);
		
		// Delete 
		session.delete(business);
	}
	
	/**
	 * Edits an existing Business
	 */
	public void edit(Business business) {
		logger.debug("Editing existing Business");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Business via id
		Business existingBusiness = (Business) session.get(Business.class, business.getbusiness_id());
		
		// Assign updated values to this Business
		existingBusiness.setName(business.getName());
		

		// Save updates
		session.save(existingBusiness);
	}
}
