/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moviedb_classes.Movie;
import moviedb_classes.MovieDB;
import moviedb_classes.Ratings;
import moviedb_classes.User;

/**
 *
 * @author Utilizador
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        System.out.println(user);
        String pwd = request.getParameter("password");
        if (request.getParameter("log_state") != null) {
            System.out.println("entrei em log state");
            int log_state = Integer.parseInt(request.getParameter("log_state"));
            System.out.println(log_state);
            if (log_state == 1) {
                User u= MovieDB.get_user(user);
                request.setAttribute("user", u);
                        List<Movie> r = MovieDB.list_all_movies();
                        List<Movie> c = MovieDB.list_coming_soon_movies();
                        List<Movie> l = MovieDB.latest_releases();
                        Map<String, List<Movie>> lists = MovieDB.get_user_lists(u);
                        List<Ratings> ratings = MovieDB.get_user_ratings(u);
                        request.setAttribute("ratings", ratings);
                        request.setAttribute("lists", lists);
                        request.setAttribute("top_movies", r);
                        request.setAttribute("coming_soon", c);
                        request.setAttribute("latest", l);
                        request.getRequestDispatcher("/WEB-INF/LoginSucessfull.jsp").forward(request, response);
            }
        } else {
            if (request.getAttribute("log_state") != null) {
                int log_state = (int) request.getAttribute("log_state");
                System.out.println(log_state);
                if (log_state == 1) {
                User u= MovieDB.get_user(user);
                    request.setAttribute("user", u);
                        List<Movie> r = MovieDB.list_all_movies();
                        List<Movie> c = MovieDB.list_coming_soon_movies();
                        List<Movie> l = MovieDB.latest_releases();
                        Map<String, List<Movie>> lists = MovieDB.get_user_lists(u);
                        List<Ratings> ratings = MovieDB.get_user_ratings(u);
                        request.setAttribute("ratings", ratings);
                        request.setAttribute("lists", lists);
                        request.setAttribute("top_movies", r);
                        request.setAttribute("coming_soon", c);
                        request.setAttribute("latest", l);
                        request.getRequestDispatcher("/WEB-INF/LoginSucessfull.jsp").forward(request, response);
                } 
            }else {

                    User u = MovieDB.login(user, pwd);

                    if (u != null) {
                        request.setAttribute("user", u);
                        List<Movie> r = MovieDB.list_all_movies();
                        List<Movie> c = MovieDB.list_coming_soon_movies();
                        List<Movie> l = MovieDB.latest_releases();
                        Map<String, List<Movie>> lists = MovieDB.get_user_lists(u);
                        List<Ratings> ratings = MovieDB.get_user_ratings(u);
                        request.setAttribute("ratings", ratings);
                        request.setAttribute("lists", lists);
                        request.setAttribute("top_movies", r);
                        request.setAttribute("coming_soon", c);
                        request.setAttribute("latest", l);
                        request.getRequestDispatcher("/WEB-INF/LoginSucessfull.jsp").forward(request, response);
                    } else {
                        request.setAttribute("log_state", -1);
                        request.getRequestDispatcher("/WEB-INF/Login_Page.jsp").forward(request, response);
                    }
                }

            }
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
