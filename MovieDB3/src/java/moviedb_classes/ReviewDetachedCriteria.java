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

public class ReviewDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression review;
	public final IntegerExpression sound_grade;
	public final IntegerExpression story_grade;
	public final IntegerExpression direction_grade;
	public final IntegerExpression enjoyment_grade;
	public final IntegerExpression overall_grade;
	
	public ReviewDetachedCriteria() {
		super(moviedb_classes.Review.class, moviedb_classes.ReviewCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		review = new StringExpression("review", this.getDetachedCriteria());
		sound_grade = new IntegerExpression("sound_grade", this.getDetachedCriteria());
		story_grade = new IntegerExpression("story_grade", this.getDetachedCriteria());
		direction_grade = new IntegerExpression("direction_grade", this.getDetachedCriteria());
		enjoyment_grade = new IntegerExpression("enjoyment_grade", this.getDetachedCriteria());
		overall_grade = new IntegerExpression("overall_grade", this.getDetachedCriteria());
	}
	
	public ReviewDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, moviedb_classes.ReviewCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		review = new StringExpression("review", this.getDetachedCriteria());
		sound_grade = new IntegerExpression("sound_grade", this.getDetachedCriteria());
		story_grade = new IntegerExpression("story_grade", this.getDetachedCriteria());
		direction_grade = new IntegerExpression("direction_grade", this.getDetachedCriteria());
		enjoyment_grade = new IntegerExpression("enjoyment_grade", this.getDetachedCriteria());
		overall_grade = new IntegerExpression("overall_grade", this.getDetachedCriteria());
	}
	
	public Review uniqueReview(PersistentSession session) {
		return (Review) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Review[] listReview(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Review[]) list.toArray(new Review[list.size()]);
	}
}

