package org.lifestyle.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lifestyle.com.domain.Landmark;
import org.lifestyle.com.domain.News;
import org.lifestyle.com.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("newsService")
@Transactional
public class NewsService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Retrieves all News
	 * 
	 * @return a list of News
	 */
	public List<News> getAll() {
		logger.debug("Retrieving all News");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM News");

		// Retrieve all
		return query.list();
	}

	/**
	 * Retrieves 6 latest News
	 * 
	 * @return a list of News
	 */
	public List<News> getLatest() {
		logger.debug("Retrieving Latest News");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM News ORDER BY rand()").setMaxResults(5);
		
		// Retrieve all
		return query.list();
	}

	/**
	 * Retrieves a single News
	 */
	public News get(Integer id) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing News first
		News news = (News) session.get(News.class, id);

		return news;
	}

	/**
	 * Adds a new News
	 */
	public void add(News news) {
		logger.debug("Adding new News");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Save
		session.save(news);
	}

	/**
	 * Deletes an existing News
	 * 
	 * @param id
	 *            the id of the existing News
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing News");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing News first
		News news = (News) session.get(News.class, id);

		// Delete
		session.delete(news);
	}

	/**
	 * Edits an existing person
	 */
	public void edit(News news) {
		logger.debug("Editing existing person");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing person via id
		News existingNews = (News) session.get(News.class, news.getNews_id());

		// Assign updated values to this person
		existingNews.setTitle(news.getTitle());

		// Save updates
		session.save(existingNews);
	}
}
