package com.lzw;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuBar extends JMenuBar {

	private JMenu jinhuo_Menu = null;
	
	private JMenuItem jinhuoItem = null;
	
	private JMenuItem jinhuo_tuihuoItem = null;
	
	private JMenu xiaoshou_Menu = null;
	
	private JMenu kucun_Menu = null;
	
	private JMenu xinxi_chaxunMenu = null;
	
	private JMenu jiben_ziliaoMenu = null;
	
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
		if(bang_zhuMenu == null){
			bang_zhuMenu = new JMenu();
			bang_zhuMenu.setText("帮助(H)");
			bang_zhuMenu.setMnemonic(KeyEvent.VK_H);
			bang_zhuMenu.add(getGuanyu_Item());
			bang_zhuMenu.add(getBugItem());
			bang_zhuMenu.add(getFangwen_wangzhanItem());
		}
		return bang_zhuMenu;
	}

	public JMenuItem getGuanyu_Item() {
		// TODO Auto-generated method stub
		if(guanyu_Item == null){
			guanyu_Item = new JMenuItem();
			guanyu_Item.setText("关于");
			guanyu_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/guanyu.png")));
			URL url = DesktopPanel.class.getResource("/res/about.jpg");
			ImageIcon aboutImage = new ImageIcon(url);
			final JLabel imgLabel = new JLabel(aboutImage);
			imgLabel.setVisible(false);
			desktopPanel.add(imgLabel);
			desktopPanel.setLayer(imgLabel, Integer.MAX_VALUE);
			guanyu_Item.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int dw = desktopPanel.getWidth();
					int dh = desktopPanel.getHeight();
					imgLabel.setBounds((dw-500)/2, (dh - 350)/2, 500, 350);
					imgLabel.setVisible(true);
				}
			});
			imgLabel.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					imgLabel.setVisible(false);
				}
			});
		}
		return guanyu_Item;
	}

	public JMenuItem getBugItem() {
		// TODO Auto-generated method stub
		if(bugItem == null){
			bugItem = new JMenuItem();
			bugItem.setText("联系技术支持");
			bugItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jizhu_zhichi.png")));
			bugItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(Desktop.isDesktopSupported()){
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("mailto:tmoonbook@sina.com");
							desktop.mail(uri);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return bugItem;
	}

	public JMenuItem getFangwen_wangzhanItem() {
		// TODO Auto-generated method stub
		if(fangwen_wangzhanItem == null){
			fangwen_wangzhanItem = new JMenuItem();
			fangwen_wangzhanItem.setText("访问技术网站");
			fangwen_wangzhanItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jishu_wangzhan.png")));
			fangwen_wangzhanItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(Desktop.isDesktopSupported()){
						Desktop desktop = Desktop.getDesktop();
						try {
							URL url = new URL("http://www.mrbccd.com");
							desktop.browse(url.toURI());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return fangwen_wangzhanItem;
	}

	public JMenu getChuang_kouMenu() {
		// TODO Auto-generated method stub
		if(chuang_kouMenu == null){
			chuang_kouMenu = new JMenu();
			chuang_kouMenu.setText("窗口(W)");
			chuang_kouMenu.setMnemonic(KeyEvent.VK_W);
			chuang_kouMenu.addMenuListener(new MenuListener() {
				
				@Override
				public void menuSelected(MenuEvent arg0) {
					// TODO Auto-generated method stub
					chuang_kouMenu.removeAll();
					chuang_kouMenu.add(getPingpuItem());
					chuang_kouMenu.add(getClassAllItem());
					chuang_kouMenu.add(getAllIconItem());
					chuang_kouMenu.add(getAllResumeItem());
					chuang_kouMenu.addSeparator();
					
					int count = 0;
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					for(final JInternalFrame frame : allFrames){
						String frameTitle = frame.getTitle();
						count++;
						final JMenuItem item = new JMenuItem(count + " " + frameTitle);
						chuang_kouMenu.add(item);
						item.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								try{
									frame.setIcon(false);
									frame.setSelected(true);
								}catch (PropertyVetoException e1){
									e1.printStackTrace();
								}
							}
						});
					}
				}

				@Override
				public void menuDeselected(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void menuCanceled(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return chuang_kouMenu;
	}

	public JMenuItem getPingpuItem() {
		// TODO Auto-generated method stub
		return null;
	}


	public JMenuItem getClassAllItem() {
		// TODO Auto-generated method stub
		return null;
	}


	public JMenuItem getAllIconItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public JMenuItem getAllResumeItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public JMenu getXitong_weihuMenu() {
		// TODO Auto-generated method stub
		if(xitong_weihuMenu == null){
			xitong_weihuMenu = new JMenu();
			xitong_weihuMenu.setText("系统维护(S)");
			xitong_weihuMenu.setMnemonic(KeyEvent.VK_S);
			xitong_weihuMenu.add(getSHuju_beifenItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getMima_xiugaiItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getExitItem());
		}
		return xitong_weihuMenu;
	}
	
	public JMenuItem getSHuju_beifenItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getMima_xiugaiItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getExitItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getJiben_ziliaoMenu() {
		// TODO Auto-generated method stub
		if(jiben_ziliaoMenu == null){
			jiben_ziliaoMenu = new JMenu();
			jiben_ziliaoMenu.setText("基本资料(B)");
			jiben_ziliaoMenu.setMnemonic(KeyEvent.VK_B);
			jiben_ziliaoMenu.add(getShangpin_guanliItem());
			jiben_ziliaoMenu.add(getKehu_guanliItem());
			jiben_ziliaoMenu.add(getGys_guanliItem());
			jiben_ziliaoMenu.addSeparator();
			jiben_ziliaoMenu.add(getJsr_guanliItem());
		}
		return jiben_ziliaoMenu;
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
	
	public JMenuItem getJsr_guanliItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getXinxi_chaxunMenu() {
		// TODO Auto-generated method stub
		if(xinxi_chaxunMenu ==null){
			xinxi_chaxunMenu = new JMenu();
			xinxi_chaxunMenu.setText("信息查询(C)");
			xinxi_chaxunMenu.setMnemonic(KeyEvent.VK_C);
			xinxi_chaxunMenu.add(getXiaoshou_chaxunItem());
			xinxi_chaxunMenu.add(getShangpin_chaxunItem());
			xinxi_chaxunMenu.addSeparator();
			xinxi_chaxunMenu.add(getXiaoshou_paihangItem());
		}
		return null;
	}

	public JMenuItem getXiaoshou_chaxunItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public JMenuItem getShangpin_chaxunItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getXiaoshou_paihangItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getKucun_Menu() {
		// TODO Auto-generated method stub
		if(kucun_Menu == null){
			kucun_Menu = new JMenu();
			kucun_Menu.setText("库存管理(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			kucun_Menu.add(getKucun_pandianItem());
			kucun_Menu.add(getJiage_tiaozhengItem());
		}
		return kucun_Menu;
	}
	
	public JMenuItem getKucun_pandianItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getJiage_tiaozhengItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getXiaoshou_Menu() {
		// TODO Auto-generated method stub
		if(xiaoshou_Menu == null){
			xiaoshou_Menu = new JMenu();
			xiaoshou_Menu.setText("销售管理(X)");
			xiaoshou_Menu.setMnemonic(KeyEvent.VK_X);
			xiaoshou_Menu.add(getXiaoshou_danItem());
			xiaoshou_Menu.add(getXiaoshou_tuihuoItem());
		}
		return xiaoshou_Menu;
	}

	public JMenuItem getXiaoshou_danItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public JMenuItem getXiaoshou_tuihuoItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenu getJinhuo_Menu() {
		// TODO Auto-generated method stub
		if(jinhuo_Menu == null){
			jinhuo_Menu = new JMenu();
			jinhuo_Menu.setText("进货管理(J)");
			jinhuo_Menu.setMnemonic(KeyEvent.VK_J);
			jinhuo_Menu.add(getJinhuoItem());
			jinhuo_Menu.add(getJinhuo_tuihuoItem());
		}
		return jinhuo_Menu;
	}


	public JMenuItem getJinhuoItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public JMenuItem getJinhuo_tuihuoItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
