import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ��Ա��Ϣ����ģ��
 * �޸���Ա��Ϣ����
 */
public class ModifyPerson extends PersonInfo {
	String id_str = "";
	public ModifyPerson() {
		this.setTitle("�޸���Ա��Ϣ");
		this.setResizable(false);

		jTextField1.setEditable(false);
		jTextField1.setText("���ѯ���");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);


		//��������ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
	}

	public void downInit(){
		searchInfo.setText("��Ա��Ų�ѯ");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		modifyInfo.setText("�޸�");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("�˳�");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		searchInfo.setEnabled(true);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		eixtInfo.setEnabled(true);

		//����¼�����
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] s = new String[8];

		if (obj == eixtInfo) { //�˳�
			this.dispose();
		}
		else if (obj == modifyInfo) { //�޸�
			PersonBean modifyPerson = new PersonBean();
			modifyPerson.modify(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), jTextField6.getText());
			modifyPerson.search(jTextField1.getText());
			s = modifyPerson.search(id_str);

			jTextField2.setText(s[0]);
			jTextField3.setText(s[1]);
			jTextField4.setText(s[2]);
			jTextField5.setText(s[3]);
			jTextField6.setText(s[4]);
			jTextField7.setText(s[5]);
			jTextField8.setText(s[6]);
		}
		else if (obj == clearInfo) { //���
			setNull();
			jTextField1.setText("���ѯ���");
		}
		else if (obj == searchInfo) { //��Ų�ѯ
			
			ModifyPersonSearch modify_search = new ModifyPersonSearch(this);
			modify_search.pack();
			modify_search.setVisible(true);
			try{
				id_str = modify_search.getID();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "û�в��ҵ��ñ�ţ�"); 
			}
	
			PersonBean searchA = new PersonBean();
			s = searchA.search(id_str);
			if(s == null){
				JOptionPane.showMessageDialog(null, "��¼�����ڣ�");
				jTextField1.setText("���ѯ���");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				
				jTextField1.setEditable(false);
				jTextField2.setEditable(false);
				jTextField3.setEditable(false);
				jTextField4.setEditable(false);
				jTextField5.setEditable(false);
				jTextField6.setEditable(false);
				return;
			}
			else{
				jTextField1.setText(id_str);
				jTextField2.setText(s[0]);
				jTextField3.setText(s[1]);
				jTextField4.setText(s[2]);
				jTextField5.setText(s[3]);
				jTextField6.setText(s[4]);

				jTextField2.setEditable(true);
				jTextField3.setEditable(true);
				jTextField4.setEditable(true);
				jTextField5.setEditable(true);
				jTextField6.setEditable(true);
				modifyInfo.setEnabled(true);
			}
		}
	}
}