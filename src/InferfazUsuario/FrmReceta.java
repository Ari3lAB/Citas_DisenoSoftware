package InferfazUsuario;

import ModuloControl.Control;
import ModuloControl.ControlFaçade;
import interfaces.IControl;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import objetosNegocio.Paciente;

/**
 *
 * @author Ariiel AB
 */
public class FrmReceta extends javax.swing.JFrame {

    IControl controlFacade = ControlFaçade.getInstance();

    /**
     * Creates new form FrmUsuario
     */
    public FrmReceta() {
        initComponents();
        centraVentana();

    }

    private void centraVentana() {
        //Obtiene el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Obtiene el tamaño de la ventana de la aplicación
        Dimension frameSize = getSize();

        // Se asegura que el tamaño de la ventana de la aplicación
        // no exceda el tamaño de la pantalla
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }

        // Centra la ventana de la aplicación sobre la pantalla
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbuttonNuevaConsulta = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        consultaMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbuttonNuevaConsulta.setText("Nueva consulta");
        jbuttonNuevaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonNuevaConsultaActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("Consulta");

        consultaMenuItem.setMnemonic('o');
        consultaMenuItem.setText("Nueva consulta");
        consultaMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultaMenuItemMouseClicked(evt);
            }
        });
        consultaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(consultaMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jbuttonNuevaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jbuttonNuevaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void consultaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaMenuItemActionPerformed
try{
        while (true) {
            StringBuffer respuesta = new StringBuffer("");
            DlgBuscarPaciente dialog = new DlgBuscarPaciente(this, "Buscar Paciente", respuesta);
            dialog.setVisible(true);
            if (respuesta.toString().equals("Aceptar")) {
               
                if (!controlFacade.getListaPacientes().isEmpty()) {
                    respuesta = new StringBuffer("");
                    DlgSeleccionPaciente dlgSeleccion = new DlgSeleccionPaciente(this, "Seleccione al paciente", respuesta);
                    dlgSeleccion.setVisible(true);
                    if (respuesta.toString().equals("Aceptar")) {
                        respuesta = new StringBuffer("");
                        controlFacade.muestraReceta(this, respuesta, dlgSeleccion.getPaciente());
                        if (respuesta.toString().equals("Aceptar")) {
                            respuesta = new StringBuffer("");
                            controlFacade.imprime(this, respuesta);
                        }
                    } else {

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se enontró ninguna coincidencia en la base de datos.");

                }

            } else {
                break;
            }
        
        }
}catch(SQLException e){
    
}
    }/*
        dialog.setVisible(true);    }//GEN-LAST:event_consultaMenuItemActionPerformed
*/
    private void consultaMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaMenuItemMouseClicked

    }//GEN-LAST:event_consultaMenuItemMouseClicked

    private void jbuttonNuevaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonNuevaConsultaActionPerformed

        while (true) {
            StringBuffer respuesta = new StringBuffer("");
            try{
            DlgBuscarPaciente dialog = new DlgBuscarPaciente(this, "Buscar Paciente", respuesta);
            dialog.setVisible(true);
            if(respuesta.toString().equals("EX"))
                throw  new SQLException();
            if (respuesta.toString().equals("Aceptar")) {
                
                if (!controlFacade.getListaPacientes().isEmpty()) {
                    respuesta = new StringBuffer("");
                    DlgSeleccionPaciente dlgSeleccion = new DlgSeleccionPaciente(this, "Seleccione al paciente", respuesta);
                    dlgSeleccion.setVisible(true);
                    if (respuesta.toString().equals("Aceptar")) {
                        respuesta = new StringBuffer("");
                        controlFacade.muestraReceta(this, respuesta, dlgSeleccion.getPaciente());
                        if (respuesta.toString().equals("Aceptar")) {
                            respuesta = new StringBuffer("");
                            controlFacade.imprime(this, respuesta);
                            break;
                        }
                    } 
                } else {
                     JOptionPane.showMessageDialog(this, "No se enontró ninguna coincidencia en la base de datos.");
                    
                }
                

            } else {
                break;
            }
            }catch(SQLException e){
               
    JOptionPane.showMessageDialog(this, "ERROR: No se pudo conectar a la base de datos externa.");
    
}catch(NullPointerException e){
    JOptionPane.showMessageDialog(this, "ERROR: No se pudo conectar a la base de datos externa.");
}
        }
        controlFacade.setControl(new Control());

        /*
        dialog.setVisible(true);    }                                                
         */
    }//GEN-LAST:event_jbuttonNuevaConsultaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmReceta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem consultaMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jbuttonNuevaConsulta;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
