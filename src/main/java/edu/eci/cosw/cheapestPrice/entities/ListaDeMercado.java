package edu.eci.cosw.cheapestPrice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 2105403 on 2/20/17.
 */
@Entity
@Table(name = "LISTAS_MERCADOS")
public class ListaDeMercado implements Serializable {

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "fechaCreacion",nullable = false)
    private Date fechaCreacion;

    @Column(name = "realizado", nullable = false)
    private boolean revisado;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "lista")
    private List<ItemLista> items;

    @EmbeddedId
    //@JsonIgnore
    private ListaMercado_Item listaid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="USUARIOS_correo",referencedColumnName = "correo", nullable = false,insertable=false, updatable=false)
    })
    @JsonIgnore
    private Usuario usuario;

    public ListaDeMercado(){}

    public ListaDeMercado(Date fechaCreacion, boolean revisado){
        this.fechaCreacion=fechaCreacion;
        this.revisado=revisado;
        //items=new ArrayList<ItemLista>();
    }

    /**
     * Agrega items a la lista de mercado
     * @param ite
     */
    public void agregarProducto(ItemLista ite){
        items.add(ite);
    }

    /**
     * Marca items como comprados
     * @param id
     */
   /* public void marcarProductoComprado(long id){
        for(ItemLista i: items){
            if(i.getId().getItem().getId().getProducto().getId()==id){
                i.setComprado(true);
            }
        }
    }*/

    /**
     * Marca items como favoritos
     */
    /*public void marcarProductoFavorito(long id){
        for(ItemLista i: items){
            if(i.getId().getItem().getId().getProducto().getId()==id){
                i.setFavorito(true);
            }
        }
    }*/


    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public boolean isRevisado() {
        return revisado;
    }

    public boolean getRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    public List<ItemLista> getItems() {
        return items;
    }

    public void setItems(List<ItemLista> items) {
        this.items = items;
    }



    public ListaMercado_Item getListaid() {
        return listaid;
    }

    public void setListaid(ListaMercado_Item listaid) {
        this.listaid = listaid;
    }
}