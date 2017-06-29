/**
 * Licensee: Universidade do Minho
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateMovieDB2Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = moviedb_classes.MovieDB2PersistentManager.instance().getSession().beginTransaction();
		try {
			moviedb_classes.Movie lmoviedb_classesMovie = moviedb_classes.MovieDAO.loadMovieByQuery(null, null);
			// Update the properties of the persistent object
			moviedb_classes.MovieDAO.save(lmoviedb_classesMovie);
			moviedb_classes.User lmoviedb_classesUser = moviedb_classes.UserDAO.loadUserByQuery(null, null);
			// Update the properties of the persistent object
			moviedb_classes.UserDAO.save(lmoviedb_classesUser);
			moviedb_classes.Staff lmoviedb_classesStaff = moviedb_classes.StaffDAO.loadStaffByQuery(null, null);
			// Update the properties of the persistent object
			moviedb_classes.StaffDAO.save(lmoviedb_classesStaff);
			moviedb_classes.Review lmoviedb_classesReview = moviedb_classes.ReviewDAO.loadReviewByQuery(null, null);
			// Update the properties of the persistent object
			moviedb_classes.ReviewDAO.save(lmoviedb_classesReview);
			moviedb_classes.Lists lmoviedb_classesLists = moviedb_classes.ListsDAO.loadListsByQuery(null, null);
			// Update the properties of the persistent object
			moviedb_classes.ListsDAO.save(lmoviedb_classesLists);
			moviedb_classes.Ratings lmoviedb_classesRatings = moviedb_classes.RatingsDAO.loadRatingsByQuery(null, null);
			// Update the properties of the persistent object
			moviedb_classes.RatingsDAO.save(lmoviedb_classesRatings);
			moviedb_classes.Movie_Staff lmoviedb_classesMovie_Staff = moviedb_classes.Movie_StaffDAO.loadMovie_StaffByQuery(null, null);
			// Update the properties of the persistent object
			moviedb_classes.Movie_StaffDAO.save(lmoviedb_classesMovie_Staff);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Movie by MovieCriteria");
		moviedb_classes.MovieCriteria lmoviedb_classesMovieCriteria = new moviedb_classes.MovieCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmoviedb_classesMovieCriteria.id.eq();
		System.out.println(lmoviedb_classesMovieCriteria.uniqueMovie());
		
		System.out.println("Retrieving User by UserCriteria");
		moviedb_classes.UserCriteria lmoviedb_classesUserCriteria = new moviedb_classes.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmoviedb_classesUserCriteria.id.eq();
		System.out.println(lmoviedb_classesUserCriteria.uniqueUser());
		
		System.out.println("Retrieving Staff by StaffCriteria");
		moviedb_classes.StaffCriteria lmoviedb_classesStaffCriteria = new moviedb_classes.StaffCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmoviedb_classesStaffCriteria.id.eq();
		System.out.println(lmoviedb_classesStaffCriteria.uniqueStaff());
		
		System.out.println("Retrieving Review by ReviewCriteria");
		moviedb_classes.ReviewCriteria lmoviedb_classesReviewCriteria = new moviedb_classes.ReviewCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmoviedb_classesReviewCriteria.id.eq();
		System.out.println(lmoviedb_classesReviewCriteria.uniqueReview());
		
		System.out.println("Retrieving Lists by ListsCriteria");
		moviedb_classes.ListsCriteria lmoviedb_classesListsCriteria = new moviedb_classes.ListsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmoviedb_classesListsCriteria.user.eq();
		//lmoviedb_classesListsCriteria.movie.eq();
		System.out.println(lmoviedb_classesListsCriteria.uniqueLists());
		
		System.out.println("Retrieving Ratings by RatingsCriteria");
		moviedb_classes.RatingsCriteria lmoviedb_classesRatingsCriteria = new moviedb_classes.RatingsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmoviedb_classesRatingsCriteria.user.eq();
		//lmoviedb_classesRatingsCriteria.movie.eq();
		System.out.println(lmoviedb_classesRatingsCriteria.uniqueRatings());
		
		System.out.println("Retrieving Movie_Staff by Movie_StaffCriteria");
		moviedb_classes.Movie_StaffCriteria lmoviedb_classesMovie_StaffCriteria = new moviedb_classes.Movie_StaffCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lmoviedb_classesMovie_StaffCriteria.movie.eq();
		//lmoviedb_classesMovie_StaffCriteria.staff.eq();
		System.out.println(lmoviedb_classesMovie_StaffCriteria.uniqueMovie_Staff());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateMovieDB2Data retrieveAndUpdateMovieDB2Data = new RetrieveAndUpdateMovieDB2Data();
			try {
				retrieveAndUpdateMovieDB2Data.retrieveAndUpdateTestData();
				//retrieveAndUpdateMovieDB2Data.retrieveByCriteria();
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
