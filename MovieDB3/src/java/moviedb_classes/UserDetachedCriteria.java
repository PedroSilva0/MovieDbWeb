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

public class UserDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression avatar;
	public final StringExpression email;
	public final CollectionExpression user_reviews;
	public final CollectionExpression lists;
	public final CollectionExpression evaluated;
	
	public UserDetachedCriteria() {
		super(moviedb_classes.User.class, moviedb_classes.UserCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		user_reviews = new CollectionExpression("ORM_User_reviews", this.getDetachedCriteria());
		lists = new CollectionExpression("ORM_Lists", this.getDetachedCriteria());
		evaluated = new CollectionExpression("ORM_Evaluated", this.getDetachedCriteria());
	}
	
	public UserDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, moviedb_classes.UserCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		user_reviews = new CollectionExpression("ORM_User_reviews", this.getDetachedCriteria());
		lists = new CollectionExpression("ORM_Lists", this.getDetachedCriteria());
		evaluated = new CollectionExpression("ORM_Evaluated", this.getDetachedCriteria());
	}
	
	public ReviewDetachedCriteria createUser_reviewsCriteria() {
		return new ReviewDetachedCriteria(createCriteria("ORM_User_reviews"));
	}
	
	public ListsDetachedCriteria createListsCriteria() {
		return new ListsDetachedCriteria(createCriteria("ORM_Lists"));
	}
	
	public RatingsDetachedCriteria createEvaluatedCriteria() {
		return new RatingsDetachedCriteria(createCriteria("ORM_Evaluated"));
	}
	
	public User uniqueUser(PersistentSession session) {
		return (User) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public User[] listUser(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (User[]) list.toArray(new User[list.size()]);
	}
}

