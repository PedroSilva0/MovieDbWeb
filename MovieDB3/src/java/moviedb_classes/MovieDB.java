/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedb_classes;

//import Beans.MovieBeanLocal;
import beans.MovieBeanLocal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
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
        
        return movieBean.list_all_movies();
    }
    
    public static List<Movie> list_top_rated_movies(){
        List<Movie> res= movieBean.list_top_rated_movies();
        Collections.reverse(res);
        res=res.subList(0, 5);
        return res;
    }
    
    public static List<Movie> list_coming_soon_movies(){
        List<Movie> aux = movieBean.list_movies_by_year();
        List<Movie> res = new ArrayList<>();
        Date today=new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int year = cal.get(Calendar.YEAR);
        Collections.reverse(aux);
        for (Movie m : aux) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, m.getRelease_year());
            if(year< m.getRelease_year()){
                break;
            }
            calendar.set(Calendar.MONTH, m.getRelease_month() - 1);
            calendar.set(Calendar.DATE, m.getRelease_day() );
            Date movie_date = calendar.getTime();
            if(movie_date.after(today)){
                res.add(m);
            }
            if(res.size()==5){
                break;
            }
        }
        return res;
    }
    
    public static List<Movie> list_in_cinema_movies(){
        List<Movie> aux = movieBean.list_movies_by_year();
        List<Movie> res = new ArrayList<>();
        Date today=new Date();
        Date two_weeks_ago;
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -14);
        two_weeks_ago=cal.getTime();
        int year = cal.get(Calendar.YEAR);
        Collections.reverse(aux);
        for (Movie m : aux) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, m.getRelease_year());
            if(year< m.getRelease_year()){
                break;
            }
            calendar.set(Calendar.MONTH, m.getRelease_month() - 1);
            calendar.set(Calendar.DATE, m.getRelease_day() );
            Date movie_date = calendar.getTime();
            if(movie_date.before(today)&&movie_date.after(two_weeks_ago)){
                res.add(m);
            }
            if(res.size()==5){
                break;
            }
        }
        return res;
    
    }

    private static MovieBeanLocal lookupMovieBeanLocal() {
        try {
            Context c = new InitialContext();
            return (MovieBeanLocal) c.lookup("java:global/MovieDB3/MovieBean!beans.MovieBeanLocal");
        } catch (NamingException ne) {
            System.out.println("Erro no bean");
            throw new RuntimeException(ne);
        }
    }

    
    
    

    
    
}
