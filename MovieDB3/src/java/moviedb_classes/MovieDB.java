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

    static RatingsBeanLocal ratingsBean = lookupRatingsBeanLocal();

    static ListsBeanLocal listsBean = lookupListsBeanLocal();

    static UserBeanLocal userBean = lookupUserBeanLocal();

    static MovieBeanLocal movieBean = lookupMovieBeanLocal();

    public static List<Movie> list_all_movies() {
        return movieBean.list_all_movies();
    }

    public static List<Movie> list_top_rated_movies() {
        List<Movie> res = movieBean.list_top_rated_movies();
        Collections.reverse(res);
        List<Movie> final_res=new ArrayList<>();
        for(Movie m:res){
            if(m.getRating()==0){
                break;
            }
            final_res.add(m);
            if(final_res.size()==54){
                break;
            }
        }
        return final_res;
    }

    public static Movie getMovieById(String id) {
        return movieBean.getMovieByORMID(id);
    }

    public static User getUserById(String id) {
        return userBean.getUserById(id);
    }

    public static List<Movie> list_coming_soon_movies() {
        List<Movie> aux = movieBean.list_movies_by_year();
        List<Movie> res = new ArrayList<>();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int year = cal.get(Calendar.YEAR);
        Collections.reverse(aux);
        for (Movie m : aux) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, m.getRelease_year());
            if (year < m.getRelease_year()) {
                break;
            }
            calendar.set(Calendar.MONTH, m.getRelease_month() - 1);
            calendar.set(Calendar.DATE, m.getRelease_day());
            Date movie_date = calendar.getTime();
            if (movie_date.after(today)) {
                res.add(m);
            }
            if (res.size() == 54) {
                break;
            }
        }
        return res;
    }
    
    public static List<Movie> latest_releases(){
        List<Movie> aux = movieBean.list_movies_by_year();
        List<Movie> res = new ArrayList<>();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        Collections.reverse(aux);
        for (Movie m : aux) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, m.getRelease_year());
            calendar.set(Calendar.MONTH, m.getRelease_month() - 1);
            calendar.set(Calendar.DATE, m.getRelease_day());
            Date movie_date = calendar.getTime();
            if (movie_date.before(today)) {
                res.add(m);
            }
            if (res.size() == 54) {
                break;
            }
        }
        
        Collections.sort(res, new Comparator<Movie>() {
            public int compare(Movie one, Movie other) {
                return other.getDate().compareTo(one.getDate());
            }
        });
        return res;
    }

   

    public static User login(String user, String pass) {
        User u = userBean.get_user_by_username(user);
        if (u != null) {
            if (u.getPassword().equals(pass)) {
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
        System.out.println("pass: " + pwd + " pass2: " + pwd2);
        if (!pwd.equals(pwd2)) {
            return -1;
        }
        if (!validate_email(email)) {
            return -2;
        }
        User u = userBean.get_user_by_username(user);
        if (u != null) {
            return -3;
        }
        User new_user = new User();
        new_user.setAvatar("images/avatars/user2_avatar.png");
        new_user.setEmail(email);
        new_user.setPassword(pwd2);
        new_user.setUsername(user);

        userBean.register_user(new_user);
        return 1;
    }

    private static boolean validate_email(String email) {
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

    public static List<Ratings> get_user_ratings(User u) {
        List<Ratings> user_ratings = ratingsBean.get_all_ratings_of_user(u.getId());
        if (user_ratings != null) {
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
        List<Movie> res = movieBean.list_top_rated_movies();
        List<Movie> final_res = new ArrayList<>();
        Collections.reverse(res);
        if (res.size() > i + 20) {
            res = res.subList(i, i + 20);
        } else {
            res = res.subList(i, res.size());
        }
        for (Movie m : res) {
            if (m.getRating() > 0) {
                final_res.add(m);
            }
        }
        return final_res;
    }

    public static User get_user(String username) {
        System.out.println("tentei ir buscar user");
        User u = userBean.get_user_by_username(username);
        if(u==null){
            System.out.println("nao encontrou o user");
        }
        return u;
    }

    public static List<Movie> list_user_list(int i, int id, String list_type) {
        List<Lists> aux = listsBean.get_list(id, list_type);
        List<Movie> res = new ArrayList<>();
        for (Lists l : aux) {
            res.add(l.getMovie());
        }

        Collections.sort(res, new Comparator<Movie>() {
            public int compare(Movie one, Movie other) {
                return one.getTitle().compareTo(other.getTitle());
            }
        });
        //Collections.reverse(res);
        if (res.size() > i + 20) {
            res = res.subList(i, i + 20);
        } else {
            res = res.subList(i, res.size());
        }
        return res;
    }

    public static void remove_from_list(int user_id, int movie_id, String list_type) {
        listsBean.remove_from_list(user_id, movie_id, list_type);
        movieBean.clear();
        userBean.clear();
    }

    public static List<Staff> getMovieCast(String movieId) {
        List<Staff> actors = new ArrayList<>();
        try {
            List<Integer> actorIds = Movie_StaffDAO.queryMovie_Staff("MovieId=" + movieId, "StaffId");
            for (int actorId : actorIds) {
                actors.add(StaffDAO.getStaffByORMID(actorId));
            }
        } catch (PersistentException ex) {
            Logger.getLogger(MovieDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actors;
    }

    public static Movie get_movie(String movie_name) {
        return movieBean.getMovie(movie_name);
    }

    public static List<Movie> list_coming_soon_movies(int i) {
        List<Movie> aux = movieBean.list_movies_by_year();
        List<Movie> res = new ArrayList<>();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int year = cal.get(Calendar.YEAR);
        Collections.reverse(aux);
        for (Movie m : aux) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, m.getRelease_year());
            if (year < m.getRelease_year()) {
                break;
            }
            calendar.set(Calendar.MONTH, m.getRelease_month() - 1);
            calendar.set(Calendar.DATE, m.getRelease_day());
            Date movie_date = calendar.getTime();
            if (movie_date.after(today)) {
                res.add(m);
            }
        }
        if (res.size() > i + 20) {
            res = res.subList(i, i + 20);
        } else {
            res = res.subList(i, res.size());
        }
        return res;
    }

    public static List<Movie> latest_releases(int i) {
        List<Movie> aux = movieBean.list_movies_by_year();
        List<Movie> res = new ArrayList<>();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        Collections.reverse(aux);
        for (Movie m : aux) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, m.getRelease_year());
            calendar.set(Calendar.MONTH, m.getRelease_month() - 1);
            calendar.set(Calendar.DATE, m.getRelease_day());
            Date movie_date = calendar.getTime();
            if (movie_date.before(today)) {
                res.add(m);
            }
            if (res.size() == 54) {
                break;
            }
        }
        
        Collections.sort(res, new Comparator<Movie>() {
            public int compare(Movie one, Movie other) {
                return other.getDate().compareTo(one.getDate());
            }
        });
        
        if (res.size() > i + 20) {
            res = res.subList(i, i + 20);
        } else {
            res = res.subList(i, res.size());
        }
        return res;
    }

    public static void delete_list(String id, String list_name) {
        System.out.println("cheguei a moviedb");
       listsBean.remove_list(id,list_name);
    }

}
