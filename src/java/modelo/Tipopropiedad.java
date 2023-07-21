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
public class Tipopropiedad {
    private int id;
    private String desc_type;

    public Tipopropiedad() {
    }

    public Tipopropiedad(int id, String desc_type) {
        this.id = id;
        this.desc_type = desc_type;
    }

    public String getDesc_type() {
        return desc_type;
    }

    public void setDesc_type(String desc_type) {
        this.desc_type = desc_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
