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
import com.lzw.dao.model.TbKhinfo;

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
