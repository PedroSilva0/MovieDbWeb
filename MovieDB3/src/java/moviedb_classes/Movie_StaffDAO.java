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

public class Movie_StaffDAO {
	public static Movie_Staff loadMovie_StaffByORMID(moviedb_classes.Movie movie, moviedb_classes.Staff staff) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadMovie_StaffByORMID(session, movie, staff);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff getMovie_StaffByORMID(moviedb_classes.Movie movie, moviedb_classes.Staff staff) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getMovie_StaffByORMID(session, movie, staff);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff loadMovie_StaffByORMID(moviedb_classes.Movie movie, moviedb_classes.Staff staff, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadMovie_StaffByORMID(session, movie, staff, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff getMovie_StaffByORMID(moviedb_classes.Movie movie, moviedb_classes.Staff staff, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getMovie_StaffByORMID(session, movie, staff, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff loadMovie_StaffByORMID(PersistentSession session, moviedb_classes.Movie movie, moviedb_classes.Staff staff) throws PersistentException {
		try {
			Movie_Staff movie_staff = new moviedb_classes.Movie_Staff();
			movie_staff.setORM_Movie(movie);
			movie_staff.setORM_Staff(staff);
			
			return (Movie_Staff) session.load(moviedb_classes.Movie_Staff.class, movie_staff);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff getMovie_StaffByORMID(PersistentSession session, moviedb_classes.Movie movie, moviedb_classes.Staff staff) throws PersistentException {
		try {
			Movie_Staff movie_staff = new moviedb_classes.Movie_Staff();
			movie_staff.setORM_Movie(movie);
			movie_staff.setORM_Staff(staff);
			
			return (Movie_Staff) session.get(moviedb_classes.Movie_Staff.class, movie_staff);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff loadMovie_StaffByORMID(PersistentSession session, moviedb_classes.Movie movie, moviedb_classes.Staff staff, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Movie_Staff movie_staff = new moviedb_classes.Movie_Staff();
			movie_staff.setORM_Movie(movie);
			movie_staff.setORM_Staff(staff);
			
			return (Movie_Staff) session.load(moviedb_classes.Movie_Staff.class, movie_staff, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff getMovie_StaffByORMID(PersistentSession session, moviedb_classes.Movie movie, moviedb_classes.Staff staff, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Movie_Staff movie_staff = new moviedb_classes.Movie_Staff();
			movie_staff.setORM_Movie(movie);
			movie_staff.setORM_Staff(staff);
			
			return (Movie_Staff) session.get(moviedb_classes.Movie_Staff.class, movie_staff, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovie_Staff(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryMovie_Staff(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovie_Staff(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryMovie_Staff(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff[] listMovie_StaffByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listMovie_StaffByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff[] listMovie_StaffByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listMovie_StaffByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovie_Staff(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("StaffId From moviedb_classes.Movie_Staff as Movie_Staff");
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
	
	public static List queryMovie_Staff(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Movie_Staff as Movie_Staff");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Movie_Staff", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff[] listMovie_StaffByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMovie_Staff(session, condition, orderBy);
			return (Movie_Staff[]) list.toArray(new Movie_Staff[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff[] listMovie_StaffByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMovie_Staff(session, condition, orderBy, lockMode);
			return (Movie_Staff[]) list.toArray(new Movie_Staff[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff loadMovie_StaffByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadMovie_StaffByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff loadMovie_StaffByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadMovie_StaffByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff loadMovie_StaffByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Movie_Staff[] movie_Staffs = listMovie_StaffByQuery(session, condition, orderBy);
		if (movie_Staffs != null && movie_Staffs.length > 0)
			return movie_Staffs[0];
		else
			return null;
	}
	
	public static Movie_Staff loadMovie_StaffByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Movie_Staff[] movie_Staffs = listMovie_StaffByQuery(session, condition, orderBy, lockMode);
		if (movie_Staffs != null && movie_Staffs.length > 0)
			return movie_Staffs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMovie_StaffByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateMovie_StaffByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovie_StaffByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateMovie_StaffByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovie_StaffByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Movie_Staff as Movie_Staff");
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
	
	public static java.util.Iterator iterateMovie_StaffByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Movie_Staff as Movie_Staff");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Movie_Staff", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff createMovie_Staff() {
		return new moviedb_classes.Movie_Staff();
	}
	
	public static boolean save(moviedb_classes.Movie_Staff movie_Staff) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().saveObject(movie_Staff);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(moviedb_classes.Movie_Staff movie_Staff) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().deleteObject(movie_Staff);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Movie_Staff movie_Staff)throws PersistentException {
		try {
			moviedb_classes.Movie movie = movie_Staff.getMovie();
			if (movie_Staff.getMovie() != null) {
				movie_Staff.getMovie().participants.remove(movie_Staff);
			}
			movie_Staff.setORM_Movie(movie);
			
			moviedb_classes.Staff staff = movie_Staff.getStaff();
			if (movie_Staff.getStaff() != null) {
				movie_Staff.getStaff().worked.remove(movie_Staff);
			}
			movie_Staff.setORM_Staff(staff);
			
			return delete(movie_Staff);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Movie_Staff movie_Staff, org.orm.PersistentSession session)throws PersistentException {
		try {
			moviedb_classes.Movie movie = movie_Staff.getMovie();
			if (movie_Staff.getMovie() != null) {
				movie_Staff.getMovie().participants.remove(movie_Staff);
			}
			movie_Staff.setORM_Movie(movie);
			
			moviedb_classes.Staff staff = movie_Staff.getStaff();
			if (movie_Staff.getStaff() != null) {
				movie_Staff.getStaff().worked.remove(movie_Staff);
			}
			movie_Staff.setORM_Staff(staff);
			
			try {
				session.delete(movie_Staff);
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
	
	public static boolean refresh(moviedb_classes.Movie_Staff movie_Staff) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().refresh(movie_Staff);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(moviedb_classes.Movie_Staff movie_Staff) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().evict(movie_Staff);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movie_Staff loadMovie_StaffByCriteria(Movie_StaffCriteria movie_StaffCriteria) {
		Movie_Staff[] movie_Staffs = listMovie_StaffByCriteria(movie_StaffCriteria);
		if(movie_Staffs == null || movie_Staffs.length == 0) {
			return null;
		}
		return movie_Staffs[0];
	}
	
	public static Movie_Staff[] listMovie_StaffByCriteria(Movie_StaffCriteria movie_StaffCriteria) {
		return movie_StaffCriteria.listMovie_Staff();
	}
}
