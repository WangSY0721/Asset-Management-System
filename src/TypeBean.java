import java.util.*;
import java.sql.*;
import javax.swing.*;

/**
 * �й��ʲ�������Ϣ���ݿ��������
 */
public class TypeBean {
	String sql;
	ResultSet rs = null;
	
	String field1;     //TypeID;
	String field2;     //B_Type;
	String field3;     //S_Type;

	String colName;//����
	String colValue;//��ֵ
	String colValue2;//��ֵ

	
	/**
	 * �����Ϣ
	 */	
	public void add(String f1, String f2, String f3){
		
		Database DB = new Database();
		
		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;


		if(field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ�����", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ�С��", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			sql = "insert into AssetsType(TypeID,B_Type,S_Type) values ('"+field1+"','"+field2+"','"+field3+"')";

			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"�ɹ����һ���µļ�¼��");

			}
			catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "����ʧ��", "����", JOptionPane.ERROR_MESSAGE); 
			}
			finally {
				DB.closeStmt();
				DB.closeConn();
			}
		}
	}

	/**
	 * �޸���Ϣ
	 */
	public void modify(String f1, String f2, String f3){
		
		Database DB = new Database();
		
		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;

		if(field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ�����", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ�С��", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			sql = "update AssetsType set B_Type = '"+field2+"', S_Type = '"+field3+"' where TypeID = "+field1+"";
			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"�ɹ��޸�һ���µļ�¼��");
			}
			catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "����ʧ��", "����", JOptionPane.ERROR_MESSAGE); 
			}
			finally {
				DB.closeStmt();
				DB.closeConn();
			}
		}
	}

	/**
	 * ɾ����Ϣ
	 */
	public void delete(String f1){
		
		Database DB = new Database();
		this.field1 = f1;
		
		sql = "delete from AssetsType where TypeID = "+field1+"";
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"�ɹ�ɾ��һ���µļ�¼��");
		}
		catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "����", JOptionPane.ERROR_MESSAGE); 
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}

	/**
	 * ���ݱ�Ų�ѯ��Ϣ
	 */
	public String[] search(String f1){
		
		Database DB = new Database();
		this.field1 = f1;
		String[] s = new String[7];
		sql = "select * from AssetsType where TypeID = "+field1+"";

		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				s[0] = rs.getString("TypeID");
				s[1] = rs.getString("B_Type");
				s[2] = rs.getString("S_Type");
			}
			else
				s = null;
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	} 

	/**
	 * ��ѯ���м�¼
	 */
	public String[][] searchAll(){

		Database DB = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from AssetsType order by TypeID";
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
			}
			else{
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("TypeID");
					sn[i][1] = rs.getString("B_Type");
					sn[i][2] = rs.getString("S_Type");
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
	 * Ϊ�ʲ������ṩ��ѯ
	 */
	public String[] searchAllForAssets(){

		Database DB = new Database();
		String[] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from AssetsType order by TypeID";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			
			if(row == 0){
				sn[0] = "";
				sn[1] = "";
				sn[2] = "";
			}
			else{
				sn = new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i] = rs.getString("TypeID")+"-"+rs.getString("B_Type")+"-"+rs.getString("S_Type");
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
	 * ��Ա��Ϣ�ۺϲ�ѯ(����ID���в�ѯ)
	 */
	public String[][] searchAll(String f1){
		this.field1 = f1;
		Database DB = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from AssetsType where TypeID="+field1+" order by TypeID";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			
			if(row == 0){
				sn = null;
			}
			else{
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("TypeID");
					sn[i][1] = rs.getString("B_Type");
					sn[i][2] = rs.getString("S_Type");
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
	 * ����µ�ID
	 */
	public int getId(){
		Database DB = new Database();
		int ID = 1;
		sql = "select max(TypeID) from AssetsType";
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

	/**
	 * ��ñ��е����б��
	 */
	public String[] getAllId(){
		String[] s = null;
		int row = 0;
		int i = 0;
		Database DB = new Database();
		sql = "select TypeID from AssetsType order by TypeID";
		
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.last()){
				row = rs.getRow();
			}

			if(row == 0){
				s = null;
			}
			else{
				s = new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					s[i] = rs.getString(1);
					i++;
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	} 

	/**
	 * ���ݱ�Ų�ѯ��Ϣ
	 */
	public String getDeptStr(String f1){
		
		Database DB = new Database();
		this.field1 = f1;
		String s = "";
		sql = "select * from AssetsType where TypeID = "+field1;
		
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				s = rs.getString("B_Type")+"-"+rs.getString("S_Type");
			}
			else
				s = null;
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	} 
}
