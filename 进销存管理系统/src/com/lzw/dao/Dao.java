package com.lzw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.lzw.Item;
import com.lzw.dao.model.TbGysinfo;
import com.lzw.dao.model.TbJsr;
import com.lzw.dao.model.TbKhinfo;
import com.lzw.dao.model.TbKucun;
import com.lzw.dao.model.TbSpinfo;

public class Dao {

	protected static String dbClassName = "com.mysql.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/db_database28";
	protected static String dbUser = "root";
	protected static String dbPwd = "123456";
	protected static String dbName = "db_database28";
	protected static String second = null;
	public static Connection conn = null;
	
	static{
		if(conn == null){
			try {
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "请将MySql的JDBC驱动包复制到lib文件夹中。");
				System.exit(-1);//异常退出
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}

	private Dao() {
		// TODO Auto-generated constructor stub
	}
	
	//读取客户信息
	public static List getKhInfos(){
		List list = findForList("select id,khname from tb_khinfo");
		return list;
	}

	//读取所有供应商信息
	public static List getGysInfos(){
		List list = findForList("select id,name from tb_gysinfo");
		return list;
	}
	
	//读取客户信息
	public static TbKhinfo getKhInfo(Item item){
		String where = "khname='"+item.getName()+"'";
		if(item.getId() != null)
			where = "id='" +item.getId() + "'";
		TbKhinfo info = new TbKhinfo();
		ResultSet set = findForResultSet("select * from tb_khinfo where" + where);
		try{
			if(set.next()){
				info.setId(set.getString("id").trim());
				info.setKhname(set.getString("khname").trim());
				info.setJian(set.getString("jian").trim());
				info.setAddress(set.getString("address"));
				info.setBianma(set.getString("bianma").trim());
				info.setFax(set.getString("fan").trim());
				info.setHao(set.getString("hao").trim());
				info.setLian(set.getString("lian").trim());
				info.setLtel(set.getString("ltel").trim());
				info.setMail(set.getString("mail").trim());
				info.setTel(set.getString("tel").trim());
				info.setYinhang(set.getString("yinhang").trim());
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return info;
	}
	
	//读取指定供应商信息
	public static TbGysinfo getGysInfo(Item item){
		String where = "name='" + item.getName() + "'";
		if(item.getId() != null)
			where = "id='"+item.getId() + "'";
		TbGysinfo info = new TbGysinfo();
		ResultSet set = findForResultSet("select * from tb_gysinfo where" + where);
		
		try {
			if(set.next()){
				info.setId(set.getString("id").trim());
				info.setAddress(set.getString("address").trim());
				info.setBianma(set.getString("bianma").trim());
				info.setFax(set.getString("fax").trim());
				info.setJc(set.getString("jc").trim());
				info.setLian(set.getString("lian").trim());
				info.setLtel(set.getString("tel").trim());
				info.setMail(set.getString("mail").trim());
				info.setName(set.getString("name").trim());
				info.setTel(set.getString("tel").trim());
				info.setYh(set.getString("yh").trim());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info;
	}
	
	//读取经手人
	public static TbJsr getJsr(String name,String password){
		TbJsr user = new TbJsr();
		ResultSet rs = findForResultSet("select * from tb_jsr where name='"+name+"'");
		try {
			if(rs.next()){
				user.setSex(name);
				user.setAge(rs.getString("pass"));
				if(user.getAge().equals(password)){
					user.setName(rs.getString("name"));
					user.setTel(rs.getString("quan"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	//执行指定查询
	public static ResultSet query(String QueryStr){
		ResultSet set = findForResultSet(QueryStr);
		return set;
	}
	
	//执行删除
	public static int delete(String sql){
		return update(sql);
	}
	
	//添加客户信息的方法
	public static boolean addKeHu(TbKhinfo khinfo){
		if(khinfo == null)
			return false;
		return insert("insert tb_khinfo values('" + khinfo.getId()+"','"
				+ khinfo.getKhname() + "','" + khinfo.getJian() + "','"
				+ khinfo.getAddress() + "','" + khinfo.getBianma() + "','"
				+ khinfo.getTel() + "','" + khinfo.getFax() + "','"
				+ khinfo.getLian() + "','" + khinfo.getLtel() + "','"
				+ khinfo.getMail() + "','" + khinfo.getYinhang() + "','"
				+ khinfo.getHao() + "','");
	}
	
	//修改客户信息的方法
	public static int updateKeHu(TbKhinfo khinfo){
		return update("update tb_khinfo set jian='" + khinfo.getJian()
				+ "',address='" + khinfo.getAddress() + "',bianma='"
				+ khinfo.getBianma() + "',tel='" + khinfo.getTel() + "',fax='"
				+ khinfo.getFax() + "',lian='" + khinfo.getLian() + "',ltel='"
				+ khinfo.getLtel() + "',mail='" + khinfo.getMail() + "',xinhang='"
				+ khinfo.getYinhang() + "',hao='" + khinfo.getHao() + "' where id='"
				+ khinfo.getId() + "'");
	}
	
	//修改库存的方法
	public static int updateKucunDj(TbKucun kcInfo){
		return update("update tb_kucun set dj=" +kcInfo.getDj()
				+ "where id='" + kcInfo.getId() + "'");
	}
	
	//修改供应商信息的方法
	public static int updateGys(TbGysinfo gysInfo){
		return update("update tb_gysindo set jc='"+gysInfo.getJc()
				+ "',address='" + gysInfo.getAddress() + "',bianma='"
				+ gysInfo.getBianma() + "',tel='" + gysInfo.getTel()
				+ "',fax='" + gysInfo.getFax() + "',lian='" + gysInfo.getLian()
				+ "',ltel='" + gysInfo.getLtel() + "',mail='"
				+ gysInfo.getMail() + "',yh='" + gysInfo.getYh()
				+ "' where id='" + gysInfo.getId() + "'");
	}
	
	//添加供应商信息的方法
	public static boolean addGys(TbGysinfo gysInfo){
		if(gysInfo == null)
			return false;
		return insert("insert tb_gysindo values('" + gysInfo.getId() + "','"
				+ gysInfo.getName() + "','" + gysInfo.getJc() + "','"
				+ gysInfo.getAddress() + "','" + gysInfo.getBianma() + "','"
				+ gysInfo.getTel() + "','" + gysInfo.getFax() + "','"
				+ gysInfo.getLian() + "','" + gysInfo.getLtel() + "','"
				+ gysInfo.getMail() + "','" + gysInfo.getYh() + "')");
	}
	
	//添加商品
	public static boolean addSp(TbSpinfo spInfo){
		if(spInfo == null)
			return false;
		return insert("insert tb_spinfo values('" + spInfo.getId() + "','"
				+ spInfo.getSpname() + "','" + spInfo.getJc() + "','"
				+ spInfo.getCd() + "','" + spInfo.getDw() + "','"
				+ spInfo.getGg() + "','" + spInfo.getBz() + "','"
				+ spInfo.getPh() + "','" + spInfo.getPzwh() + "','"
				+ spInfo.getMemo() + "','" + spInfo.getGysname() + "')");
		
	}
	
	//更新商品
	public static int updateSp(TbSpinfo spInfo){
		return update("update tb_spinfo set jc='" + spInfo.getJc() + "',cd='"
				+ spInfo.getCd() + "',dw='" + spInfo.getDw() + "',gg='"
				+ spInfo.getGg() + "',bz='" + spInfo.getBz() + "',ph'"
				+ spInfo.getPh() + "',pzwh='" + spInfo.getPzwh() + "',memo='"
				+ spInfo.getMemo() + "',gysname='" + spInfo.getGysname()
				+ "' where id='" + spInfo.getId() + "'");
	}
	
	
	
	//添加数据
	private static boolean insert(String sql) {
		boolean result = false;
		// TODO Auto-generated method stub
		Statement stmt;
		try {
			stmt = conn.createStatement();
			result = stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	//更新数据
	private static int update(String sql) {
		// TODO Auto-generated method stub
		int result = 0;
		try{
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static List findForList(String sql){
		List<List> list = new ArrayList<List>();
		ResultSet rs = findForResultSet(sql);
		try{
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			while(rs.next()){
				List<String> row = new ArrayList<String>();
				for(int i = 1;i <= colCount; i++){
					String str = rs.getString(i);
					if(str != null && !str.isEmpty())
						str = str.trim();
					row.add(str);
				}
				list.add(row);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	private static ResultSet findForResultSet(String sql) {
		// TODO Auto-generated method stub
		if(conn == null)
			return null;
		long time = System.currentTimeMillis();
		ResultSet rs = null;
		try{
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			second = ((System.currentTimeMillis() - time) / 1000d) + "";
		}catch (Exception e){
			e.printStackTrace();
		}
		return rs;
	}
}
