/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoProfesor;
import dto.Profesor;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import vistas.Login;
import vistas.MenuProfesor;
import vistas.MenuView;

/**
 *
 * @author User
 */
public class Controlate {
    private final DaoProfesor daoprofe;
    private final Login logeando;
    private final MenuView menu;
    private Profesor profe=null;
    
    public Controlate(DaoProfesor daoprofe,MenuView menu,Login logeando){
        this.daoprofe=daoprofe;
        this.menu=menu;
        this.logeando=logeando;
               
        InitView();
        
    }
    
    private void InitView(){
        logeando.setVisible(true);
    }
    
    public void InitController(){
        logeando.getBtnConectar().addActionListener(e->login());
        logeando.getBtnSalir().addActionListener(e->exit());
        menu.getBtnMenu().addActionListener(e->inicio());
        menu.getBtnSalir().addActionListener(e->exit());
        
    }
    private Profesor login(){
        String nick=logeando.getTxtNick().getText();
        String clave=logeando.getTxPClave().getText();
        try{
            profe=daoprofe.acceder(nick, clave);
            if(profe!=null){
                logeando.dispose();
                menu.setTitle("Control Escuelita");
                MenuProfesor menus=new MenuProfesor();
                menus.getLblDatos().setText(profe.toString());
                cargarFrame(menus, menu.getjDpContenedor());
                menu.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,daoprofe.getMessage(),"SPAR",
                JOptionPane.WARNING_MESSAGE);               
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return profe;
    }
     private void cargarFrame(JInternalFrame frame, JDesktopPane jdp) {
        jdp.removeAll();
        jdp.add(frame);
        Dimension contenedor = jdp.getSize();
        Dimension contenido = frame.getSize();
        frame.setLocation(
                (contenedor.width - contenido.width) / 2,
                (contenedor.height - contenido.height) / 2);
        frame.show();
    }
        private void inicio() {
        MenuProfesor menus=new MenuProfesor();
          menus.getLblDatos().setText(profe.toString());
           cargarFrame(menus, menu.getjDpContenedor());
    }
        private void exit(){
       System.exit(0);
   }
    
     
}
