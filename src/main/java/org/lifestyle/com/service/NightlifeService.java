package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Nightlife;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("nightlifeService")
@Transactional
public class NightlifeService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all Nightlifes
	 * 
	 * @return a list of Nightlifes
	 */
	public List<Nightlife> getAll() {
		logger.debug("Retrieving all Nightlifes");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Nightlife");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves all Landmarks
	 * 
	 * @return a list of Landmarks
	 */
	@SuppressWarnings("unchecked")
	public List<Nightlife> getRandomEntries() {
		logger.debug("Retrieving 3 random Nightlife");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Nightlife ORDER BY rand()").setMaxResults(3); 
		
		// Retrieve all
		return query.list();
	}
	
	/**
	 * Retrieves a single Nightlife
	 */
	public Nightlife get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Nightlife first
		Nightlife nightlife = (Nightlife) session.get(Nightlife.class, id);
		
		return nightlife;
	}
	/**
	 * Adds a new Nightlife
	 */
	public void add(Nightlife nightlife) {
		logger.debug("Adding new Nightlife");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(nightlife);
	}
	
	/**
	 * Deletes an existing Nightlife
	 * @param id the id of the existing Nightlife
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Nightlife");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Nightlife first
		Nightlife nightlife = (Nightlife) session.get(Nightlife.class, id);
		
		// Delete 
		session.delete(nightlife);
	}
	
	/**
	 * Edits an existing person
	 */
	public void edit(Nightlife nightlife) {
		logger.debug("Editing existing person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Nightlife existingNightlife = (Nightlife) session.get(Nightlife.class, nightlife.getClub_id());
		
		// Assign updated values to this person
		existingNightlife.setName(nightlife.getName());
		

		// Save updates
		session.save(existingNightlife);
	}
}
