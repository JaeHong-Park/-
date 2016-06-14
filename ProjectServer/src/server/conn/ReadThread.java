package server.conn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import dto.drawDTO;
import dto.objectDTO;

public class ReadThread extends Thread {
	
	private Socket socket;	
	private ArrayList<Socket> socketList;
	private String id;
	
	public ReadThread(Socket socket, ArrayList<Socket> socketList) {
		this.socket = socket;
		this.socketList = socketList;
		
		System.out.println("���� IP : " + socket.getInetAddress());
		System.out.println("Port : " + socket.getPort());	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		// ����			
		ObjectInputStream ois = null;		// recv		
		
		
		try {
			// loop
			while(true){
				// recv				
				try {
					SingletonClass scls = SingletonClass.getInstance();	
					ois = new ObjectInputStream(socket.getInputStream());
					objectDTO odto = (objectDTO)ois.readObject();
					if(odto.getState()==0){
						// chat
						id = odto.getId();
						new WriterClass(socket, socketList).sendEnter(id);
					}else if(odto.getState()==1){
						// chat
						new WriterClass(socket, socketList).sendMsg(id, odto.getMsg());
						if(odto.getMsg().equals("���丮")){
							new WriterClass(socket, socketList).sendSystemMsg(odto.getId() + "�� �����Դϴ�");
							scls.index++;
							if(scls.index==scls.size){
								scls.index = 0;
							}
							new WriterClass(socketList.get(scls.index), socketList).startGame();
						}
					}else if(odto.getState()==2){
						// draw							
						scls.vc = (Vector<drawDTO>)odto.getVc();
						new WriterClass(socket, socketList).sendList(id);
					}					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		
		} catch (IOException e) {
			System.out.println(socket.getInetAddress() + " ������ ���������ϴ�");
			
			new WriterClass(socket, socketList).sendExit(id);
			
		} finally {
			// ������ ����� ����Ʈ���� ��������
			for(int i = 0; i < socketList.size(); i++){
				if(socketList.get(i) == this.socket){
					socketList.remove(i);
				}
			}
		}
	}
}
