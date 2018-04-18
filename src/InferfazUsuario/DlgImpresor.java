package InferfazUsuario;

import ModuloControl.ControlFaçade;
import SistemaImpresion.ControlImpresion;
import java.awt.Frame;
import javax.swing.JOptionPane;
import objetosNegocio.Orden;

/**
 *
 * @author Ariiel AB
 */
public class DlgImpresor extends javax.swing.JDialog {

    private ControlFaçade control = ControlFaçade.getInstance();
    private StringBuffer respuesta;

    public DlgImpresor(Frame frame, String titulo, StringBuffer respuesta, Orden orden) {
        super(frame, titulo, true);

        this.respuesta = respuesta;
        initComponents();
        setLocationRelativeTo(null);
        if (orden == null) {
            // setear la receta de consulta.getReceta() al area de texto con formato.
            areaTexto.setText("Receta");
        } else {
            // setear la orden recibida al area de texto con formato.
            areaTexto.setText(orden.getNumeroOrden());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jButtonImprimir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        try {
            if (respuesta != null) {
                respuesta.append("Aceptar");
            }
            areaTexto.print();
            dispose();
        } catch (java.awt.print.PrinterException ex) {      //Codigo para imprimir cualquier text area con el formato en que esté
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Imprimiendo");
     }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (respuesta != null) {
            respuesta.append("Cancelar");
        }
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
