package com.neu.ruidaoQA.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * ������
 * @author Administrator
 *
 */
public class BaseDao {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/wukong?useSSL=false";
	private String user="root";
	private String pwd="5046513";
	public static Connection con=null;
	public static  PreparedStatement pst =null;
	public static  ResultSet rs = null;
	/**
	 * ��ȡ�Ự�ķ���
	 * @return
	 */
	public Connection getCon(){
		try {
			Class.forName(driver);//����mysql����
			con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ӽ���ʧ��");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * ���õĹرո���jdbc����ķ���
	 * @param con
	 * @param st
	 * @param rs
	 */
	public void closeAll(Connection con,Statement st,ResultSet rs){
		try {
			if(null!=rs){
				rs.close();
			}
			if (null!=st) {
				st.close();
			}
			if (null!=con) {
				con.close();
			}
		} catch (Exception e2) {
			System.out.println("�ر����ݿ�ʧ��");
			e2.printStackTrace();
		}
		
	}
	
	/**
	 * ����ɾ�ĵĲ�����ȡ�ɹ�ͨ�ķ���
	 * @return int ��ʾӰ�������
	 */
	public int executeIUD(String sql , Object[] params){
		PreparedStatement pst =null;//Ԥ����sql������
		con = getCon();//ͨ����ͨ�����õ����ݿ�����
		int count =0;//����Ӱ�������ı���
		try {
			pst=con.prepareStatement(sql);
			//ƴ�Ӳ���  ,һ��?��Ӧһ������
			if (null!=params) {
				for (int i = 0; i <params.length; i++) {
					pst.setObject(i+1, params[i]);//Ϊsql�е�ÿһ��?��ֵ
				}
			}
			count=pst.executeUpdate();//PreparedStatement����ɾ�ķ���
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(con,pst,null);
		}
		return count;
	}
	
	/**
	 * ��ͨ�Ĳ�ѯ����,����ֵ�ǽ����
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeSelect(String sql , Object[] params){
		con = getCon();//ͨ����ͨ�����õ����ݿ�����
		try {
			pst=con.prepareStatement(sql);
			if (null!=params) {
				for (int i = 0; i <params.length; i++) {
					pst.setObject(i+1, params[i]);//Ϊsql�е�ÿһ��?��ֵ
				}
			}
			
			rs=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//����ע�ⲻ�ܵ���closeAll����,��Ȼ���ڵò���rs�е�ֵŶ
		}
		
		return rs;
	}
	
	
	public static void main(String[] args) {
		BaseDao bb = new BaseDao();
		
		int i = bb.executeIUD("update admin set admin_name=? ,adminPwd=? where admin_id=1",
				new Object[]{"emm","111111"});
		
		System.out.println(i);
	}
	
}
