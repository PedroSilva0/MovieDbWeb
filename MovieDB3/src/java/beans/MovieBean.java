/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import moviedb_classes.Movie;
import moviedb_classes.MovieDAO;
import moviedb_classes.MovieDB2PersistentManager;
import org.orm.PersistentSession;

/**
 *
 * @author Utilizador
 */
@Stateless
public class MovieBean implements MovieBeanLocal {

    private static PersistentSession session = null;
    
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @Override
    public List<Movie> list_all_movies() {
        PersistentSession session_aux=this.getSession();
        List<Movie> r = null;
        try {
            r = MovieDAO.queryMovie(session_aux,"id>0", "Id");
            
        } catch (Exception e) {
            System.out.println("didnt get any movies");
        }
        return r;
    }

    @Override
    public List<Movie> list_top_rated_movies() {
        PersistentSession session_aux=this.getSession();
        List<Movie> r = null;
        try {
            r = MovieDAO.queryMovie(session_aux,"id>0", "rating");
            
        } catch (Exception e) {
            System.out.println("didnt get any movies");
        }
        return r;
    }

    @Override
    public List<Movie> list_movies_by_year() {
        PersistentSession session_aux=this.getSession();
        List<Movie> r = null;
        try {
            r = MovieDAO.queryMovie(session_aux,"id>0", "release_year");
            
        } catch (Exception e) {
            System.out.println("didnt get any movies");
        }
        return r;
    }
  
    
   
    
    
    private static PersistentSession getSession() {
        if (session == null) {
            try {
                session = MovieDB2PersistentManager.instance().getSession();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return session;
    }

}
