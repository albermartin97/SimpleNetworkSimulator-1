package app.Elements;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import material.graphs.Edge;
import objects.Linker;

public class MyMouseAdapter extends MouseAdapter {

    private NodeItem parent;
    private static java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
    
    public MyMouseAdapter() {
        super();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (parent.getSimulatorItem().isConectarHosts()) {
            if (parent.getSimulatorItem().getClickHost() == 1) {
                Graphics g = parent.getSimulatorItem().getWorkSpacePanel().getGraphics();
                LinkerItem li = new LinkerItem(parent.getSimulatorItem(), parent, this.parent.getSimulatorItem().getAuxHost());

                Edge<Linker> l = parent.getSimulatorItem().getSimulator().getRed().connect(parent.getVertex(), this.parent.getSimulatorItem().getAuxHost().getVertex(), parent.getSimulatorItem().getL().getIp(), parent.getSimulatorItem().getL().getSpeed(), parent.getSimulatorItem().getL().getDistance());
                li.setLinker(l);
                li.getLblName().setText(l.getElement().getIp());
                li.getLblName().setToolTipText(bundle.getString("speed") + "= " + li.getLinker().getElement().getSpeed().toString() + "; " + bundle.getString("distance") + "= " + li.getLinker().getElement().getDistance().toString());

                parent.getSimulatorItem().setClickHost(0);
                parent.getSimulatorItem().setConectarHosts(false);
                parent.getSimulatorItem().getWorkSpacePanel().getLinkers().add(li);

                parent.getLinkers().add(li);
                parent.getSimulatorItem().getAuxHost().getLinkers().add(li);

                parent.getSimulatorItem().getvMain().enabled(true);
                Cursor hourglassCursor = new Cursor(Cursor.DEFAULT_CURSOR);
                this.parent.getSimulatorItem().getvMain().setCursor(hourglassCursor);
                enabledBotons();
                
                parent.getSimulatorItem().getWorkSpacePanel().paint(g);
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

    public void enabledBotons() {
        if (this.parent.getSimulatorItem().getWorkSpacePanel().getChildsItems().size() >= 2) {
            this.parent.getSimulatorItem().getvMain().getBtnNewLinker().setEnabled(true);
        } else {
            this.parent.getSimulatorItem().getvMain().getBtnNewLinker().setEnabled(false);
        }
        if (this.parent.getSimulatorItem().getWorkSpacePanel().getChildsItems().size() > 0 && this.parent.getSimulatorItem().getWorkSpacePanel().getLinkers().size() >= this.parent.getSimulatorItem().getWorkSpacePanel().getChildsItems().size() - 1) {
            this.parent.getSimulatorItem().getvMain().getBtnEnrutar().setEnabled(true);
        } else {
            this.parent.getSimulatorItem().getvMain().getBtnEnrutar().setEnabled(false);
        }
    }
}
