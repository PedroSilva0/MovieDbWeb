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

public class MovieDAO {
	public static Movie loadMovieByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadMovieByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie getMovieByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getMovieByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie loadMovieByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadMovieByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie getMovieByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getMovieByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie loadMovieByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Movie) session.load(moviedb_classes.Movie.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie getMovieByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Movie) session.get(moviedb_classes.Movie.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie loadMovieByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Movie) session.load(moviedb_classes.Movie.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie getMovieByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Movie) session.get(moviedb_classes.Movie.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovie(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryMovie(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovie(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryMovie(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie[] listMovieByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listMovieByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie[] listMovieByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listMovieByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovie(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Movie as Movie");
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
	
	public static List queryMovie(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Movie as Movie");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Movie", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie[] listMovieByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMovie(session, condition, orderBy);
			return (Movie[]) list.toArray(new Movie[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie[] listMovieByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMovie(session, condition, orderBy, lockMode);
			return (Movie[]) list.toArray(new Movie[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie loadMovieByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadMovieByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie loadMovieByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadMovieByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie loadMovieByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Movie[] movies = listMovieByQuery(session, condition, orderBy);
		if (movies != null && movies.length > 0)
			return movies[0];
		else
			return null;
	}
	
	public static Movie loadMovieByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Movie[] movies = listMovieByQuery(session, condition, orderBy, lockMode);
		if (movies != null && movies.length > 0)
			return movies[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMovieByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateMovieByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovieByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateMovieByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovieByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Movie as Movie");
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
	
	public static java.util.Iterator iterateMovieByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Movie as Movie");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Movie", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie createMovie() {
		return new moviedb_classes.Movie();
	}
	
	public static boolean save(moviedb_classes.Movie movie) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().saveObject(movie);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(moviedb_classes.Movie movie) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().deleteObject(movie);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Movie movie)throws PersistentException {
		try {
			moviedb_classes.Staff[] lParticipantss = movie.participants.toArray();
			for(int i = 0; i < lParticipantss.length; i++) {
				lParticipantss[i].worked.remove(movie);
			}
			moviedb_classes.Lists[] lListss = movie.lists.toArray();
			for(int i = 0; i < lListss.length; i++) {
				lListss[i].setMovie(null);
			}
			moviedb_classes.Ratings[] lRateds = movie.rated.toArray();
			for(int i = 0; i < lRateds.length; i++) {
				lRateds[i].setMovie(null);
			}
			return delete(movie);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Movie movie, org.orm.PersistentSession session)throws PersistentException {
		try {
			moviedb_classes.Staff[] lParticipantss = movie.participants.toArray();
			for(int i = 0; i < lParticipantss.length; i++) {
				lParticipantss[i].worked.remove(movie);
			}
			moviedb_classes.Lists[] lListss = movie.lists.toArray();
			for(int i = 0; i < lListss.length; i++) {
				lListss[i].setMovie(null);
			}
			moviedb_classes.Ratings[] lRateds = movie.rated.toArray();
			for(int i = 0; i < lRateds.length; i++) {
				lRateds[i].setMovie(null);
			}
			try {
				session.delete(movie);
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
	
	public static boolean refresh(moviedb_classes.Movie movie) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().refresh(movie);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(moviedb_classes.Movie movie) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().evict(movie);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie loadMovieByCriteria(MovieCriteria movieCriteria) {
		Movie[] movies = listMovieByCriteria(movieCriteria);
		if(movies == null || movies.length == 0) {
			return null;
		}
		return movies[0];
	}
	
	public static Movie[] listMovieByCriteria(MovieCriteria movieCriteria) {
		return movieCriteria.listMovie();
	}
}
