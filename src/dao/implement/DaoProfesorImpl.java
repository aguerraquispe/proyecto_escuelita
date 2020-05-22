/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implement;

import conexion.ConectaBD;
import dao.DaoProfesor;
import dto.Profesor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DaoProfesorImpl implements DaoProfesor{
    private final ConectaBD conecta;
    private String mensaje;
    
    public DaoProfesorImpl(){
        this.conecta=new ConectaBD();
    }

    @Override
    public Profesor acceder(String nick, String clave) {
       Profesor profe=new Profesor();
       
        try {
           Connection cd=conecta.conexionDB();
           CallableStatement procedur= cd.prepareCall("{SP_Login(?,?)}");
           procedur.setString(1, nick);
           procedur.setString(2,clave);
           
          ResultSet rs= procedur.executeQuery();
          if(rs.next()){
             profe.setId_profesor(rs.getInt(1));
             profe.setNombre(rs.getString(2));
             profe.setApellido_peterno(rs.getString(3));
             profe.setApellido_materno(rs.getString(4));
             profe.setDni(rs.getString(5));
             profe.setNickname(rs.getString(6));
             profe.setCurso(rs.getString(7));
          }else{
              profe=null;
              mensaje="Credenciales invalidas";
          }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoProfesorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profe;
    }

    @Override
    public String getMessage() {
        return mensaje;
    }
    
}
