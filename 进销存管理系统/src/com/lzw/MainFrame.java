package com.lzw;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.MenuBar;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import org.omg.CORBA.INITIALIZE;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel frameContentPane = null;
	private MenuBar frameMenuBar = null;
	private ToolBar toolBar = null;
	private DesktopPanel desktopPane = null;
	private JPanel statePanel  = null;
	private JLabel stateLabel = null;
	private JLabel nameLabel = null;
	private JLabel nowDateLabel = null;
	private JSeparator jSeparator = null;
	private static JLabel czyStateLabel = null;
	private JSeparator jSeparator2 = null;
	
	private ToolBar getJJToolBar(){
		if(toolBar == null){
			toolBar = new ToolBar(getFrameMenuBar());
			toolBar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return toorBar;
	}
	
	private MenuBar getFrameMenuBar(){
		if(frameMenuBar == null){
			frameMenuBar = new MenuBar(getDesktopPane(),getStateLabel());
		}
		return frameMenuBar;
	}
	
	private DesktopPanel getDesktopPane(){
		if(desktopPane == null){
			desktopPane = new DesktopPanel();
		}
		return desktopPane;
	}
	
	private Jpanel getStatePanel(){
		if(statePanel == null){
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 2;
			gridBagConstraints6.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints6.inserts = new Inserts(0,5,0,5);
			gridBagConstraints6.gridy = 0;
			
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 3;
			gridBagConstraints4.gridy = 0;
			
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 6;
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints3.insets = new Insets(0, 5, 0, 5);
			gridBagConstraints3.gridy = 0;
			
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 5;
			gridBagConstraints11.insets new Insets(0, 5, 0, 5);
			gridBagConstraints11.gridy = 0;
			nowDateLabel = new JLabel();
			Date now = new Date();
			nowDateLabel.setText(String.format("%tF", now));
					
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 7;
			gridBagConstraints2.weightx = 0.0;
			gridBagConstraints2.fill = GridBagConstrains.NONE;
			gridBagConstraints2.gridy = 0;
			nameLabel = new JLabel("吉林省铭泰xx有限公司");
			
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 4;
			gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.inserts = new Insets(0, 5, 0, 5);
			gridBagConstraints1.gridy = 0;
			
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.gridy = 0;
			
			statePanel = new JPanel();
			statePanel.setLayout(new GridBagLayout());
			statePanel.setBorder(BorderFactory.createBevelBorder(RAISED));
			statePanel.add(getStateLabel(),gridBagConstraints);
			statePanel.add(getJSeparator(),gridBagConstraints1);
			statePanel.add(nameLabel,gridBagConstraints2);
			statePanel.add(getJSeparator1(),gridBagConstraints3);
			statePanel.add(nowDateLabel, gridBagConstraints11);
			statePanel.add(getCzyStateLabel, gridBagConstraints4);
			statePanel.add(getJSparator2(), gridBagConstraints6);
		}
		return statePanel;
	}
	
	public static JLabel getCzyStateLabel(){
		if(czyStateLabel == null){
			czyStateLabel = new JLabel("操作员：");
		}
		return czyStateLabel;
	}
	
	public JLabel getStateLabel(){
		if(stateLabel == null){
			stateLabel = new JLabel();
			stateLabel.setText("当前没有选定窗体");
		}
		return stateLabel;
	}
	
	private JSeparator getSeparator(){
		JSeparator jSeparator = new JSeparator();
		jSeparator.setOrientation(JSeparator.VERTICAL);
		return jSeparator;
	}
	
	private JSeparator getSeparator1(){
		if(jSeparator1 == null){
			JSeparator jSeparator1 = new JSeparator();
			jSeparator1.setOrientation(JSeparator.VERTICAL);
		}
		return jSeparator;
	}
	
	private JSeparator getSeparator2(){
		if(jSeparator2 == null){
			JSeparator jSeparator2 = new JSeparator();
			jSeparator2.setOrientation(JSeparator.VERTICAL);
		}
		return jSeparator;
	}
	
	private JPanel getFrameContentPane(){
		if(frameContentPane == null){
			frameContentPane = new JPanel();
			frameContentPane.setLayout(new BorderLayout());
			frameContentPane.add(getStateLabel(),BorderLayout.SOUTH);
			frameContentPane.add(getJJToolBar(),BorderLayout.NORTH);
			frameContentPane.add(getDesktopPane(),BorderLayout.CENTER);
		}
		return frameContentPane;
	}
	
	public MainFrame(){
		super();
		initialize();
	}
	
	private void initialize(){
		this.setSize(800, 600);
		this.setJMenuBar(getFrameMenuBar());
		this.setContentPane(getFrameContentPane());
		this.setTitle("铭泰企业进销存管理系统");
	}
}
