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

public class RatingsCriteria extends AbstractORMCriteria {
	public final IntegerExpression userId;
	public final AssociationExpression user;
	public final IntegerExpression movieId;
	public final AssociationExpression movie;
	public final IntegerExpression rating;
	
	public RatingsCriteria(Criteria criteria) {
		super(criteria);
		userId = new IntegerExpression("ORM_User.id", this);
		user = new AssociationExpression("ORM_User", this);
		movieId = new IntegerExpression("ORM_Movie.id", this);
		movie = new AssociationExpression("ORM_Movie", this);
		rating = new IntegerExpression("rating", this);
	}
	
	public RatingsCriteria(PersistentSession session) {
		this(session.createCriteria(Ratings.class));
	}
	
	public RatingsCriteria() throws PersistentException {
		this(moviedb_classes.MovieDB2PersistentManager.instance().getSession());
	}
	
	public UserCriteria createUserCriteria() {
		return new UserCriteria(createCriteria("ORM_User"));
	}
	
	public MovieCriteria createMovieCriteria() {
		return new MovieCriteria(createCriteria("ORM_Movie"));
	}
	
	public Ratings uniqueRatings() {
		return (Ratings) super.uniqueResult();
	}
	
	public Ratings[] listRatings() {
		java.util.List list = super.list();
		return (Ratings[]) list.toArray(new Ratings[list.size()]);
	}
}

