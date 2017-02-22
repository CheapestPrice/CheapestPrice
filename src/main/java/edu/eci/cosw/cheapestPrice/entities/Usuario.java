package edu.eci.cosw.cheapestPrice.entities;

import java.util.List;

/**
 * Created by 2105403 on 2/20/17.
 */
public class Usuario {

    private String nombre;
    private String email;
    private String nickname;
    private List<ListaDeMercado> listas;

    public Usuario(){}

    public Usuario(String nombre, String email, String nickname, List<ListaDeMercado> listas){
        this.setNombre(nombre);
        this.setEmail(email);
        this.setNickname(nickname);
        this.setListas(listas);
    }

    public Usuario(String nombre,String email, String nickname){
        this.setNombre(nombre);
        this.setEmail(email);
        this.setNickname(nickname);

    }

    /**
     * Agregar productos a la lista de mercado seleccionada por el usuario
     * @param iT
     * @param nombreLista
     */
    public void agregarProducto(ItemLista iT, String nombreLista){
        for(ListaDeMercado lM: listas){
            if(lM.getNombre().equals(nombreLista)){
                lM.agregarProducto(iT);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<ListaDeMercado> getListas() {
        return listas;
    }

    public void setListas(List<ListaDeMercado> listas) {
        this.listas = listas;
    }
}
