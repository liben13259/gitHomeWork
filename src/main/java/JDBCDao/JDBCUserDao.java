package JDBCDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBCEntity.User;


public interface JDBCUserDao {
	
	
	public ResultSet select(Connection conn,Long id) throws SQLException;
	
	public ResultSet fndByName(Connection conn,String name,String password) throws SQLException;
}
