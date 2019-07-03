package app.Elements;

import app.Windows.VConfLinker;
import app.Windows.VConfRouter;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import material.graphs.Edge;
import objects.Linker;

public class LinkerItem extends JPanel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Edge<Linker> linker;
    private SimulatorItem si;
    private NodeItem h1;
    private NodeItem h2;
    private JLabel lblName;

    @Override
    public void paint(Graphics g) {
        lblName.setBounds((h1.getX() + h2.getX()) / 2, (h1.getY() + h2.getY()) / 2, 100, 20);
        g.drawLine(h1.getX() + h1.getWidth() / 2, h1.getY() + h1.getHeight() / 2, h2.getX() + h2.getWidth() / 2, h2.getY() + h2.getHeight() / 2);
    }

    public LinkerItem(SimulatorItem simulatorItem, NodeItem h1, NodeItem h2) {
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
        this.lblName = new JLabel();
        this.si = simulatorItem;
        lblName.setBounds((h1.getX() + h2.getX()) / 2, (h1.getY() + h2.getY()) / 2, 100, 20);
        lblName.setVisible(true);
        lblName.setFont(new java.awt.Font("Tahoma", 1, 14));
        JPopupMenu popUpMenuHost = new JPopupMenu();
        JMenuItem miConfigurar = new JMenuItem();
        miConfigurar.setText(bundle.getString("VConfLinker"));
        miConfigurar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VConfLinker vConfLinker = new VConfLinker(linker, simulatorItem.getvMain());
                vConfLinker.setVisible(true);
            }
        });
        popUpMenuHost.add(miConfigurar);
        JMenuItem miEliminar = new JMenuItem();
        miEliminar.setText(bundle.getString("VRemoveLinker"));
        miEliminar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                si.getSimulator().getRed().removeLinker(linker);
                si.getWorkSpacePanel().updateUI();
                si.getvMain().setRouting(false);
                LinkerItem linkerItem = null;
                for (LinkerItem li : si.getWorkSpacePanel().getLinkers()) {
                    if (li.getLblName().getText().equals(lblName.getText())) {
                        linkerItem = li;
                    }
                }
                boolean borrado = si.getWorkSpacePanel().getLinkers().remove(linkerItem);
                if (borrado) {
                    si.getWorkSpacePanel().remove(lblName);
                }
            }
        });
        popUpMenuHost.add(miEliminar);
        lblName.setComponentPopupMenu(popUpMenuHost);
        this.si.getWorkSpacePanel().add(lblName);
        this.h1 = h1;
        this.h2 = h2;
    }

    public NodeItem getH1() {
        return h1;
    }

    public void setH1(NodeItem h1) {
        this.h1 = h1;
    }

    public NodeItem getH2() {
        return h2;
    }

    public void setH2(NodeItem h2) {
        this.h2 = h2;
    }

    public Edge<Linker> getLinker() {
        return linker;
    }

    public void setLinker(Edge<Linker> linker) {
        this.linker = linker;
        this.lblName.setText(linker.getElement().getIp());
    }

    public JLabel getLblName() {
        return lblName;
    }

    public void setLblName(JLabel lblName) {
        this.lblName = lblName;
    }

    @Override
    public String toString() {
        return "LinkerItem{\n" + linker.getElement().toString() + ",\n" + h1.getVertex().getElement().getName() + ",\n" + h2.getVertex().getElement().getName() + "}\n";
    }

}
