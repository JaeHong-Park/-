package client.window;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import client.conn.ReadThread;
import client.conn.SingletonClass;
import client.conn.WriterClass;

public class ClientWindow extends Frame implements WindowListener, ActionListener{

	// connect
	int timeout;
	InetSocketAddress sockAddr;
	InetAddress inetAddr;
	
	// draw
	private Panel pnDraw;
	private Label lblQuestion;
	private Button btnClear;
	private DrawCanvas dc;
	
	// chat
	private Panel pnChat;
	private TextArea taClient;
	private TextField tfClient;
	private Button btnSend;
	
	public ClientWindow() throws IOException {		
		// draw
		pnDraw = new Panel();
		lblQuestion = new Label();
		dc = new DrawCanvas();
		btnClear = new Button("Áö¿ì±â");
		btnClear.addActionListener(this);
				
		pnDraw.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		pnDraw.add(lblQuestion, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 10;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		pnDraw.add(dc, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		pnDraw.add(btnClear, gc);		
		
		// chat
		pnChat = new Panel();
		taClient = new TextArea();
		tfClient = new TextField();
		btnSend = new Button("Send");
		
		pnChat.setLayout(new GridBagLayout());
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 10;
		gc.gridwidth = 2;
		gc.gridheight = 1;
		pnChat.add(taClient, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 3;
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		pnChat.add(tfClient, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		pnChat.add(btnSend, gc);
		
		btnSend.addActionListener(this);
		
		
		// window
		this.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 100;
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		this.add(pnDraw, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		this.add(pnChat, gc);
		
		conn();
		
		setTitle("Client");
		setBounds(0, 0, 1000, 500);
		addWindowListener(this);
		setVisible(true);
	}
	
	public void conn() throws IOException{
		SingletonClass scls = SingletonClass.getInstance();
		timeout = 10000;		
		sockAddr = new InetSocketAddress("211.238.142.191", 9000);
		scls.socket.connect(sockAddr, timeout);		
		
		new WriterClass(taClient, tfClient).sendEnter();
		new ReadThread(lblQuestion, btnClear, taClient, dc).start();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnClear){		
			dc.clear();
		}else if(e.getSource() == btnSend){
			new WriterClass(taClient, tfClient).sendMsg();
		}
	}
	/*
	public void actionPerformed(ActionEvent e){
	
		
	}
	*/




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