import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.text.DateFormat;

/**
 * 资产领用、归还的数据库操作类
 */
public class AssetsTrjnBean {
	String sql;
	ResultSet rs = null;
	
	String field1;     //JourNo;
	String field2;     //FromAcc;
	String field3;     //OldInfo;
	String field4;     //NewInfo;
	String field5;     //ChgTime;
	String field6;     //RegDate;
	String field7;     //PersonID;

	String colName;//列名
	String colValue;//列值
	String colValue2;//列值

	
	/**
	 * 添加信息
	 */	
	public void add(String f1, String f2, String f3, String f4, String f5, String f6, String f7){
		
		Database DB = new Database();
		
		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;
		this.field4 = f4;
		this.field5 = f5;
		this.field6 = f6;
		this.field7 = f7;

		sql = "insert into AssetsTrjn(JourNo,FromAcc,AssetsID,RegDate,PersonID,Useornot,Other) "
			+"values ('"+field1+"','"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"')";
		System.out.println("sql="+sql);
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
		}
		catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "保存失败", "错误", JOptionPane.ERROR_MESSAGE); 
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}



	/**
	 * 查询所有记录
	 */
	public String[][] searchAllForUse(){

		Database DB = new Database();

		AssetsBean aBean = new AssetsBean();
		PersonBean pBean = new PersonBean();

		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "SELECT * FROM AssetsTrjn where Fromacc='设备借用' order by JourNo";

		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			
			if(row == 0){
				sn = new String[1][6];
				sn[0][0] = "  ";
				sn[0][1] = "  ";
				sn[0][2] = "  ";
				sn[0][3] = "  ";
				sn[0][4] = "  ";
				sn[0][5] = "  ";
			}
			else{
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("JourNo");
					sn[i][1] = aBean.getAssetsName(rs.getString("AssetsID"));
					sn[i][2] = rs.getString("RegDate");
					sn[i][3] = pBean.getPersonName(rs.getString("PersonID"));
					sn[i][4] = rs.getString("Use");
					sn[i][5] = rs.getString("Other");
					i++;
				}
			}
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;
	}

	/**
	 * 查询所有记录
	 */
	public String[][] searchAllForBack(){

		Database DB = new Database();

		AssetsBean aBean = new AssetsBean();
		PersonBean pBean = new PersonBean();

		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "SELECT * FROM AssetsTrjn where Fromacc='设备归还' order by JourNo";

		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			
			if(row == 0){
				sn = new String[1][6];
				sn[0][0] = "  ";
				sn[0][1] = "  ";
				sn[0][2] = "  ";
				sn[0][3] = "  ";
				sn[0][4] = "  ";
				sn[0][5] = "  ";
			}
			else{
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("JourNo");
					sn[i][1] = aBean.getAssetsName(rs.getString("AssetsID"));
					sn[i][2] = rs.getString("RegDate");
					sn[i][3] = pBean.getPersonName(rs.getString("PersonID"));
					sn[i][4] = rs.getString("Useornot");
					sn[i][5] = rs.getString("Other");
					i++;
				}
			}
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;
	}

	/**
	 * 查询所有记录
	 */
	public String[][] searchAllForInvalid(){

		Database DB = new Database();

		AssetsBean aBean = new AssetsBean();
		PersonBean pBean = new PersonBean();

		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "SELECT * FROM AssetsTrjn where Fromacc='设备报废' order by JourNo";

		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			
			if(row == 0){
				sn = new String[1][6];
				sn[0][0] = "  ";
				sn[0][1] = "  ";
				sn[0][2] = "  ";
				sn[0][3] = "  ";
				sn[0][4] = "  ";
				sn[0][5] = "  ";
			}
			else{
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("JourNo");
					sn[i][1] = aBean.getAssetsName(rs.getString("AssetsID"));
					sn[i][2] = rs.getString("RegDate");
					sn[i][3] = pBean.getPersonName(rs.getString("PersonID"));
					sn[i][4] = rs.getString("Useornot");
					sn[i][5] = rs.getString("Other");
					i++;
				}
			}
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;
	}
	
	/**
	 * 获得新的ID
	 */
	public int getId(){
		Database DB = new Database();
		int ID = 1;
		sql = "select max(JourNo) from AssetsTrjn";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				ID = rs.getInt(1) + 1;
			}
			else
				ID = 1;
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return ID;
	} 
}
