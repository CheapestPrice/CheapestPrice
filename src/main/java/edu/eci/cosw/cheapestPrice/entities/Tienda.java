package edu.eci.cosw.cheapestPrice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Blob;

import java.sql.Timestamp;
import java.util.*;
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
    private HashMap<Integer, String> diasemana;
    private java.util.GregorianCalendar cal;

    public Tienda(){
        createHorary();
    };

    public Tienda(String direccion,TiendaId id,String nombre,String telefono, boolean disponible) {
        setHorarios(new ArrayList<>());
        this.setOpiniones(new ArrayList<>());
        this.direccion = direccion;
        this.setId(id);
        this.nombre = nombre;
        this.telefono = telefono;
        this.disponible = disponible;
        createHorary();
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
        createHorary();
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
        createHorary();
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
    /**
     * Agregar una opinion a la tienda
     * @param opinion
     */
    public void addOpinion(Opinion opinion){
        opiniones.add(opinion);
    }

    /***
     * La tienda se encuentra abierta en la fecha estipualada
     * @param time
     *
     */
    public boolean isOpen(Timestamp time){
        setCal((GregorianCalendar) Calendar.getInstance());
        getCal().setTime(time);
        String dia = diasemana.get(getCal().get(Calendar.DAY_OF_WEEK));
        boolean ans=false;
        for (int i = 0; i < horarios.size() && !ans; i++) {
            Horario tmp=horarios.get(i);
            if(tmp.getDia().equals(dia)){
                if(tmp.getHoraInicio()<cal.HOUR_OF_DAY && tmp.getHoraFin()>cal.HOUR_OF_DAY && tmp.getMinutosInicio()<cal.MINUTE && tmp.getMinutoFin()>cal.MINUTE){
                    ans=true;
                }
            }
        }
        return ans;
    }

    /**
     * identificador dias de la semana
     */
    public void createHorary(){
        setDiasemana(new HashMap<Integer,String>());
        getDiasemana().put(getCal().MONDAY,"Lunes");
        getDiasemana().put(getCal().TUESDAY,"Martes");
        getDiasemana().put(getCal().WEDNESDAY,"Miercoles");
        getDiasemana().put(getCal().THURSDAY,"Jueves");
        getDiasemana().put(getCal().FRIDAY,"Viernes");
        getDiasemana().put(getCal().SATURDAY,"Sabado");
        getDiasemana().put(getCal().SUNDAY,"Domingo");
    }
    /**
     * Dias de la semana
     * @return diasemana
     */
    public HashMap<Integer,String> getDiasemana() {
        return diasemana;
    }
    /**
     * Dias de la semana
     * @param diasemana
     */
    public void setDiasemana(HashMap<Integer,String> diasemana) {
        this.diasemana = diasemana;
    }
    /**
     * Calendario
     * @return cal
     */
    public GregorianCalendar getCal() {
        return cal;
    }
    /**
     * Calendario
     * @param cal
     */
    public void setCal(GregorianCalendar cal) {
        this.cal = cal;
    }
    /**
     * Modificar horario de un dia de la tienda
     * @param  dia
     * @param horario
     */
    public void modifyHorary(String dia, Horario horario){
        for (int j = 0; j < horarios.size(); j++) {
            if(horarios.get(j).getDia().equals(dia)){
                horarios.remove(j);
                horarios.add(j,horario);
            }
        }
    }
}
