/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moviedb_classes.Movie;
import moviedb_classes.MovieDB;
import moviedb_classes.User;

/**
 *
 * @author Utilizador
 */
@WebServlet(name = "Website_List", urlPatterns = {"/Website_List"})
public class Website_List extends HttpServlet {

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
        
        
        User u= null;
        String list_type = request.getParameter("list_name").toString().replaceAll("_", " ");
        System.out.println(list_type);
        int start_point=Integer.parseInt(request.getParameter("bot_limit"));
        System.out.println(start_point);
        List<Movie> r = new ArrayList<Movie>();
        if(request.getParameter("user")!=null){
            String username=request.getParameter("user");
            u = MovieDB.get_user(username);
        }
        
        switch (list_type){
            case "Top Rated":
                r= MovieDB.list_top_rated_movies(start_point);
                break;
            case "Coming Soon":
                r=MovieDB.list_coming_soon_movies(start_point);
                break;
            case "Latest Releases":
                r=MovieDB.latest_releases(start_point);
                break;
                
        }
        //System.out.println("entrei");
        
        
        
        request.setAttribute("list", r);
        request.setAttribute("list_name", list_type);
        request.setAttribute("start",start_point);
        request.setAttribute("user",u);
        //request.setAttribute("user",u);
        request.getRequestDispatcher("/WEB-INF/Website_Lists.jsp").forward(request, response);
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
