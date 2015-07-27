package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Sport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Sports
 * 
 */
@Service("sportService")
@Transactional
public class SportService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all Sports
	 * 
	 * @return a list of Sports
	 */
	public List<Sport> getAll() {
		logger.debug("Retrieving all Sports");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Sport");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single Sport
	 */
	public Sport get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Sport first
		Sport sport = (Sport) session.get(Sport.class, id);
		
		return sport;
	}
	/**
	 * Adds a new Sport
	 */
	public void add(Sport sport) {
		logger.debug("Adding new Sport");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(sport);
	}
	
	/**
	 * Deletes an existing Sport
	 * @param id the id of the existing Sport
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Sport");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Sport first
		Sport sport = (Sport) session.get(Sport.class, id);
		
		// Delete 
		session.delete(sport);
	}
	
	/**
	 * Edits an existing sport
	 */
	public void edit(Sport sport) {
		logger.debug("Editing existing sport");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing sport via id
		Sport existingSport = (Sport) session.get(Sport.class, sport.getSport_id());
		
		// Assign updated values to this sport
		existingSport.setName(sport.getName());
		

		// Save updates
		session.save(existingSport);
	}
}
