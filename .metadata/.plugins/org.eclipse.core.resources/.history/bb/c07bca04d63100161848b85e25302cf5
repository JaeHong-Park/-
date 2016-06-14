package client.conn;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Vector;

import client.dto.drawDTO;
import client.dto.objectDTO;
import client.window.DrawCanvas;

public class ReadThread extends Thread {
	private Label lblQuestion;
	private Button btnClear;
	private TextArea taClient;
	private DrawCanvas dc;

	public ReadThread(Label lblQuestion, Button btnClear, TextArea taClient, DrawCanvas dc) {
		this.lblQuestion = lblQuestion;
		this.btnClear = btnClear;
		this.taClient = taClient;
		this.dc = dc;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		ObjectInputStream ois = null;		// recv
		
		try {
			// »ý¼º
			SingletonClass scls = SingletonClass.getInstance();			
			
			// loop
			while(true){
				// recv
				ois = new ObjectInputStream(scls.socket.getInputStream());
				objectDTO odto = (objectDTO)ois.readObject();
				if(odto.getState()==0){
					// chat
					taClient.append(odto.getMsg() + "\n");		
				}else if(odto.getState()==1){
					// chat
					taClient.append(odto.getId() + " : " + odto.getMsg() + "\n");
				}else if(odto.getState()==2){
					// draw							
					scls.vc = (Vector<drawDTO>)odto.getVc();
					dc.repaint();
				}else if(odto.getState()==3){
					System.out.println(odto.getMsg());
					lblQuestion.setText(odto.getMsg());
					btnClear.setEnabled(true);
					dc.addMouseListener(dc);
					dc.addMouseMotionListener(dc);
				}else if(odto.getState()==4){
					lblQuestion.setText("");
					btnClear.setEnabled(false);
					dc.removeMouseListener(dc);
					dc.removeMouseMotionListener(dc);
				}
			}
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
