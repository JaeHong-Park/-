package client.conn;

import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import dto.objectDTO;

public class WriterClass {
	private TextArea taClient;
	private TextField tfClient;
	
	public WriterClass() {
		// TODO Auto-generated constructor stub
	}
	
	public WriterClass(TextArea taClient, TextField tfClient) {
		this.taClient = taClient;
		this.tfClient = tfClient;
	}
	
	public void sendEnter(){		
		try{
			SingletonClass scls = SingletonClass.getInstance();
			ObjectOutputStream oos = null;
			oos = new ObjectOutputStream(scls.socket.getOutputStream());
			
			objectDTO odto = new objectDTO();
			odto.setState(0);
			odto.setId(scls.id);
			
			oos.writeObject(odto);
			
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	public void sendMsg(){
		try{
			SingletonClass scls = SingletonClass.getInstance();
			ObjectOutputStream oos = null;
			oos = new ObjectOutputStream(scls.socket.getOutputStream());
			
			objectDTO odto = new objectDTO();
			odto.setState(1);
			odto.setId(scls.id);
			odto.setMsg(tfClient.getText());
			taClient.append(scls.id + " : " + tfClient.getText() + "\n");
			tfClient.setText("");
			
			oos.writeObject(odto);
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void sendList(){
		try{
			SingletonClass scls = SingletonClass.getInstance();
			ObjectOutputStream oos = null;
			oos = new ObjectOutputStream(scls.socket.getOutputStream());
			
			objectDTO odto = new objectDTO();
			odto.setState(2);
			odto.setId(scls.id);
			odto.setVc(scls.vc);
			
			oos.writeObject(odto);
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
