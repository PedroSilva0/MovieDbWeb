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

public class Movie_StaffCriteria extends AbstractORMCriteria {
	public final IntegerExpression movieId;
	public final AssociationExpression movie;
	public final IntegerExpression staffId;
	public final AssociationExpression staff;
	public final StringExpression role;
	
	public Movie_StaffCriteria(Criteria criteria) {
		super(criteria);
		movieId = new IntegerExpression("ORM_Movie.id", this);
		movie = new AssociationExpression("ORM_Movie", this);
		staffId = new IntegerExpression("ORM_Staff.id", this);
		staff = new AssociationExpression("ORM_Staff", this);
		role = new StringExpression("role", this);
	}
	
	public Movie_StaffCriteria(PersistentSession session) {
		this(session.createCriteria(Movie_Staff.class));
	}
	
	public Movie_StaffCriteria() throws PersistentException {
		this(moviedb_classes.MovieDB2PersistentManager.instance().getSession());
	}
	
	public MovieCriteria createMovieCriteria() {
		return new MovieCriteria(createCriteria("ORM_Movie"));
	}
	
	public StaffCriteria createStaffCriteria() {
		return new StaffCriteria(createCriteria("ORM_Staff"));
	}
	
	public Movie_Staff uniqueMovie_Staff() {
		return (Movie_Staff) super.uniqueResult();
	}
	
	public Movie_Staff[] listMovie_Staff() {
		java.util.List list = super.list();
		return (Movie_Staff[]) list.toArray(new Movie_Staff[list.size()]);
	}
}

