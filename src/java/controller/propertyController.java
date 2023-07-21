/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Propiedad;
import modeloDAO.propertyDAO;

/**
 *
 * @author mrang
 */
public class propertyController extends HttpServlet {
    
    Propiedad property;
    propertyDAO propiedadDAO;
    ArrayList<Propiedad>listarpropiedades;
    ArrayList<Propiedad>listatodaspropiedades;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action= request.getParameter("accion");
        String full_name = request.getParameter("full_name");
        System.out.println("Full_name: "+full_name);
        String perfil = "perfil_propietarios.jsp";
        String buscar_propiedad = "busqueda_resultados.jsp";
        
        String property_id;
        String owner_id;
        String property_address;
        String property_district;
        String property_department;
        int type_id;
        int property_room_qty;
        String property_shared_bathroom;
        String property_kitchen_room;
        String property_living_room;
        int property_capacity;
        String property_pet_friendly;
        Double property_buil_area;
        Double property_rent_price;
        String property_description;
        String property_state;

        if(action.equalsIgnoreCase("addProperty")){
            property = new Propiedad();
            propiedadDAO = new propertyDAO();
            property_id = propiedadDAO.newProperty();
            
            owner_id = request.getParameter("owner_id");
            property_address = request.getParameter("propery_address");
            property_district = request.getParameter("property_district");
            property_department = request.getParameter("property_department");
            type_id = Integer.parseInt(request.getParameter("type_id"));
            property_room_qty = Integer.parseInt(request.getParameter("propery_room_qty"));
            property_shared_bathroom = request.getParameter("property_shared_room");
            property_kitchen_room = request.getParameter("property_kitchen_room");
            property_living_room = request.getParameter("property_living_room");
            property_capacity = Integer.parseInt(request.getParameter("property_capacity"));
            property_pet_friendly = request.getParameter("property_pet_friendly");
            property_buil_area = Double.parseDouble(request.getParameter("property_build_area"));
            property_rent_price = Double.parseDouble(request.getParameter("property_rent_price"));
            property_description = request.getParameter("property_description");
            property_state = request.getParameter("property_state");
            
            
            property.setProperty_id(property_id);
            property.setOwner_id(owner_id);
            property.setProperty_address(property_address);
            property.setProperty_district(property_district);
            property.setProperty_department(property_department);
            property.setType_id(type_id);
            property.setProperty_room_qty(property_room_qty);
            property.setProperty_shared_bathroom(property_shared_bathroom);
            property.setProperty_kitchen_room(property_kitchen_room);
            property.setProperty_living_room(property_living_room);
            property.setProperty_capacity(property_capacity);
            property.setProperty_pet_friendly(property_pet_friendly);
            property.setProperty_buil_area(property_buil_area);
            property.setProperty_rent_price(property_rent_price);
            property.setProperty_description(property_description);
            property.setProperty_state(property_state);
            propiedadDAO.addProperty(property);
            
            String  mensaje = "Registro de Propiedad Correcto";
            HttpSession sesion = request.getSession();
            sesion.setAttribute("ow_id", sesion.getAttribute("id"));
            request.setAttribute("ownerid", owner_id);
            request.setAttribute("full_name", full_name);
            request.setAttribute("address", "");
            request.setAttribute("phone", "");
            request.setAttribute("mensaje", mensaje);
            
            request.getRequestDispatcher("propertyController?accion=listarPropiedades&owner_id="+owner_id).forward(request, response);
        }
        
        if(action.equalsIgnoreCase("listarPropiedades")){
            HttpSession session = request.getSession();
            Object obj;
            obj = session.getAttribute("owner_id").toString();
            System.out.println("propertyController/listarPropiedades/: "+obj.toString());
            request.setAttribute("ownerid", obj.toString());
            full_name= session.getAttribute("fullname").toString();
            request.setAttribute("full_name", full_name);
            request.setAttribute("address", "");
            request.setAttribute("phone", "");
            
            listarpropiedades = new ArrayList<>();
            property = new Propiedad();
            propiedadDAO = new propertyDAO();
            listarpropiedades = propiedadDAO.listarPropiedades(obj.toString());
            
            request.setAttribute("listapropiedades", listarpropiedades);
            
            request.getRequestDispatcher(perfil).forward(request, response);
        }
        
        if(action.equalsIgnoreCase("buscar_propiedad")){
            listatodaspropiedades = new ArrayList<>();
            property = new Propiedad();
            propiedadDAO = new propertyDAO();
            listatodaspropiedades = propiedadDAO.listarPropiedades();
            
            request.setAttribute("listatodaspropiedades", listatodaspropiedades);
            System.out.println(listatodaspropiedades);
            
            request.getRequestDispatcher(buscar_propiedad).forward(request, response);
            
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
