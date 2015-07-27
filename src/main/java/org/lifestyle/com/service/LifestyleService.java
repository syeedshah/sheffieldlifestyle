package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Lifestyle;
import org.lifestyle.com.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("lifestyleService")
@Transactional
public class LifestyleService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Retrieves all Lifestyles
	 * 
	 * @return a list of Lifestyles
	 */
	@SuppressWarnings("unchecked")
	public List<Lifestyle> getRandomEntries() {
		logger.debug("Retrieving 3 random Lifestyles");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Lifestyle ORDER BY rand()").setMaxResults(3);
		
		// Retrieve all
		return query.list();
	}

	/**
	 * Retrieves a single Lifestyle
	 */
	public Lifestyle get(Integer id) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing Lifestyle first
		Lifestyle lifestyle = (Lifestyle) session.get(Lifestyle.class, id);

		return lifestyle;
	}

	/**
	 * Retrieves a single Lifestyle
	 */
	public List<Lifestyle> getAll() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Lifestyle");

		// Retrieve all
		return query.list();
	}

	/**
	 * Adds a new Lifestyle
	 */
	public void add(Lifestyle lifestyle) {
		logger.debug("Adding new Lifestyle");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Save
		session.save(lifestyle);
	}

	/**
	 * Deletes an existing Lifestyle
	 * 
	 * @param id
	 *            the id of the existing Lifestyle
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Lifestyle");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing Lifestyle first
		Lifestyle lifestyle = (Lifestyle) session.get(Lifestyle.class, id);

		// Delete
		session.delete(lifestyle);
	}

	/**
	 * Edits an existing lifestyle
	 */
	public void edit(Lifestyle lifestyle) {
		logger.debug("Editing existing lifestyle");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing lifestyle via id
		Lifestyle existingLifestyle = (Lifestyle) session.get(Lifestyle.class,
				lifestyle.getLifestyle_id());

		// Assign updated values to this lifestyle
		existingLifestyle.setName(lifestyle.getName());

		// Save updates
		session.save(existingLifestyle);
	}
}
