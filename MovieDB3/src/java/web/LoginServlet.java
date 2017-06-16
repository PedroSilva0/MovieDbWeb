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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moviedb_classes.User;
import moviedb_classes.UserDAO;
import org.orm.PersistentException;

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
            
            String user = request.getParameter("name");
            String pwd = request.getParameter("password");
            System.out.println("User: "+ user);
            System.out.println("Password: "+pwd);
            
            List<User> users = new ArrayList<User>();
        try {
            users = UserDAO.queryUser("username='"+user+"'","Username");
            System.out.println(users.size());
        } catch (PersistentException ex) {
            System.out.println("Nao peguei no user");
        }
            System.out.println(users.size());
            if(users.size()>0){
                User u = users.get(0);
                if(u.getPassword().equals(pwd)){
                  request.setAttribute("user", u.getUsername());
                  request.getRequestDispatcher("/WEB-INF/LoginSucessfull.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("user", "login falhado");
                request.getRequestDispatcher("/WEB-INF/LoginSucessfull.jsp").forward(request, response);
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
