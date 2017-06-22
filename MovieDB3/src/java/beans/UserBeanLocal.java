/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import moviedb_classes.User;

/**
 *
 * @author Utilizador
 */
@Local
public interface UserBeanLocal {
    public User get_user_by_username(String username);
    
    public void register_user(User u);
}
