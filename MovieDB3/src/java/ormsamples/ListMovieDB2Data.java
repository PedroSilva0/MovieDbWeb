/**
 * Licensee: Universidade do Minho
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListMovieDB2Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Movie...");
		moviedb_classes.Movie[] moviedb_classesMovies = moviedb_classes.MovieDAO.listMovieByQuery(null, null);
		int length = Math.min(moviedb_classesMovies.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(moviedb_classesMovies[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing User...");
		moviedb_classes.User[] moviedb_classesUsers = moviedb_classes.UserDAO.listUserByQuery(null, null);
		length = Math.min(moviedb_classesUsers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(moviedb_classesUsers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Staff...");
		moviedb_classes.Staff[] moviedb_classesStaffs = moviedb_classes.StaffDAO.listStaffByQuery(null, null);
		length = Math.min(moviedb_classesStaffs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(moviedb_classesStaffs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Review...");
		moviedb_classes.Review[] moviedb_classesReviews = moviedb_classes.ReviewDAO.listReviewByQuery(null, null);
		length = Math.min(moviedb_classesReviews.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(moviedb_classesReviews[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Movie by Criteria...");
		moviedb_classes.MovieCriteria lmoviedb_classesMovieCriteria = new moviedb_classes.MovieCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmoviedb_classesMovieCriteria.id.eq();
		lmoviedb_classesMovieCriteria.setMaxResults(ROW_COUNT);
		moviedb_classes.Movie[] moviedb_classesMovies = lmoviedb_classesMovieCriteria.listMovie();
		int length =moviedb_classesMovies== null ? 0 : Math.min(moviedb_classesMovies.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(moviedb_classesMovies[i]);
		}
		System.out.println(length + " Movie record(s) retrieved."); 
		
		System.out.println("Listing User by Criteria...");
		moviedb_classes.UserCriteria lmoviedb_classesUserCriteria = new moviedb_classes.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmoviedb_classesUserCriteria.id.eq();
		lmoviedb_classesUserCriteria.setMaxResults(ROW_COUNT);
		moviedb_classes.User[] moviedb_classesUsers = lmoviedb_classesUserCriteria.listUser();
		length =moviedb_classesUsers== null ? 0 : Math.min(moviedb_classesUsers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(moviedb_classesUsers[i]);
		}
		System.out.println(length + " User record(s) retrieved."); 
		
		System.out.println("Listing Staff by Criteria...");
		moviedb_classes.StaffCriteria lmoviedb_classesStaffCriteria = new moviedb_classes.StaffCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmoviedb_classesStaffCriteria.id.eq();
		lmoviedb_classesStaffCriteria.setMaxResults(ROW_COUNT);
		moviedb_classes.Staff[] moviedb_classesStaffs = lmoviedb_classesStaffCriteria.listStaff();
		length =moviedb_classesStaffs== null ? 0 : Math.min(moviedb_classesStaffs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(moviedb_classesStaffs[i]);
		}
		System.out.println(length + " Staff record(s) retrieved."); 
		
		System.out.println("Listing Review by Criteria...");
		moviedb_classes.ReviewCriteria lmoviedb_classesReviewCriteria = new moviedb_classes.ReviewCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lmoviedb_classesReviewCriteria.id.eq();
		lmoviedb_classesReviewCriteria.setMaxResults(ROW_COUNT);
		moviedb_classes.Review[] moviedb_classesReviews = lmoviedb_classesReviewCriteria.listReview();
		length =moviedb_classesReviews== null ? 0 : Math.min(moviedb_classesReviews.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(moviedb_classesReviews[i]);
		}
		System.out.println(length + " Review record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListMovieDB2Data listMovieDB2Data = new ListMovieDB2Data();
			try {
				listMovieDB2Data.listTestData();
				//listMovieDB2Data.listByCriteria();
			}
			finally {
				moviedb_classes.MovieDB2PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
