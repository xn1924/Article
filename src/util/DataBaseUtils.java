package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;

public class DataBaseUtils {
	private static String username;
	private static String password;
	private static String dataBaseName;
	static {
		config("jdbc.properties");
	}
	public static void config(String path){
		InputStream inputStream = DataBaseUtils.class.getClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		try{
			p.load(inputStream);
			username = p.getProperty("db.username");
			password = p.getProperty("db.password");
			dataBaseName = p.getProperty("db.dataBaseName");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName+"?useUnicode=true&characterEncoding=utf8",username,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection(Connection connection,PreparedStatement statement,ResultSet rs){
	    try {
	        if(rs!=null)rs.close();
	        if(statement!=null)statement.close();
	        if(connection!=null)connection.close();
	    } catch (Exception e) {
	        e.fillInStackTrace();
	    }
	}
	public static void update(String sql,Object...objects){
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try{
			statement = (PreparedStatement)connection.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
				statement.setObject(i+1, objects[i]);
			}
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnection(connection, statement, null);
		}
	}
	
	
}
