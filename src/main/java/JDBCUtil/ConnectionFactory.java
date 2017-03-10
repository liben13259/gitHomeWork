package JDBCUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private static DataSource ds;
	
	private static final ConnectionFactory factory = new ConnectionFactory();
	
	private Connection conn;
	
	static{
		Properties pop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			pop.load(in);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("≈‰÷√Œƒº˛∂¡»°¥ÌŒÛ£°");
		}
		driver = pop.getProperty("driver");
		dburl = pop.getProperty("dburl");
		user = pop.getProperty("user");
		password = pop.getProperty("password");
	}
	
	public ConnectionFactory(){
		
	}
	
	public static ConnectionFactory getInstance(){
		return factory;
	} 
	
	public Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
}
