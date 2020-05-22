/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import controlador.Controlate;
import dao.DaoProfesor;
import dao.implement.DaoProfesorImpl;
import vistas.Login;
import vistas.MenuView;


/**
 *
 * @author User
 */
public class execute {
    public static void main(String[] args) {
        DaoProfesor pf=new DaoProfesorImpl();
        Login lg=new Login();
        MenuView mn=new MenuView();
        Controlate cont=new Controlate(pf,mn,lg);
        
        cont.InitController();
        
    }
}
