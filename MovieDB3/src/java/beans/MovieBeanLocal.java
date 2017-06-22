/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import moviedb_classes.Movie;

/**
 *
 * @author Utilizador
 */
@Local
public interface MovieBeanLocal {
    String sayHello(String name);
    
    public List<Movie> list_all_movies();

    public List<Movie> list_top_rated_movies();

    public List<Movie> list_movies_by_year();
}
