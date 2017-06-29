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
public class Movie_Staff implements Serializable {
	public Movie_Staff() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Movie_Staff))
			return false;
		Movie_Staff movie_staff = (Movie_Staff)aObj;
		if (getMovie() == null) {
			if (movie_staff.getMovie() != null)
				return false;
		}
		else if (!getMovie().equals(movie_staff.getMovie()))
			return false;
		if (getStaff() == null) {
			if (movie_staff.getStaff() != null)
				return false;
		}
		else if (!getStaff().equals(movie_staff.getStaff()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getMovie() != null) {
			hashcode = hashcode + (int) getMovie().getORMID();
		}
		if (getStaff() != null) {
			hashcode = hashcode + (int) getStaff().getORMID();
		}
		return hashcode;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == moviedb_classes.ORMConstants.KEY_MOVIE_STAFF_MOVIE) {
			this.movie = (moviedb_classes.Movie) owner;
		}
		
		else if (key == moviedb_classes.ORMConstants.KEY_MOVIE_STAFF_STAFF) {
			this.staff = (moviedb_classes.Staff) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private moviedb_classes.Movie movie;
	
	private int movieId;
	
	private void setMovieId(int value) {
		this.movieId = value;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	private moviedb_classes.Staff staff;
	
	private int staffId;
	
	private void setStaffId(int value) {
		this.staffId = value;
	}
	
	public int getStaffId() {
		return staffId;
	}
	
	private String role;
	
	public void setRole(String value) {
		this.role = value;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setMovie(moviedb_classes.Movie value) {
		if (movie != null) {
			movie.participants.remove(this);
		}
		if (value != null) {
			value.participants.add(this);
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
	
	public void setStaff(moviedb_classes.Staff value) {
		if (staff != null) {
			staff.worked.remove(this);
		}
		if (value != null) {
			value.worked.add(this);
		}
	}
	
	public moviedb_classes.Staff getStaff() {
		return staff;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Staff(moviedb_classes.Staff value) {
		this.staff = value;
	}
	
	private moviedb_classes.Staff getORM_Staff() {
		return staff;
	}
	
	public String toString() {
		return String.valueOf(((getMovie() == null) ? "" : String.valueOf(getMovie().getORMID())) + " " + ((getStaff() == null) ? "" : String.valueOf(getStaff().getORMID())));
	}
	
}
