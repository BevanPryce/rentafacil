/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuarios;
import modeloDAO.usersDAO;

/**
 *
 * @author mrang
 */
public class userController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Usuarios user;
    usersDAO userDAO;
    String user_id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String home = "home.jsp";
            String action = request.getParameter("accion");
            String first_name = request.getParameter("user_first_name");
            String last_name_1 = request.getParameter("user_last_name_1");
            String last_name_2 = request.getParameter("user_last_name_2");
            String user_doi = request.getParameter("user_doi");
            String user_email = request.getParameter("user_email");
            String user_pwd = request.getParameter("user_pwd");
            int rol_id = Integer.parseInt(request.getParameter("role_id"));
            String full_name = first_name + " " + last_name_1 + " " + last_name_2;
            System.out.println("userController/fullname: "+full_name);
            //userDAO = new usersDAO();
            //String user_id = userDAO.newUser();
            
            
            if(action.equalsIgnoreCase("newUser")){
                user = new Usuarios();
                userDAO = new usersDAO();
                user_id = userDAO.newUser();
                System.out.println("Nuevo usuario: "+user_id);
                user.setUser_id(user_id);
                user.setUser_first_name(first_name);
                user.setUser_last_name1(last_name_1);
                user.setUser_last_name2(last_name_2);
                user.setUser_doi(user_doi);
                user.setUser_email(user_email);
                user.setUser_pwd(user_pwd);
                user.setUser_role_id(rol_id);
                userDAO.addUser(user);
                if(rol_id==1){
                    request.getRequestDispatcher("ownerController?accion=newOwner&user="+user_id+"&fullname="+full_name).forward(request, response);
                }
                else{
                    request.getRequestDispatcher(home).forward(request, response);
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
