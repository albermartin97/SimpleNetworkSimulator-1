package app.Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JLabel;

import material.graphs.Edge;
import objects.Linker;

public class LinkerItem implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Edge<Linker> linker;
    private SimulatorItem si;
    private NodeItem h1;
    private NodeItem h2;
    private JLabel lblName;
    
    public void paint(Graphics g) {
        lblName.setBounds((h1.getX() + h2.getX())/2,(h1.getY() +  h2.getY())/2,100,20);
        g.drawLine(h1.getX() + h1.getWidth() / 2, h1.getY() + h1.getHeight() / 2, h2.getX() + h2.getWidth() / 2, h2.getY() + h2.getHeight() / 2);
    }

    public LinkerItem(SimulatorItem simulatorItem,NodeItem h1, NodeItem h2) {
        this.lblName = new JLabel();
        this.si = simulatorItem;        
        //lblName.setText(linker.getElement().getIp());
        lblName.setBounds((h1.getX() + h2.getX())/2,(h1.getY() +  h2.getY())/2,100,20);
        lblName.setVisible(true);
        lblName.setFont(new java.awt.Font("Tahoma", 1, 14));
        //this.si.getWorkSpacePanel().getLayout().addLayoutComponent("lblLinker", lblName);
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
