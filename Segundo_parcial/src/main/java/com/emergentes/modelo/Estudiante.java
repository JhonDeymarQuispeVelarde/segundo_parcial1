
package com.emergentes.modelo;

public class Estudiante {
    private int Id;
    private String Nombre;
    private String Apellidos;
    private String Seminario;
    private String Confirmado;
    private String Fecha_de_Inscripcion;

    public Estudiante() {
        Id = 0;
        Nombre = "";
        Apellidos = "";
        Seminario = "";
        Confirmado = "";
        Fecha_de_Inscripcion = "";
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getSeminario() {
        return Seminario;
    }

    public void setSeminario(String Seminario) {
        this.Seminario = Seminario;
    }

    public String getConfirmado() {
        return Confirmado;
    }

    public void setConfirmado(String Confirmado) {
        this.Confirmado = Confirmado;
    }

    public String getFecha_de_Inscripcion() {
        return Fecha_de_Inscripcion;
    }

    public void setFecha_de_Inscripcion(String Fecha_de_Inscripcion) {
        this.Fecha_de_Inscripcion = Fecha_de_Inscripcion;
    }
    
    
    
    
}
