package com.lzw;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

public class ToolBar extends JToolBar {
	
	private MenuBar menuBar;
	
	private ToolBar(){
		
	}
	
	public ToolBar(MenuBar frameMenuBar){
		super();
		this.menuBar = frameMenuBar;
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		setSize(new Dimension(600,24));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		add(createToolButton(menuBar.getJinhuoItem()));
		add(createToolButton(menuBar.getXiaoshou_danItem()));
		add(createToolButton(menuBar.getKucun_pandianItem()));
		add(createToolButton(menuBar.getJiage_tiaozhengItem()));
		add(createToolButton(menuBar.getShangpin_chaxunItem()));
		add(createToolButton(menuBar.getShangpin_guanliItem()));
		add(createToolButton(menuBar.getKehu_guanliItem()));
		add(createToolButton(menuBar.getGys_guanliItem()));
		add(createToolButton(menuBar.getExitItem()));		
	}

	private JButton createToolButton(final JMenuItem item) {
		// TODO Auto-generated method stub
		JButton button = new JButton();
		button.setText(item.getText());
		button.setToolTipText(item.getText());
		button.setIcon(item.getIcon());
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				item.doClick();
			}
		});
		return button;
	}
	
	public void setMenuBar(MenuBar menuBar){
		this.menuBar = menuBar;
	}
}
