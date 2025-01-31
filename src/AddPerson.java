import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 人员信息管理模块
 * 添加新的人员信息
 */
public class AddPerson extends PersonInfo {
	PersonBean pb = new PersonBean();

	public AddPerson() {
		this.setTitle("添加人员信息");
		this.setResizable(false);
		jTextField1.setEditable(false);
		jTextField1.setText(""+pb.getId());		
		jTextField2.setEditable(true);
		jTextField3.setEditable(true);
		jTextField4.setEditable(true);
		jTextField5.setEditable(true);
		jTextField6.setEditable(true);


		//设置运行时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
	}

	public void downInit(){
		addInfo.setText("增加");
		addInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(addInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		//添加事件侦听
		addInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == eixtInfo) { //退出
			this.dispose();
		}
		else if (obj == addInfo) { //增加
			jTextField1.setEnabled(false);
			jTextField2.setEnabled(false);
			jTextField3.setEnabled(false);
			jTextField4.setEnabled(false);
			jTextField5.setEnabled(false);
			jTextField6.setEnabled(false);

			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			eixtInfo.setEnabled(false);
			//添加信息
			PersonBean pb1 = new PersonBean();
			pb1.add(jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),jTextField6.getText());
			
			this.dispose();
			//重新生成界面
			AddPerson ap = new AddPerson();
			ap.downInit();
			ap.pack();
			ap.setVisible(true);
		}
		else if (obj == clearInfo) { //清空
			setNull();
			jTextField1.setText(""+pb.getId());
		}
	}
}