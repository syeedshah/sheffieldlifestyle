package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Landmark;
import org.lifestyle.com.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("landmarkService")
@Transactional
public class LandmarkService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Retrieves all Landmarks
	 * 
	 * @return a list of Landmarks
	 */
	@SuppressWarnings("unchecked")
	public List<Landmark> getRandomEntries() {
		logger.debug("Retrieving 3 random Landmarks");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Landmark ORDER BY rand()").setMaxResults(3);
		
		// Retrieve all
		return query.list();
	}

	/**
	 * Retrieves a single Landmark
	 */
	public Landmark get(Integer id) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing Landmark first
		Landmark landmark = (Landmark) session.get(Landmark.class, id);

		return landmark;
	}

	/**
	 * Retrieves a single Landmark
	 */
	public List<Landmark> getAll() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Landmark");

		// Retrieve all
		return query.list();
	}

	/**
	 * Adds a new Landmark
	 */
	public void add(Landmark landmark) {
		logger.debug("Adding new Landmark");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Save
		session.save(landmark);
	}

	/**
	 * Deletes an existing Landmark
	 * 
	 * @param id
	 *            the id of the existing Landmark
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Landmark");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing Landmark first
		Landmark landmark = (Landmark) session.get(Landmark.class, id);

		// Delete
		session.delete(landmark);
	}

	/**
	 * Edits an existing person
	 */
	public void edit(Landmark landmark) {
		logger.debug("Editing existing person");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing person via id
		Landmark existingLandmark = (Landmark) session.get(Landmark.class,
				landmark.getLandmark_id());

		// Assign updated values to this person
		existingLandmark.setName(landmark.getName());

		// Save updates
		session.save(existingLandmark);
	}
}
