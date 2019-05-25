package app.Elements;

import java.awt.Container;
import java.awt.Graphics;
import java.util.List;

import material.graphs.Vertex;
import objects.Node;

/**
 *
 * @author alber
 */
public interface NodeItem {
	public void paint(Graphics g);
	public boolean isDrag();
	public void setDrag(boolean drag);
	public int getDragX();
	public void setDragX(int dragX);
	public int getDragY();
	public void setDragY(int dragY);
	public int getX();
	public int getY();
	public void setLocation(int x, int y);
	public Vertex<Node> getVertex();
	public void setVertex(Vertex<Node> host);
 	public SimulatorItem getSimulatorItem();
 	public void setSimulatorItem(SimulatorItem simulatorItem);
 	public int getWidth();
 	public int getHeight();
 	public List<LinkerItem> getLinkers();
 	public Container getParent();
 	public void updateUI();
 	public void setVisible(boolean b);
        @Override
        public String toString();
        public String toStringAux();
}
