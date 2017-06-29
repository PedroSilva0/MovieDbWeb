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
		
		System.out.println("Listing Lists...");
		moviedb_classes.Lists[] moviedb_classesListses = moviedb_classes.ListsDAO.listListsByQuery(null, null);
		length = Math.min(moviedb_classesListses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(moviedb_classesListses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ratings...");
		moviedb_classes.Ratings[] moviedb_classesRatingses = moviedb_classes.RatingsDAO.listRatingsByQuery(null, null);
		length = Math.min(moviedb_classesRatingses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(moviedb_classesRatingses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Movie_Staff...");
		moviedb_classes.Movie_Staff[] moviedb_classesMovie_Staffs = moviedb_classes.Movie_StaffDAO.listMovie_StaffByQuery(null, null);
		length = Math.min(moviedb_classesMovie_Staffs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(moviedb_classesMovie_Staffs[i]);
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
		
		System.out.println("Listing Lists by Criteria...");
		moviedb_classes.ListsCriteria lmoviedb_classesListsCriteria = new moviedb_classes.ListsCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//moviedb_classes.UserCriteria lmoviedb_classesListsCriteria_User = lmoviedb_classesListsCriteria.createUserCriteria();
		//lmoviedb_classesListsCriteria_User.id.eq();
		//moviedb_classes.MovieCriteria lmoviedb_classesListsCriteria_Movie = lmoviedb_classesListsCriteria.createMovieCriteria();
		//lmoviedb_classesListsCriteria_Movie.id.eq();
		lmoviedb_classesListsCriteria.setMaxResults(ROW_COUNT);
		moviedb_classes.Lists[] moviedb_classesListses = lmoviedb_classesListsCriteria.listLists();
		length =moviedb_classesListses== null ? 0 : Math.min(moviedb_classesListses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(moviedb_classesListses[i]);
		}
		System.out.println(length + " Lists record(s) retrieved."); 
		
		System.out.println("Listing Ratings by Criteria...");
		moviedb_classes.RatingsCriteria lmoviedb_classesRatingsCriteria = new moviedb_classes.RatingsCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//moviedb_classes.UserCriteria lmoviedb_classesRatingsCriteria_User = lmoviedb_classesRatingsCriteria.createUserCriteria();
		//lmoviedb_classesRatingsCriteria_User.id.eq();
		//moviedb_classes.MovieCriteria lmoviedb_classesRatingsCriteria_Movie = lmoviedb_classesRatingsCriteria.createMovieCriteria();
		//lmoviedb_classesRatingsCriteria_Movie.id.eq();
		lmoviedb_classesRatingsCriteria.setMaxResults(ROW_COUNT);
		moviedb_classes.Ratings[] moviedb_classesRatingses = lmoviedb_classesRatingsCriteria.listRatings();
		length =moviedb_classesRatingses== null ? 0 : Math.min(moviedb_classesRatingses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(moviedb_classesRatingses[i]);
		}
		System.out.println(length + " Ratings record(s) retrieved."); 
		
		System.out.println("Listing Movie_Staff by Criteria...");
		moviedb_classes.Movie_StaffCriteria lmoviedb_classesMovie_StaffCriteria = new moviedb_classes.Movie_StaffCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//moviedb_classes.MovieCriteria lmoviedb_classesMovie_StaffCriteria_Movie = lmoviedb_classesMovie_StaffCriteria.createMovieCriteria();
		//lmoviedb_classesMovie_StaffCriteria_Movie.id.eq();
		//moviedb_classes.StaffCriteria lmoviedb_classesMovie_StaffCriteria_Staff = lmoviedb_classesMovie_StaffCriteria.createStaffCriteria();
		//lmoviedb_classesMovie_StaffCriteria_Staff.id.eq();
		lmoviedb_classesMovie_StaffCriteria.setMaxResults(ROW_COUNT);
		moviedb_classes.Movie_Staff[] moviedb_classesMovie_Staffs = lmoviedb_classesMovie_StaffCriteria.listMovie_Staff();
		length =moviedb_classesMovie_Staffs== null ? 0 : Math.min(moviedb_classesMovie_Staffs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(moviedb_classesMovie_Staffs[i]);
		}
		System.out.println(length + " Movie_Staff record(s) retrieved."); 
		
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
