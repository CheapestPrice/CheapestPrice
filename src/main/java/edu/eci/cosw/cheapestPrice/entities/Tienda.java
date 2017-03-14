package edu.eci.cosw.cheapestPrice.entities;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

/**
 * Clase tienda
 *Created by Daniela .
 */
@Entity
@Table(name="TIENDAS")
public class Tienda implements java.io.Serializable {

    private TiendaId id;
    private String direccion;
    private String nombre;
    private String telefono;
    private boolean disponible;
    private byte[] logo;
    private Map<String,Horario> horarios;

    public Tendero tendero;

    public Tienda(){};

    public Tienda(String direccion,TiendaId id,String nombre,String telefono, boolean disponible) {
        this.direccion = direccion;
        this.setId(id);
        this.nombre = nombre;
        this.telefono = telefono;
        this.disponible = disponible;
    }


    public Tienda(String direccion,TiendaId id, String nombre,String telefono, boolean disponible,byte[] logo) {
        this.direccion = direccion;
        this.setId(id);
        this.nombre = nombre;
        this.telefono = telefono;
        this.disponible = disponible;
        this.logo = logo;
    }

    public Tienda(String direccion,TiendaId id,String nombre,String telefono, Tendero tendero){
        this.direccion = direccion;
        this.nombre = nombre;
        this.setId(id);
        this.telefono = telefono;
        this.tendero=tendero;
        this.disponible=true;
    }


    public void mnodificarHorario(String dia, Horario horario){

        horarios.put(dia,horario);
    }

    public void setHorario(Map<String,Horario> hor){
        this.horarios=hor;
    }


    public Map<String,Horario> getHorario(){
        return this.horarios;
    }
    
    @EmbeddedId
    public TiendaId getId() {
        return id;
    }

    public void setId(TiendaId id) {
        this.id = id;
    }
    @Column(name="direccion", nullable=false)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name="nombre", nullable=false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="telefono", nullable=false)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name="disponible", nullable=false)
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o){
        Tienda ot=(Tienda) o;
        return getId().equals(ot.getId()) && direccion.equals(ot.getDireccion()) && nombre.equals(ot.getNombre()) && telefono.equals(ot.getTelefono());
    }

    @Override
    public String toString(){
        return "nombre: "+nombre+" direccion: "+direccion+" telefono: "+telefono+" NIT: "+id.getNit();
    }

    public Tendero getTendero() {
        return tendero;
    }

    public void setTendero(Tendero tendero) {
        this.tendero = tendero;
    }

}
