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

public class ReviewCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression review;
	public final IntegerExpression sound_grade;
	public final IntegerExpression story_grade;
	public final IntegerExpression direction_grade;
	public final IntegerExpression enjoyment_grade;
	public final IntegerExpression overall_grade;
	
	public ReviewCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		review = new StringExpression("review", this);
		sound_grade = new IntegerExpression("sound_grade", this);
		story_grade = new IntegerExpression("story_grade", this);
		direction_grade = new IntegerExpression("direction_grade", this);
		enjoyment_grade = new IntegerExpression("enjoyment_grade", this);
		overall_grade = new IntegerExpression("overall_grade", this);
	}
	
	public ReviewCriteria(PersistentSession session) {
		this(session.createCriteria(Review.class));
	}
	
	public ReviewCriteria() throws PersistentException {
		this(moviedb_classes.MovieDB2PersistentManager.instance().getSession());
	}
	
	public Review uniqueReview() {
		return (Review) super.uniqueResult();
	}
	
	public Review[] listReview() {
		java.util.List list = super.list();
		return (Review[]) list.toArray(new Review[list.size()]);
	}
}

