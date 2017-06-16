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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class StaffDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression role;
	public final StringExpression name;
	public final StringExpression bio;
	public final StringExpression picture;
	public final CollectionExpression worked;
	
	public StaffDetachedCriteria() {
		super(moviedb_classes.Staff.class, moviedb_classes.StaffCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		role = new StringExpression("role", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		bio = new StringExpression("bio", this.getDetachedCriteria());
		picture = new StringExpression("picture", this.getDetachedCriteria());
		worked = new CollectionExpression("ORM_Worked", this.getDetachedCriteria());
	}
	
	public StaffDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, moviedb_classes.StaffCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		role = new StringExpression("role", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		bio = new StringExpression("bio", this.getDetachedCriteria());
		picture = new StringExpression("picture", this.getDetachedCriteria());
		worked = new CollectionExpression("ORM_Worked", this.getDetachedCriteria());
	}
	
	public MovieDetachedCriteria createWorkedCriteria() {
		return new MovieDetachedCriteria(createCriteria("ORM_Worked"));
	}
	
	public Staff uniqueStaff(PersistentSession session) {
		return (Staff) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Staff[] listStaff(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Staff[]) list.toArray(new Staff[list.size()]);
	}
}

