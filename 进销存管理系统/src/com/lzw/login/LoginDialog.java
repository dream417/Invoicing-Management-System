package com.lzw.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lzw.dao.Dao;

public class LoginDialog extends JFrame {

	private static final long serialVersionUID=1L;
	private LoginPanel loginPanel = null;
	private JLabel jLabel = null;
	private JTextField userField = null;
	private JLabel jLabel1 = null;
	private JPasswordField passwordField = null;
	private JButton loginButton = null;
	private JButton exitButton = null;
	private static String userStr;
	
	public static void main(String []srgs){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new LoginDialog().initialize();
		
	}
	
	private void initialize(){		
		Dimension size = getToolkit().getScreenSize();
		setLocation((size.width-296)/2,(size.height-188)/2);
		setSize(296,188);
		this.setTitle("系统登录");
		setContentPane(getLoginPanel());
		this.setVisible(true);
	}

	private LoginPanel getLoginPanel() {
		// TODO Auto-generated method stub
		if(loginPanel == null){
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(86,71,55,18));
			jLabel1.setText("密  码：");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(86,41,55,18));
			jLabel.setText("用户名：");
			loginPanel = new LoginPanel();
			loginPanel.setLayout(null);
			loginPanel.setBackground(new Color(0xD8DDC7));
			loginPanel.add(jLabel,null);
			loginPanel.add(getUserField(),null);
			loginPanel.add(jLabel1,null);
			loginPanel.add(getPassworldField(),null);
			loginPanel.add(getLoginButton(),null);
			loginPanel.add(getExitButton(),null);
		}
		return loginPanel;
	}

	private JButton getExitButton() {
		// TODO Auto-generated method stub
		if(exitButton == null){
			exitButton = new JButton();
			exitButton.setBounds(new Rectangle(181,114,48,20));
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));
			exitButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				
			});
		}
		return exitButton;
	}

	private JButton getLoginButton() {
		// TODO Auto-generated method stub
		if(loginButton==null){
			loginButton = new JButton();
			loginButton.setBounds(new Rectangle(109,114,48,20));
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));
			loginButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					userStr = userField.getText();
					String passStr = new String(passwordField.getPassword());
					try {
						if(Dao.checkLogin(userStr, passStr))
							JOptionPane.showMessageDialog(LoginDialog.this,"登录成功！");
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
			});
		}
		return loginButton;
	}

	private JPasswordField getPassworldField() {
		// TODO Auto-generated method stub
		if(passwordField == null){
			passwordField = new JPasswordField();
			passwordField.setBounds(new Rectangle(142,69,127,22));
			passwordField.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent e){
					if(e.getKeyChar()=='\n'){
						loginButton.doClick();
					}
				}
			});
		}
		return passwordField;
	}

	private JTextField getUserField() {
		// TODO Auto-generated method stub
		if(userField==null){
			userField = new JTextField();
			userField.setBounds(new Rectangle(142,39,127,22));
		}
		return userField;
	}
}
