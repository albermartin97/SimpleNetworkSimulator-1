/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Windows;

import app.Elements.HostItem;
import app.Elements.SimulatorItem;
import java.math.BigDecimal;
import java.util.List;
import material.graphs.Vertex;
import objects.Node;
import app.Elements.NodeItem;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class VAddPackage extends javax.swing.JFrame {

    private SimulatorItem si;
    private String[] computerList;
    private HostItem ci;
    private VConfHost vConfComputer;

    /**
     * Creates new form VAddPackage
     */
    public VAddPackage() {
        initComponents();
        setLocation((getToolkit().getScreenSize().width - this.getWidth()) / 2, 
                (getToolkit().getScreenSize().height - this.getHeight()) / 2);
    }

    public VAddPackage(VConfHost vConfComputer) {
        this.si = vConfComputer.getSI();
        this.ci = vConfComputer.getCI();
        this.vConfComputer = vConfComputer;
        List<Vertex<Node>> vhList = null;
        vhList = this.si.getSimulator().getRed().getAllHosts();
        computerList = new String[vhList.size()];
        int i = 0;
        for (Vertex<Node> vh : vhList) {
            computerList[i] = vh.getElement().getName();
            i++;
        }
        setLocation((getToolkit().getScreenSize().width - this.getWidth()) / 2, 
                (getToolkit().getScreenSize().height - this.getHeight()) / 2);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTamañoPackage = new javax.swing.JTextField();
        jcbDestinoPackage = new javax.swing.JComboBox<>(this.computerList);
        lblKb = new javax.swing.JLabel();
        lblTamañoPackage = new javax.swing.JLabel();
        lblDestinoPackage = new javax.swing.JLabel();
        btnAceptarPackage = new javax.swing.JButton();
        btnCancelarPackage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle"); // NOI18N
        setTitle(bundle.getString("VAddPackage.title")); // NOI18N
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        txtTamañoPackage.setToolTipText(bundle.getString("VAddPackage.txtTamañoPackage.toolTipText")); // NOI18N

        jcbDestinoPackage.setToolTipText(bundle.getString("VAddPackage.jcbDestinoPackage.toolTipText")); // NOI18N

        lblKb.setText(bundle.getString("VAddPackage.lblKb.text")); // NOI18N

        lblTamañoPackage.setText(bundle.getString("VAddPackage.lblTamañoPackage.text")); // NOI18N

        lblDestinoPackage.setText(bundle.getString("VAddPackage.lblDestinoPackage.text")); // NOI18N

        btnAceptarPackage.setText(bundle.getString("VAddPackage.btnAceptarPackage.text")); // NOI18N
        btnAceptarPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarPackageActionPerformed(evt);
            }
        });

        btnCancelarPackage.setText(bundle.getString("VAddPackage.btnCancelarPackage.text")); // NOI18N
        btnCancelarPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPackageActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTamañoPackage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDestinoPackage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTamañoPackage)
                            .addComponent(jcbDestinoPackage, 0, 166, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblKb))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnAceptarPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTamañoPackage)
                    .addComponent(txtTamañoPackage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDestinoPackage)
                    .addComponent(jcbDestinoPackage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarPackage)
                    .addComponent(btnCancelarPackage))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarPackageActionPerformed
        if(getChildItem(jcbDestinoPackage.getSelectedItem().toString()) != null){
            this.setVisible(false);
            ci.getVertex()
                    .getElement()
                    .addPackage(new objects.Package(new BigDecimal(txtTamañoPackage
                                    .getText()),
                                    (Vertex<Node>) getChildItem(jcbDestinoPackage
                                            .getSelectedItem().toString())));
            this.vConfComputer.updateTComputer();
            this.vConfComputer.setEnabled(true);
            this.vConfComputer.getRemovePackage().setEnabled(true);
            this.vConfComputer.setVisible(true);
            this.vConfComputer.getBtnRemovePackage().setEnabled(true);
        }else{
            java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
            JOptionPane.showMessageDialog(this,bundle.getString("ErrorDestinoPaquete"),bundle.getString("ErrorDestinoPaqueteTitulo"),JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarPackageActionPerformed

    private void btnCancelarPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPackageActionPerformed
        this.setVisible(false);
        this.vConfComputer.setEnabled(true);
        ci = new HostItem();
    }//GEN-LAST:event_btnCancelarPackageActionPerformed


    private Vertex<Node> getChildItem(String selectedItem) {
        for (NodeItem hi : this.si.getWorkSpacePanel()
                .getChildsItems()) {
            if (hi.getVertex().getElement().getName()
                    .equalsIgnoreCase(selectedItem)) {
                return hi.getVertex();
            }
        }
        return null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarPackage;
    private javax.swing.JButton btnCancelarPackage;
    private javax.swing.JComboBox<String> jcbDestinoPackage;
    private javax.swing.JLabel lblDestinoPackage;
    private javax.swing.JLabel lblKb;
    private javax.swing.JLabel lblTamañoPackage;
    private javax.swing.JTextField txtTamañoPackage;
    // End of variables declaration//GEN-END:variables
}
