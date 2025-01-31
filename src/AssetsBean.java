import java.util.*;
import java.sql.*;
import javax.swing.*;

/**
 * �й��ʲ���Ϣ���ݿ��������
 */
public class AssetsBean {
	String sql;
	ResultSet rs = null;
	
	String field1;     //assetsID;
	String field2;     //assetsName;
	String field3;     //typeID;
	String field4;     //model;
	String field5;     //price;
	String field6;     //buyDate;
	String field7;     //status;
	String field8;     //other;

	String colName;//����
	String colValue;//��ֵ
	String colValue2;//��ֵ

	
	/**
	 * ����豸��Ϣ
	 */	
	public void add(String f1, String f2, String f3, String f4, String f5, String f6, String f7, String f8){
		
		Database DB = new Database();
		
		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;
		this.field4 = f4;
		this.field5 = f5;
		this.field6 = f6;
		this.field7 = f7;
		this.field8 = f8;

		if(field1 == null||field1.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ����", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "�������豸����", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "�������豸�ͺ�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field4 == null||field4.equals("")){
			JOptionPane.showMessageDialog(null, "�������豸�۸�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field5 == null||field5.equals("")){
			JOptionPane.showMessageDialog(null, "�������豸�۸�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			// sqlserver
			//sql = "execute proc_insAsset '"+field1+"','"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"','"+field8+"'";
			// mysql
			sql = "call proc_insAsset('"+field1+"','"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"','"+field8+"')";

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
	 * �޸��豸��Ϣ
	 */
	public void modify(String f1, String f2, String f3, String f4, String f5, String f6, String f7, String f8){
		
		Database DB = new Database();
		
		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;
		this.field4 = f4;
		this.field5 = f5;
		this.field6 = f6;
		this.field7 = f7;
		this.field8 = f8;

		if(field1 == null||field1.equals("")){
			JOptionPane.showMessageDialog(null, "�������ʲ����", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field2 == null||field2.equals("")){
			JOptionPane.showMessageDialog(null, "�������豸����", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3 == null||field3.equals("")){
			JOptionPane.showMessageDialog(null, "�������豸�ͺ�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field4 == null||field4.equals("")){
			JOptionPane.showMessageDialog(null, "�������豸�۸�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field5 == null||field5.equals("")){
			JOptionPane.showMessageDialog(null, "�������豸�۸�", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			sql = "update Assets set Name = '"+field2+"', typeID = '"+field3+"', model = '"+field4+"', price = '"+field5+"', buyDate = '"+field6+"', status = '"+field7+"', other = '"+field8+"' where AssetsID = "+field1+"";
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
		
		//sql = "delete from Assets where AssetsID = "+field1+"";
		//sqlserver
		//sql = "exec proc_delAsset "+field1+"";
		
		//mysql
		sql = "call proc_delAsset ('"+field1+"')";
		
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
		sql = "select * from Assets where AssetsID = "+field1+"";

		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				s[0] = rs.getString("Name");
				s[1] = rs.getString("TypeID");
				s[2] = rs.getString("Model");
				s[3] = rs.getString("Price");
				s[4] = rs.getString("BuyDate");
				s[5] = rs.getString("Status");
				s[6] = rs.getString("Other");
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
	 * �ʲ���Ϣ�ۺϲ�ѯ(��ѯ���м�¼)
	 */
	public String[][] searchAll(){

		Database DB = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from Assets order by AssetsID";
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
				sn = new String[row][8];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("AssetsID");
					sn[i][1] = rs.getString("Name");
					sn[i][2] = rs.getString("TypeID");
					sn[i][3] = rs.getString("Model");
					sn[i][4] = rs.getString("Price");
					sn[i][5] = rs.getString("BuyDate");
					sn[i][6] = rs.getString("Status");
					sn[i][7] = rs.getString("Other");
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
	 * �ʲ���Ϣ�ۺϲ�ѯ(����ID���в�ѯ)
	 */
	public String[][] searchAll(String f1){
		this.field1 = f1;
		Database DB = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from Assets where AssetsID="+field1+" order by AssetsID";
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
				sn = new String[row][8];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("AssetsID");
					sn[i][1] = rs.getString("Name");
					sn[i][2] = rs.getString("TypeID");
					sn[i][3] = rs.getString("Model");
					sn[i][4] = rs.getString("Price");
					sn[i][5] = rs.getString("BuyDate");
					sn[i][6] = rs.getString("Status");
					sn[i][7] = rs.getString("Other");
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
		sql = "select max(AssetsID) from Assets";
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
		sql = "select AssetsID from Assets";
		
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
	public String getAssetsName(String f1){
		
		Database DB = new Database();
		this.field1 = f1;
		String s = "";
		sql = "select name from Assets where AssetsID = "+field1+"";
		
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				s = rs.getString("name");
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
	 * Ϊ�ʲ����ü����Ϸ�������
	 */
	public String[][] searchAllForUse(){

		Database DB = new Database();
		TypeBean abean = new TypeBean();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from Assets where Status='�ڿ�' order by AssetsID";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			
			if(row == 0){
				sn = new String[1][5];
				sn[0][0] = "  ";
				sn[0][1] = "  ";
				sn[0][2] = "  ";
				sn[0][3] = "  ";
				sn[0][4] = "  ";
			}
			else{
				sn = new String[row][5];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("AssetsID");
					sn[i][1] = rs.getString("Name");
					sn[i][2] = abean.getDeptStr(rs.getString("TypeID"));
					sn[i][3] = rs.getString("Model");
					sn[i][4] = rs.getString("Price");
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
	 * Ϊ�ʲ��黹��������
	 */
	public String[][] searchAllForBack(){

		Database DB = new Database();
		TypeBean abean = new TypeBean();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from Assets where Status='���' order by AssetsID";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			
			if(row == 0){
				sn = new String[1][5];
				sn[0][0] = "  ";
				sn[0][1] = "  ";
				sn[0][2] = "  ";
				sn[0][3] = "  ";
				sn[0][4] = "  ";
			}
			else{
				sn = new String[row][5];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0] = rs.getString("AssetsID");
					sn[i][1] = rs.getString("Name");
					sn[i][2] = abean.getDeptStr(rs.getString("TypeID"));
					sn[i][3] = rs.getString("Model");
					sn[i][4] = rs.getString("Price");
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
	 * �޸���Ϣ
	 */
	public void updateStatus(String f1,String f7){

		Database DB = new Database();
		
		this.field1 = f1;
		this.field7 = f7;

		sql = "update Assets set Status ='"+field7+"' where AssetsID = "+field1;
		
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"�����ɹ���");
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
