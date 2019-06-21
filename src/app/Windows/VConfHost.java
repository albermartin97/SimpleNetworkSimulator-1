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
public class VConfHost extends javax.swing.JFrame {

    private SimulatorItem si;
    private HostItem ci;
    private VAddPackage vAddPackage;
    private VRandomSend vRandomSend;
    private VMain vMain;

    /**
     * Creates new form VConfComputer
     */
    public VConfHost() {
        initComponents();
        setLocation((getToolkit().getScreenSize().width - this.getWidth()) / 2,
                (getToolkit().getScreenSize().height - this.getHeight()) / 2);
    }

    public VConfHost(HostItem ci, VMain vMain) {
        this.ci = ci;
        this.si = vMain.getSI();
        this.vMain = vMain;
        initComponents();
        this.setVisible(true);
        configComponents();
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
        lblNameComputer = new javax.swing.JLabel();
        txtNameComputer = new javax.swing.JTextField();
        btnAceptarConfHost = new javax.swing.JButton();
        jComputerTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tComputer = new javax.swing.JTable();
        btnCancelarConfHost = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnAddPackage = new javax.swing.JButton();
        btnRemovePackage = new javax.swing.JButton();
        rbtnEnvioAleatorio = new javax.swing.JRadioButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle"); // NOI18N
        setTitle(bundle.getString("VConfHost.title")); // NOI18N
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        lblNameComputer.setText(bundle.getString("VConfHost.lblNameComputer.text_1")); // NOI18N

        txtNameComputer.setToolTipText(bundle.getString("VConfHost.txtNameComputer.toolTipText_1")); // NOI18N

        btnAceptarConfHost.setText(bundle.getString("VConfHost.btnAceptarConfHost.text_1")); // NOI18N
        btnAceptarConfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarConfHostActionPerformed(evt);
            }
        });

        tComputer.setModel(new app.Elements.HostTable(ci.getVertex()));
        jScrollPane1.setViewportView(tComputer);

        javax.swing.GroupLayout jComputerTableLayout = new javax.swing.GroupLayout(jComputerTable);
        jComputerTable.setLayout(jComputerTableLayout);
        jComputerTableLayout.setHorizontalGroup(
            jComputerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jComputerTableLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        jComputerTableLayout.setVerticalGroup(
            jComputerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        btnCancelarConfHost.setText(bundle.getString("VConfHost.btnCancelarConfHost.text_1")); // NOI18N
        btnCancelarConfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConfHostActionPerformed(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        btnAddPackage.setText(bundle.getString("VConfHost.btnAddPackage.text_1")); // NOI18N
        btnAddPackage.setToolTipText(bundle.getString("VConfHost.btnAddPackage.toolTipText_1")); // NOI18N
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

        btnRemovePackage.setText(bundle.getString("VConfHost.btnRemovePackage.text_1")); // NOI18N
        btnRemovePackage.setToolTipText(bundle.getString("VConfHost.btnRemovePackage.toolTipText_1")); // NOI18N
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

        rbtnEnvioAleatorio.setText(bundle.getString("VConfHost.rbtnEnvioAleatorio.text_1")); // NOI18N
        rbtnEnvioAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEnvioAleatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jConfComputerLayout = new javax.swing.GroupLayout(jConfComputer);
        jConfComputer.setLayout(jConfComputerLayout);
        jConfComputerLayout.setHorizontalGroup(
            jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConfComputerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addComponent(jComputerTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnEnvioAleatorio))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jConfComputerLayout.createSequentialGroup()
                                .addComponent(lblNameComputer)
                                .addGap(18, 18, 18)
                                .addComponent(txtNameComputer))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jConfComputerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAceptarConfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarConfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))
                        .addContainerGap())))
        );
        jConfComputerLayout.setVerticalGroup(
            jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConfComputerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameComputer)
                    .addComponent(txtNameComputer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnEnvioAleatorio)
                        .addGap(53, 53, 53))
                    .addGroup(jConfComputerLayout.createSequentialGroup()
                        .addComponent(jComputerTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jConfComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAceptarConfHost, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnCancelarConfHost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(159, 159, 159))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jConfComputer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jConfComputer, javax.swing.GroupLayout.PREFERRED_SIZE, 234, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnEnvioAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEnvioAleatorioActionPerformed
        boolean enabled = rbtnEnvioAleatorio.isSelected();
        btnAddPackage.setEnabled(!enabled);
        btnRemovePackage.setEnabled(!enabled);
        jComputerTable.setEnabled(!enabled);
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
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
        this.setVisible(false);
        this.vMain.setRouting(false);
        if(ci.getLocation().x  == 0 && ci.getLocation().y == 0)
            ci.setBounds(150, 150, 120, 120);
        ci.setName(txtNameComputer.getText());
        ci.getLblName().setText(txtNameComputer.getText());
        ci.getVertex().getElement().setName(txtNameComputer.getText());
        JPopupMenu popUpMenuHost = new JPopupMenu();
        JMenuItem miConfigurar = new JMenuItem();
        miConfigurar.setText(bundle.getString("VConfWorkSpace"));
        miConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VConfHost vConfComputer = new VConfHost(ci, vMain);
                //vConfComputer.setVisible(true);
            }
        });
        popUpMenuHost.add(miConfigurar);
        JMenuItem miEliminar = new JMenuItem();
        miEliminar.setText(bundle.getString("VRemoveWorkSpace"));
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
        this.tComputer.setModel(new HostTable(ci.getVertex()));
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblNameComputer;
    private javax.swing.JRadioButton rbtnEnvioAleatorio;
    private javax.swing.JTable tComputer;
    private javax.swing.JTextField txtNameComputer;
    // End of variables declaration//GEN-END:variables

    private void configComponents() {
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
}
