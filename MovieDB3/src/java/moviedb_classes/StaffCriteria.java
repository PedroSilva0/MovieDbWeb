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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class StaffCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression role;
	public final StringExpression name;
	public final StringExpression bio;
	public final StringExpression picture;
	public final CollectionExpression worked;
	
	public StaffCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		role = new StringExpression("role", this);
		name = new StringExpression("name", this);
		bio = new StringExpression("bio", this);
		picture = new StringExpression("picture", this);
		worked = new CollectionExpression("ORM_Worked", this);
	}
	
	public StaffCriteria(PersistentSession session) {
		this(session.createCriteria(Staff.class));
	}
	
	public StaffCriteria() throws PersistentException {
		this(moviedb_classes.MovieDB2PersistentManager.instance().getSession());
	}
	
	public MovieCriteria createWorkedCriteria() {
		return new MovieCriteria(createCriteria("ORM_Worked"));
	}
	
	public Staff uniqueStaff() {
		return (Staff) super.uniqueResult();
	}
	
	public Staff[] listStaff() {
		java.util.List list = super.list();
		return (Staff[]) list.toArray(new Staff[list.size()]);
	}
}

