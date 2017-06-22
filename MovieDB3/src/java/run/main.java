/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import java.util.ArrayList;
import java.util.List;
import moviedb_classes.Movie;
import moviedb_classes.MovieDAO;
import moviedb_classes.MovieDB;
import moviedb_classes.User;
import moviedb_classes.UserDAO;

/**
 *
 * @author Utilizador
 */
public class main {

    public static void main(String[] args) {
        List<Movie> aux= new ArrayList<Movie>();
        aux=MovieDB.list_all_movies();
        System.out.println(aux.get(0).getTitle());
       /*List<Movie> r = MovieDB.list_all_movies();
       System.out.println(r.size());*/
    }

}
