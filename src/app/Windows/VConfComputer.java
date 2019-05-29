/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Windows;

import app.Elements.HostItem;
import app.Elements.HostTable;
import app.Elements.LinkerItem;
import app.Elements.SimulatorItem;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import objects.Host;

/**
 *
 * @author alber
 */
public class VConfComputer extends javax.swing.JFrame {

    private SimulatorItem si;
    private HostItem ci;
    private VAddPackage vAddPackage;
    private VRandomSend vRandomSend;
    private VMain vMain;

    /**
     * Creates new form VConfComputer
     */
    public VConfComputer() {
        initComponents();
        setLocation((getToolkit().getScreenSize().width - this.getWidth()) / 2,
                (getToolkit().getScreenSize().height - this.getHeight()) / 2);
    }

    public VConfComputer(HostItem ci, VMain vMain) {
        this.ci = ci;
        this.si = vMain.getSI();
        this.vMain = vMain;
        this.setVisible(true);
        initComponents();
        if (ci.getVertex().getElement() instanceof Host) {
            Host c = (Host) ci.getVertex().getElement();
            txtNameComputer.setText(c.getName());
            rbtnEnvioAleatorio.setSelected(c.isRandomSend());
            if (rbtnEnvioAleatorio.isSelected()) {
                this.setEnabled(false);
                this.vRandomSend = new VRandomSend(this,c);
                vRandomSend.setVisible(true);
            }
        }
        btnRemovePackage.setEnabled(ci.getVertex().getElement().getQueuePackages().size() != 0);

        setLocation((getToolkit().getScreenSize().width - this.getWidth()) / 2,
                (getToolkit().getScreenSize().height - this.getHeight()) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jConfComputer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNameComputer = new javax.swing.JLabel();
        txtNameComputer = new javax.swing.JTextField();
        jComputerTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tComputer = new javax.swing.JTable();
        rbtnEnvioAleatorio = new javax.swing.JRadioButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnAddPackage = new javax.swing.JButton();
        btnRemovePackage = new javax.swing.JButton();
        btnAceptarConfHost = new javax.swing.JButton();
        btnCancelarConfHost = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle"); // NOI18N
        setTitle(bundle.getString("VConfComputer.title")); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(bundle.getString("VConfComputer.jLabel1.text")); // NOI18N

        lblNameComputer.setText(bundle.getString("VConfComputer.lblNameComputer.text")); // NOI18N

        txtNameComputer.setToolTipText(bundle.getString("VConfComputer.txtNameComputer.toolTipText")); // NOI18N

        tComputer.setModel(new app.Elements.HostTable(si.getSimulator(),ci.getVertex()));
        jScrollPane1.setViewportView(tComputer);

        javax.swing.GroupLayout jComputerTableLayout = new javax.swing.GroupLayout(jComputerTable);
        jComputerTable.setLayout(jComputerTableLayout);
        jComputerTableLayout.setHorizontalGroup(
            jComputerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
            .addGroup(jComputerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jComputerTableLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jComputerTableLayout.setVerticalGroup(
            jComputerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
            .addGroup(jComputerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jComputerTableLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        rbtnEnvioAleatorio.setText(bundle.getString("VConfComputer.rbtnEnvioAleatorio.text")); // NOI18N
        rbtnEnvioAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEnvioAleatorioActionPerformed(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        btnAddPackage.setText(bundle.getString("VConfComputer.btnAddPackage.text")); // NOI18N
        btnAddPackage.setToolTipText(bundle.getString("VConfComputer.btnAddPackage.toolTipText")); // NOI18N
        btnAddPackage.setFocusable(false);
        btnAddPackage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddPackage.setMargin(new java.awt.Insets(6, 14, 2, 14));
        btnAddPackage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPackageActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAddPackage);

        btnRemovePackage.setText(bundle.getString("VConfComputer.btnRemovePackage.text")); // NOI18N
        btnRemovePackage.setToolTipText(bundle.getString("VConfComputer.btnRemovePackage.toolTipText")); // NOI18N
        btnRemovePackage.setEnabled(false);
        btnRemovePackage.setFocusable(false);
        btnRemovePackage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemovePackage.setMargin(new java.awt.Insets(6, 14, 2, 14));
        btnRemovePackage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemovePackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePackageActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemovePackage);

        btnAceptarConfHost.setText(bundle.getString("VConfComputer.btnAceptarConfHost.text")); // NOI18N
        btnAceptarConfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarConfHostActionPerformed(evt);
            }
        });

        btnCancelarConfHost.setText(bundle.getString("VConfComputer.btnCancelarConfHost.text")); // NOI18N
        btnCancelarConfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConfHostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jConfComputerLayout = new javax.swing.GroupLayout(jConfComputer);
        jConfComputer.setLayout(jConfComputerLayout);
        jConfComputerLayout.setHorizontalGroup(
            jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jConfComputerLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnAceptarConfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(btnCancelarConfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComputerTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jConfComputerLayout.createSequentialGroup()
                .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(lblNameComputer)
                        .addGap(26, 26, 26)
                        .addComponent(txtNameComputer, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jConfComputerLayout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(rbtnEnvioAleatorio)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jConfComputerLayout.setVerticalGroup(
            jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConfComputerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63))
                    .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNameComputer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNameComputer)))
                .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(rbtnEnvioAleatorio)
                        .addGap(18, 18, 18)
                        .addComponent(jComputerTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jConfComputerLayout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)))
                .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarConfHost, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnAceptarConfHost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jConfComputer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jConfComputer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnEnvioAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEnvioAleatorioActionPerformed
        boolean enabled = rbtnEnvioAleatorio.isSelected();
        btnAddPackage.setVisible(!enabled);
        btnRemovePackage.setVisible(!enabled);
        jComputerTable.setVisible(!enabled);
        this.setEnabled(!enabled);
        if (enabled) {
            this.setEnabled(false);
            this.vRandomSend = new VRandomSend(this);
            vRandomSend.setVisible(true);
        } else {
            if (ci.getVertex().getElement() instanceof Host) {
                Host computer = (Host) ci.getVertex()
                        .getElement();
                computer.setRandomSend(null);

            }

        }

    }//GEN-LAST:event_rbtnEnvioAleatorioActionPerformed

    private void btnAddPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPackageActionPerformed
        this.vAddPackage = new VAddPackage(this);
        this.setEnabled(false);
        this.vAddPackage.setVisible(true);
    }//GEN-LAST:event_btnAddPackageActionPerformed

    private void btnAceptarConfHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarConfHostActionPerformed
        this.setVisible(false);
        this.vMain.setRouting(false);
        if(ci.getLocation().x  == 0 && ci.getLocation().y == 0)
            ci.setBounds(150, 150, 120, 120);
        ci.setName(txtNameComputer.getText());
        ci.getLblName().setText(txtNameComputer.getText());
        ci.getVertex().getElement().setName(txtNameComputer.getText());
        JPopupMenu popUpMenuHost = new JPopupMenu();
        JMenuItem miConfigurar = new JMenuItem();
        miConfigurar.setText("Configurar Host");
        miConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VConfComputer vConfComputer = new VConfComputer(ci, vMain);
                //vConfComputer.setVisible(true);
            }
        });
        popUpMenuHost.add(miConfigurar);
        JMenuItem miEliminar = new JMenuItem();
        miEliminar.setText("Eliminar Host");
        miEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                si.getWorkSpacePanel().remove(ci.getLblName());
                si.getWorkSpacePanel().remove(ci);
                si.getSimulator().getRed().removeHost(ci.getVertex());
                si.getWorkSpacePanel().updateUI();
                vMain.setRouting(false);
                for (LinkerItem li : ci.getLinkers()) {
                    boolean borrado = si.getWorkSpacePanel().getLinkers().remove(li);
                    if(borrado)
                        si.getWorkSpacePanel().remove(li.getLblName());
                }
                si.getWorkSpacePanel().getChildsItems().remove(ci);
                enabledBotons();
            }
        });
        popUpMenuHost.add(miEliminar);
        ci.setComponentPopupMenu(popUpMenuHost);
        if (!si.getWorkSpacePanel().getChildsItems().contains(ci)) {
            si.getWorkSpacePanel().add(ci);
        }
        if (ci.getVertex().getElement() instanceof Host) {
            Host c = (Host) ci.getVertex().getElement();
            vMain.setAnyRandom(c.isRandomSend());
        }
        enabledBotons();

        //si.getWorkSpacePanel().getChildsItems().add(ci);
        si.getWorkSpacePanel().updateUI();
    }//GEN-LAST:event_btnAceptarConfHostActionPerformed

    private void btnCancelarConfHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConfHostActionPerformed
        ci = new HostItem();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarConfHostActionPerformed

    private void btnRemovePackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePackageActionPerformed
        String paquete = (String) tComputer.getValueAt(tComputer.getSelectedRow(), 0);
        int id = Integer.parseInt(paquete.split(" ")[1]);
        if (ci.getVertex().getElement() instanceof Host) {
            Host c = (Host) ci.getVertex().getElement();
            c.removePackage(id);
        }
        this.updateTComputer();
    }//GEN-LAST:event_btnRemovePackageActionPerformed

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
            java.util.logging.Logger.getLogger(VConfComputer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VConfComputer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VConfComputer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VConfComputer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VConfComputer().setVisible(true);
            }
        });
    }

    public SimulatorItem getSI() {
        return this.si;
    }

    public HostItem getCI() {
        return this.ci;
    }

    public void setSI(SimulatorItem si) {
        this.si = si;
    }

    public void setCI(HostItem ci) {
        this.ci = ci;
    }

    public JTable getTComputer() {
        return this.tComputer;
    }

    public void updateTComputer() {
        this.tComputer.setModel(new HostTable(si.getSimulator(), ci.getVertex()));
    }

    public JRadioButton getRbtnEnvioAleatorio() {
        return this.rbtnEnvioAleatorio;
    }

    public JButton getAddPackage() {
        return btnAddPackage;
    }

    public JButton getRemovePackage() {
        return btnRemovePackage;
    }

    public JPanel getComputerTable() {
        return jComputerTable;
    }

    public void enabledBotons() {
        if (si.getWorkSpacePanel().getChildsItems().size() >= 2) {
            this.vMain.getBtnNewLinker().setEnabled(true);
        } else {
            this.vMain.getBtnNewLinker().setEnabled(false);
        }
        if (si.getWorkSpacePanel().getChildsItems().size() > 0 && si.getWorkSpacePanel().getLinkers().size() >= si.getWorkSpacePanel().getChildsItems().size() - 1) {
            this.vMain.getBtnStart().setEnabled(true);
        } else {
            this.vMain.getBtnStart().setEnabled(false);
        }
    }

    public JButton getBtnRemovePackage() {
        return btnRemovePackage;
    }

    public void setBtnRemovePackage(JButton btnRemovePackage) {
        this.btnRemovePackage = btnRemovePackage;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarConfHost;
    private javax.swing.JButton btnAddPackage;
    private javax.swing.JButton btnCancelarConfHost;
    private javax.swing.JButton btnRemovePackage;
    private javax.swing.JPanel jComputerTable;
    private javax.swing.JPanel jConfComputer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblNameComputer;
    private javax.swing.JRadioButton rbtnEnvioAleatorio;
    private javax.swing.JTable tComputer;
    private javax.swing.JTextField txtNameComputer;
    // End of variables declaration//GEN-END:variables
}
