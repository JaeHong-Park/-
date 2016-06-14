package server.conn;

import java.util.Vector;

import dto.drawDTO;

/*
 * singleton
 */

public class SingletonClass {
private static SingletonClass single = null;
	
	public Vector<drawDTO> vc;
	public int size;
	public int index;
	public String correct;
	
	private SingletonClass() {
		vc = new Vector<drawDTO>();
		size = 0;
		index = 0;
		correct = "µµ≈‰∏Æ";
	}
	
	public static SingletonClass getInstance(){
		if(single == null){
			single = new SingletonClass();
		}
		return single;
	}
	
	public void displayMessage(String nameSupplied){
		javax.swing.JOptionPane.showMessageDialog(null, nameSupplied);
	}

}
