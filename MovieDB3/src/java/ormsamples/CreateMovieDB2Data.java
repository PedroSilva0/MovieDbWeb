/**
 * Licensee: Universidade do Minho
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateMovieDB2Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = moviedb_classes.MovieDB2PersistentManager.instance().getSession().beginTransaction();
		try {
			moviedb_classes.Movie lmoviedb_classesMovie = moviedb_classes.MovieDAO.createMovie();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : movie_reviews, participants, rated, box_office, rating, release_year, release_month, release_day, duration
			moviedb_classes.MovieDAO.save(lmoviedb_classesMovie);
			moviedb_classes.User lmoviedb_classesUser = moviedb_classes.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : user_reviews, evaluated, plan_to_watch, watched
			moviedb_classes.UserDAO.save(lmoviedb_classesUser);
			moviedb_classes.Staff lmoviedb_classesStaff = moviedb_classes.StaffDAO.createStaff();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : worked
			moviedb_classes.StaffDAO.save(lmoviedb_classesStaff);
			moviedb_classes.Review lmoviedb_classesReview = moviedb_classes.ReviewDAO.createReview();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : overall_grade, enjoyment_grade, direction_grade, story_grade, sound_grade
			moviedb_classes.ReviewDAO.save(lmoviedb_classesReview);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateMovieDB2Data createMovieDB2Data = new CreateMovieDB2Data();
			try {
				createMovieDB2Data.createTestData();
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
