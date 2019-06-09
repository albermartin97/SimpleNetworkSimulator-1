package app.Elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class MyMouseMotionAdapter extends MouseMotionAdapter{
	private NodeItem parent;
	public MyMouseMotionAdapter(){
		super();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
            Point limits = parent.getSimulatorItem().getWorkSpacePanel().getLocation();
            int wLimit = parent.getSimulatorItem().getWorkSpaceScroll().getWidth();
            //wLimit = 1789;
            int hLimit = parent.getSimulatorItem().getWorkSpaceScroll().getHeight();
            //hLimit = 850;
            int x = parent.getX() + e.getX() - parent.getDragX();
            int y = parent.getY() + e.getY() - parent.getDragY();
            if(-x < limits.x && -y < limits.y  && -x > limits.x - wLimit + parent.getWidth() && -y > limits.y - hLimit + parent.getHeight()){
		Graphics g = parent.getSimulatorItem().getWorkSpacePanel().getGraphics();
		//g.clearRect(parent.getX(), parent.getY() , parent.getSimulatorItem().getWorkSpacePanel().getWidth()-parent.getWidth(), parent.getSimulatorItem().getWorkSpacePanel().getHeight()- parent.getHeight());
		parent.getSimulatorItem().getWorkSpacePanel().setBackground(Color.WHITE);
		
		parent.setLocation(x,y);
		//parent.getSimulatorItem().getWorkSpacePanel().paint(g);
		//parent.getSimulatorItem().getWorkSpacePanel().updateUI();
		parent.getSimulatorItem().getWorkSpacePanel().repaint();
		//parent.getSimulatorItem().getWorkSpacePanel().updateUI();
		/*for(LinkerItem l :parent.getSimulatorItem().getWorkSpacePanel().getLinkers()){
			//parent.getSimulatorItem().getWorkSpacePanel().getGraphics().clearRect(0, 0, 500, 500);
			//l.getH1().updateUI();
			//l.getH2().updateUI();
			//parent.getSimulatorItem().getWorkSpacePanel().repaint();
			l.repaint(g);
			
		}*/
		//parent.getSimulatorItem().getWorkSpacePanel().updateUI();
            }
	}
	/*@Override
	public void mouseMoved(MouseEvent e) {
		if(parent != null && parent.isDrag()){
			int x = parent.getX() + e.getX() - parent.getDragX();
			int y = parent.getY() + e.getY() - parent.getDragY();
			for(LinkerItem li : parent.getLinkers()){
				li.setBounds(parent.getX() + parent.getWidth() , parent.getY(), li.getWidth(), 20);
			}
			parent.setLocation(x,y);
		}
	}*/
	public NodeItem getParent() {
		return parent;
	}
	public void setParent(NodeItem parent) {
		this.parent = parent;
	}
	
	/*public WorkSpacePanel getWorkSpace() {
		return workSpace;
	}
	public void setWorkSpace(WorkSpacePanel workSpace) {
		this.workSpace = workSpace;
	}*/
	
	
}
