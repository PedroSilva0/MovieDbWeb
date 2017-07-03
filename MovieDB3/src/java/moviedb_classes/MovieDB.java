/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedb_classes;

//import Beans.MovieBeanLocal;
import beans.ListsBeanLocal;
import beans.MovieBean;
import beans.MovieBeanLocal;
import beans.MovieStaffBeanLocal;
import beans.RatingsBeanLocal;
import beans.UserBeanLocal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.orm.PersistentException;
/**
 *
 * @author Utilizador
 */
public class MovieDB {

    static MovieStaffBeanLocal movieStaffBean = lookupMovieStaffBeanLocal();

    static RatingsBeanLocal ratingsBean = lookupRatingsBeanLocal();

    static ListsBeanLocal listsBean = lookupListsBeanLocal();

    static UserBeanLocal userBean = lookupUserBeanLocal();

    static MovieBeanLocal movieBean = lookupMovieBeanLocal();

   
    
    public static List<Movie> list_all_movies(){
        return movieBean.list_all_movies();
    }
    
    public static List<Movie> list_top_rated_movies(){
        List<Movie> res= movieBean.list_top_rated_movies();
        Collections.reverse(res);
        if(res.size()>54){
            res=res.subList(0, 54);
        }
        return res;
    }
    
    public static Movie getMovieById(String id){
        return movieBean.getMovieByORMID(id);
    }
    
    public static User getUserById(String id){
        return userBean.getUserById(id);
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
    
    public static User login(String user,String pass){
        User u= userBean.get_user_by_username(user);
        if(u!=null){
            if(u.getPassword().equals(pass)){
                return u;
            }
        }
        return null; 
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

    private static UserBeanLocal lookupUserBeanLocal() {
        try {
            Context c = new InitialContext();
            return (UserBeanLocal) c.lookup("java:global/MovieDB3/UserBean!beans.UserBeanLocal");
        } catch (NamingException ne) {
            System.out.println("erro no beans de user");
            throw new RuntimeException(ne);
        }
    }
    
    

    public static int register(String user, String email, String pwd, String pwd2) {
        System.out.println("pass: "+ pwd+" pass2: "+pwd2 );
        if(!pwd.equals(pwd2)){
            return -1;
        }
        if(!validate_email(email)){
            return -2;
        }
        User u= userBean.get_user_by_username(user);
        if(u!=null){
            return -3;
        }
        User new_user= new User();
        new_user.setAvatar("/image/avatar/default.png");
        new_user.setEmail(email);
        new_user.setPassword(pwd2);
        new_user.setUsername(user);
        
        userBean.register_user(new_user);
        return 1;
    }
    
    private static boolean validate_email(String email){
        Pattern ptr = Pattern.compile("(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)");
        return ptr.matcher(email).matches(); 
    }

    public static Map<String, List<Movie>> get_user_lists(User u) {
        List<Lists> user_lists_data = listsBean.get_user_lists(u.getId());
        Map<String, List<Movie>> user_lists = new TreeMap<>();
        if (user_lists_data != null) {
            for (Lists l : user_lists_data) {
                List<Movie> aux = user_lists.get(l.getList_name());
                if (aux != null) {
                    aux.add(l.getMovie());
                    user_lists.put(l.getList_name(), aux);
                } else {
                    aux = new ArrayList<Movie>();
                    aux.add(l.getMovie());
                    user_lists.put(l.getList_name(), aux);
                }
            }
        }
        return user_lists;
    }
    
    public static List<Ratings> get_user_ratings(User u){
        List<Ratings> user_ratings=ratingsBean.get_all_ratings_of_user(u.getId());
        if(user_ratings!=null){
            Collections.reverse(user_ratings);
            return user_ratings;
        }
        return new ArrayList<>();
    }

    private static ListsBeanLocal lookupListsBeanLocal() {
        try {
            Context c = new InitialContext();
            return (ListsBeanLocal) c.lookup("java:global/MovieDB3/ListsBean!beans.ListsBeanLocal");
        } catch (NamingException ne) {
            System.out.println("problem in lists bean");
            throw new RuntimeException(ne);
        }
    }

    private static RatingsBeanLocal lookupRatingsBeanLocal() {
        try {
            Context c = new InitialContext();
            return (RatingsBeanLocal) c.lookup("java:global/MovieDB3/RatingsBean!beans.RatingsBeanLocal");
        } catch (NamingException ne) {
            System.out.println("problem with ratings bean");
            throw new RuntimeException(ne);
        }
    }

    public static List<Movie> list_top_rated_movies(int i) {
        List<Movie> res= movieBean.list_top_rated_movies();
        Collections.reverse(res);
        if(res.size()>i+20){
            res=res.subList(i,i+20);
        }else{
            res=res.subList(i,i+res.size());
        }
        return res;
    }

    public static User get_user(String username) {
        User u= userBean.get_user_by_username(username);
        return u;
    }

    public static List<Movie> list_user_list(int i, int id, String list_type) {
        List<Lists> aux= listsBean.get_list(id,list_type);
        List<Movie> res= new ArrayList<>();
        for(Lists l:aux){
            res.add(l.getMovie());
        }
        
        Collections.sort(res, new Comparator<Movie>() {
    public int compare(Movie one, Movie other) {
        return one.getTitle().compareTo(other.getTitle());
    }
}); 
        //Collections.reverse(res);
        if(res.size()>i+20){
            res=res.subList(i,i+20);
        }else{
            res=res.subList(i,i+res.size());
        }
        return res;
    }

    public static void remove_from_list(int user_id, int movie_id, String list_type) {
        listsBean.remove_from_list(user_id,movie_id,list_type);
    }

    public static List<Staff> getMovieCast(String movieId){
        List<Staff> actors = new ArrayList<>();
        List<Movie_Staff> records = movieStaffBean.getMovieCast("movieId="+movieId,"staffId");
        for(Movie_Staff ms : records)
            actors.add(ms.getStaff());
        return actors;
    }
    
    public static void saveRating(User user, Movie movie, int rating) {
        Ratings stars = new Ratings();
        stars.setUser(user);
        stars.setMovie(movie);
        stars.setRating(rating);
        ratingsBean.saveRating(stars);
    }

    private static MovieStaffBeanLocal lookupMovieStaffBeanLocal() {
        try {
            Context c = new InitialContext();
            return (MovieStaffBeanLocal) c.lookup("java:global/MovieDB3/MovieStaffBean!beans.MovieStaffBeanLocal");
        } catch (NamingException ne) {
            System.out.println("erro no moviestaff bean");
            throw new RuntimeException(ne);
        }
    }
}
