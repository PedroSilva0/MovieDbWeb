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

public class Review {
	public Review() {
	}
	
	private int id;
	
	private String review;
	
	private int sound_grade;
	
	private int story_grade;
	
	private int direction_grade;
	
	private int enjoyment_grade;
	
	private int overall_grade;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setReview(String value) {
		this.review = value;
	}
	
	public String getReview() {
		return review;
	}
	
	public void setSound_grade(int value) {
		this.sound_grade = value;
	}
	
	public int getSound_grade() {
		return sound_grade;
	}
	
	public void setStory_grade(int value) {
		this.story_grade = value;
	}
	
	public int getStory_grade() {
		return story_grade;
	}
	
	public void setDirection_grade(int value) {
		this.direction_grade = value;
	}
	
	public int getDirection_grade() {
		return direction_grade;
	}
	
	public void setEnjoyment_grade(int value) {
		this.enjoyment_grade = value;
	}
	
	public int getEnjoyment_grade() {
		return enjoyment_grade;
	}
	
	public void setOverall_grade(int value) {
		this.overall_grade = value;
	}
	
	public int getOverall_grade() {
		return overall_grade;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
