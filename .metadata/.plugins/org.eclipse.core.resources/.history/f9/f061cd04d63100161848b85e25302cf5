package client.conn;


import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

import client.dto.drawDTO;

/*
 * singleton
 */

public class SingletonClass {
private static SingletonClass single = null;
	
	public Socket socket;
	public Vector<drawDTO> vc;
	public String id;
	
	private SingletonClass() {		
		socket = new Socket();
		vc = new Vector<drawDTO>();
		id = "";
	}
	
	public static SingletonClass getInstance() throws IOException{
		if(single == null){
			single = new SingletonClass();
		}
		return single;
	}
	
	public void displayMessage(String nameSupplied){
		javax.swing.JOptionPane.showMessageDialog(null, nameSupplied);
	}

}
