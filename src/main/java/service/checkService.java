package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBCDao.JDBCUserDao;
import JDBCDaoImpl.JDBCUserDaoImpl;
import JDBCEntity.User;
import JDBCUtil.ConnectionFactory;

public class checkService {
	
	private JDBCUserDao judi = new JDBCUserDaoImpl();
	
	
	public ResultSet save(Long id){
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
		
		ResultSet rs = null;
		
		try {
			
			rs = judi.select(conn,id);
			
			return rs;
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(1);
		
		return rs;
	}
	
	public boolean find(String name,String password){
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
		
		ResultSet rs = null;
		
		try {
			
			rs = judi.fndByName(conn, name, password);
			
			if(rs.next()){
				
				System.out.println(6);
				
				return true;
		
			}else{
				
				System.out.println(7);
				
				return false;
				
			}
			
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}
