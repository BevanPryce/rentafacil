/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Imgpropiedades;

/**
 *
 * @author mrang
 */
public interface metodoImgpropiedades {
    public void addImages(String imgpropertyid, String propertyid,List<InputStream> imagenes);
    public void updImages(Imgpropiedades imgproperty);
    public void getImages(String propertyId,HttpServletResponse response);
    public ArrayList<Imgpropiedades>listarimgPropiedades();
    public String new_imgProperty();
}
