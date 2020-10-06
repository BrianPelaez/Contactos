package com.example.contactos;

public class Contacto {

    private String nombre;
    private String tel;
    private String email;
    private int foto;

    public Contacto(String nombre, String tel, String email, int foto) {
        this.nombre = nombre;
        this.tel = tel;
        this.email = email;
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
