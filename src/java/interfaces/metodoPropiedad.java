/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.Propiedad;

/**
 *
 * @author mrang
 */
public interface metodoPropiedad {
    public void addProperty(Propiedad property);
    public void deleteProperty(String property_id);
    public void updateProperty(Propiedad property);
    public ArrayList<Object> listartodasPropiedades();
    public ArrayList<Propiedad> listarPropiedades();
    public ArrayList<Propiedad> listarPropiedades(String owner_id);
    public String newProperty();
}
