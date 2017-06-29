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

public class MovieDetachedCriteria extends AbstractORMDetachedCriteria {
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
	public final CollectionExpression movie_reviews;
	public final CollectionExpression lists;
	public final CollectionExpression rated;
	public final CollectionExpression participants;
	
	public MovieDetachedCriteria() {
		super(moviedb_classes.Movie.class, moviedb_classes.MovieCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		duration = new IntegerExpression("duration", this.getDetachedCriteria());
		release_day = new IntegerExpression("release_day", this.getDetachedCriteria());
		release_month = new IntegerExpression("release_month", this.getDetachedCriteria());
		release_year = new IntegerExpression("release_year", this.getDetachedCriteria());
		rating = new FloatExpression("rating", this.getDetachedCriteria());
		title = new StringExpression("title", this.getDetachedCriteria());
		poster = new StringExpression("poster", this.getDetachedCriteria());
		genre = new StringExpression("genre", this.getDetachedCriteria());
		synopsys = new StringExpression("synopsys", this.getDetachedCriteria());
		box_office = new FloatExpression("box_office", this.getDetachedCriteria());
		movie_reviews = new CollectionExpression("ORM_Movie_reviews", this.getDetachedCriteria());
		lists = new CollectionExpression("ORM_Lists", this.getDetachedCriteria());
		rated = new CollectionExpression("ORM_Rated", this.getDetachedCriteria());
		participants = new CollectionExpression("ORM_Participants", this.getDetachedCriteria());
	}
	
	public MovieDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, moviedb_classes.MovieCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		duration = new IntegerExpression("duration", this.getDetachedCriteria());
		release_day = new IntegerExpression("release_day", this.getDetachedCriteria());
		release_month = new IntegerExpression("release_month", this.getDetachedCriteria());
		release_year = new IntegerExpression("release_year", this.getDetachedCriteria());
		rating = new FloatExpression("rating", this.getDetachedCriteria());
		title = new StringExpression("title", this.getDetachedCriteria());
		poster = new StringExpression("poster", this.getDetachedCriteria());
		genre = new StringExpression("genre", this.getDetachedCriteria());
		synopsys = new StringExpression("synopsys", this.getDetachedCriteria());
		box_office = new FloatExpression("box_office", this.getDetachedCriteria());
		movie_reviews = new CollectionExpression("ORM_Movie_reviews", this.getDetachedCriteria());
		lists = new CollectionExpression("ORM_Lists", this.getDetachedCriteria());
		rated = new CollectionExpression("ORM_Rated", this.getDetachedCriteria());
		participants = new CollectionExpression("ORM_Participants", this.getDetachedCriteria());
	}
	
	public ReviewDetachedCriteria createMovie_reviewsCriteria() {
		return new ReviewDetachedCriteria(createCriteria("ORM_Movie_reviews"));
	}
	
	public ListsDetachedCriteria createListsCriteria() {
		return new ListsDetachedCriteria(createCriteria("ORM_Lists"));
	}
	
	public RatingsDetachedCriteria createRatedCriteria() {
		return new RatingsDetachedCriteria(createCriteria("ORM_Rated"));
	}
	
	public Movie_StaffDetachedCriteria createParticipantsCriteria() {
		return new Movie_StaffDetachedCriteria(createCriteria("ORM_Participants"));
	}
	
	public Movie uniqueMovie(PersistentSession session) {
		return (Movie) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Movie[] listMovie(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Movie[]) list.toArray(new Movie[list.size()]);
	}
}

