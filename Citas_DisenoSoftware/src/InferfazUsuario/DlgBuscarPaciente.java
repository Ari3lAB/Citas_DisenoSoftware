package InferfazUsuario;

import ModuloControl.Control;
import ModuloControl.ControlFaçade;
import interfaces.IControl;
import java.awt.Dimension;
import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.ldap.ControlFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 

/**
 *
 * @author Ariel AB
 */
public class DlgBuscarPaciente extends javax.swing.JDialog {

    private IControl controlFacade;
    private JFrame parent;
    StringBuffer respuesta = new StringBuffer("");

    public DlgBuscarPaciente(javax.swing.JFrame parent, String titulo, StringBuffer respuesta) {
        super(parent, titulo, true);
        this.controlFacade = ControlFaçade.getInstance();
        this.respuesta = respuesta;
        this.parent = parent;
        initComponents();
        // centra el cuadro de dialogo sobre la ventana de la aplicación 
        centraCuadroDialogo(parent);

    }

    /**
     * Este método centra el cuadro de dialogo sobre la ventana de la
     * aplicación.
     *
     * @param parent Ventana sobre la que aparecerá el cuadro de diálogo
     */
    private void centraCuadroDialogo(java.awt.Frame parent) {
        // Obtiene el tamaño y posición de la ventana de la aplicación 
        Dimension frameSize = parent.getSize();
        Point loc = parent.getLocation();
        // Obtiene el tamaño del cuadro de diálogo 
        Dimension dlgSize = getPreferredSize();
        // Centra el cuadro de diálogo sobre la ventana padre 
        setLocation((frameSize.width - dlgSize.width) / 2 + loc.x,
                (frameSize.height - dlgSize.height) / 2 + loc.y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nssjTextField = new javax.swing.JTextField();
        nombrejTextField = new javax.swing.JTextField();
        jRadioButtonNss = new javax.swing.JRadioButton();
        jRadioButtonNombre = new javax.swing.JRadioButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nssjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nssjTextFieldActionPerformed(evt);
            }
        });
        nssjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nssjTextFieldKeyTyped(evt);
            }
        });

        nombrejTextField.setEnabled(false);
        nombrejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrejTextFieldActionPerformed(evt);
            }
        });
        nombrejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombrejTextFieldKeyTyped(evt);
            }
        });

        jRadioButtonNss.setSelected(true);
        jRadioButtonNss.setText("NSS (Numero de Seguro Social");
        jRadioButtonNss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNssActionPerformed(evt);
            }
        });

        jRadioButtonNombre.setText("Nombre");
        jRadioButtonNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNombreActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setEnabled(false);
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonNombre)
                    .addComponent(jRadioButtonNss)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nssjTextField)
                        .addComponent(nombrejTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jButtonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jRadioButtonNss)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nssjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombrejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nssjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nssjTextFieldActionPerformed
        
    }//GEN-LAST:event_nssjTextFieldActionPerformed

    private void nombrejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrejTextFieldActionPerformed
       
    }//GEN-LAST:event_nombrejTextFieldActionPerformed

    private void jRadioButtonNssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNssActionPerformed
        jRadioButtonNss.setSelected(true);
       
            jRadioButtonNombre.setSelected(false);
            nssjTextField.setEnabled(true);
            nombrejTextField.setEnabled(false);
            
        
    }//GEN-LAST:event_jRadioButtonNssActionPerformed

    private void jRadioButtonNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNombreActionPerformed
        jRadioButtonNombre.setSelected(true);
       
            jRadioButtonNss.setSelected(false);
            nssjTextField.setEnabled(false);
            nombrejTextField.setEnabled(true);
           
            
            /*
        }    }//GEN-LAST:event_jRadioButtonNombreActionPerformed
*/
    }
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        respuesta.append("Aceptar");
try{
        if (jRadioButtonNss.isSelected()) {
            controlFacade.obtenerPaciente(nssjTextField.getText(), null);

        } else {

            controlFacade.obtenerPaciente(null, nombrejTextField.getText());
        }
}catch(SQLException e){
    respuesta = new StringBuffer();
    respuesta.append("EX");
}
        dispose();


    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        respuesta.append("Cancelar");
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void nssjTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nssjTextFieldKeyTyped
        if(nssjTextField.getText().equals("")){
            jButtonAceptar.setEnabled(false);
        }
        else
             jButtonAceptar.setEnabled(true);
    }//GEN-LAST:event_nssjTextFieldKeyTyped

    private void nombrejTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombrejTextFieldKeyTyped
         if(nombrejTextField.getText().equals("")){
            jButtonAceptar.setEnabled(false);
        }
        else
             jButtonAceptar.setEnabled(true);
    }//GEN-LAST:event_nombrejTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JRadioButton jRadioButtonNombre;
    private javax.swing.JRadioButton jRadioButtonNss;
    private javax.swing.JTextField nombrejTextField;
    private javax.swing.JTextField nssjTextField;
    // End of variables declaration//GEN-END:variables

}