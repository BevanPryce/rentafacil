/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import configuracion.Conexion;
import interfaces.metodoImgpropiedades;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Imgpropiedades;

/**
 *
 * @author mrang
 */
public class imgpropertyDAO implements metodoImgpropiedades{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String picpropertyid;

    @Override
    public void addImages(String imgpropertyid, String propertyid,List<InputStream> imagenes) {
        try {
            System.out.println("Codigo-Propiedad: " + propertyid);
            String sql = "INSERT INTO imagenes_propiedad (pic_property_id, property_id, pic1_property, pic2_property, pic3_property) VALUES (?, ?, ?, ?, ?)";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, imgpropertyid);
            ps.setString(2, propertyid);
            
            // Convertir las imágenes en objetos Blob y establecer los parámetros en la consulta
            for (int i = 0; i < 3; i++) {
                if (i < imagenes.size()) {
                    InputStream imagenStream = imagenes.get(i);
                    ps.setBlob(i + 3,imagenStream);
                    System.out.println("imgpropertyDAO: "+ imagenes.get(i));
                } else {
                    ps.setNull(i + 3, Types.BLOB);
                }
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(imgpropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updImages(Imgpropiedades imgproperty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Imgpropiedades> listarimgPropiedades() {
        ArrayList<Imgpropiedades>listarimgPropiedades = new ArrayList<>();
        try{
            String sql = "Select * from imagenes_propiedad";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Imgpropiedades imgpropiedades = new Imgpropiedades();
                imgpropiedades.setPic_property_id(rs.getString("pic_property_id"));
                imgpropiedades.setProperty_id(rs.getString("property_id"));

                Blob pic1Blob = rs.getBlob("pic1_property");
                if (pic1Blob != null) {
                    imgpropiedades.setPic1_property(pic1Blob.getBinaryStream());
                }

                Blob pic2Blob = rs.getBlob("pic2_property");
                if (pic2Blob != null) {
                    imgpropiedades.setPic2_property(pic2Blob.getBinaryStream());
                }

                Blob pic3Blob = rs.getBlob("pic3_property");
                if (pic3Blob != null) {
                    imgpropiedades.setPic3_property(pic3Blob.getBinaryStream());
                }
                
            //    imgpropiedades.setPic1_property(rs.getBlob("pic1_property").getBinaryStream());
              //  imgpropiedades.setPic2_property(rs.getBlob("pic2_property").getBinaryStream());
               // imgpropiedades.setPic3_property(rs.getBlob("pic3_property").getBinaryStream());
                listarimgPropiedades.add(imgpropiedades);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(imgpropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarimgPropiedades;
    }
    
    @Override
    public void getImages(String propertyId, HttpServletResponse response) {
    String sql = "SELECT pic1_property, pic2_property, pic3_property FROM imagenes_propiedad WHERE property_id = ?";
    InputStream inputstream = null;
    OutputStream outputstream = null;
    BufferedInputStream bufferedinputstream =null;
    BufferedOutputStream bufferedoutstream =null;
    try {
        outputstream = response.getOutputStream();
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, propertyId);
        rs = ps.executeQuery();

        if (rs.next()) {
            inputstream = rs.getBinaryStream("pic1_property");
        }
        bufferedinputstream = new BufferedInputStream(inputstream);
        bufferedoutstream =new BufferedOutputStream(outputstream);
        int i=0;
        while((i=bufferedinputstream.read())!=-1){
            bufferedoutstream.write(i);
        }
    }
    catch (IOException | SQLException ex) {
        Logger.getLogger(imgpropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}
      

        
    @Override
    public String new_imgProperty() {
    ArrayList<Imgpropiedades>allProperties = listarimgPropiedades();
    try{
        int total_imgproperties = allProperties.size()+1;
        String formato="00000";
        DecimalFormat objf= new DecimalFormat(formato);
        picpropertyid = "IMG"+objf.format(total_imgproperties);
        System.out.println("Img_Propiedad id: "+picpropertyid);
    }
    catch(UnknownError ue){
        Logger.getLogger(propertyDAO.class.getName()).log(Level.SEVERE, null, ue);
    }
    return picpropertyid;

    }
}
