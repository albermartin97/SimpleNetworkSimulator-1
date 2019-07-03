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

    public RouterItem() {

    }

    public RouterItem(SimulatorItem simulatorItem, String name) {
        Router router = new Router(name);
        lblName = new JLabel();
        lblName.setText(name);
        this.setName(name);
        this.lblName.setVisible(true);
        lblName.setFont(new java.awt.Font("Tahoma", 1, 14));
        this.simulatorItem = simulatorItem;
        this.linkers = new ArrayList<>();
        this.vertex = simulatorItem.getSimulator().getRed().addRouter(router);
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
        lblName.setBounds(this.getX() + 20 ,this.getY() - 30,100,20);
        this.setSize(new Dimension(60, 60));
        ImageIcon imageIcon;
        Image image;
        imageIcon = new ImageIcon(getClass().getResource("/images/RouterIcon.png"));
        image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
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
    public SimulatorItem getSimulatorItem() {
        return simulatorItem;
    }

    @Override
    public void setSimulatorItem(SimulatorItem simulatorItem) {
        this.simulatorItem = simulatorItem;
    }

    @Override
    public Vertex<Node> getVertex() {
        return vertex;
    }

    @Override
    public void setVertex(Vertex<Node> router) {
        this.vertex = router;
    }

    @Override
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
    @Override
    public String toStringAux() {
        return "RouterItem{" + vertex.getElement().getName() + "}";
    }
}
