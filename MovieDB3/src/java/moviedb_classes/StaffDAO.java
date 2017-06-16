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

public class StaffDAO {
	public static Staff loadStaffByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadStaffByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff getStaffByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getStaffByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff loadStaffByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadStaffByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff getStaffByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return getStaffByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff loadStaffByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Staff) session.load(moviedb_classes.Staff.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff getStaffByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Staff) session.get(moviedb_classes.Staff.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff loadStaffByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Staff) session.load(moviedb_classes.Staff.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff getStaffByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Staff) session.get(moviedb_classes.Staff.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryStaff(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryStaff(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryStaff(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return queryStaff(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff[] listStaffByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listStaffByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff[] listStaffByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return listStaffByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryStaff(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Staff as Staff");
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
	
	public static List queryStaff(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Staff as Staff");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Staff", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff[] listStaffByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryStaff(session, condition, orderBy);
			return (Staff[]) list.toArray(new Staff[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff[] listStaffByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryStaff(session, condition, orderBy, lockMode);
			return (Staff[]) list.toArray(new Staff[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff loadStaffByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadStaffByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff loadStaffByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return loadStaffByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff loadStaffByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Staff[] staffs = listStaffByQuery(session, condition, orderBy);
		if (staffs != null && staffs.length > 0)
			return staffs[0];
		else
			return null;
	}
	
	public static Staff loadStaffByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Staff[] staffs = listStaffByQuery(session, condition, orderBy, lockMode);
		if (staffs != null && staffs.length > 0)
			return staffs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateStaffByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateStaffByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateStaffByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = moviedb_classes.MovieDB2PersistentManager.instance().getSession();
			return iterateStaffByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateStaffByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Staff as Staff");
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
	
	public static java.util.Iterator iterateStaffByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From moviedb_classes.Staff as Staff");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Staff", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff createStaff() {
		return new moviedb_classes.Staff();
	}
	
	public static boolean save(moviedb_classes.Staff staff) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().saveObject(staff);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(moviedb_classes.Staff staff) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().deleteObject(staff);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Staff staff)throws PersistentException {
		try {
			moviedb_classes.Movie[] lWorkeds = staff.worked.toArray();
			for(int i = 0; i < lWorkeds.length; i++) {
				lWorkeds[i].participants.remove(staff);
			}
			return delete(staff);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(moviedb_classes.Staff staff, org.orm.PersistentSession session)throws PersistentException {
		try {
			moviedb_classes.Movie[] lWorkeds = staff.worked.toArray();
			for(int i = 0; i < lWorkeds.length; i++) {
				lWorkeds[i].participants.remove(staff);
			}
			try {
				session.delete(staff);
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
	
	public static boolean refresh(moviedb_classes.Staff staff) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().refresh(staff);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(moviedb_classes.Staff staff) throws PersistentException {
		try {
			moviedb_classes.MovieDB2PersistentManager.instance().getSession().evict(staff);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Staff loadStaffByCriteria(StaffCriteria staffCriteria) {
		Staff[] staffs = listStaffByCriteria(staffCriteria);
		if(staffs == null || staffs.length == 0) {
			return null;
		}
		return staffs[0];
	}
	
	public static Staff[] listStaffByCriteria(StaffCriteria staffCriteria) {
		return staffCriteria.listStaff();
	}
}
