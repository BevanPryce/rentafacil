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
public class Usuarios {
    
    private String user_id;
    private String user_first_name;
    private String user_last_name1;
    private String user_last_name2;
    private String user_doi;
    private String user_email;
    private String user_pwd;
    private int user_role_id;

    public Usuarios() {
    }

    public Usuarios(String user_id, String user_first_name, String user_last_name1, String user_last_name2, String user_doi, String user_email, String user_pwd, int user_role_id) {
        this.user_id = user_id;
        this.user_first_name = user_first_name;
        this.user_last_name1 = user_last_name1;
        this.user_last_name2 = user_last_name2;
        this.user_doi = user_doi;
        this.user_email = user_email;
        this.user_pwd = user_pwd;
        this.user_role_id = user_role_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name1() {
        return user_last_name1;
    }

    public void setUser_last_name1(String user_last_name1) {
        this.user_last_name1 = user_last_name1;
    }

    public String getUser_last_name2() {
        return user_last_name2;
    }

    public void setUser_last_name2(String user_last_name2) {
        this.user_last_name2 = user_last_name2;
    }

    public String getUser_doi() {
        return user_doi;
    }

    public void setUser_doi(String user_doi) {
        this.user_doi = user_doi;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }
    
    public int getUser_role_id(){
        return user_role_id;
    }
    
    public void setUser_role_id(int user_role_id){
        this.user_role_id = user_role_id;
    }
}
