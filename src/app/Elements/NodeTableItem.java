/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Elements;

import java.awt.Graphics;
import javax.swing.JPanel;
import simulator.Simulator;

/**
 *
 * @author alber
 */
public class NodeTableItem extends JPanel{
    private NodeTable ht;
    private JPanel jHt;
    
    public NodeTableItem(){
        
    }
    public NodeTableItem(SimulatorItem si){
        this.ht = new NodeTable(si.getSimulator());
        this.jHt = new JPanel();
        //this.jHt.add(ht.getScrollPane());
        //this.add(ht.getScrollPane());
    }

    public NodeTable getHt() {
        return ht;
    }

    public void setHt(NodeTable ht) {
        this.ht = ht;
    }

    public JPanel getjHt() {
        return jHt;
    }

    public void setjHt(JPanel jHt) {
        this.jHt = jHt;
    }
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
    }
}
