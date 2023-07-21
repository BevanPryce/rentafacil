/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.Propietarios;

/**
 *
 * @author mrang
 */
public interface metodoPropietarios {
    public void addOwner(Propietarios owner);
    public void deleteOwner(String ownerId);
    public void updateOwner(String owner_id, String owner_address, String phone);
    public ArrayList<Propietarios> listarPropietarios();
    public ArrayList<Propietarios> listarPropietario(String userid);
    public String newOwner();
}
