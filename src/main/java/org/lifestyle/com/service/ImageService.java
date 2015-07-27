package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Image;
import org.lifestyle.com.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("imageService")
@Transactional
public class ImageService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all Images
	 * 
	 * @return a list of Images
	 */
	public List<Image> getAll() {
		logger.debug("Retrieving all Images");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Image");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves Image by image_link
	 * 
	 * @return a image
	 */
	public List<Image> getImageByLink(String imageLink) {
		logger.debug("Retrieving Image by image link");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Image image where imageLink=:imageLink");
		query.setParameter("imageLink",imageLink);
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single Image
	 */
	public Image get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Image first
		Image image = (Image) session.get(Image.class, id);
		
		return image;
	}
	/**
	 * Adds a new Image
	 */
	public void add(Image image) {
		logger.debug("Adding new Image");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(image);
	}
	
	/**
	 * Deletes an existing Image
	 * @param id the id of the existing Image
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Image");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Image first
		Image image = (Image) session.get(Image.class, id);
		
		// Delete 
		session.delete(image);
	}
	
	/**
	 * Edits an existing person
	 */
	public void edit(Image image) {
		logger.debug("Editing existing person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Image existingImage = (Image) session.get(Image.class, image.getImage_id());
		
		// Assign updated values to this person
		existingImage.setName(image.getName());
		

		// Save updates
		session.save(existingImage);
	}
}
