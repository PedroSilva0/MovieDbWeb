/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidade do Minho
 * License Type: Academic
 */
package moviedb_classes;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class RatingsDAO {
	public static Ratings loadRatingsByORMID(moviedb_classes.User user, moviedb_classes.Movie movie) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadRatingsByORMID(session, user, movie);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings getRatingsByORMID(moviedb_classes.User user, moviedb_classes.Movie movie) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getRatingsByORMID(session, user, movie);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByORMID(moviedb_classes.User user, moviedb_classes.Movie movie, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadRatingsByORMID(session, user, movie, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings getRatingsByORMID(moviedb_classes.User user, moviedb_classes.Movie movie, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getRatingsByORMID(session, user, movie, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByORMID(PersistentSession session, moviedb_classes.User user, moviedb_classes.Movie movie) throws PersistentException {
		try {
			Ratings ratings = new moviedb_classes.Ratings();
			ratings.setORM_User(user);
			ratings.setORM_Movie(movie);
			
			return (Ratings) session.load(moviedb_classes.Ratings.class, ratings);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings getRatingsByORMID(PersistentSession session, moviedb_classes.User user, moviedb_classes.Movie movie) throws PersistentException {
		try {
			Ratings ratings = new moviedb_classes.Ratings();
			ratings.setORM_User(user);
			ratings.setORM_Movie(movie);
			
			return (Ratings) session.get(moviedb_classes.Ratings.class, ratings);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByORMID(PersistentSession session, moviedb_classes.User user, moviedb_classes.Movie movie, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ratings ratings = new moviedb_classes.Ratings();
			ratings.setORM_User(user);
			ratings.setORM_Movie(movie);
			
			return (Ratings) session.load(moviedb_classes.Ratings.class, ratings, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings getRatingsByORMID(PersistentSession session, moviedb_classes.User user, moviedb_classes.Movie movie, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Ratings ratings = new moviedb_classes.Ratings();
			ratings.setORM_User(user);
			ratings.setORM_Movie(movie);
			
			return (Ratings) session.get(moviedb_classes.Ratings.class, ratings, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRatings(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryRatings(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRatings(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryRatings(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings[] listRatingsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listRatingsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings[] listRatingsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listRatingsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRatings(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Ratings as Ratings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRatings(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Ratings as Ratings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ratings", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings[] listRatingsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRatings(session, condition, orderBy);
			return (Ratings[]) list.toArray(new Ratings[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings[] listRatingsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRatings(session, condition, orderBy, lockMode);
			return (Ratings[]) list.toArray(new Ratings[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadRatingsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadRatingsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ratings[] ratingses = listRatingsByQuery(session, condition, orderBy);
		if (ratingses != null && ratingses.length > 0)
			return ratingses[0];
		else
			return null;
	}
	
	public static Ratings loadRatingsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ratings[] ratingses = listRatingsByQuery(session, condition, orderBy, lockMode);
		if (ratingses != null && ratingses.length > 0)
			return ratingses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRatingsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateRatingsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRatingsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateRatingsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRatingsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Ratings as Ratings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRatingsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Ratings as Ratings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ratings", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings createRatings() {
		return new moviedb_classes.Ratings();
	}
	
	public static boolean save(moviedb_classes.Ratings ratings) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().saveObject(ratings);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(moviedb_classes.Ratings ratings) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().deleteObject(ratings);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Ratings ratings)throws PersistentException {
		try {
			moviedb_classes.User user = ratings.getUser();
			if (ratings.getUser() != null) {
				ratings.getUser().evaluated.remove(ratings);
			}
			ratings.setORM_User(user);
			
			moviedb_classes.Movie movie = ratings.getMovie();
			if (ratings.getMovie() != null) {
				ratings.getMovie().rated.remove(ratings);
			}
			ratings.setORM_Movie(movie);
			
			return delete(ratings);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Ratings ratings, org.orm.PersistentSession session)throws PersistentException {
		try {
			moviedb_classes.User user = ratings.getUser();
			if (ratings.getUser() != null) {
				ratings.getUser().evaluated.remove(ratings);
			}
			ratings.setORM_User(user);
			
			moviedb_classes.Movie movie = ratings.getMovie();
			if (ratings.getMovie() != null) {
				ratings.getMovie().rated.remove(ratings);
			}
			ratings.setORM_Movie(movie);
			
			try {
				session.delete(ratings);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(moviedb_classes.Ratings ratings) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().refresh(ratings);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(moviedb_classes.Ratings ratings) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().evict(ratings);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByCriteria(RatingsCriteria ratingsCriteria) {
		Ratings[] ratingses = listRatingsByCriteria(ratingsCriteria);
		if(ratingses == null || ratingses.length == 0) {
			return null;
		}
		return ratingses[0];
	}
	
	public static Ratings[] listRatingsByCriteria(RatingsCriteria ratingsCriteria) {
		return ratingsCriteria.listRatings();
	}
}
