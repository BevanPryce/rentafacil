/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import configuracion.Conexion;
import interfaces.metodoTipopropiedad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 *
 * @author mrang
 */
public class tipopropiedadDAO implements metodoTipopropiedad{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public String listarTipo(int type_id) {
        String sql = "Select desc_type from tipo_propiedad where type_id=?";
        con = cn.getConnection();
        String tipo=null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, type_id);
            rs = ps.executeQuery();
            if (rs.next()) {
            tipo = rs.getString("desc_type");
            }
        } catch (SQLException ex) {
            Logger.getLogger(tipopropiedadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipo;
    }
    
}
