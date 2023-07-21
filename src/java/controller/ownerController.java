/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Propietarios;
import modeloDAO.ownersDAO;

/**
 *
 * @author mrang
 */
public class ownerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Propietarios owner;
    ownersDAO ownerDAO;
    String newowner;
    String mensaje;
    ArrayList<Propietarios>propietario;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String home = "home.jsp";
        String perfil = "perfil_propietarios.jsp";
        
        String action = request.getParameter("accion");
        String user_id = request.getParameter("user");
        String full_name = request.getParameter("fullname");
        
        String owner_id = request.getParameter("owner_id");
        System.out.println("ownerController/owner_id="+owner_id);
        String owner_address = request.getParameter("owner_address");
        String owner_phone = request.getParameter("owner_phone");
        
        //ownerDAO = new ownersDAO();
        //String newowner;// = ownerDAO.newOwner();
        //System.out.println("Nuevo propietario: "+ newowner);
        //System.out.print("usuario: "+user_id);
        
        if(action.equalsIgnoreCase("newOwner")){
            owner = new Propietarios();
            ownerDAO = new ownersDAO();
            newowner = ownerDAO.newOwner();
            owner.setOwner_id(newowner);
            owner.setOwner_fullname(full_name);
            owner.setOwner_address("");
            owner.setOwner_phone("");
            owner.setUser_id(user_id);
            ownerDAO.addOwner(owner);
            request.getRequestDispatcher(home).forward(request, response);
        }
        
        if(action.equals("ownerPerfil")){
            //propietario = new ArrayList<>();
            HttpSession sesion = request.getSession();
            
            ownerDAO = new ownersDAO();
            propietario = ownerDAO.listarPropietario(sesion.getAttribute("id").toString());
            String ownerid = propietario.get(0).getOwner_id();
            System.out.println("ownerController/ownerPerfil/: "+ownerid);
            String userid = propietario.get(0).getUser_id();
            //String fullname = propietario.get(0).getOwner_fullname();
            String fullname = sesion.getAttribute("fullname").toString();
            String address = propietario.get(0).getOwner_address();
            String phone = propietario.get(0).getOwner_phone();
            String msg = "Bienvenido "+fullname;
            request.setAttribute("mensaje", msg);
            sesion.setAttribute("owner_id", ownerid);
            sesion.setAttribute("fullname", fullname);
            System.out.println("ownerController/ownerPerfil/: "+ownerid);
            
            request.setAttribute("ownerid", ownerid);
            request.setAttribute("userid", userid);
            request.setAttribute("fullname", fullname);
            request.setAttribute("address", address);
            request.setAttribute("phone", phone);
            
            request.getRequestDispatcher("propertyController?accion=listarPropiedades").forward(request, response);
            //request.getRequestDispatcher(perfil).forward(request, response);
        }
        
        if(action.endsWith("ownerUPD")){
            ownerDAO = new ownersDAO();
            ownerDAO.updateOwner(owner_id, owner_address, owner_phone);
            mensaje = "Datos actualizados correctamente";
            HttpSession sesion = request.getSession();
            sesion.setAttribute("id", sesion.getAttribute("id"));
            request.setAttribute("ownerid", owner_id);
            request.setAttribute("full_name", full_name);
            request.setAttribute("address", "");
            request.setAttribute("phone", "");
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("propertyController?accion=listarPropiedades").forward(request, response);
            //response.sendRedirect(perfil);
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
