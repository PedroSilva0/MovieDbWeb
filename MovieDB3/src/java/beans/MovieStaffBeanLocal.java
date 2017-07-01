/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import moviedb_classes.Movie_Staff;

/**
 *
 * @author adt
 */
@Local
public interface MovieStaffBeanLocal {
    public List<Movie_Staff> getMovieCast(String condition, String orderBy);
}
