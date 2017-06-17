package com.lzw;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuBar extends JMenuBar {

	private JMenu jinhuo_Menu = null;
	
	private JMenuItem jinhuoItem = null;
	
	private JMenuItem jinhuo_tuihuoItem = null;
	
	private JMenu xiaoshou_Menu = null;
	
	private JMenu kucun_Menu = null;
	
	private JMenu xinxi_chaxunMenu = null;
	
	private JMenu jjiben_ziliaoMenu = null;
	
	private JMenu xitong_weihuMenu = null;
	
	private JMenu chuang_kouMenu = null;
	
	private JMenu bang_zhuMenu = null;
	
	private JMenuItem guanyu_Item = null;
	
	private JMenuItem bugItem = null;
	
	private JMenuItem fangwen_wangzhanItem = null;
	
	private JMenuItem xiaoshou_danItem = null;
	
	private JMenuItem xiaoshou_tuihuoItem = null;
	
	private JMenuItem kucun_pandianItem = null;
	
	private JMenuItem jiage_tiaozhengItem = null;
	
	private JMenuItem xiaoshou_chaxunItem = null;
	
	private JMenuItem shangpin_chaxunItem = null;
	
	private JMenuItem xiaoshou_paihangItem = null;
	
	private JMenuItem shangpin_guanliItem = null;
	
	private JMenuItem kehu_guanliItem = null;
	
	private JMenuItem gys_guanliItem = null;
	
	private JMenuItem jsr_guanliItem = null;
	
	private JMenuItem mima_xiiugaiItem = null;
	
	private JMenuItem shuju_beifenItem = null;
	
	private JMenuItem exitItem = null;
	
	private JMenuItem pingpuItem = null;
	
	private JDesktopPane desktopPanel = null;
	
	private Map<JMenuItem, JInternalFrame> iFrames = null;
	
	private int nextFrameX, nextFrameY;
	
	private JMenuItem closeAllItem = null;
	
	private JMenuItem allIconItem = null;
	
	private JMenuItem allResumeItem = null;
	
	private JLabel stateLabel = null;
	
	
	private MenuBar(){
		
	}
	
	public MenuBar(JDesktopPane desktopPanel, JLabel label){
		super();
		iFrames = new HashMap<JMenuItem, JInternalFrame>();
		this.desktopPanel = desktopPanel;
		this.stateLabel = label;
		initialize();
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		this.setSize(new Dimension(600, 24));
		add(getJinhuo_Menu());
		add(getXiaoshou_Menu());
		add(getKucun_Menu());
		add(getXinxi_chaxunMenu());
		add(getJiben_ziliaoMenu());
		add(getXitong_weihuMenu());
		add(getChuang_kouMenu());
		add(getBang_zhuMenu());
	}

	public JMenu getBang_zhuMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getChuang_kouMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getXitong_weihuMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getJiben_ziliaoMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getXinxi_chaxunMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getKucun_Menu() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getXiaoshou_Menu() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getJinhuo_Menu() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getJinhuoItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getXiaoshou_danItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getKucun_pandianItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getJiage_tiaozhengItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getShangpin_chaxunItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getShangpin_guanliItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getKehu_guanliItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getGys_guanliItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getExitItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
