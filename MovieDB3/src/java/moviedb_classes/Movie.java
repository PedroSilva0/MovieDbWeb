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

import java.util.Calendar;
import java.util.Date;

public class Movie {
	public Movie() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == moviedb_classes.ORMConstants.KEY_MOVIE_MOVIE_REVIEWS) {
			return ORM_movie_reviews;
		}
		else if (key == moviedb_classes.ORMConstants.KEY_MOVIE_LISTS) {
			return ORM_lists;
		}
		else if (key == moviedb_classes.ORMConstants.KEY_MOVIE_RATED) {
			return ORM_rated;
		}
		else if (key == moviedb_classes.ORMConstants.KEY_MOVIE_PARTICIPANTS) {
			return ORM_participants;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private int duration;
	
	private int release_day;
	
	private int release_month;
	
	private int release_year;
	
	private float rating;
	
	private String title;
	
	private String poster;
	
	private String genre;
	
	private String synopsys;
	
	private float box_office;
	
	private java.util.Set ORM_movie_reviews = new java.util.HashSet();
	
	private java.util.Set ORM_lists = new java.util.HashSet();
	
	private java.util.Set ORM_rated = new java.util.HashSet();
	
	private java.util.Set ORM_participants = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDuration(int value) {
		this.duration = value;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setRelease_day(int value) {
		this.release_day = value;
	}
	
	public int getRelease_day() {
		return release_day;
	}
	
	public void setRelease_month(int value) {
		this.release_month = value;
	}
	
	public int getRelease_month() {
		return release_month;
	}
	
	public void setRelease_year(int value) {
		this.release_year = value;
	}
	
	public int getRelease_year() {
		return release_year;
	}
	
	public void setRating(float value) {
		this.rating = value;
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setPoster(String value) {
		this.poster = value;
	}
	
	public String getPoster() {
		return poster;
	}
	
	public void setGenre(String value) {
		this.genre = value;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setSynopsys(String value) {
		this.synopsys = value;
	}
	
	public String getSynopsys() {
		return synopsys;
	}
	
	public void setBox_office(float value) {
		this.box_office = value;
	}
	
	public float getBox_office() {
		return box_office;
	}
	
	private void setORM_Movie_reviews(java.util.Set value) {
		this.ORM_movie_reviews = value;
	}
	
	private java.util.Set getORM_Movie_reviews() {
		return ORM_movie_reviews;
	}
	
	public final moviedb_classes.ReviewSetCollection movie_reviews = new moviedb_classes.ReviewSetCollection(this, _ormAdapter, moviedb_classes.ORMConstants.KEY_MOVIE_MOVIE_REVIEWS, moviedb_classes.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Lists(java.util.Set value) {
		this.ORM_lists = value;
	}
	
	private java.util.Set getORM_Lists() {
		return ORM_lists;
	}
	
	public final moviedb_classes.ListsSetCollection lists = new moviedb_classes.ListsSetCollection(this, _ormAdapter, moviedb_classes.ORMConstants.KEY_MOVIE_LISTS, moviedb_classes.ORMConstants.KEY_LISTS_MOVIE, moviedb_classes.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Rated(java.util.Set value) {
		this.ORM_rated = value;
	}
	
	private java.util.Set getORM_Rated() {
		return ORM_rated;
	}
	
	public final moviedb_classes.RatingsSetCollection rated = new moviedb_classes.RatingsSetCollection(this, _ormAdapter, moviedb_classes.ORMConstants.KEY_MOVIE_RATED, moviedb_classes.ORMConstants.KEY_RATINGS_MOVIE, moviedb_classes.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Participants(java.util.Set value) {
		this.ORM_participants = value;
	}
	
	private java.util.Set getORM_Participants() {
		return ORM_participants;
	}
	
	public final moviedb_classes.Movie_StaffSetCollection participants = new moviedb_classes.Movie_StaffSetCollection(this, _ormAdapter, moviedb_classes.ORMConstants.KEY_MOVIE_PARTICIPANTS, moviedb_classes.ORMConstants.KEY_MOVIE_STAFF_MOVIE, moviedb_classes.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}

    public Date getDate() {
        Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, this.getRelease_year());
            calendar.set(Calendar.MONTH, this.getRelease_month() - 1);
            calendar.set(Calendar.DATE, this.getRelease_day());
            Date movie_date = calendar.getTime();
            return movie_date;
    }
	
}
