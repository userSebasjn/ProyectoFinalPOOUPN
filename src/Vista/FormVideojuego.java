
package Vista;

import Modelo.Videojuego;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormVideojuego extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormVideojuego.class.getName());
    ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();
    DefaultTableModel modTabla; 

    public FormVideojuego() {
        initComponents();
        String[] titulo = {"Tirulo","Genero","Precio"};
        modTabla = new DefaultTableModel(null, titulo);
        tblMostrar.setModel(modTabla);  
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPrecio = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        lblCanVideo = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio"));
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 210, 80));

        txtTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder("Titulo"));
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 210, 80));

        txtGenero.setBorder(javax.swing.BorderFactory.createTitledBorder("Genero"));
        jPanel1.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 210, 80));

        lblCanVideo.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad Videojuegos:"));
        jPanel1.add(lblCanVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 200, 60));

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setToolTipText("");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 200, 60));

        btnAgregar.setText("AGREGAR");
        btnAgregar.setToolTipText("");
        btnAgregar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 200, 60));

        btnEliminar1.setText("ELIMINAR");
        btnEliminar1.setToolTipText("");
        btnEliminar1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEliminar1.addActionListener(this::btnEliminar1ActionPerformed);
        jPanel1.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 200, 60));

        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMostrar);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 590, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1020, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String titulo = txtTitulo.getText();
        String genero = txtGenero.getText();
        String precioTexto = txtPrecio.getText();
    
    
    if (titulo.isEmpty() || genero.isEmpty() || precioTexto.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Complete todos los campos."
        );
        return;
    }

    try {
        double precio = Double.parseDouble(precioTexto);

        Videojuego videojuego = new Videojuego(
            titulo,
            genero,
            precio
        );

        listaVideojuegos.add(videojuego);

        DefaultTableModel modelo =
            (DefaultTableModel) tblMostrar.getModel();

        modelo.addRow(new Object[]{
            videojuego.getTitulo(),
            videojuego.getGenero(),
            videojuego.getPrecio()
        });
        lblCanVideo.setText(""
                + listaVideojuegos.size());
        txtTitulo.setText("");
        txtGenero.setText("");
        txtPrecio.setText("");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
            this,
            "El precio debe ser un número válido."
        );
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        int fila;
        fila = tblMostrar.getSelectedRow();
        if(fila>=0){
            int res;
            res = JOptionPane.showConfirmDialog(
                    null,"¿Deseas eliminar este videojuego?","Eliminar",
                    JOptionPane.YES_NO_OPTION
            );
            if(res == JOptionPane.YES_OPTION){
                    listaVideojuegos.remove(fila);
                    modTabla.removeRow(fila);
                    lblCanVideo.setText("" + listaVideojuegos.size());
            }
            JOptionPane.showMessageDialog(null, "Videojuego eliminada correctamnete");
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona un videojuego de la tabla");
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
        txtGenero.setText("");
        txtPrecio.setText("");
        txtTitulo.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(() -> new FormVideojuego().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCanVideo;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
