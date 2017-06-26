/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import moviedb_classes.User;
import moviedb_classes.UserDAO;

/**
 *
 * @author Utilizador
 */
public class main {

    public static void main(String[] args) {
        User u = new User();
        u.setAvatar("C:\\MovieDB_images\\avatars\\default");
        u.setEmail("mail@mail.com");
        u.setPassword("pass1");
        u.setUsername("User1");
        try {
            UserDAO.save(u);
        } catch (Exception e) {
            System.out.println("didn't save user");
        }

        try {
            User b = UserDAO.getUserByORMID(1);
            System.out.println("Loaded A with id " + b.getId());
            
        } catch (Exception e) {
            System.out.println("didnt load user");
        }
        //To list all the entities, it is possible to use following code.
        try {
            User[] r = UserDAO.listUserByQuery("id>0", "Id");
            System.out.println("Retrieved " + r.length + " entries");
            
        } catch (Exception e) {
            System.out.println("didnt get any users");
        }
    }

}
