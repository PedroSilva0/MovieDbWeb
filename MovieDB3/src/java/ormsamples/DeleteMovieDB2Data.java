/**
 * Licensee: Universidade do Minho
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteMovieDB2Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = moviedb_classes.MovieDB2PersistentManager.instance().getSession().beginTransaction();
		try {
			moviedb_classes.Movie lmoviedb_classesMovie = moviedb_classes.MovieDAO.loadMovieByQuery(null, null);
			// Delete the persistent object
			moviedb_classes.MovieDAO.delete(lmoviedb_classesMovie);
			moviedb_classes.User lmoviedb_classesUser = moviedb_classes.UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			moviedb_classes.UserDAO.delete(lmoviedb_classesUser);
			moviedb_classes.Staff lmoviedb_classesStaff = moviedb_classes.StaffDAO.loadStaffByQuery(null, null);
			// Delete the persistent object
			moviedb_classes.StaffDAO.delete(lmoviedb_classesStaff);
			moviedb_classes.Review lmoviedb_classesReview = moviedb_classes.ReviewDAO.loadReviewByQuery(null, null);
			// Delete the persistent object
			moviedb_classes.ReviewDAO.delete(lmoviedb_classesReview);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteMovieDB2Data deleteMovieDB2Data = new DeleteMovieDB2Data();
			try {
				deleteMovieDB2Data.deleteTestData();
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
