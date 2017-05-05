package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Paula on 18/03/2017.
 */
public class CuentaPass implements Serializable{

    private String email;

    private String hash;

    public CuentaPass(String email, String hash){
        this.email=email;
        this.hash=hash;
    }

    public CuentaPass(){ }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getHash() { return hash;}

    public void setHash(String hash) { this.hash = hash;}

}
