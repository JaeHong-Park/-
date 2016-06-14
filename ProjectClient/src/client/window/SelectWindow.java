package client.window;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;


public class SelectWindow extends Frame implements ActionListener, WindowListener {
	
	Button btnHorse;
	Button btnDraw;
	
	public SelectWindow() {
		btnHorse = new Button("경마게임");
		btnDraw = new Button("캐치마인드");
		
		this.setLayout(new GridLayout(1, 2));
		this.add(btnHorse);
		this.add(btnDraw);
		
		btnHorse.addActionListener(this);
		btnDraw.addActionListener(this);
		
		setTitle("게임선택");
		setBounds(400, 300, 300, 200);
		addWindowListener(this);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnHorse){
			new HorseWindow();
			this.dispose();
		}else if(obj == btnDraw){
			try {
				new DrawWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
		}		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
