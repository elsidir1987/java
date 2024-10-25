package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class ChessFrame extends JFrame {

	
	private BoardPanel panel;
	
	public ChessFrame() throws HeadlessException {
		
		panel=new BoardPanel();
		this.setContentPane(panel);
		MouseMoveListener listener=new MouseMoveListener();
		panel.addMouseMotionListener(listener);
		
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Chess Board");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class BoardPanel extends JPanel{
		
		private static final int ROWS =8;
		private static final int COLUMNS=8;
		private int xCoord=50;
		private int yCoord=50;
		
		
		public int getyCoord() {
			return yCoord;
		}


		public void setyCoord(int yCoord) {
			this.yCoord = yCoord;
		}


		public int getxCoord() {
			return xCoord;
		}
		public void setxCoord(int xCoord) {
			this.xCoord=xCoord;
		}

		public void paintComponent(Graphics g) {
			
			int sqSize=this.getHeight()/ROWS;
			for(int i=0;i<ROWS;i++) {
				for(int j=0;j<COLUMNS;j++) {
					int x=j*sqSize;
					int y=i*sqSize;
					g.setColor(Color.GREEN);
					g.fillRect(x, y, sqSize, sqSize);
					if((i+j)%2==0) {
						g.setColor(Color.MAGENTA);
					}
						g.fillRect(x, y, sqSize, sqSize);
				}
			}
			g.setColor(Color.red);
			g.fillOval(xCoord, yCoord, 40, 40);
		}
		
	}
	class MouseMoveListener implements MouseMotionListener{
		
		public void mouseDragged(MouseEvent e) {
			int x=e.getX();
			int y=e.getY();
			panel.setxCoord(x-20);
			panel.setyCoord(y-20);
			panel.repaint();
		}
		public void mouseMoved(MouseEvent e) {
			
		}
		
	}

}
