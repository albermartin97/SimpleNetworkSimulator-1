package app.Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MyMouseMotionAdapter extends MouseMotionAdapter {

    private NodeItem parent;

    public MyMouseMotionAdapter() {
        super();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point limits = parent.getSimulatorItem().getWorkSpacePanel().getLocation();
        int wLimit = parent.getSimulatorItem().getWorkSpaceScroll().getWidth();
        int hLimit = parent.getSimulatorItem().getWorkSpaceScroll().getHeight();
        int x = parent.getX() + e.getX() - parent.getDragX();
        int y = parent.getY() + e.getY() - parent.getDragY();
        if (-x < limits.x && -y < limits.y && -x > limits.x - wLimit + parent.getWidth() && -y > limits.y - hLimit + parent.getHeight()) {
            Graphics g = parent.getSimulatorItem().getWorkSpacePanel().getGraphics();
            parent.getSimulatorItem().getWorkSpacePanel().setBackground(Color.WHITE);

            parent.setLocation(x, y);

            parent.getSimulatorItem().getWorkSpacePanel().repaint();
        }
    }

    public NodeItem getParent() {
        return parent;
    }

    public void setParent(NodeItem parent) {
        this.parent = parent;
    }

}
