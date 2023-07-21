/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import modelo.Usuarios;
import modeloDAO.usersDAO;

/**
 *
 * @author mrang
 */
public class test_connection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion instance = new Conexion();
        usersDAO userDAO;
        Usuarios user;
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getConnection()!=null){
            System.out.println("Conectado");
            String user_id="U0000001";
            String password="visitante1";
            userDAO = new usersDAO();
            user = userDAO.searchUser(user_id, password);
            if(user.getUser_id()!=null){
                System.out.println("DOI: "+user.getUser_doi());
            }
            else{
                System.out.println("No encontrado");
            }
        }
        else{
        System.out.println("The test case is a prototype.");
        }
    }
    
}
