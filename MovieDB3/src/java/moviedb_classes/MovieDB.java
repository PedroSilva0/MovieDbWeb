/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedb_classes;

//import Beans.MovieBeanLocal;
import beans.MovieBeanLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Utilizador
 */
public class MovieDB {

    static MovieBeanLocal movieBean = lookupMovieBeanLocal();

   

   
    
    public static List<Movie> list_all_movies(){
        System.out.println("entrei 2");
        return movieBean.list_all_movies();
    }

    private static MovieBeanLocal lookupMovieBeanLocal() {
        try {
            Context c = new InitialContext();
            return (MovieBeanLocal) c.lookup("java:global/MovieDB3/MovieBean!beans.MovieBeanLocal");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

    
    
    

    
    
}
