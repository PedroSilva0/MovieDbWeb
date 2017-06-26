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

public class User {
	public User() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == moviedb_classes.ORMConstants.KEY_USER_USER_REVIEWS) {
			return ORM_user_reviews;
		}
		else if (key == moviedb_classes.ORMConstants.KEY_USER_LISTS) {
			return ORM_lists;
		}
		else if (key == moviedb_classes.ORMConstants.KEY_USER_EVALUATED) {
			return ORM_evaluated;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String avatar;
	
	private String email;
	
	private java.util.Set ORM_user_reviews = new java.util.HashSet();
	
	private java.util.Set ORM_lists = new java.util.HashSet();
	
	private java.util.Set ORM_evaluated = new java.util.HashSet();
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setAvatar(String value) {
		this.avatar = value;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	private void setORM_User_reviews(java.util.Set value) {
		this.ORM_user_reviews = value;
	}
	
	private java.util.Set getORM_User_reviews() {
		return ORM_user_reviews;
	}
	
	public final moviedb_classes.ReviewSetCollection user_reviews = new moviedb_classes.ReviewSetCollection(this, _ormAdapter, moviedb_classes.ORMConstants.KEY_USER_USER_REVIEWS, moviedb_classes.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Lists(java.util.Set value) {
		this.ORM_lists = value;
	}
	
	private java.util.Set getORM_Lists() {
		return ORM_lists;
	}
	
	public final moviedb_classes.ListsSetCollection lists = new moviedb_classes.ListsSetCollection(this, _ormAdapter, moviedb_classes.ORMConstants.KEY_USER_LISTS, moviedb_classes.ORMConstants.KEY_LISTS_USER, moviedb_classes.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Evaluated(java.util.Set value) {
		this.ORM_evaluated = value;
	}
	
	private java.util.Set getORM_Evaluated() {
		return ORM_evaluated;
	}
	
	public final moviedb_classes.RatingsSetCollection evaluated = new moviedb_classes.RatingsSetCollection(this, _ormAdapter, moviedb_classes.ORMConstants.KEY_USER_EVALUATED, moviedb_classes.ORMConstants.KEY_RATINGS_USER, moviedb_classes.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
