package client.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import client.conn.SingletonClass;
import client.conn.WriterClass;
import dto.drawDTO;

public class DrawCanvas extends Canvas implements MouseListener, MouseMotionListener{
	// 좌표
	private int x;
	private int y;
	private int x1;
	private int y1;

	public DrawCanvas(){
		this.start();
		this.setVisible(true);
	}

	public void start(){		
	//	this.addMouseListener(this);
	//	this.addMouseMotionListener(this);		
	}
	
	public void paint(Graphics g){	
		//현재 마우스가 드래그된 지점까지의 그림을 표현
		Color c = new Color(0, 0, 0);
		g.setColor(c);
		g.drawLine(x, y, x1, y1);
		
		SingletonClass scls;
		try {
			scls = SingletonClass.getInstance();
			// Vector에 저장된 내용을 전부 표현
			for(int i = 0; i < scls.vc.size(); i++){
				drawDTO ddto = (drawDTO) scls.vc.get(i);
				g.drawLine(ddto.getX(), ddto.getY(), ddto.getX1(), ddto.getY1());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void mouseClicked(MouseEvent e){
	
	}

	//마우스를 누른 지점을 시작점으로 등록
	public void mousePressed(MouseEvent e){
		x = e.getX();
		y = e.getY();
	}

	//마우스를 뗀 지점을 끝점으로 등록한다. repaint()메서드를 호출하여 다시 그림을 그린다.
	public void mouseReleased(MouseEvent e){
		x1 = e.getX();
		y1 = e.getY();
		
		try {
			SingletonClass scls = SingletonClass.getInstance();
			drawDTO ddto = new drawDTO(x, y, x1, y1);
			scls.vc.add(ddto);
			this.repaint();
			new WriterClass().sendList();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void mouseEntered(MouseEvent e){
	
	}

	public void mouseExited(MouseEvent e){
	
	}

	public void mouseMoved(MouseEvent e){
	
	}

	/*
	* 마우스를 대르그할 때에는 움직이는 지점까지의 그림이 그때 그때 표현되어야 하기 때문에
	* 해당 그림을 그려준다.
	*/
	public void mouseDragged(MouseEvent e){
		x1 = e.getX();
		y1 = e.getY();
		
		//PEN이 선택 되었을때 모든 움직임을 벡터에 저장한다.		
		Color c = new Color(0, 0, 0);
		
		try {
			SingletonClass scls = SingletonClass.getInstance();
			drawDTO ddto = new drawDTO(x, y, x1, y1);
			scls.vc.add(ddto);
			x = x1;
			y = y1;		
			this.repaint();
			new WriterClass().sendList();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	
	public void clear(){
		try {
			SingletonClass scls = SingletonClass.getInstance();
			scls.vc.clear();
			x = 0;
			y = 0;
			x1 = 0;
			y1 = 0;
			this.repaint();
			new WriterClass().sendList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}