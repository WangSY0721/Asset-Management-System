import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * �ʲ���Ϣ����ģ��
 * ɾ���ʲ���Ϣ����
 */
public class DeleteAssets extends AssetsInfo{
	String id_str = "";

	public DeleteAssets() {
		this.setTitle("ɾ���ʲ���Ϣ");
		this.setResizable(false);

		jTextField1.setEditable(false);
		jTextField1.setText("���ѯ�ʲ����");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);
		jComboBox1.setEditable(false);
		jComboBox1.setEnabled(false);

		//��������ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
	}

	public void downInit(){
		searchInfo.setText("�ʲ���Ų�ѯ");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		deleteInfo.setText("ɾ��");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		eixtInfo.setText("�˳�");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		eixtInfo.setEnabled(true);

		//����¼�����
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		contentPane.add(downPanel,BorderLayout.SOUTH);
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
		else if (obj == deleteInfo) { //ɾ��
			int ifdel = JOptionPane.showConfirmDialog(null,"���Ҫɾ������Ϣ��","��ʾ��Ϣ",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE );
			if(ifdel == JOptionPane.YES_OPTION){
				AssetsBean ab = new AssetsBean();
				ab.delete(jTextField1.getText());
				
				this.dispose();

				DeleteAssets delete = new DeleteAssets();
				delete.downInit();
				delete.pack();
				delete.setVisible(true);
			}
			else{
				return;
			}
		}
		else if (obj == searchInfo) { //��Ų�ѯ
			ModifyAssetsSearch modify_search = new ModifyAssetsSearch(this);
			modify_search.pack();
			modify_search.setVisible(true);
			id_str = modify_search.getID();
			AssetsBean searchA = new AssetsBean();
			s = searchA.search(id_str);

			if(s == null){
				JOptionPane.showMessageDialog(null, "��¼�����ڣ�");
				jTextField1.setText("���ѯ�ʲ����");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				jTextField7.setText("");
				jTextField8.setText("");
				deleteInfo.setEnabled(false);
				return;
			}
			else{
				jTextField1.setText(id_str);
				jTextField2.setText(s[0]);
				jTextField3.setText(s[1]);
				int index = Integer.parseInt(s[1]) - 1;
				jComboBox1.setSelectedIndex(index);
				jTextField4.setText(s[2]);
				jTextField5.setText(s[3]);
				jTextField6.setText(s[4]);
				jTextField7.setText(s[5]);
				jTextField8.setText(s[6]);
				deleteInfo.setEnabled(true);
			}
		}
	}
}