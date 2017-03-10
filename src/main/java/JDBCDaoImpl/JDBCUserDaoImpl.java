package JDBCDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCDao.JDBCUserDao;
import JDBCEntity.User;



public class JDBCUserDaoImpl implements JDBCUserDao {

	public ResultSet select(Connection conn,Long id) throws SQLException {
		String sql = "select a.address_name,u.user_id,u.name,u.hobby from jdbc_address a,jdbc_user u "+
				     "where a.address_id = u.address_id "+
				     "and a.address_id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	public ResultSet fndByName(Connection conn,String name,String password) throws SQLException {
		String sql = "select * from jdbc_user where name = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery();
		System.out.println(5);
		return rs;
	}

}
	

	







   


