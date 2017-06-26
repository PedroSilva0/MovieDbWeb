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

import java.io.Serializable;
public class Ratings implements Serializable {
	public Ratings() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Ratings))
			return false;
		Ratings ratings = (Ratings)aObj;
		if (getUser() == null) {
			if (ratings.getUser() != null)
				return false;
		}
		else if (!getUser().equals(ratings.getUser()))
			return false;
		if (getMovie() == null) {
			if (ratings.getMovie() != null)
				return false;
		}
		else if (!getMovie().equals(ratings.getMovie()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getUser() != null) {
			hashcode = hashcode + (int) getUser().getORMID();
		}
		if (getMovie() != null) {
			hashcode = hashcode + (int) getMovie().getORMID();
		}
		return hashcode;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == moviedb_classes.ORMConstants.KEY_RATINGS_USER) {
			this.user = (moviedb_classes.User) owner;
		}
		
		else if (key == moviedb_classes.ORMConstants.KEY_RATINGS_MOVIE) {
			this.movie = (moviedb_classes.Movie) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private moviedb_classes.User user;
	
	private int userId;
	
	private void setUserId(int value) {
		this.userId = value;
	}
	
	public int getUserId() {
		return userId;
	}
	
	private moviedb_classes.Movie movie;
	
	private int movieId;
	
	private void setMovieId(int value) {
		this.movieId = value;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	private Integer rating;
	
	public void setRating(int value) {
		setRating(new Integer(value));
	}
	
	public void setRating(Integer value) {
		this.rating = value;
	}
	
	public Integer getRating() {
		return rating;
	}
	
	public void setUser(moviedb_classes.User value) {
		if (user != null) {
			user.evaluated.remove(this);
		}
		if (value != null) {
			value.evaluated.add(this);
		}
	}
	
	public moviedb_classes.User getUser() {
		return user;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_User(moviedb_classes.User value) {
		this.user = value;
	}
	
	private moviedb_classes.User getORM_User() {
		return user;
	}
	
	public void setMovie(moviedb_classes.Movie value) {
		if (movie != null) {
			movie.rated.remove(this);
		}
		if (value != null) {
			value.rated.add(this);
		}
	}
	
	public moviedb_classes.Movie getMovie() {
		return movie;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Movie(moviedb_classes.Movie value) {
		this.movie = value;
	}
	
	private moviedb_classes.Movie getORM_Movie() {
		return movie;
	}
	
	public String toString() {
		return String.valueOf(((getUser() == null) ? "" : String.valueOf(getUser().getORMID())) + " " + ((getMovie() == null) ? "" : String.valueOf(getMovie().getORMID())));
	}
	
}
