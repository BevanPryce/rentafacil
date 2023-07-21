/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import configuracion.Conexion;
import interfaces.metodoPropietarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Propietarios;

public class ownersDAO implements metodoPropietarios{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Propietarios owner;
    String ownerid;

    @Override
    public void addOwner(Propietarios owner) {
        try {
            String sql = "INSERT INTO propietario(owner_id, user_id, owner_full_name, owner_address, owner_phone)"
                    + "VALUES (?, ?, ?, ?, ?)";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, owner.getOwner_id());
            ps.setString(2, owner.getUser_id());
            ps.setString(3, owner.getOwner_fullname());
            ps.setString(4, owner.getOwner_address());
            ps.setString(5, owner.getOwner_phone());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ownersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar la conexión y los recursos
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ownersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deleteOwner(String ownerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOwner(String owner_id, String owner_address, String phone) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            String sql ="update propietario set owner_address='"+owner_address+"', owner_phone='"+phone+"' where owner_id='"+owner_id+"'";                
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ownersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Propietarios> listarPropietarios() {
        ArrayList<Propietarios>listarpropietarios= new ArrayList<>();
        try{
            String sql ="Select * From propietario";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                owner =new Propietarios();
                owner.setOwner_id(rs.getString("owner_id"));
                owner.setUser_id(rs.getString("user_id"));
                owner.setOwner_fullname(rs.getString("owner_full_name"));
                owner.setOwner_address(rs.getString("owner_address"));
                owner.setOwner_phone(rs.getString("owner_phone"));
                listarpropietarios.add(owner);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(ownersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarpropietarios;
    }
    
    @Override
    public ArrayList<Propietarios> listarPropietario(String userid) {
        ArrayList<Propietarios>listarpropietario= new ArrayList<>();
        try{
            System.out.println("ownersDAO/listarPropietario(userid): "+userid);
            String sql ="Select * From propietario where user_id=?";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, userid);
            rs=ps.executeQuery();
            while(rs.next()){
                owner =new Propietarios();
                owner.setOwner_id(rs.getString("owner_id"));
                owner.setUser_id(rs.getString("user_id"));
                owner.setOwner_fullname(rs.getString("owner_full_name"));
                owner.setOwner_address(rs.getString("owner_address"));
                owner.setOwner_phone(rs.getString("owner_phone"));
                listarpropietario.add(owner);
                System.out.println("resultado propietario: "+ listarpropietario);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(ownersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarpropietario;
    }
    
    @Override
    public String newOwner() {
        ArrayList<Propietarios>allOwners = listarPropietarios();
        try{
            int total_owners = allOwners.size()+1;
            String formato="0000000";
            DecimalFormat objf= new DecimalFormat(formato);
            ownerid = "P"+objf.format(total_owners);
            System.out.println("Propietario id: "+ownerid);
        }
        catch(UnknownError ue){
            Logger.getLogger(ownersDAO.class.getName()).log(Level.SEVERE, null, ue);
        }
        return ownerid;
    }
}
