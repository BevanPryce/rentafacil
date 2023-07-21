/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import configuracion.Conexion;
import interfaces.metodoPropiedad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Propiedad;
import modelo.Tipopropiedad;

/**
 *
 * @author mrang
 */
public class propertyDAO implements metodoPropiedad{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Propiedad property;
    Tipopropiedad type_property;
    String propertyid;
    Object obj;

    @Override
    public void addProperty(Propiedad property) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            String sql="insert into propiedad(property_id, owner_id, property_address, property_district, property_department, type_id, property_room_qty, property_shared_bathroom, property_kitchen_room, property_living_room, property_capacity, property_pet_friendly, property_built_area, property_rent_price, property_description, property_state)"
            + "values('"+property.getProperty_id()+"', '"+property.getOwner_id()+"', '"+property.getProperty_address()+"', '"+property.getProperty_district()+"', '"+property.getProperty_department()+"', '"+property.getType_id()+"', '"+property.getProperty_room_qty()+"', '"+property.getProperty_shared_bathroom()+"', '"+property.getProperty_kitchen_room()+"', '"+property.getProperty_living_room()+"', '"+property.getProperty_capacity()+"', '"+property.getProperty_pet_friendly()+"', '"+property.getProperty_buil_area()+"', '"+property.getProperty_rent_price()+"', '"+property.getProperty_description()+"', '"+property.getProperty_state()+"')";
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(propertyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteProperty(String property_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProperty(Propiedad property) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> listartodasPropiedades() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Object>listartodaspropiedades= new ArrayList<>();
        try{
            String sql ="SELECT DISTINCT * FROM propiedad LEFT JOIN tipo_propiedad ON propiedad.type_id = tipo_propiedad.type_id LEFT JOIN imagenes_propiedad ON imagenes_propiedad.property_id = propiedad.property_id";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                property = new Propiedad();
                type_property = new Tipopropiedad();
                
                property.setProperty_id(rs.getString("property_id"));
                property.setOwner_id(rs.getString("owner_id"));
                property.setProperty_address(rs.getString("property_address"));
                property.setProperty_district(rs.getString("property_district"));
                property.setProperty_department(rs.getString("property_department"));
                property.setType_id(rs.getInt("type_id"));
                property.setProperty_room_qty(rs.getInt("property_room_qty"));
                property.setProperty_shared_bathroom(rs.getString("property_shared_bathroom"));
                property.setProperty_kitchen_room(rs.getString("property_kitchen_room"));
                property.setProperty_living_room(rs.getString("property_living_room"));
                property.setProperty_capacity(rs.getInt("property_capacity"));
                property.setProperty_pet_friendly(rs.getString("property_pet_friendly"));
                property.setProperty_buil_area(rs.getDouble("property_built_area"));
                property.setProperty_rent_price(rs.getDouble("property_rent_price"));
                property.setProperty_description(rs.getString("property_description"));
                property.setProperty_state(rs.getString("property_state"));
                
                type_property.setDesc_type(sql);
                
                listartodaspropiedades.add(property);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(propertyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listartodaspropiedades;
    }

    @Override
    public ArrayList<Propiedad> listarPropiedades() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Propiedad>listarpropiedades= new ArrayList<>();
        try{
            String sql ="SELECT * FROM propiedad";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                property = new Propiedad();
                property.setProperty_id(rs.getString("property_id"));
                property.setOwner_id(rs.getString("owner_id"));
                property.setProperty_address(rs.getString("property_address"));
                property.setProperty_district(rs.getString("property_district"));
                property.setProperty_department(rs.getString("property_department"));
                property.setType_id(rs.getInt("type_id"));
                property.setProperty_room_qty(rs.getInt("property_room_qty"));
                property.setProperty_shared_bathroom(rs.getString("property_shared_bathroom"));
                property.setProperty_kitchen_room(rs.getString("property_kitchen_room"));
                property.setProperty_living_room(rs.getString("property_living_room"));
                property.setProperty_capacity(rs.getInt("property_capacity"));
                property.setProperty_pet_friendly(rs.getString("property_pet_friendly"));
                property.setProperty_buil_area(rs.getDouble("property_built_area"));
                property.setProperty_rent_price(rs.getDouble("property_rent_price"));
                property.setProperty_description(rs.getString("property_description"));
                property.setProperty_state(rs.getString("property_state"));
                listarpropiedades.add(property);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(propertyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarpropiedades;
    }
    
    @Override
    public String newProperty() {
        ArrayList<Propiedad>allProperties = listarPropiedades();
        try{
            int total_properties = allProperties.size()+1;
            String formato="0000";
            DecimalFormat objf= new DecimalFormat(formato);
            propertyid = "PROP"+objf.format(total_properties);
            System.out.println("Propiedad id: "+propertyid);
        }
        catch(UnknownError ue){
            Logger.getLogger(propertyDAO.class.getName()).log(Level.SEVERE, null, ue);
        }
        return propertyid;
    
    }
    
    @Override
    public ArrayList<Propiedad> listarPropiedades(String owner_id) {
        ArrayList<Propiedad>listarpropiedades= new ArrayList<>();
        try{
            String sql ="Select * From propiedad where owner_id=?";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, owner_id);
            rs=ps.executeQuery();
            while(rs.next()){
                property = new Propiedad();
                property.setProperty_id(rs.getString("property_id"));
                property.setOwner_id(rs.getString("owner_id"));
                property.setProperty_address(rs.getString("property_address"));
                property.setProperty_district(rs.getString("property_district"));
                property.setProperty_department(rs.getString("property_department"));
                property.setType_id(rs.getInt("type_id"));
                property.setProperty_room_qty(rs.getInt("property_room_qty"));
                property.setProperty_shared_bathroom(rs.getString("property_shared_bathroom"));
                property.setProperty_kitchen_room(rs.getString("property_kitchen_room"));
                property.setProperty_living_room(rs.getString("property_living_room"));
                property.setProperty_capacity(rs.getInt("property_capacity"));
                property.setProperty_pet_friendly(rs.getString("property_pet_friendly"));
                property.setProperty_buil_area(rs.getDouble("property_built_area"));
                property.setProperty_rent_price(rs.getDouble("property_rent_price"));
                property.setProperty_description(rs.getString("property_description"));
                property.setProperty_state(rs.getString("property_state"));
                listarpropiedades.add(property);
            }
            System.out.println("Lista de propiedades: "+listarpropiedades);
        }
        catch(SQLException ex){
            Logger.getLogger(propertyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarpropiedades;
    }
}
