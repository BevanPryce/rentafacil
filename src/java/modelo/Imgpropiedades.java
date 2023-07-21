/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;

/**
 *
 * @author mrang
 */
public class Imgpropiedades {
    
    private String pic_property_id;
    private String property_id;
    private InputStream pic1_property;
    private InputStream pic2_property;
    private InputStream pic3_property;

    public Imgpropiedades() {
    }

    public Imgpropiedades(String pic_property_id, String property_id, InputStream pic1_property, InputStream pic2_property, InputStream pic3_property) {
        this.pic_property_id = pic_property_id;
        this.property_id = property_id;
        this.pic1_property = pic1_property;
        this.pic2_property = pic2_property;
        this.pic3_property = pic3_property;
    }

    public InputStream getPic3_property() {
        return pic3_property;
    }

    public void setPic3_property(InputStream pic3_property) {
        this.pic3_property = pic3_property;
    }

    public String getPic_property_id() {
        return pic_property_id;
    }

    public void setPic_property_id(String pic_property_id) {
        this.pic_property_id = pic_property_id;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public InputStream getPic1_property() {
        return pic1_property;
    }

    public void setPic1_property(InputStream pic1_property) {
        this.pic1_property = pic1_property;
    }

    public InputStream getPic2_property() {
        return pic2_property;
    }

    public void setPic2_property(InputStream pic2_property) {
        this.pic2_property = pic2_property;
    }
    
    
    
}
