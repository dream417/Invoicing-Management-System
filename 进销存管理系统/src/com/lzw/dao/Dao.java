package com.lzw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import com.lzw.Item;
import com.lzw.dao.model.TbGysinfo;
import com.lzw.dao.model.TbJsr;
import com.lzw.dao.model.TbKhinfo;
import com.lzw.dao.model.TbKucun;
import com.lzw.dao.model.TbRukuDetail;
import com.lzw.dao.model.TbRukuMain;
import com.lzw.dao.model.TbSellDetail;
import com.lzw.dao.model.TbSellMain;
import com.lzw.dao.model.TbSpinfo;
import com.lzw.dao.model.TbXsthDetail;
import com.lzw.dao.model.TbXsthMain;

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
				JOptionPane.showMessageDialog(null, "�뽫MySql��JDBC���������Ƶ�lib�ļ����С�");
				System.exit(-1);//�쳣�˳�
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}

	private Dao() {
		// TODO Auto-generated constructor stub
	}
	
	//��ȡ�ͻ���Ϣ
	public static List getKhInfos(){
		List list = findForList("select id,khname from tb_khinfo");
		return list;
	}

	//��ȡ���й�Ӧ����Ϣ
	public static List getGysInfos(){
		List list = findForList("select id,name from tb_gysinfo");
		return list;
	}
	
	//��ȡ�ͻ���Ϣ
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
	
	//��ȡָ����Ӧ����Ϣ
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
	
	//��ȡ������
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
	
	//ִ��ָ����ѯ
	public static ResultSet query(String QueryStr){
		ResultSet set = findForResultSet(QueryStr);
		return set;
	}
	
	//ִ��ɾ��
	public static int delete(String sql){
		return update(sql);
	}
	
	//��ӿͻ���Ϣ�ķ���
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
	
	//�޸Ŀͻ���Ϣ�ķ���
	public static int updateKeHu(TbKhinfo khinfo){
		return update("update tb_khinfo set jian='" + khinfo.getJian()
				+ "',address='" + khinfo.getAddress() + "',bianma='"
				+ khinfo.getBianma() + "',tel='" + khinfo.getTel() + "',fax='"
				+ khinfo.getFax() + "',lian='" + khinfo.getLian() + "',ltel='"
				+ khinfo.getLtel() + "',mail='" + khinfo.getMail() + "',xinhang='"
				+ khinfo.getYinhang() + "',hao='" + khinfo.getHao() + "' where id='"
				+ khinfo.getId() + "'");
	}
	
	//�޸Ŀ��ķ���
	public static int updateKucunDj(TbKucun kcInfo){
		return update("update tb_kucun set dj=" +kcInfo.getDj()
				+ "where id='" + kcInfo.getId() + "'");
	}
	
	//�޸Ĺ�Ӧ����Ϣ�ķ���
	public static int updateGys(TbGysinfo gysInfo){
		return update("update tb_gysindo set jc='"+gysInfo.getJc()
				+ "',address='" + gysInfo.getAddress() + "',bianma='"
				+ gysInfo.getBianma() + "',tel='" + gysInfo.getTel()
				+ "',fax='" + gysInfo.getFax() + "',lian='" + gysInfo.getLian()
				+ "',ltel='" + gysInfo.getLtel() + "',mail='"
				+ gysInfo.getMail() + "',yh='" + gysInfo.getYh()
				+ "' where id='" + gysInfo.getId() + "'");
	}
	
	//��ӹ�Ӧ����Ϣ�ķ���
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
	
	//�����Ʒ
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
	
	//������Ʒ
	public static int updateSp(TbSpinfo spInfo){
		return update("update tb_spinfo set jc='" + spInfo.getJc() + "',cd='"
				+ spInfo.getCd() + "',dw='" + spInfo.getDw() + "',gg='"
				+ spInfo.getGg() + "',bz='" + spInfo.getBz() + "',ph'"
				+ spInfo.getPh() + "',pzwh='" + spInfo.getPzwh() + "',memo='"
				+ spInfo.getMemo() + "',gysname='" + spInfo.getGysname()
				+ "' where id='" + spInfo.getId() + "'");
	}
	
	// ��ȡ��Ʒ��Ϣ
	public static TbSpinfo getSpInfo(Item item) {
		String where = "spname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_spinfo where "
				+ where);
		TbSpinfo spInfo = new TbSpinfo();
		try {
			if (rs.next()) {
				spInfo.setId(rs.getString("id").trim());
				spInfo.setBz(rs.getString("bz").trim());
				spInfo.setCd(rs.getString("cd").trim());
				spInfo.setDw(rs.getString("dw").trim());
				spInfo.setGg(rs.getString("gg").trim());
				spInfo.setGysname(rs.getString("gysname").trim());
				spInfo.setJc(rs.getString("jc").trim());
				spInfo.setMemo(rs.getString("memo").trim());
				spInfo.setPh(rs.getString("ph").trim());
				spInfo.setPzwh(rs.getString("pzwh").trim());
				spInfo.setSpname(rs.getString("spname").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spInfo;
	}

	// ��ȡ������Ʒ��Ϣ
	public static List getSpInfos() {
		List list = findForList("select * from tb_spinfo");
		return list;
	}
	
	// ��ȡ�����Ʒ��Ϣ
	public static TbKucun getKucun(Item item) {
		String where = "spname='" + item.getName() + "'";
		if (item.getId() != null)
			where = "id='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_kucun where " + where);
		TbKucun kucun = new TbKucun();
		try {
			if (rs.next()) {
				kucun.setId(rs.getString("id"));
				kucun.setSpname(rs.getString("spname"));
				kucun.setJc(rs.getString("jc"));
				kucun.setBz(rs.getString("bz"));
				kucun.setCd(rs.getString("cd"));
				kucun.setDj(rs.getDouble("dj"));
				kucun.setDw(rs.getString("dw"));
				kucun.setGg(rs.getString("gg"));
				kucun.setKcsl(rs.getInt("kcsl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kucun;
	}
	
	// ��ȡ��ⵥ�����ID����������Ʊ��
	public static String getRuKuMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_ruku_main", "RK", "rkid");
	}

	// ����������������Ϣ
	public static boolean insertRukuInfo(TbRukuMain ruMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// �����������¼
			insert("insert into tb_ruku_main values('" + ruMain.getRkId()
					+ "','" + ruMain.getPzs() + "'," + ruMain.getJe() + ",'"
					+ ruMain.getYsjl() + "','" + ruMain.getGysname() + "','"
					+ ruMain.getRkdate() + "','" + ruMain.getCzy() + "','"
					+ ruMain.getJsr() + "','" + ruMain.getJsfs() + "')");
			Set<TbRukuDetail> rkDetails = ruMain.getTabRukuDetails();
			for (Iterator<TbRukuDetail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				TbRukuDetail details = iter.next();
				// ��������ϸ���¼
				insert("insert into tb_ruku_detail values('" + ruMain.getRkId()
						+ "','" + details.getTbSpinfo() + "',"
						+ details.getDj() + "," + details.getSl() + ")");
				// ��ӻ��޸Ŀ����¼
				Item item = new Item();
				item.setId(details.getTbSpinfo());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() == null || kucun.getId().isEmpty()) {
						insert("insert into tb_kucun values('" + spInfo.getId()
								+ "','" + spInfo.getSpname() + "','"
								+ spInfo.getJc() + "','" + spInfo.getCd()
								+ "','" + spInfo.getGg() + "','"
								+ spInfo.getBz() + "','" + spInfo.getDw()
								+ "'," + details.getDj() + ","
								+ details.getSl() + ")");
					} else {
						int sl = kucun.getKcsl() + details.getSl();
						update("update tb_kucun set kcsl=" + sl + ",dj="
								+ details.getDj() + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}		

	// ��ȡ�˻����ID
	public static String getRkthMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_rkth_main", "RT", "rkthId");
	}
	
	// �����������������Ϣ
	public static boolean insertSellInfo(TbSellMain sellMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// ������������¼
			insert("insert into tb_sell_main values('" + sellMain.getSellId()
					+ "','" + sellMain.getPzs() + "'," + sellMain.getJe()
					+ ",'" + sellMain.getYsjl() + "','" + sellMain.getKhname()
					+ "','" + sellMain.getXsdate() + "','" + sellMain.getCzy()
					+ "','" + sellMain.getJsr() + "','" + sellMain.getJsfs()
					+ "')");
			Set<TbSellDetail> rkDetails = sellMain.getTbSellDetails();
			for (Iterator<TbSellDetail> iter = rkDetails.iterator(); iter
					.hasNext();) {
				TbSellDetail details = iter.next();
				// ���������ϸ���¼
				insert("insert into tb_sell_detail values('"
						+ sellMain.getSellId() + "','" + details.getSpid()
						+ "'," + details.getDj() + "," + details.getSl() + ")");
				// �޸Ŀ����¼
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() != null && !kucun.getId().isEmpty()) {
						int sl = kucun.getKcsl() - details.getSl();
						update("update tb_kucun set kcsl=" + sl + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	

	// ������������˻����
	public static String getXsthMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_xsth_main", "XT", "xsthID");
	}
	
	// ��ÿ����Ϣ
	public static List getKucunInfos() {
		List list = findForList("select id,spname,dj,kcsl from tb_kucun");
		return list;
	}
	
	// ����������������˻���Ϣ
	public static boolean insertXsthInfo(TbXsthMain xsthMain) {
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			// ��������˻������¼
			insert("insert into tb_xsth_main values('" + xsthMain.getXsthId()
					+ "','" + xsthMain.getPzs() + "'," + xsthMain.getJe()
					+ ",'" + xsthMain.getYsjl() + "','" + xsthMain.getKhname()
					+ "','" + xsthMain.getThdate() + "','" + xsthMain.getCzy()
					+ "','" + xsthMain.getJsr() + "','" + xsthMain.getJsfs()
					+ "')");
			Set<TbXsthDetail> xsthDetails = xsthMain.getTbXsthDetails();
			for (Iterator<TbXsthDetail> iter = xsthDetails.iterator(); iter
					.hasNext();) {
				TbXsthDetail details = iter.next();
				// ��������˻���ϸ���¼
				insert("insert into tb_xsth_detail values('"
						+ xsthMain.getXsthId() + "','" + details.getSpid()
						+ "'," + details.getDj() + "," + details.getSl() + ")");
				// �޸Ŀ����¼
				Item item = new Item();
				item.setId(details.getSpid());
				TbSpinfo spInfo = getSpInfo(item);
				if (spInfo.getId() != null && !spInfo.getId().isEmpty()) {
					TbKucun kucun = getKucun(item);
					if (kucun.getId() != null && !kucun.getId().isEmpty()) {
						int sl = kucun.getKcsl() + details.getSl();
						update("update tb_kucun set kcsl=" + sl + " where id='"
								+ kucun.getId() + "'");
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	// ����û�
	public static int addJsr(TbJsr jsr) {
		String sql = "insert tb_jsr values('" + jsr.getName() + "','"
				+ jsr.getSex() + "','" + jsr.getAge() + "','" + jsr.getTel()
				+ "',1)";
		System.out.println(sql);
		return update(sql);
	}
	
	public static List getJsrs() {
		List list = findForList("select * from tb_jsr where enable=1");
		return list;
	}
	
	// �޸��û�����
	public static int modifyPassword(String oldPass, String pass) {
		return update("update tb_userlist set pass='" + pass + "' where pass='"
				+ oldPass + "'");
	}
	
	// ��ȡ�����������ID
	private static String getMainTypeTableMaxId(Date date, String table,
			String idChar, String idName) {
		String dateStr = date.toString().replace("-", "");
		String id = idChar + dateStr;
		String sql = "select max(" + idName + ") from " + table + " where "
				+ idName + " like '" + id + "%'";
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseId = baseId == null ? "000" : baseId.substring(baseId.length() - 3);
		int idNum = Integer.parseInt(baseId) + 1;
		id += String.format("%03d", idNum);
		return id;
	}

	//�������
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

	//��������
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
	
	// ��ȡ�û�����ķ���
	public static TbJsr getUser(Item item) {
		String where = "username='" + item.getName() + "'";
		if (item.getId() != null)
			where = "name='" + item.getId() + "'";
		ResultSet rs = findForResultSet("select * from tb_userlist where "
				+ where);
		TbJsr user = new TbJsr();
		try {
			if (rs.next()) {
				user.setName(rs.getString("name").trim());
				user.setSex(rs.getString("username").trim());
				user.setAge(rs.getString("pass").trim());
				user.setTel(rs.getString("quan").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	// ��֤��¼
	public static boolean checkLogin(String userStr, String passStr)
			throws SQLException {
		ResultSet rs = findForResultSet("select * from tb_userlist where name='"
				+ userStr + "' and pass='" + passStr + "'");
		if (rs == null)
			return false;
		return rs.next();
	}
}
