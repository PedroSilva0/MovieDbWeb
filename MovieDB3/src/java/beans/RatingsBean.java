/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import moviedb_classes.Lists;
import moviedb_classes.ListsDAO;
import moviedb_classes.MovieDB2PersistentManager;
import moviedb_classes.Ratings;
import moviedb_classes.RatingsDAO;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

/**
 *
 * @author Utilizador
 */
@Stateless
public class RatingsBean implements RatingsBeanLocal {
    
    private static PersistentSession session = null;

    public List<Ratings> get_all_ratings_of_user(int userId){
        PersistentSession session_aux=this.getSession();
        List<Ratings> r = null;
        try {
            r = RatingsDAO.queryRatings(session_aux,"userid="+userId, "rating");
            
        } catch (Exception e) {
            System.out.println("didnt get any ratings");
        }
        return r;
    }
    
    private static PersistentSession getSession() {
        if (session == null) {
            try {
                session = MovieDB2PersistentManager.instance().getSession();
                session.setFlushMode(FlushMode.ALWAYS);
                session.setCacheMode(CacheMode.REFRESH);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return session;
    }
    
    public void saveRating(Ratings rating) {
        PersistentSession session_aux=this.getSession();
        try {
           PersistentTransaction t=session_aux.beginTransaction();
           RatingsDAO.save(rating);
           t.commit();
           session.flush();
           session.clear();
       } catch (PersistentException ex) {
           System.out.println("Não registou");
       }
    }
}
