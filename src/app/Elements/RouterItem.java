package app.Elements;

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
import objects.Router;
import objects.Node;

public class RouterItem extends JPanel implements NodeItem, Serializable {

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
    //private WorkSpacePanel workSpace;

    public RouterItem() {

    }

    public RouterItem(SimulatorItem simulatorItem, String name) {
        Router router = new Router(name);
        lblName = new JLabel();
        lblName.setText(name);
        this.setName(name);
        this.lblName.setVisible(true);
        //this.add(lblName);
        lblName.setFont(new java.awt.Font("Tahoma", 1, 14));
        this.simulatorItem = simulatorItem;
        this.linkers = new ArrayList<>();
        this.vertex = simulatorItem.getSimulator().getRed().addRouter(router);
        MyMouseAdapter m1 = new MyMouseAdapter();
        //m1.setWorkSpace(parent);
        m1.setParent(this);
        this.drag = false;
        this.addMouseListener(m1);
        MyMouseMotionAdapter m2 = new MyMouseMotionAdapter();
        //m2.setWorkSpace(parent);
        m2.setParent(this);
        this.addMouseMotionListener(m2);
        this.simulatorItem.getWorkSpacePanel().add(lblName);
    }

    @Override
    public void paint(Graphics g) {
        lblName.setBounds(this.getX() + 20 ,this.getY() - 30,100,20);
        this.setSize(new Dimension(60, 60));
        ImageIcon imageIcon;
        Image image;
        imageIcon = new ImageIcon(getClass().getResource("/images/RouterIcon2.png"));
        image = imageIcon.getImage();
        //super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        //this.lblName.paint(g);
    }

    public boolean isDrag() {
        return drag;
    }

    public void setDrag(boolean drag) {
        this.drag = drag;
    }

    public int getDragX() {
        return dragX;
    }

    public void setDragX(int dragX) {
        this.dragX = dragX;
    }

    public int getDragY() {
        return dragY;
    }

    public void setDragY(int dragY) {
        this.dragY = dragY;
    }

    public SimulatorItem getSimulatorItem() {
        return simulatorItem;
    }

    public void setSimulatorItem(SimulatorItem simulatorItem) {
        this.simulatorItem = simulatorItem;
    }

    public Vertex<Node> getVertex() {
        return vertex;
    }

    public void setVertex(Vertex<Node> router) {
        this.vertex = router;
    }

    public List<LinkerItem> getLinkers() {
        return linkers;
    }

    public void setLinkers(List<LinkerItem> linkers) {
        this.linkers = linkers;
    }
    public JLabel getLblName(){
        return lblName;
    }

    @Override
    public String toString() {
        return "RouterItem{\n"+ this.getLocation().x + ",\n" + this.getLocation().y + ",\n" + vertex.getElement().toString() + "}\n";
    }
    public String toStringAux() {
        return "RouterItem{" + vertex.getElement().getName() + "}";
    }
}
