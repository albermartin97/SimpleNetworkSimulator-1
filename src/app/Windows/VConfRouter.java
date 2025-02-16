/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Windows;

import app.Elements.LinkerItem;
import app.Elements.RouterItem;
import app.Elements.SimulatorItem;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author alber
 */
public class VConfRouter extends javax.swing.JFrame {

    private SimulatorItem si;
    private VMain vMain;
    private RouterItem ri;

    /**
     * Creates new form VConfRouter
     */
    public VConfRouter() {
        initComponents();
        setLocation((getToolkit().getScreenSize().width - this.getWidth()) / 2, 
                (getToolkit().getScreenSize().height - this.getHeight()) / 2);
    }

    public VConfRouter(VMain vMain) {
        this.si = vMain.getSI();
        this.vMain = vMain;
        this.ri = new RouterItem(si,"");
        initComponents();
        setLocation((getToolkit().getScreenSize().width - this.getWidth()) / 2, 
                (getToolkit().getScreenSize().height - this.getHeight()) / 2);
    }
    public VConfRouter(RouterItem ri, VMain vMain) {
        this.si = vMain.getSI();
        this.vMain = vMain;
        initComponents();
        configComponents(ri);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNameRouter = new javax.swing.JLabel();
        txtNameRouter = new javax.swing.JTextField();
        btnCancelarConfRouter = new javax.swing.JButton();
        btnAceptarConfRouter = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle"); // NOI18N
        setTitle(bundle.getString("VConfRouter.title")); // NOI18N
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(360, 82));
        setResizable(false);

        lblNameRouter.setText(bundle.getString("VConfRouter.lblNameRouter.text")); // NOI18N

        txtNameRouter.setToolTipText(bundle.getString("VConfRouter.txtNameRouter.toolTipText")); // NOI18N

        btnCancelarConfRouter.setText(bundle.getString("VConfRouter.btnCancelarConfRouter.text")); // NOI18N
        btnCancelarConfRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConfRouterActionPerformed(evt);
            }
        });

        btnAceptarConfRouter.setText(bundle.getString("VConfRouter.btnAceptarConfRouter.text")); // NOI18N
        btnAceptarConfRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarConfRouterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptarConfRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarConfRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNameRouter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNameRouter)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameRouter)
                    .addComponent(txtNameRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarConfRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarConfRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarConfRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConfRouterActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarConfRouterActionPerformed

    private void btnAceptarConfRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarConfRouterActionPerformed
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
        this.setVisible(false);
        this.vMain.setRouting(false);
        this.ri.getVertex().getElement().setName(txtNameRouter.getText());
        if(ri.getLocation().x == 0 && ri.getLocation().y == 0)
            ri.setBounds(150, 150, 120, 120);
        ri.getLblName().setText(txtNameRouter.getText());
        ri.setName(txtNameRouter.getText());
        JPopupMenu popUpMenuHost = new JPopupMenu();
        JMenuItem miConfigurar = new JMenuItem();
        miConfigurar.setText(bundle.getString("VConfWorkSpace"));
        miConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VConfRouter vConfRouter = new VConfRouter(ri,vMain);
                vConfRouter.setVisible(true);
            }
        });
        popUpMenuHost.add(miConfigurar);
        JMenuItem miEliminar = new JMenuItem();
        miEliminar.setText(bundle.getString("VRemoveWorkSpace"));
        miEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                si.getWorkSpacePanel().remove(ri.getLblName());
                si.getWorkSpacePanel().remove(ri);
                si.getSimulator().getRed().removeHost(ri.getVertex());
                si.getWorkSpacePanel().updateUI();
                vMain.setRouting(false);
                for(LinkerItem li : ri.getLinkers()){
                    boolean borrado = si.getWorkSpacePanel().getLinkers().remove(li);
                    if(borrado)
                        si.getWorkSpacePanel().remove(li.getLblName());
                } 
                si.getWorkSpacePanel().getChildsItems().remove(ri);
                enabledBotons();
            }
        });
        popUpMenuHost.add(miEliminar);
        ri.setComponentPopupMenu(popUpMenuHost);
        if(!si.getWorkSpacePanel().getChildsItems().contains(ri))
            si.getWorkSpacePanel().add(ri);
        enabledBotons();
        
        si.getWorkSpacePanel().updateUI();
    }//GEN-LAST:event_btnAceptarConfRouterActionPerformed

    public void enabledBotons() {
        if (si.getWorkSpacePanel().getChildsItems().size() >= 2) {
            this.vMain.getBtnNewLinker().setEnabled(true);
        } else {
            this.vMain.getBtnNewLinker().setEnabled(false);
        }
        if (si.getWorkSpacePanel().getChildsItems().size() > 0 && si.getWorkSpacePanel().getLinkers().size() >= si.getWorkSpacePanel().getChildsItems().size() - 1) {
            this.vMain.getBtnEnrutar().setEnabled(true);
        } else {
            this.vMain.getBtnEnrutar().setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarConfRouter;
    private javax.swing.JButton btnCancelarConfRouter;
    private javax.swing.JLabel lblNameRouter;
    private javax.swing.JTextField txtNameRouter;
    // End of variables declaration//GEN-END:variables

    private void configComponents(RouterItem ri) {
        this.ri = ri;
        txtNameRouter.setText(ri.getName());
        setLocation((getToolkit().getScreenSize().width - this.getWidth()) / 2, 
                (getToolkit().getScreenSize().height - this.getHeight()) / 2);
    }
}
