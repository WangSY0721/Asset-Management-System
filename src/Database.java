import java.sql.*;

/**
 * �������ݿ����
 */


public class Database {
	
	private Statement stmt=null;
	ResultSet rs=null;
	private Connection conn=null;
	
	
	String sql;
	
	
	//sql server 2012  ���ӷ�ʽ
	//String strurl="jdbc:sqlserver://localhost:1433; DatabaseName=Assets";	
	//String userName = "sa"; //Ĭ���û���
	//String userPwd = "000000"; //��װsql server 2012ʱ������
	
	//mysql���ӷ�ʽ
	//String strurl="jdbc:mysql://localhost:3306/Assets?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	String strurl="jdbc:mysql://localhost:3306/Assets?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	
	String userName = "root"; //Ĭ���û���
	String userPwd = "000000"; //����

	//odbc���ӷ�ʽ
	//String strurl="jdbc:odbc:yu0525";
     //String userName="root";
	//String userPwd="000000";

	
	public Database(){
	}
	
	/**
	 * �����ݿ�����
	 */
	public void OpenConn()throws Exception{
		try{
			//sql server 2012  ���ӷ�ʽ
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//conn=DriverManager.getConnection(strurl, userName, userPwd);
			
			
			//mysql���ӷ�ʽ			
			
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn=DriverManager.getConnection(strurl, userName, userPwd);
			System.out.println("Successful");
			
			
			//ODBC���ݿ�����
			/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");			
			 conn = DriverManager.getConnection(strurl, userName, userPwd);
			 System.out.println("Successful");*/
			

			
		}
		catch(Exception e){ 
			System.err.println("OpenConn:"+e.getMessage());
		}
	}

	/**
	 * ִ��sql��䣬���ؽ����rs
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
	 * ִ��sql���
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
	 * �ر����ݿ�����
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
	 *ת������
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

