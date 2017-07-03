/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import moviedb_classes.Ratings;

/**
 *
 * @author Utilizador
 */
@Local
public interface RatingsBeanLocal {

    public List<Ratings> get_all_ratings_of_user(int userId);
    
    public void saveRating(Ratings rating);
    
}
