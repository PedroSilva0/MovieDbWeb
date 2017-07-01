/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import moviedb_classes.MovieDB2PersistentManager;
import moviedb_classes.User;
import moviedb_classes.UserDAO;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author Utilizador
 */
@Stateless
public class UserBean implements UserBeanLocal {

   private static PersistentSession session = null;
   
   @Override
    public User get_user_by_username(String username) {
        PersistentSession session_aux=this.getSession();
        User r= null;
        try {
            r = UserDAO.loadUserByQuery(session_aux,"username='"+username+"'", "username");
            
        } catch (Exception e) {
            System.out.println("didnt get any users");
        }
        return r;
    }

    @Override
    public void register_user(User u) {
        PersistentSession session_aux=this.getSession();
       try {
           UserDAO.save(u);
           //session.clear();
       } catch (PersistentException ex) {
           System.out.println("Não registou");
       }
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
   
    @Override
    public User getUserById(String id){
       User u = null;
       try {
           u = UserDAO.getUserByORMID(Integer.parseInt(id));
       } catch (PersistentException ex) {
           Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
       }
       return u;
   }

    @Override
    public void clear() {
        session.clear();
    }
    
    
    
}
