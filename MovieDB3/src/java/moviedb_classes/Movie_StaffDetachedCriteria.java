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

public class Movie_StaffDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression movieId;
	public final AssociationExpression movie;
	public final IntegerExpression staffId;
	public final AssociationExpression staff;
	public final StringExpression role;
	
	public Movie_StaffDetachedCriteria() {
		super(moviedb_classes.Movie_Staff.class, moviedb_classes.Movie_StaffCriteria.class);
		movieId = new IntegerExpression("ORM_Movie.id", this.getDetachedCriteria());
		movie = new AssociationExpression("ORM_Movie", this.getDetachedCriteria());
		staffId = new IntegerExpression("ORM_Staff.id", this.getDetachedCriteria());
		staff = new AssociationExpression("ORM_Staff", this.getDetachedCriteria());
		role = new StringExpression("role", this.getDetachedCriteria());
	}
	
	public Movie_StaffDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, moviedb_classes.Movie_StaffCriteria.class);
		movieId = new IntegerExpression("ORM_Movie.id", this.getDetachedCriteria());
		movie = new AssociationExpression("ORM_Movie", this.getDetachedCriteria());
		staffId = new IntegerExpression("ORM_Staff.id", this.getDetachedCriteria());
		staff = new AssociationExpression("ORM_Staff", this.getDetachedCriteria());
		role = new StringExpression("role", this.getDetachedCriteria());
	}
	
	public MovieDetachedCriteria createMovieCriteria() {
		return new MovieDetachedCriteria(createCriteria("ORM_Movie"));
	}
	
	public StaffDetachedCriteria createStaffCriteria() {
		return new StaffDetachedCriteria(createCriteria("ORM_Staff"));
	}
	
	public Movie_Staff uniqueMovie_Staff(PersistentSession session) {
		return (Movie_Staff) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Movie_Staff[] listMovie_Staff(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Movie_Staff[]) list.toArray(new Movie_Staff[list.size()]);
	}
}

