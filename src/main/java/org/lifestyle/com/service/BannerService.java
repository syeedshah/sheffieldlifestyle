package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Banner;
import org.lifestyle.com.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("BannerService")
@Transactional
public class BannerService {

	protected static Logger logger = Logger.getLogger("bannerservice");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all banner
	 * 
	 * @return a list of banner
	 */
	public List<Banner> getAll() {
		logger.debug("Retrieving all banner");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  banner");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single banner
	 */
	public Banner get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Banner first
		Banner banner = (Banner) session.get(Banner.class, id);
		
		return banner;
	}
	/**
	 * Adds a new Banner
	 */
	public void add(Banner banner) {
		logger.debug("Adding new Banner");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(banner);
	}
	
	/**
	 * Deletes an existing Banner
	 * @param id the id of the existing Banner
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Banner");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Banner first
		Banner banner = (Banner) session.get(Banner.class, id);
		
		// Delete 
		session.delete(banner);
	}
	
	/**
	 * Edits an existing Banner
	 */
	public void edit(Banner banner) {
		logger.debug("Editing existing Banner");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Banner via id
		Banner existingBanner = (Banner) session.get(Banner.class, banner.getBanner_id());
		
		// Assign updated values to this Banner
		existingBanner.setTitle(banner.getTitle());
		

		// Save updates
		session.save(existingBanner);
	}
}
