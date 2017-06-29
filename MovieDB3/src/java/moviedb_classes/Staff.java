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

public class Staff {
	public Staff() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == moviedb_classes.ORMConstants.KEY_STAFF_WORKED) {
			return ORM_worked;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String name;
	
	private String bio;
	
	private String picture;
	
	private java.util.Set ORM_worked = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBio(String value) {
		this.bio = value;
	}
	
	public String getBio() {
		return bio;
	}
	
	public void setPicture(String value) {
		this.picture = value;
	}
	
	public String getPicture() {
		return picture;
	}
	
	private void setORM_Worked(java.util.Set value) {
		this.ORM_worked = value;
	}
	
	private java.util.Set getORM_Worked() {
		return ORM_worked;
	}
	
	public final moviedb_classes.Movie_StaffSetCollection worked = new moviedb_classes.Movie_StaffSetCollection(this, _ormAdapter, moviedb_classes.ORMConstants.KEY_STAFF_WORKED, moviedb_classes.ORMConstants.KEY_MOVIE_STAFF_STAFF, moviedb_classes.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
