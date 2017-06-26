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

public class ListsDAO {
	public static Lists loadListsByORMID(moviedb_classes.User user, moviedb_classes.Movie movie) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadListsByORMID(session, user, movie);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists getListsByORMID(moviedb_classes.User user, moviedb_classes.Movie movie) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getListsByORMID(session, user, movie);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists loadListsByORMID(moviedb_classes.User user, moviedb_classes.Movie movie, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadListsByORMID(session, user, movie, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists getListsByORMID(moviedb_classes.User user, moviedb_classes.Movie movie, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getListsByORMID(session, user, movie, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists loadListsByORMID(PersistentSession session, moviedb_classes.User user, moviedb_classes.Movie movie) throws PersistentException {
		try {
			Lists lists = new moviedb_classes.Lists();
			lists.setORM_User(user);
			lists.setORM_Movie(movie);
			
			return (Lists) session.load(moviedb_classes.Lists.class, lists);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists getListsByORMID(PersistentSession session, moviedb_classes.User user, moviedb_classes.Movie movie) throws PersistentException {
		try {
			Lists lists = new moviedb_classes.Lists();
			lists.setORM_User(user);
			lists.setORM_Movie(movie);
			
			return (Lists) session.get(moviedb_classes.Lists.class, lists);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists loadListsByORMID(PersistentSession session, moviedb_classes.User user, moviedb_classes.Movie movie, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Lists lists = new moviedb_classes.Lists();
			lists.setORM_User(user);
			lists.setORM_Movie(movie);
			
			return (Lists) session.load(moviedb_classes.Lists.class, lists, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists getListsByORMID(PersistentSession session, moviedb_classes.User user, moviedb_classes.Movie movie, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Lists lists = new moviedb_classes.Lists();
			lists.setORM_User(user);
			lists.setORM_Movie(movie);
			
			return (Lists) session.get(moviedb_classes.Lists.class, lists, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLists(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryLists(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLists(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryLists(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists[] listListsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listListsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists[] listListsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listListsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLists(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Lists as Lists");
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
	
	public static List queryLists(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Lists as Lists");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Lists", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists[] listListsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryLists(session, condition, orderBy);
			return (Lists[]) list.toArray(new Lists[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists[] listListsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryLists(session, condition, orderBy, lockMode);
			return (Lists[]) list.toArray(new Lists[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists loadListsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadListsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists loadListsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadListsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists loadListsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Lists[] listses = listListsByQuery(session, condition, orderBy);
		if (listses != null && listses.length > 0)
			return listses[0];
		else
			return null;
	}
	
	public static Lists loadListsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Lists[] listses = listListsByQuery(session, condition, orderBy, lockMode);
		if (listses != null && listses.length > 0)
			return listses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateListsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateListsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateListsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateListsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateListsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Lists as Lists");
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
	
	public static java.util.Iterator iterateListsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Lists as Lists");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Lists", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists createLists() {
		return new moviedb_classes.Lists();
	}
	
	public static boolean save(moviedb_classes.Lists lists) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().saveObject(lists);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(moviedb_classes.Lists lists) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().deleteObject(lists);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Lists lists)throws PersistentException {
		try {
			moviedb_classes.User user = lists.getUser();
			if (lists.getUser() != null) {
				lists.getUser().lists.remove(lists);
			}
			lists.setORM_User(user);
			
			moviedb_classes.Movie movie = lists.getMovie();
			if (lists.getMovie() != null) {
				lists.getMovie().lists.remove(lists);
			}
			lists.setORM_Movie(movie);
			
			return delete(lists);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Lists lists, org.orm.PersistentSession session)throws PersistentException {
		try {
			moviedb_classes.User user = lists.getUser();
			if (lists.getUser() != null) {
				lists.getUser().lists.remove(lists);
			}
			lists.setORM_User(user);
			
			moviedb_classes.Movie movie = lists.getMovie();
			if (lists.getMovie() != null) {
				lists.getMovie().lists.remove(lists);
			}
			lists.setORM_Movie(movie);
			
			try {
				session.delete(lists);
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
	
	public static boolean refresh(moviedb_classes.Lists lists) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().refresh(lists);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(moviedb_classes.Lists lists) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().evict(lists);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Lists loadListsByCriteria(ListsCriteria listsCriteria) {
		Lists[] listses = listListsByCriteria(listsCriteria);
		if(listses == null || listses.length == 0) {
			return null;
		}
		return listses[0];
	}
	
	public static Lists[] listListsByCriteria(ListsCriteria listsCriteria) {
		return listsCriteria.listLists();
	}
}
