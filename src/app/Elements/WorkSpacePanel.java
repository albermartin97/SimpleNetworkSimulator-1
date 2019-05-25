package app.Elements;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class WorkSpacePanel extends JPanel implements Serializable {

    private List<NodeItem> childsItems;
    private int dragX;
    private int dragY;
    private boolean drag;
    private List<LinkerItem> linkers;

    public WorkSpacePanel() {
        linkers = new ArrayList<>();
        childsItems = new ArrayList<>();
        /*
		 * this.childsItems = new ArrayList<>(); MyMouseAdapter m1 = new
		 * MyMouseAdapter(); m1.setWorkSpace(this); this.drag = false;
		 * this.addMouseListener(m1); MyMouseMotionAdapter m2 = new
		 * MyMouseMotionAdapter(); m2.setWorkSpace(this);
		 * this.addMouseMotionListener(m2);
         */
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /*if (childsItems != null)
			for (HostItem h : childsItems) {
				h.updateUI();
			}*/
        if (linkers != null) {
            for (LinkerItem l : linkers) {
                l.paint(g);
            }
        }
    }
    @Override
    public void updateUI(){
        super.updateUI();
        paint(this.getGraphics());
    }
    @Override
    public Component add(Component c) {
        if (c instanceof NodeItem) {
            this.childsItems.add((NodeItem) c);
        }
        return super.add(c);

    }
    public NodeItem findChild(String nameChild){
        for(NodeItem hi : this.childsItems){
            if(hi.getVertex().getElement().getName().equals(nameChild)){
                return hi;
            }
        }
        return null;
    }
    public LinkerItem findLinker(String nameLinker){
        for(LinkerItem li : this.linkers){
            if(li.getLinker().getElement().getIp().equals(nameLinker)){
                return li;
            }
        }
        return null;
    }
    public List<NodeItem> getChildsItems() {
        return childsItems;
    }

    public void setChildsItems(List<NodeItem> childsItems) {
        this.childsItems = childsItems;
    }

    public int getDragX() {
        return dragX;
    }

    public List<LinkerItem> getLinkers() {
        return linkers;
    }

    public void setLinkers(List<LinkerItem> linkers) {
        this.linkers = linkers;
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

    public boolean isDrag() {
        return drag;
    }

    public void setDrag(boolean drag) {
        this.drag = drag;
    }

    @Override
    public String toString() {
        return "WorkSpacePanel{\n" + childsItems.size() + "\n" + childsItems.toString() + ","+ linkers.size()+ "\n" + linkers.toString() + '}';
    }

}
