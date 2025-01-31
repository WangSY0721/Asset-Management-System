import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * �ʲ���Ϣ����ģ��
 * ����µ��ʲ���Ϣ
 */
public class AddAssets extends AssetsInfo {
	AssetsBean ab = new AssetsBean();

	public AddAssets() {
		this.setTitle("����ʲ���Ϣ");
		this.setResizable(false);
		jTextField1.setEditable(false);
		jTextField1.setText(""+ab.getId());		
		jTextField2.setEditable(true);
		jTextField3.setText("1");
		jTextField3.setEditable(true);
		jTextField4.setEditable(true);
		jTextField5.setEditable(true);
		jTextField6.setEditable(true);
		jTextField7.setText("�ڿ�");
		jTextField7.setEditable(false);
		jTextField8.setEditable(true);

		//��������ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
	}

	public void downInit(){
		addInfo.setText("����");
		addInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(addInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("�˳�");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		//����¼�����
		addInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		jComboBox1.addItemListener(this);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == eixtInfo) { //�˳�
			this.dispose();
		}
		else if (obj == addInfo) { //����
			jTextField1.setEnabled(false);
			jTextField2.setEnabled(false);
			jTextField3.setEnabled(false);
			jTextField4.setEnabled(false);
			jTextField5.setEnabled(false);
			jTextField6.setEnabled(false);
			jTextField7.setEnabled(false);
			jTextField8.setEnabled(false);

			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			eixtInfo.setEnabled(false);

			AssetsBean ab = new AssetsBean();
			ab.add(jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),jTextField6.getText(),jTextField7.getText(),jTextField8.getText());
			
			this.dispose();

			AddAssets addAssets = new AddAssets();
			addAssets.downInit();
			addAssets.pack();
			addAssets.setVisible(true);
		}
		else if (obj == clearInfo) { //���
			setNull();
			jTextField1.setText(""+ab.getId());
		}
	}

	/**
	 * �����˵��¼�����
	 */
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){		
			String tempStr = "" +e.getItem();
			int i = tempStr.indexOf("-");
			jTextField3.setText(tempStr.substring(0,i));
		}
	}
}