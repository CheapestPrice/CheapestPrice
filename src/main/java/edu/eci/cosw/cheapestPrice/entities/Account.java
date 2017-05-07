/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.cheapestPrice.entities;

/**
 *
 * @author 2105684
 */
public class Account {

    public static final String TENDERO="Tendero";
    public static final String CLIENTE="Usuario";
    
    private int id;
    
    private String rol;
    
    public Account(){}
    
    public Account(int id,String rol){
        this.rol=rol;
        this.id=id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
