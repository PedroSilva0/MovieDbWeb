/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import moviedb_classes.Lists;
import moviedb_classes.ListsDAO;
import moviedb_classes.Movie;
import moviedb_classes.MovieDAO;
import moviedb_classes.MovieDB2PersistentManager;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author Utilizador
 */
@Stateless
public class ListsBean implements ListsBeanLocal {
    
     private static PersistentSession session = null;

    @Override
    public List<Lists> get_user_lists(int user_id) {
        PersistentSession session_aux=this.getSession();
        List<Lists> r = null;
        try {
            r = ListsDAO.queryLists(session_aux,"userid="+user_id, "userid");
            
        } catch (Exception e) {
            System.out.println("didnt get any lists");
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
    
    
    @Override
    public List<Lists> get_list(int id, String list_type) {
        PersistentSession session_aux=this.getSession();
        List<Lists> r = null;
        try {
            r = ListsDAO.queryLists(session_aux,"userid="+id+"and list_name='"+list_type+"'", "userid");
            
        } catch (Exception e) {
            System.out.println("didnt get any lists");
        }
        return r;
    }

    @Override
    public void remove_from_list(int user_id, int movie_id, String list_type) {
            PersistentSession session_aux=this.getSession();
            List<Lists> r = null;
         try {
             r = ListsDAO.queryLists(session_aux,"userid="+user_id+"and list_name='"+list_type+"' and movieid="+movie_id, "userid");
             System.out.println("vou apagar");
             ListsDAO.delete(r.get(0));
         } catch (PersistentException ex) {
             System.out.println("dele falhou");
         }
    }
    
    
}
