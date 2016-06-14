package server.window;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import server.conn.ReadThread;
import server.conn.SingletonClass;
import server.conn.WriterClass;


public class ServerWindow extends Frame implements WindowListener, ActionListener {

	TextArea taServer;
	
	int port;
	ServerSocket srvSock;
	ArrayList<Socket> socketList;
	Socket socket;
	
	boolean correct;
	
	public ServerWindow() throws IOException {
		setTitle("Server");
		setBounds(0, 0, 300, 400);
		addWindowListener(this);
		setVisible(true);
		
		taServer = new TextArea();		
		this.add(taServer);
		
		port = Integer.parseInt("9000");		
		srvSock = new ServerSocket(port);		
		socketList = new ArrayList<Socket>();
		Socket socket = null;
		
		correct = false;
	
		while(socketList.size()<2){		
			socket = srvSock.accept();
			
			taServer.append("연결 IP : " + socket.getInetAddress() + "\n");
			taServer.append("Port : " + socket.getPort() + "\n");
			
			socketList.add(socket);
			
			new ReadThread(socket, socketList).start();
		}		
		System.out.println("시작");
		
		SingletonClass scls = SingletonClass.getInstance();
		scls.size = socketList.size();
		new WriterClass(socketList.get(scls.index), socketList).startGame();		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);

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
