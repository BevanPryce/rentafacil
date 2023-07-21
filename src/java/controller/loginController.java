/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuarios;
import modeloDAO.usersDAO;

/**
 *
 * @author mrang
 */
public class loginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    usersDAO userDAO;
    Usuarios user;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String home = "home.jsp";
        String password;
        String usuario;
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("login")){
            usuario = (String)request.getParameter("txtusuario");
            password = (String)request.getParameter("txtpassword");
            userDAO = new usersDAO();
            user = userDAO.searchUser(usuario, password);
            HttpSession sesion = request.getSession();
            if(user.getUser_id()!=null && sesion.getAttribute("id")==null){
                System.out.println("Usuario: "+usuario);
                System.out.println("Password: "+password);
                String id = user.getUser_id();
                String primer_nombre = user.getUser_first_name();
                String fullname = user.getUser_first_name()+" " + user.getUser_last_name1()+" "+user.getUser_last_name2();
                int rol_id = user.getUser_role_id();
                
                sesion.setAttribute("id", id);
                sesion.setAttribute("nombre", primer_nombre);
                sesion.setAttribute("fullname", fullname);
                sesion.setAttribute("rol", rol_id);
                
                   
                request.getRequestDispatcher(home).forward(request, response);
            }
            else{
                System.out.println("Error de Usuario y/o Contraseña");
            }
        }
        
        if(action.equalsIgnoreCase("logout")){
        try{
            if(request.getSession()!=null){
                request.logout();
                request.getSession().invalidate();
                request.getRequestDispatcher(home).forward(request, response);
            }
        }
        catch(ServletException e){
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
