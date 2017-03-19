package edu.eci.cosw.cheapestPrice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Blob;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Clase tienda
 *Created by Daniela.
 */
@Entity
@Table(name="TIENDAS")
public class Tienda implements java.io.Serializable {

    private TiendaId id;
    private String direccion;
    private String nombre;
    private String telefono;
    private boolean disponible;
    private Blob logo;
    private List<Horario> horarios;
    private Tendero tendero;
    private List<Opinion> opiniones;

    public Tienda(){};

    public Tienda(String direccion,TiendaId id,String nombre,String telefono, boolean disponible) {
        setHorarios(new ArrayList<>());
        this.setOpiniones(new ArrayList<>());
        this.direccion = direccion;
        this.setId(id);
        this.nombre = nombre;
        this.telefono = telefono;
        this.disponible = disponible;
    }


    public Tienda(String direccion,TiendaId id, String nombre,String telefono, boolean disponible,Blob logo) {
        setHorarios(new ArrayList<>());
        this.setOpiniones(new ArrayList<>());
        this.direccion = direccion;
        this.setId(id);
        this.nombre = nombre;
        this.telefono = telefono;
        this.disponible = disponible;
        this.logo = logo;
    }

    public Tienda(String direccion,TiendaId id,String nombre,String telefono, Tendero tendero){
        setHorarios(new ArrayList<>());
        this.setOpiniones(new ArrayList<>());
        this.direccion = direccion;
        this.nombre = nombre;
        this.setId(id);
        this.telefono = telefono;
        this.tendero=tendero;
        this.disponible=true;
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

    @JsonIgnore
    @Column(name = "logo")
    public Blob getLogo() {
        return logo;
    }

    public void setLogo(Blob logo) {
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

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="TENDEROS_USUARIOS_correo", referencedColumnName="correo", nullable=false)
    })
    @JsonIgnore
    public Tendero getTendero() {
        return tendero;
    }

    public void setTendero(Tendero tendero) {
        this.tendero = tendero;
    }
    /***
     * Get horarios
     * @return horarios
     */
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="TIENDAS_x", referencedColumnName="x", nullable=false),
            @JoinColumn(name="TIENDAS_y", referencedColumnName="y", nullable=false),
            @JoinColumn(name="TIENDAS_nit", referencedColumnName="nit", nullable=false)
    })
    public List<Horario> getHorarios() {
        return horarios;
    }
    /**
     * Set horarios
     * @param horarios
     */
    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="TIENDAS_x", referencedColumnName="x", nullable=false),
            @JoinColumn(name="TIENDAS_y", referencedColumnName="y", nullable=false),
            @JoinColumn(name="TIENDAS_nit", referencedColumnName="nit", nullable=false)
    })
    public List<Opinion> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(List<Opinion> opiniones) {
        this.opiniones = opiniones;
    }
}
