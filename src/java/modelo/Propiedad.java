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
public class Propiedad {
    
    private String property_id;
    private String owner_id;
    private String property_address;
    private String property_district;
    private String property_department;
    private int type_id;
    private int property_room_qty;
    private String property_shared_bathroom;
    private String property_kitchen_room;
    private String property_living_room;
    private int property_capacity;
    private String property_pet_friendly;
    private Double property_buil_area;
    private Double property_rent_price;
    private String property_description;
    private String property_state;

    public Propiedad() {
    }

    public Propiedad(String property_id, String owner_id, String property_address, String property_district, String property_department, int type_id, int property_room_qty, String property_shared_bathroom, String property_kitchen_room, String property_living_room, int property_capacity, String property_pet_friendly, Double property_buil_area, Double property_rent_price, String property_description, String property_state) {
        this.property_id = property_id;
        this.owner_id = owner_id;
        this.property_address = property_address;
        this.property_district = property_district;
        this.property_department = property_department;
        this.type_id = type_id;
        this.property_room_qty = property_room_qty;
        this.property_shared_bathroom = property_shared_bathroom;
        this.property_kitchen_room = property_kitchen_room;
        this.property_living_room = property_living_room;
        this.property_capacity = property_capacity;
        this.property_pet_friendly = property_pet_friendly;
        this.property_buil_area = property_buil_area;
        this.property_rent_price = property_rent_price;
        this.property_description = property_description;
        this.property_state = property_state;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getProperty_address() {
        return property_address;
    }

    public void setProperty_address(String property_address) {
        this.property_address = property_address;
    }

    public String getProperty_district() {
        return property_district;
    }

    public void setProperty_district(String property_district) {
        this.property_district = property_district;
    }

    public String getProperty_department() {
        return property_department;
    }

    public void setProperty_department(String property_department) {
        this.property_department = property_department;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getProperty_room_qty() {
        return property_room_qty;
    }

    public void setProperty_room_qty(int property_room_qty) {
        this.property_room_qty = property_room_qty;
    }

    public String getProperty_shared_bathroom() {
        return property_shared_bathroom;
    }

    public void setProperty_shared_bathroom(String property_shared_bathroom) {
        this.property_shared_bathroom = property_shared_bathroom;
    }

    public String getProperty_kitchen_room() {
        return property_kitchen_room;
    }

    public void setProperty_kitchen_room(String property_kitchen_room) {
        this.property_kitchen_room = property_kitchen_room;
    }

    public String getProperty_living_room() {
        return property_living_room;
    }

    public void setProperty_living_room(String property_living_room) {
        this.property_living_room = property_living_room;
    }

    public int getProperty_capacity() {
        return property_capacity;
    }

    public void setProperty_capacity(int property_capacity) {
        this.property_capacity = property_capacity;
    }

    public String getProperty_pet_friendly() {
        return property_pet_friendly;
    }

    public void setProperty_pet_friendly(String property_pet_friendly) {
        this.property_pet_friendly = property_pet_friendly;
    }

    public Double getProperty_buil_area() {
        return property_buil_area;
    }

    public void setProperty_buil_area(Double property_buil_area) {
        this.property_buil_area = property_buil_area;
    }

    public Double getProperty_rent_price() {
        return property_rent_price;
    }

    public void setProperty_rent_price(Double property_rent_price) {
        this.property_rent_price = property_rent_price;
    }

    public String getProperty_description() {
        return property_description;
    }

    public void setProperty_description(String property_description) {
        this.property_description = property_description;
    }

    public String getProperty_state() {
        return property_state;
    }

    public void setProperty_state(String property_state) {
        this.property_state = property_state;
    }
    
    
    
}
