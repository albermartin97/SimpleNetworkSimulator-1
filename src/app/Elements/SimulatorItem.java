package app.Elements;

import app.Windows.VMain;
import java.io.Serializable;
import javax.swing.JScrollPane;

import objects.Linker;
import simulator.Simulator;

public class SimulatorItem implements Serializable {

    private WorkSpacePanel workSpacePanel;
    private JScrollPane workSpaceScroll;
    private VMain vMain;
    private Simulator simulator;
    private NodeItem auxHost;
    private boolean conectarHosts = false;
    private int clickHost = 0;
    private Linker l;

    public SimulatorItem() {
    }

    public Simulator getSimulator() {
        return simulator;
    }

    public void setSimulator(Simulator simulator) {
        this.simulator = simulator;
    }

    public NodeItem getAuxHost() {
        return auxHost;
    }

    public void setAuxHost(NodeItem auxHost) {
        this.auxHost = auxHost;
    }

    public boolean isConectarHosts() {
        return conectarHosts;
    }

    public void setConectarHosts(boolean conectarHosts) {
        this.conectarHosts = conectarHosts;
    }

    public int getClickHost() {
        return clickHost;
    }

    public void setClickHost(int clickHost) {
        this.clickHost = clickHost;
    }

    public WorkSpacePanel getWorkSpacePanel() {
        return workSpacePanel;
    }

    public void setWorkSpacePanel(WorkSpacePanel workSpacePanel) {
        this.workSpacePanel = workSpacePanel;
    }

    public Linker getL() {
        return l;
    }

    public void setL(Linker l) {
        this.l = l;
    }

    public VMain getvMain() {
        return vMain;
    }

    public void setvMain(VMain vMain) {
        this.vMain = vMain;
    }

    public JScrollPane getWorkSpaceScroll() {
        return workSpaceScroll;
    }

    public void setWorkSpaceScroll(JScrollPane workSpaceScroll) {
        this.workSpaceScroll = workSpaceScroll;
    }

    
    @Override
    public String toString() {
        return workSpacePanel.toString();
    }

}
