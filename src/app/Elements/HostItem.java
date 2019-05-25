package app.Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import material.graphs.Vertex;
import objects.Host;
import objects.Node;

public class HostItem extends JPanel implements NodeItem, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private SimulatorItem simulatorItem;
    private List<LinkerItem> linkers;
    private Vertex<Node> vertex;
    private boolean drag;
    private int dragX;
    private int dragY;
    private JLabel lblName;
    private JPanel jName;

    public HostItem() {

    }

    public HostItem(SimulatorItem simulator, String name) {
        Host computer = new Host(name);
        this.setName(name);
        lblName = new JLabel();
        lblName.setText(name);
        //jName = new JPanel();
        //jName.setBackground(Color.WHITE);
        //jName.add(lblName);
        
        this.lblName.setVisible(true);
        //lblName.setBounds((this.getX() + this.getWidth())/2,  (this.getY() + this.getHeight())/2, this.getWidth() + 100, this.getHeight() + 100);
        //lblName.setBounds(15,40,20,20);
        //lblName.setLocation(10,10);
        lblName.setFont(new java.awt.Font("Tahoma", 1, 14));
        this.simulatorItem = simulator;
        this.linkers = new ArrayList<>();
        this.vertex = this.simulatorItem.getSimulator().getRed().addComputer(computer);
        MyMouseAdapter m1 = new MyMouseAdapter();
        m1.setParent(this);
        this.drag = false;
        this.addMouseListener(m1);
        MyMouseMotionAdapter m2 = new MyMouseMotionAdapter();
        m2.setParent(this);
        this.addMouseMotionListener(m2);
        this.simulatorItem.getWorkSpacePanel().add(lblName);
    }

    @Override
    public void paint(Graphics g) {
        lblName.setBounds(this.getX() + 20 ,this.getY() - 30,20,20);
        this.setSize(new Dimension(60, 60));
        ImageIcon imageIcon;
        Image image;
        imageIcon = new ImageIcon(getClass().getResource("/images/ComputerIcon2.png"));
        image = imageIcon.getImage();       
        //super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        //this.jName.updateUI();
        //super.repaint();
    }

    @Override
    public boolean isDrag() {
        return drag;
    }

    @Override
    public void setDrag(boolean drag) {
        this.drag = drag;
    }

    @Override
    public int getDragX() {
        return dragX;
    }

    @Override
    public void setDragX(int dragX) {
        this.dragX = dragX;
    }

    @Override
    public int getDragY() {
        return dragY;
    }

    @Override
    public void setDragY(int dragY) {
        this.dragY = dragY;
    }

    @Override
    public Vertex<Node> getVertex() {
        return vertex;
    }

    @Override
    public void setVertex(Vertex<Node> vertex) {
        this.vertex = vertex;
    }

    @Override
    public SimulatorItem getSimulatorItem() {
        return simulatorItem;
    }

    @Override
    public void setSimulatorItem(SimulatorItem simulatorItem) {
        this.simulatorItem = simulatorItem;
    }

    @Override
    public List<LinkerItem> getLinkers() {
        return linkers;
    }

    public void setLinkers(List<LinkerItem> linkers) {
        this.linkers = linkers;
    }

    public JLabel getLblName() {
        return lblName;
    }

    @Override
    public String toString() {
        return "ComputerItem{\n"+ this.getLocation().x + ",\n" + this.getLocation().y + ",\n" + vertex.getElement().toString() + "}\n";
    }

    @Override
    public String toStringAux() {
        return "ComputerItem{" + vertex.getElement().getName() + "}";
    }
}
