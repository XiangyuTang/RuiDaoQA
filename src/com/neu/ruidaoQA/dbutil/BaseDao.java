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
 * 工具类
 * @author Administrator
 *
 */
public class BaseDao {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/mysql";
	private String user="root";
	private String pwd="5046513";
	public static Connection con=null;
	public static  PreparedStatement pst =null;
	public static  ResultSet rs = null;
	
	/**
	 * 获取会话的方法
	 * @return
	 */
	public Connection getCon(){
		try {
			Class.forName(driver);//加载mysql驱动
			con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接建立失败");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * 公用的关闭各种jdbc对象的方法
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
			System.out.println("关闭数据库失败");
			e2.printStackTrace();
		}
		
	}
	
	/**
	 * 将增删改的操作抽取成共通的方法
	 * @return int 表示影响的行数
	 */
	public int executeIUD(String sql , Object[] params){
		PreparedStatement pst =null;//预编译sql语句对象
		con = getCon();//通过共通方法得到数据库连接
		int count =0;//设置影响行数的变量
		try {
			pst=con.prepareStatement(sql);
			//拼接参数  ,一个?对应一个参数
			if (null!=params) {
				for (int i = 0; i <params.length; i++) {
					pst.setObject(i+1, params[i]);//为sql中的每一个?赋值
				}
			}
			count=pst.executeUpdate();//PreparedStatement的增删改方法
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(con,pst,null);
		}
		return count;
	}
	
	/**
	 * 共通的查询方法,返回值是结果集
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeSelect(String sql , Object[] params){
		con = getCon();//通过共通方法得到数据库连接
		try {
			pst=con.prepareStatement(sql);
			if (null!=params) {
				for (int i = 0; i <params.length; i++) {
					pst.setObject(i+1, params[i]);//为sql中的每一个?赋值
				}
			}
			
			rs=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//这里注意不能调用closeAll方法,不然后期得不到rs中的值哦
		}
		
		return rs;
	}
	
	
//	public static void main(String[] args) {
//		BaseDao bb = new BaseDao();
//		
//		int i = bb.executeIUD("update userinfo set name=? ,password=? where id=?",
//				new Object[]{"emm","111111",1});
//		
//		System.out.println(i);
//	}
	
}
