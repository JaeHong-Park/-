package client.window;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import client.conn.SingletonClass;

public class LoginWindow extends Frame implements WindowListener, ActionListener {
	Label lblLogin;
	Label lblId;
	Label lblPw;
	
	TextField tfId;
	TextField tfPw;
	
	Button btnLogin;
	Button btnJoin;
	
	
	
	public LoginWindow() {		
		setTitle("로그인");
		setBounds(400, 300, 300, 200);
		addWindowListener(this);
		setVisible(true);
		
		lblLogin = new Label("Log in", Label.CENTER);
		lblId = new Label("ID");
		lblPw = new Label("PW");
		tfId = new TextField();
		tfPw = new TextField();
		btnLogin = new Button("로그인");
		btnJoin = new Button("회원가입");
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 3;
		this.add(lblLogin, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.insets = new Insets(0, 10, 0, 0);
		this.add(lblId, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets = new Insets(0, 10, 0, 0);
		this.add(lblPw, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 1, 0);
		this.add(tfId, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 4;
		gc.insets = new Insets(1, 0, 0, 0);
		this.add(tfPw, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		gc.gridheight = 2;
		gc.weightx = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(0, 3, 0, 0);
		this.add(btnLogin, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 3;
		gc.insets = new Insets(3, 0, 0, 0);
		gc.fill = GridBagConstraints.BOTH;
		this.add(btnJoin, gc);
		
		btnLogin.addActionListener(this);
		btnJoin.addActionListener(this);
		
		setTitle("로그인");
		setBounds(400, 300, 300, 200);
		addWindowListener(this);
		setVisible(true);
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		SingletonClass scls;
		try {
			scls = SingletonClass.getInstance();
			if(obj == btnLogin){
				
				scls.id = tfId.getText();
				new SelectWindow();
				this.dispose();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.dispose();

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
