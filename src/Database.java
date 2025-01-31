import java.sql.*;

/**
 * 连接数据库的类
 */


public class Database {
	
	private Statement stmt=null;
	ResultSet rs=null;
	private Connection conn=null;
	
	
	String sql;
	
	
	//sql server 2012  连接方式
	//String strurl="jdbc:sqlserver://localhost:1433; DatabaseName=Assets";	
	//String userName = "sa"; //默认用户名
	//String userPwd = "000000"; //安装sql server 2012时的密码
	
	//mysql连接方式
	//String strurl="jdbc:mysql://localhost:3306/Assets?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	String strurl="jdbc:mysql://localhost:3306/Assets?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	
	String userName = "root"; //默认用户名
	String userPwd = "000000"; //密码

	//odbc连接方式
	//String strurl="jdbc:odbc:yu0525";
     //String userName="root";
	//String userPwd="000000";

	
	public Database(){
	}
	
	/**
	 * 打开数据库连接
	 */
	public void OpenConn()throws Exception{
		try{
			//sql server 2012  连接方式
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//conn=DriverManager.getConnection(strurl, userName, userPwd);
			
			
			//mysql连接方式			
			
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn=DriverManager.getConnection(strurl, userName, userPwd);
			System.out.println("Successful");
			
			
			//ODBC数据库连接
			/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");			
			 conn = DriverManager.getConnection(strurl, userName, userPwd);
			 System.out.println("Successful");*/
			

			
		}
		catch(Exception e){ 
			System.err.println("OpenConn:"+e.getMessage());
		}
	}

	/**
	 * 执行sql语句，返回结果集rs
	 */
	public ResultSet executeQuery(String sql){
		stmt = null;
		rs=null;
		try{
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("executeQuery:"+e.getMessage());
		}
		return rs;
	}

	/**
	 * 执行sql语句
	 */
	public void executeUpdate(String sql){
		stmt=null;
		rs=null;
		try{
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(sql);
			conn.commit();
		}
		catch(SQLException e){
			System.err.println("executeUpdate:"+e.getMessage()); 
		}
	}
	
	public void closeStmt(){
		try{
			stmt.close();
		}
		catch(SQLException e){
			System.err.println("closeStmt:"+e.getMessage()); 
		}
	}

	/**
	 * 关闭数据库连接
	 */
	public void closeConn(){
		try{
			conn.close();
		}
		catch(SQLException ex){
			System.err.println("aq.closeConn:"+ex.getMessage()); 
		}
	}
	
	/*
	 *转换编码
	 */
	public static String toGBK(String str){
		try {
			if(str==null)
				str = "";
			else
				str=new String(str.getBytes("ISO-8859-1"),"GBK"); 
		}
		catch (Exception e) {System.out.println(e);}
		
		return str;
	}
}

