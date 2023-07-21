/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.Usuarios;

/**
 *
 * @author mrang
 */
public interface metodoUsuarios {
    public void addUser(Usuarios user);
    public void deleteUser(String userId);
    public void updateUser(Usuarios user);
    public Usuarios recoverUser(String dni, String email);
    public Usuarios searchUser(String user_id, String password);
    public ArrayList<Usuarios> listarUsuarios();
    public String newUser();
}
