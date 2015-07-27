package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Shopping;
import org.lifestyle.com.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("shoppingService")
@Transactional
public class ShoppingService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all Shoppings
	 * 
	 * @return a list of Shoppings
	 */
	public List<Shopping> getAll() {
		logger.debug("Retrieving all Shoppings");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Shopping");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single Shopping
	 */
	public Shopping get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Shopping first
		Shopping shopping = (Shopping) session.get(Shopping.class, id);
		
		return shopping;
	}
	/**
	 * Adds a new Shopping
	 */
	public void add(Shopping shopping) {
		logger.debug("Adding new Shopping");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(shopping);
	}
	
	/**
	 * Deletes an existing Shopping
	 * @param id the id of the existing Shopping
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Shopping");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Shopping first
		Shopping shopping = (Shopping) session.get(Shopping.class, id);
		
		// Delete 
		session.delete(shopping);
	}
	
	/**
	 * Edits an existing person
	 */
	public void edit(Shopping shopping) {
		logger.debug("Editing existing person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Shopping existingShopping = (Shopping) session.get(Shopping.class, shopping.getShopping_id());
		
		// Assign updated values to this person
		existingShopping.setName(shopping.getName());
		

		// Save updates
		session.save(existingShopping);
	}
}
