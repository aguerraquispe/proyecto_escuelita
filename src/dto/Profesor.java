/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author ABEL
 */
public class Profesor {
    
   private Integer Id_profesor;
   private String Nombre;
   private String apellido_peterno;
   private String apellido_materno;
   private String dni;
   private String nickname;
   private String curso;
   
   public Profesor(){
       
   }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
   

    public Integer getId_profesor() {
        return Id_profesor;
    }

    public void setId_profesor(Integer Id_profesor) {
        this.Id_profesor = Id_profesor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido_peterno() {
        return apellido_peterno;
    }

    public void setApellido_peterno(String apellido_peterno) {
        this.apellido_peterno = apellido_peterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Profesor{" + "Nombre=" + Nombre + ", apellido_peterno=" + apellido_peterno + ", apellido_materno=" + apellido_materno + '}';
    }
     
}
