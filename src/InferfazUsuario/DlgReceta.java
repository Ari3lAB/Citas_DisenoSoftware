/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InferfazUsuario;
import ModuloControl.ControlFaçade;
import interfaces.IControl;
import java.awt.Dimension;
import java.awt.Point;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.ldap.ControlFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import objetosNegocio.Consulta;
import objetosNegocio.Orden;
import objetosNegocio.Paciente;
import objetosNegocio.Receta;
import objetosNegocio.Servicio;
/**
 *
 * @author 1024zettabytes
 */
public class DlgReceta extends javax.swing.JDialog {
StringBuffer respuesta= new StringBuffer("");
    IControl controlFacade = ControlFaçade.getInstance();
    private Consulta consulta;
    
    private Receta receta;
    private ArrayList<Servicio> listaServicios;
    ArrayList<Servicio> listaS = new ArrayList<>();
    /**
     * Creates new form DlgReceta2
     */
    
    public DlgReceta(javax.swing.JFrame parent, String titulo, StringBuffer respuesta, Consulta consulta, Receta receta, ArrayList<Servicio> listaServicios) {
        super(parent, titulo, true);
        this.respuesta= respuesta;
        this.consulta = consulta;
        
        this.receta= receta;
        this.listaServicios = listaServicios;
        initComponents();
        estableceDatos();
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
    private void estableceDatos(){
        
        DateFormat dft = new SimpleDateFormat("yyyy/MM/dd");
        jTextFieldNombre.setText(consulta.getPaciente().getNombre());
        jTextFieldFecha.setText(dft.format(new Date()));
        jTextFieldFolio.setText(receta.getFolio()+"");
        jTextFieldNss.setText(consulta.getPaciente().getNss());
        jComboBoxServicios.setModel(new DefaultComboBoxModel(listaServicios.toArray()));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldNss = new javax.swing.JTextField();
        jButtonAgregarServicio = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxServicios = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaServicios = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDiagnostico = new javax.swing.JTextArea();
        jTextFieldFecha = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaTratamiento = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldFolio = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Nss");

        jButton1.setText("Aceptar e imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldNombre.setEditable(false);
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldNss.setEditable(false);

        jButtonAgregarServicio.setText("Agregar servicio");
        jButtonAgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarServicioActionPerformed(evt);
            }
        });

        jLabel6.setText("Diagnostico");

        jComboBoxServicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Tratamiento:");

        jTextAreaServicios.setEditable(false);
        jTextAreaServicios.setColumns(20);
        jTextAreaServicios.setRows(5);
        jScrollPane2.setViewportView(jTextAreaServicios);

        jLabel8.setText("Folio");

        jLabel2.setText("Fecha");

        jTextAreaDiagnostico.setColumns(20);
        jTextAreaDiagnostico.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDiagnostico);

        jTextFieldFecha.setEditable(false);

        jTextAreaTratamiento.setColumns(20);
        jTextAreaTratamiento.setRows(5);
        jScrollPane4.setViewportView(jTextAreaTratamiento);

        jLabel1.setText("Nombre");

        jLabel4.setText("Servicios");

        jTextFieldFolio.setEditable(false);
        jTextFieldFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFolioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNss, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAgregarServicio)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregarServicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
receta.setDiagnostico(jTextAreaDiagnostico.getText());
receta.setTratamiento(jTextAreaTratamiento.getText());
        
listaServicios.clear();
listaServicios.addAll(listaS);
        
respuesta.append("Aceptar");
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarServicioActionPerformed
       Servicio servicioSeleccionado = new Servicio((Servicio)jComboBoxServicios.getModel().getSelectedItem());
        
       listaS.add(servicioSeleccionado);
       if(!jTextAreaServicios.getText().equals(""))
        jTextAreaServicios.setText(jTextAreaServicios.getText()+"\n"+servicioSeleccionado.toString());
       else
           jTextAreaServicios.setText(servicioSeleccionado.toString());
       
        
    }//GEN-LAST:event_jButtonAgregarServicioActionPerformed

    private void jTextFieldFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFolioActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregarServicio;
    private javax.swing.JComboBox<String> jComboBoxServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaDiagnostico;
    private javax.swing.JTextArea jTextAreaServicios;
    private javax.swing.JTextArea jTextAreaTratamiento;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldFolio;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNss;
    // End of variables declaration//GEN-END:variables
}
