/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author mrang
 */
public class Propietarios {
    
    private String owner_id;
    private String user_id;
    private String owner_fullname;
    private String owner_address;
    private String owner_phone;

    public Propietarios() {
    }

    public Propietarios(String owner_id, String user_id, String owner_fullname, String owner_address, String owner_phone) {
        this.owner_id = owner_id;
        this.user_id = user_id;
        this.owner_fullname = owner_fullname;
        this.owner_address = owner_address;
        this.owner_phone = owner_phone;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOwner_fullname() {
        return owner_fullname;
    }

    public void setOwner_fullname(String owner_fullname) {
        this.owner_fullname = owner_fullname;
    }

    public String getOwner_address() {
        return owner_address;
    }

    public void setOwner_address(String owner_address) {
        this.owner_address = owner_address;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }
    
               
    
}
