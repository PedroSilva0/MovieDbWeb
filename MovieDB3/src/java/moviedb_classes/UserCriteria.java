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

public class UserCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression avatar;
	public final StringExpression email;
	public final CollectionExpression watched;
	public final CollectionExpression plan_to_watch;
	public final CollectionExpression evaluated;
	public final CollectionExpression user_reviews;
	
	public UserCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		avatar = new StringExpression("avatar", this);
		email = new StringExpression("email", this);
		watched = new CollectionExpression("ORM_Watched", this);
		plan_to_watch = new CollectionExpression("ORM_Plan_to_watch", this);
		evaluated = new CollectionExpression("ORM_Evaluated", this);
		user_reviews = new CollectionExpression("ORM_User_reviews", this);
	}
	
	public UserCriteria(PersistentSession session) {
		this(session.createCriteria(User.class));
	}
	
	public UserCriteria() throws PersistentException {
		this(moviedb_classes.MovieDB2PersistentManager.instance().getSession());
	}
	
	public MovieCriteria createWatchedCriteria() {
		return new MovieCriteria(createCriteria("ORM_Watched"));
	}
	
	public MovieCriteria createPlan_to_watchCriteria() {
		return new MovieCriteria(createCriteria("ORM_Plan_to_watch"));
	}
	
	public MovieCriteria createEvaluatedCriteria() {
		return new MovieCriteria(createCriteria("ORM_Evaluated"));
	}
	
	public ReviewCriteria createUser_reviewsCriteria() {
		return new ReviewCriteria(createCriteria("ORM_User_reviews"));
	}
	
	public User uniqueUser() {
		return (User) super.uniqueResult();
	}
	
	public User[] listUser() {
		java.util.List list = super.list();
		return (User[]) list.toArray(new User[list.size()]);
	}
}

