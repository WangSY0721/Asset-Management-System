import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;

/**
 * ��ѯ����Ļ�����
 */
public class ResultInfo extends JFrame {
	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1 ;
	JTable jTable;

	String sNum;
	//String[] colName;
	String[][] colValue;
	String sColValue;
	String sColName;
	String sFromValue;
	String sToValue;
	String tableID;


	/**
	 * ����Assets�����еļ�¼
     */
	public void resultAssetsAll(){
		this.setTitle("��Ϣ��ѯ���");
		//���ó���ͼ��
		this.setIconImage(getImage("icon.gif")); 
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 500) / 2 + 45);
		
		String[] colName = {"�ʲ����","�ʲ�����","��������","�ͺ�","�۸�","��������","״̬","��ע"};
		AssetsBean bean = new AssetsBean();
		try {
			colValue = bean.searchAll();
			if(colValue == null){
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼"); 
				this.dispose();
			}
			else{
				jTable = new JTable(colValue,colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1,BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����Assets���ض�ID��¼
     */
	public void resultAssetsID(String ID) {
		this.tableID = ID;

		this.setTitle("��Ϣ��ѯ���");
		this.setIconImage(getImage("icon.gif")); 
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 500) / 2 + 45);

		String[] colName = {"�ʲ����","�ʲ�����","��������","�ͺ�","�۸�","��������","״̬","��ע"};
		AssetsBean bean = new AssetsBean();
		try {
			colValue = bean.searchAll(tableID);
			if(colValue == null){
				this.dispose();
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼"); 	
			}
			else{
				jTable = new JTable(colValue,colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1,BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����Person�����еļ�¼
     */
	public void resultPersonAll(){
		this.setTitle("��Ϣ��ѯ���");
		//���ÿ�ܵĴ�С
		this.setSize(new Dimension(1500, 450));
		//���ó���ͼ��
		this.setIconImage(getImage("icon.gif")); 
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 500) / 2 + 45);
		
		String[] colName = {"��Ա���","����","�Ա�","����","ְλ","����"};
		PersonBean bean = new PersonBean();
		try {
			colValue = bean.searchAll();
			if(colValue == null){
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼"); 
				this.dispose();
			}
			else{
				jTable = new JTable(colValue,colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1,BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����Person���ض�ID��¼
     */
	public void resultPersonID(String ID) {
		this.tableID = ID;

		this.setTitle("��Ϣ��ѯ���");
		this.setIconImage(getImage("icon.gif")); 
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 500) / 2 + 45);

		String[] colName = {"��Ա���","����","�Ա�","����","ְλ","����"};
		PersonBean bean = new PersonBean();
		try {
			colValue = bean.searchAll(tableID);
			if(colValue == null){
				this.dispose();
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼"); 	
			}
			else{
				jTable = new JTable(colValue,colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1,BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����豸���õ����м�¼
     */
	public void resultUseAll(){
		this.setTitle("��Ϣ��ѯ���");
		//���ÿ�ܵĴ�С
		this.setSize(new Dimension(1500, 450));
		//���ó���ͼ��
		this.setIconImage(getImage("icon.gif")); 
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 500) / 2 + 45);
		
		String[] colName = {"���","�ʲ�����","����ʱ��","������","��;","��ע"};
		AssetsTrjnBean bean = new AssetsTrjnBean();
		try {
			colValue = bean.searchAllForUse();
			if(colValue == null){
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼"); 
				this.dispose();
			}
			else{
				jTable = new JTable(colValue,colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1,BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����豸�黹�����м�¼
     */
	public void resultBackAll(){
		this.setTitle("��Ϣ��ѯ���");
		//���ÿ�ܵĴ�С
		this.setSize(new Dimension(1500, 450));
		//���ó���ͼ��
		this.setIconImage(getImage("icon.gif")); 
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 500) / 2 + 45);
		
		String[] colName = {"���","�ʲ�����","����ʱ��","������","��;","��ע"};
		AssetsTrjnBean bean = new AssetsTrjnBean();
		try {
			colValue = bean.searchAllForBack();
			if(colValue == null){
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼"); 
				this.dispose();
			}
			else{
				jTable = new JTable(colValue,colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1,BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����豸���ϵ����м�¼
     */
	public void resultInvalidAll(){
		this.setTitle("��Ϣ��ѯ���");
		//���ÿ�ܵĴ�С
		this.setSize(new Dimension(1500, 450));
		//���ó���ͼ��
		this.setIconImage(getImage("icon.gif")); 
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 500) / 2 + 45);
		
		String[] colName = {"���","�ʲ�����","����ʱ��","������","��;","��ע"};
		AssetsTrjnBean bean = new AssetsTrjnBean();
		try {
			colValue = bean.searchAllForInvalid();
			if(colValue == null){
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼"); 
				this.dispose();
			}
			else{
				jTable = new JTable(colValue,colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1,BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ͨ���������ļ������ͼ��
	 */
	Image getImage(String filename) {
		URLClassLoader urlLoader = (URLClassLoader)this.getClass().
			getClassLoader();
		URL url = null;
		Image image = null;
		url = urlLoader.findResource(filename);
		image = Toolkit.getDefaultToolkit().getImage(url);
		MediaTracker mediatracker = new MediaTracker(this);
		try {
			mediatracker.addImage(image, 0);
			mediatracker.waitForID(0);
		}
		catch (InterruptedException _ex) {
			image = null;
		}
		if (mediatracker.isErrorID(0)) {
			image = null;
		}
		return image;
	}
}
