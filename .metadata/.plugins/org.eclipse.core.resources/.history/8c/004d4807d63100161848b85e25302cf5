package server.conn;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import server.dto.objectDTO;

public class WriterClass {
	
	private Socket socket;
	private ArrayList<Socket> socketList;
	
	public WriterClass(Socket socket, ArrayList<Socket> socketList) {
		this.socket = socket;
		this.socketList = socketList;
	}
		
	public void sendEnter(String id){
		SingletonClass scls = SingletonClass.getInstance();
		ObjectOutputStream oos = null;
		for(int i = 0; i < socketList.size(); i++){
			Socket sock = socketList.get(i);
			try {
				oos = new ObjectOutputStream(sock.getOutputStream());
				
				String msg = id + "´Ô ÀÔÀåÇÏ¼Ì½À´Ï´Ù";
				objectDTO odto = new objectDTO();
				odto.setState(0);
				odto.setId(id);
				odto.setMsg(msg);
				
				oos.writeObject(odto);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public void sendSystemMsg(String msg){
		SingletonClass scls = SingletonClass.getInstance();
		ObjectOutputStream oos = null;
		for(int i = 0; i < socketList.size(); i++){
			Socket sock = socketList.get(i);
			try {
				oos = new ObjectOutputStream(sock.getOutputStream());
				System.out.println(msg);
				objectDTO odto = new objectDTO();
				odto.setState(0);
				odto.setMsg(msg);
				
				oos.writeObject(odto);				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
	
	public void sendMsg(String id, String msg){		
		SingletonClass scls = SingletonClass.getInstance();
		ObjectOutputStream oos = null;
		for(int i = 0; i < socketList.size(); i++){
			Socket sock = socketList.get(i);
			try {
				if(sock != this.socket){
					oos = new ObjectOutputStream(sock.getOutputStream());
					System.out.println(msg);
					objectDTO odto = new objectDTO();
					odto.setState(1);
					odto.setId(id);
					odto.setMsg(msg);
					
					oos.writeObject(odto);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
	
	public void sendList(String id){
		SingletonClass scls = SingletonClass.getInstance();
		ObjectOutputStream oos = null;
		for(int i = 0; i < socketList.size(); i++){
			Socket sock = socketList.get(i);
			try {
				if(sock != this.socket){
					oos = new ObjectOutputStream(sock.getOutputStream());
					
					objectDTO odto = new objectDTO();
					odto.setState(2);
					odto.setId(id);
					odto.setVc(scls.vc);
					
					oos.writeObject(odto);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
	}
	
	public void sendExit(String id){
		SingletonClass scls = SingletonClass.getInstance();
		ObjectOutputStream oos = null;
		for(int i = 0; i < socketList.size(); i++){
			Socket sock = socketList.get(i);
			try {				
				if(sock != this.socket){
					oos = new ObjectOutputStream(sock.getOutputStream());
					
					String msg = id + "´Ô ÅðÀåÇÏ¼Ì½À´Ï´Ù.";
					objectDTO odto = new objectDTO();
					odto.setState(0);
					odto.setId(id);
					odto.setMsg(msg);
					
					oos.writeObject(odto);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public void startGame(){
		ObjectOutputStream oos = null;
		for(int i = 0; i < socketList.size(); i++){
			Socket sock = socketList.get(i);
			try {				
				if(sock == this.socket){
					oos = new ObjectOutputStream(sock.getOutputStream());
					
					objectDTO odto = new objectDTO();
					odto.setState(3);
					odto.setMsg("µµÅä¸®");
					
					oos.writeObject(odto);
				}else{
					oos = new ObjectOutputStream(sock.getOutputStream());
					
					objectDTO odto = new objectDTO();
					odto.setState(4);
					
					oos.writeObject(odto);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
