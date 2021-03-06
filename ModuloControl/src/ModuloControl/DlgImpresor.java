package ModuloControl;

import ModuloControl.ControlFaçade;
import java.awt.Frame;
import java.util.Calendar;
import javax.swing.JOptionPane;
import objetosNegocio.Consulta;
import objetosNegocio.Orden;

/**
 *
 * @author Ariiel AB
 */
public class DlgImpresor extends javax.swing.JDialog {
    
    
    private StringBuffer respuesta;
    
    public DlgImpresor(Frame frame, String titulo, StringBuffer respuesta, Consulta consulta, Orden orden) {
        super(frame, titulo, true);

        
        this.respuesta = respuesta;
        initComponents();
        if (orden == null) {
            areaTexto.setText(consulta.formatReceta());
        } else {
            String mes, dia;
        String ano = String.valueOf(orden.getFechaSolicitud().get(Calendar.YEAR));
         if(orden.getFechaSolicitud().get(Calendar.MONTH) < 10){
            mes = "0"+String.valueOf(orden.getFechaSolicitud().get(Calendar.MONTH));
        }else{
            mes = String.valueOf(orden.getFechaSolicitud().get(Calendar.MONTH));
        }
        
        if(orden.getFechaSolicitud().get(Calendar.DAY_OF_MONTH) < 10){
            dia = "0"+String.valueOf(orden.getFechaSolicitud().get(Calendar.DAY_OF_MONTH));
        }else{
            dia = String.valueOf(orden.getFechaSolicitud().get(Calendar.DAY_OF_MONTH));
        }
        
        String fecha1 = ano+"-"+mes+"-"+dia;
        
        
        ano = String.valueOf(orden.getFechaServicio().get(Calendar.YEAR));
         if(orden.getFechaServicio().get(Calendar.MONTH) < 10){
            mes = "0"+String.valueOf(orden.getFechaServicio().get(Calendar.MONTH));
        }else{
            mes = String.valueOf(orden.getFechaServicio().get(Calendar.MONTH));
        }
        
        if(orden.getFechaServicio().get(Calendar.DAY_OF_MONTH) < 10){
            dia = "0"+String.valueOf(orden.getFechaServicio().get(Calendar.DAY_OF_MONTH));
        }else{
            dia = String.valueOf(orden.getFechaServicio().get(Calendar.DAY_OF_MONTH));
        }
        
        String fecha2 = ano+"-"+mes+"-"+dia;
            String formateada = "No. Orden: " + orden.getNumeroOrden()
                    + "\tNo. Solicitud: " + orden.getNumeroSolicitud()
                    + "\tFecha solicitud: " + fecha1
                    + "\nCodigo Proovedor: " + orden.getCodigoProovedor()
                    + "\tNombre Proovedor:" + orden.getNombreProovedor()
                    + "\nNombre del paciente: " + orden.getNombrePaciente()
                    + "\tNSS: " + orden.getNSSPaciente()
                    + "\nServicio: " + orden.getServicio()
                    + "\tFecha de entrega: " + fecha2
                    + "\nIndicaciones: \n" + orden.getIndicaciones();
            areaTexto.setText(formateada);
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

        areaTexto.setEditable(false);
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
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(407, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
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
