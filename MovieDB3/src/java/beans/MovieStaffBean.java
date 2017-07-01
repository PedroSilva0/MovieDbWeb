/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import moviedb_classes.MovieDB2PersistentManager;
import moviedb_classes.Movie_Staff;
import moviedb_classes.Movie_StaffDAO;
import org.orm.PersistentSession;

/**
 *
 * @author adt
 */
@Stateless
public class MovieStaffBean implements MovieStaffBeanLocal {
    
    private static PersistentSession session = null;

    @Override
    public List<Movie_Staff> getMovieCast(String condition, String orderBy) {
        PersistentSession session_aux=this.getSession();
        List<Movie_Staff> r = null;
        try {
            r = Movie_StaffDAO.queryMovie_Staff(session_aux,condition,orderBy);
            
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
