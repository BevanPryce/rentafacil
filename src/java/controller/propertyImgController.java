/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.Imgpropiedades;
import modeloDAO.imgpropertyDAO;

//@WebServlet("/propertyImgController")
@MultipartConfig
public class propertyImgController extends HttpServlet {
    List<InputStream> Imagenes = new ArrayList<>();
    imgpropertyDAO imgDAO = new imgpropertyDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
          

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
        //processRequest(request, response);
        
        String parametro = request.getParameter("parametro");
        //Imagenes = imgDAO.getImages(parametro);
        imgDAO.getImages(parametro,response);
        
        //request.setAttribute("imagenes", Imagenes);
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
        
        String action = request.getParameter("accion");
        System.out.println("propertyImgController/addImgProperty/ :"+action);
        String propertyid = request.getParameter("property_code");
        System.out.println("propertyImgController/addImgProperty/ :"+propertyid);
        List<Part> imgParts = new ArrayList<>();
        String full_name = request.getParameter("fullname");
        System.out.println("propertyImgController/addImgProperty/ :"+full_name);
        String owner_id;
        
        
        if(action.equalsIgnoreCase("addImgProperty")){
            //owner_id = request.getParameter("owner_id");
            for (Part part : request.getParts()) {
                if (part.getName().equals("imagen[]")) {
                    imgParts.add(part);
                }
            }
            List<InputStream> inputStreams = new ArrayList<>();
            for (Part imagen : imgParts) {
                InputStream imagenStream = imagen.getInputStream();
                inputStreams.add(imagenStream);
            }
            imgDAO = new imgpropertyDAO();
            String imgproperty_id = imgDAO.new_imgProperty();
            System.out.println("propertyImgController/addImgProperty/ :"+imgproperty_id);
            imgDAO.addImages(imgproperty_id,propertyid,inputStreams);
            String  mensaje = "Registro de Imagenes Correcto";
            //HttpSession sesion = request.getSession();
            //owner_id = sesion.getAttribute("owner_id").toString();
            //System.out.println("propertyImgController/addImgProperty/:"+owner_id);
            //sesion.setAttribute("ow_id", owner_id);
            request.setAttribute("mensaje", mensaje);
            
            
            //request.getRequestDispatcher("propertyController?accion=listarPropiedades&owner_id="+owner_id).forward(request, response);
            request.getRequestDispatcher("propertyController?accion=listarPropiedades").forward(request, response);
        }
        
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
