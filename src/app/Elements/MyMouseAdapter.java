package app.Elements;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import material.graphs.Edge;
import objects.Linker;

public class MyMouseAdapter extends MouseAdapter {
    //private WorkSpacePanel workSpace;

    private NodeItem parent;

    public MyMouseAdapter() {
        super();
    }

    /*@Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
    }*/

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println(parent.getSimulatorItem().getWorkSpacePanel().getWidth() + "," + parent.getSimulatorItem().getWorkSpacePanel().getHeight());
        //System.out.println(parent.getX() + "," + parent.getY());
        if (parent.getSimulatorItem().isConectarHosts()) {
            //parent.getSimulatorItem().getWorkSpacePanel().updateUI();
            if (parent.getSimulatorItem().getClickHost() == 1) {
                Graphics g = parent.getSimulatorItem().getWorkSpacePanel().getGraphics();
                LinkerItem li = new LinkerItem(parent.getSimulatorItem(),parent, this.parent.getSimulatorItem().getAuxHost());
                //li.setLayout(null);
                //li.setBackground(Color.BLUE);	

                Edge<Linker> l = parent.getSimulatorItem().getSimulator().getRed().connect(parent.getVertex(), this.parent.getSimulatorItem().getAuxHost().getVertex(), parent.getSimulatorItem().getL().getIp(), parent.getSimulatorItem().getL().getSpeed(), parent.getSimulatorItem().getL().getDistance());
                li.setLinker(l);
                li.getLblName().setText(l.getElement().getIp());
                //parent.getSimulatorItem().getWorkSpacePanel().add(li);
                //li.updateUI();
                parent.getSimulatorItem().setClickHost(0);
                parent.getSimulatorItem().setConectarHosts(false);
                parent.getSimulatorItem().getWorkSpacePanel().getLinkers().add(li);

                parent.getLinkers().add(li);
                parent.getSimulatorItem().getAuxHost().getLinkers().add(li);
                

                parent.getSimulatorItem().getMenu().setVisible(true);
                //parent.getSimulatorItem().getPallette().setVisible(true);
                parent.getSimulatorItem().getWorkSpacePanel().paint(g);
//				//g.drawLine(parent.getX(), parent.getY(), this.parent.getSimulatorItem().getAuxHost().getX(), this.parent.getSimulatorItem().getAuxHost().getY());
                //li.repaint(g);
                //parent.getSimulatorItem().getWorkSpacePanel().updateUI();
            } else {
                this.parent.getSimulatorItem().setAuxHost(parent);
                parent.getSimulatorItem().setClickHost(parent.getSimulatorItem().getClickHost() + 1);
            }
        }
    }

    public NodeItem getParent() {
        return parent;
    }

    public void setParent(NodeItem parent) {
        this.parent = parent;
    }

}
