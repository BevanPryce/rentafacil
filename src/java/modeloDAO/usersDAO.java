/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import configuracion.Conexion;
import interfaces.metodoUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuarios;

public class usersDAO implements metodoUsuarios{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuarios user;
    String user_id;

    @Override
    public void addUser(Usuarios user) {
        try {
            String sql = "INSERT INTO usuarios (user_id, user_first_name, user_last_name_1, user_last_name_2, user_doi, user_email, user_pwd, role_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUser_id());
            ps.setString(2, user.getUser_first_name());
            ps.setString(3, user.getUser_last_name1());
            ps.setString(4, user.getUser_last_name2());
            ps.setString(5, user.getUser_doi());
            ps.setString(6, user.getUser_email());
            ps.setString(7, user.getUser_pwd());
            ps.setInt(8, user.getUser_role_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(usersDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(usersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deleteUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(Usuarios user) {
        try {
            String sql ="update usuarios set user_email='"+user.getUser_email()+"', user_pwd='"+user.getUser_pwd()+"' where user_id='"+user.getUser_id()+"'";                
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(usersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Usuarios recoverUser(String dni, String email) {
        try{
            String sql ="Select * From usuarios where user_doi='"+dni+"' and user_email='"+email+"'" ;
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                user =new Usuarios();
                user.setUser_id(rs.getString("user_id"));
                user.setUser_first_name(rs.getString("user_first_name"));
                user.setUser_last_name1(rs.getString("user_last_name_1"));
                user.setUser_last_name2(rs.getString("user_last_name_2"));
                user.setUser_doi(rs.getString("user_doi"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_pwd(rs.getString("user_pwd"));
                user.setUser_role_id(rs.getInt("role_id"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(usersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
        @Override
    public Usuarios searchUser(String user_id, String password) {
        try{
            String sql ="Select * From usuarios where user_id='"+user_id+"' and user_pwd='"+password+"'" ;
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                user =new Usuarios();
                user.setUser_id(rs.getString("user_id"));
                user.setUser_first_name(rs.getString("user_first_name"));
                user.setUser_last_name1(rs.getString("user_last_name_1"));
                user.setUser_last_name2(rs.getString("user_last_name_2"));
                user.setUser_doi(rs.getString("user_doi"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_pwd(rs.getString("user_pwd"));
                user.setUser_role_id(rs.getInt("role_id"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(usersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public ArrayList<Usuarios> listarUsuarios() {
        ArrayList<Usuarios>listarusuarios= new ArrayList<>();
        try{
            String sql ="Select * From usuarios";
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                user =new Usuarios();
                user.setUser_id(rs.getString("user_id"));
                user.setUser_first_name(rs.getString("user_first_name"));
                user.setUser_last_name1(rs.getString("user_last_name_1"));
                user.setUser_last_name2(rs.getString("user_last_name_2"));
                user.setUser_doi(rs.getString("user_doi"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_pwd(rs.getString("user_pwd"));
                user.setUser_role_id(rs.getInt("role_id"));
                listarusuarios.add(user);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(usersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listarusuarios;
    }

    @Override
    public String newUser() {
        ArrayList<Usuarios>allUsers = listarUsuarios();
        try{
            int total_users = allUsers.size()+1;
            String formato="0000000";
            DecimalFormat objf= new DecimalFormat(formato);
            user_id = "U"+objf.format(total_users);
            System.out.println("Usuario id: "+user_id);
        }
        catch(UnknownError ue){
            Logger.getLogger(usersDAO.class.getName()).log(Level.SEVERE, null, ue);
        }
        return user_id;
    }
    
}
