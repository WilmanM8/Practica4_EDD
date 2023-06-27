/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.Nodo;
import controlador.ordenacion.MergeSort;
import controlador.ordenacion.QuickSort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.modeloTabla.ModeloTabla;

/**
 *
 * @author wilman
 */
public class FrmOrdenacion extends javax.swing.JDialog {

    ListaEnlazada<Integer> lista = new ListaEnlazada<>();
    private ModeloTabla modelo = new ModeloTabla();
    private MergeSort<Integer> ms;
    private QuickSort<Integer> qs;
    private int fila = -1;

    /**
     * Creates new form FrmOrdenacion
     */
    public FrmOrdenacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarControladorMetodo();
        configurarControladorOrden();
        this.setLocationRelativeTo(null);
        cargarTabla();
    }

    public FrmOrdenacion(java.awt.Frame parent, boolean modal, MergeSort ms, QuickSort qs) {
        super(parent, modal);
        initComponents();
        this.ms = ms;
        this.qs = qs;
    }

    private void cargarTabla() {
        modelo.setLista(lista);
        tblTabla.setModel(modelo);
        tblTabla.updateUI();
    }

    private void generarDatos() {

        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        Integer size = 2000;
        for (int i = 0; i < size; i++) {
            lista.insertar((int) (Math.random() * 2000));
        }

        // Ordenar los datos según quicksort o mergesort seleccionado
        if (cbxMetodo.getSelectedItem().equals("MergeSort")) {
            long startTime = System.currentTimeMillis();
            MergeSort<Integer> ms = new MergeSort<>();
            ms.mergeSort(lista);
            long endTime = System.currentTimeMillis();

            long executionTime = endTime - startTime;
            System.out.println("Tiempo de ejecución merge: " + executionTime + " milisegundos");
        } else if (cbxMetodo.getSelectedItem().equals("QuickSort")) {
            QuickSort<Integer> qs = new QuickSort<>();
            long startTime = System.currentTimeMillis();
            // Llamar al método de ordenamiento aquí
            qs.quicksortRecursivo(lista);
            long endTime = System.currentTimeMillis();

            long executionTime = endTime - startTime;
            System.out.println("Tiempo de ejecución quick: " + executionTime + " milisegundos");

        }

        ordenarDatos();

        // Actualizar la tabla con los datos ordenados
        actualizarTabla(lista);
    }

    public void setModeloTabla(ModeloTabla modeloTabla) {
        this.modelo = modeloTabla;
    }

    private void ordenarDatos() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        for (int i = 0; i < tblTabla.getRowCount(); i++) {
            lista.insertar((Integer) tblTabla.getValueAt(i, 0));
        }

        // Aplicar el orden (ascendente o descendente)
        if (cbxOrden.getSelectedItem().equals("Ascendente")) {
            MergeSort<Integer> ms = new MergeSort<>();
            ms.mergeSort(lista);
        } else if (cbxOrden.getSelectedItem().equals("Descendente")) {
            QuickSort<Integer> qs = new QuickSort<>();
            qs.quicksortRecursivo(lista);
            lista = invertirLista(lista);
        }

        // Actualizar la tabla con los datos ordenados
        actualizarTabla(lista);
    }

    private ListaEnlazada<Integer> invertirLista(ListaEnlazada<Integer> lista) {
        ListaEnlazada<Integer> listaInvertida = new ListaEnlazada<>();
        Nodo<Integer> nodo = lista.getPrimerNodo();

        while (nodo != null) {
            listaInvertida.insertarAlInicio(nodo.getDato());
            nodo = nodo.getSiguiente();
        }

        return listaInvertida;
    }

    private void actualizarTabla(ListaEnlazada<Integer> lista) {
        
        ModeloTabla modelo = (ModeloTabla) tblTabla.getModel();// Limpiar la tabla
        modelo.setRowCount(0);

        // Agregar los datos ordenados a la tabla
        Nodo<Integer> nodo = lista.getPrimerNodo();
        while (nodo != null) {
            modelo.addRow(nodo.getDato());
            nodo = nodo.getSiguiente();
        }
    }

    private void configurarControladorMetodo() {
        cbxMetodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarDatos();
            }
        });
    }

    private void configurarControladorOrden() {
        cbxOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ordenarDatos();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        btnGenerar = new javax.swing.JButton();
        cbxMetodo = new javax.swing.JComboBox<>();
        cbxOrden = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ordenacion de datos");

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTabla);

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "MergeSort", "QuickSort" }));
        cbxMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMetodoActionPerformed(evt);
            }
        });

        cbxOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        cbxOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrdenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnGenerar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(cbxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnGenerar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        generarDatos();

    }//GEN-LAST:event_btnGenerarActionPerformed

    private void cbxMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMetodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMetodoActionPerformed

    private void cbxOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOrdenActionPerformed


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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmOrdenacion dialog = new FrmOrdenacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JComboBox<String> cbxOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTabla;
    // End of variables declaration//GEN-END:variables
}
