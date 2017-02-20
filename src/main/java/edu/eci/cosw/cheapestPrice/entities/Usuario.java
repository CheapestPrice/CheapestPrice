package edu.eci.cosw.cheapestPrice.entities;

/**
 * Created by 2105403 on 2/20/17.
 */
public class Usuario {

    private String correo;
    private String email;
    private String nickname;

    public Usuario(){}

    public Usuario(String correo, String email, String nickname){
        this.setCorreo(correo);
        this.setEmail(email);
        this.setNickname(nickname);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
}
