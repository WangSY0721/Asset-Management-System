import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 人员信息管理模块
 * 删除人员信息的类
 */
public class DeletePerson extends PersonInfo{
	String id_str = "";

	public DeletePerson() {
		this.setTitle("删除人员信息");
		this.setResizable(false);

		jTextField1.setEditable(false);
		jTextField1.setText("请查询人员编号");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);


		//设置运行时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
	}

	public void downInit(){
		searchInfo.setText("人员编号查询");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		deleteInfo.setText("删除");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		eixtInfo.setEnabled(true);

		//添加事件侦听
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		contentPane.add(downPanel,BorderLayout.SOUTH);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] s = new String[8];

		if (obj == eixtInfo) { //退出
			this.dispose();
		}
		else if (obj == deleteInfo) { //删除
			int ifdel = JOptionPane.showConfirmDialog(null,"真的要删除该信息？","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE );
			if(ifdel == JOptionPane.YES_OPTION){
				PersonBean ab = new PersonBean();
				ab.delete(jTextField1.getText());
				
				this.dispose();

				DeletePerson delete = new DeletePerson();
				delete.downInit();
				delete.pack();
				delete.setVisible(true);
			}
			else{
				return;
			}
		}
		else if (obj == searchInfo) { //编号查询
			ModifyPersonSearch modify_search = new ModifyPersonSearch(this);
			modify_search.pack();
			modify_search.setVisible(true);
			id_str = modify_search.getID();
			PersonBean searchA = new PersonBean();
			s = searchA.search(id_str);

			if(s == null){
				JOptionPane.showMessageDialog(null, "记录不存在！");
				jTextField1.setText("请查询人员编号");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				deleteInfo.setEnabled(false);
				return;
			}
			else{
				jTextField1.setText(id_str);
				jTextField2.setText(s[0]);
				jTextField3.setText(s[1]);
				jTextField4.setText(s[2]);
				jTextField5.setText(s[3]);
				jTextField6.setText(s[4]);
				deleteInfo.setEnabled(true);
			}
			
		}
	}
}