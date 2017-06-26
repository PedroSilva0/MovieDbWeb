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

public class MovieCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression duration;
	public final IntegerExpression release_day;
	public final IntegerExpression release_month;
	public final IntegerExpression release_year;
	public final FloatExpression rating;
	public final StringExpression title;
	public final StringExpression poster;
	public final StringExpression genre;
	public final StringExpression synopsys;
	public final FloatExpression box_office;
	public final CollectionExpression participants;
	public final CollectionExpression movie_reviews;
	public final CollectionExpression lists;
	public final CollectionExpression rated;
	
	public MovieCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		duration = new IntegerExpression("duration", this);
		release_day = new IntegerExpression("release_day", this);
		release_month = new IntegerExpression("release_month", this);
		release_year = new IntegerExpression("release_year", this);
		rating = new FloatExpression("rating", this);
		title = new StringExpression("title", this);
		poster = new StringExpression("poster", this);
		genre = new StringExpression("genre", this);
		synopsys = new StringExpression("synopsys", this);
		box_office = new FloatExpression("box_office", this);
		participants = new CollectionExpression("ORM_Participants", this);
		movie_reviews = new CollectionExpression("ORM_Movie_reviews", this);
		lists = new CollectionExpression("ORM_Lists", this);
		rated = new CollectionExpression("ORM_Rated", this);
	}
	
	public MovieCriteria(PersistentSession session) {
		this(session.createCriteria(Movie.class));
	}
	
	public MovieCriteria() throws PersistentException {
		this(moviedb_classes.MovieDB2PersistentManager.instance().getSession());
	}
	
	public StaffCriteria createParticipantsCriteria() {
		return new StaffCriteria(createCriteria("ORM_Participants"));
	}
	
	public ReviewCriteria createMovie_reviewsCriteria() {
		return new ReviewCriteria(createCriteria("ORM_Movie_reviews"));
	}
	
	public ListsCriteria createListsCriteria() {
		return new ListsCriteria(createCriteria("ORM_Lists"));
	}
	
	public RatingsCriteria createRatedCriteria() {
		return new RatingsCriteria(createCriteria("ORM_Rated"));
	}
	
	public Movie uniqueMovie() {
		return (Movie) super.uniqueResult();
	}
	
	public Movie[] listMovie() {
		java.util.List list = super.list();
		return (Movie[]) list.toArray(new Movie[list.size()]);
	}
}

