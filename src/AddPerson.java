import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * ��Ա��Ϣ����ģ��
 * ����µ���Ա��Ϣ
 */
public class AddPerson extends PersonInfo {
	PersonBean pb = new PersonBean();

	public AddPerson() {
		this.setTitle("�����Ա��Ϣ");
		this.setResizable(false);
		jTextField1.setEditable(false);
		jTextField1.setText(""+pb.getId());		
		jTextField2.setEditable(true);
		jTextField3.setEditable(true);
		jTextField4.setEditable(true);
		jTextField5.setEditable(true);
		jTextField6.setEditable(true);


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

			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			eixtInfo.setEnabled(false);
			//�����Ϣ
			PersonBean pb1 = new PersonBean();
			pb1.add(jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),jTextField6.getText());
			
			this.dispose();
			//�������ɽ���
			AddPerson ap = new AddPerson();
			ap.downInit();
			ap.pack();
			ap.setVisible(true);
		}
		else if (obj == clearInfo) { //���
			setNull();
			jTextField1.setText(""+pb.getId());
		}
	}
}