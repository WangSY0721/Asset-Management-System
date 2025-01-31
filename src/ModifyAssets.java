import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 资产信息管理模块
 * 修改资产信息的类
 */
public class ModifyAssets extends AssetsInfo {
	String id_str = "";
	public ModifyAssets() {
		this.setTitle("修改资产信息");
		this.setResizable(false);

		jTextField1.setEditable(false);
		jTextField1.setText("请查询编号");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);
		jComboBox1.setEnabled(false);


		//设置运行时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
	}

	public void downInit(){
		searchInfo.setText("资产编号查询");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		modifyInfo.setText("修改");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		searchInfo.setEnabled(true);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		eixtInfo.setEnabled(true);

		//添加事件侦听
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		jComboBox1.addItemListener(this);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);
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
		else if (obj == modifyInfo) { //修改
			AssetsBean modifyAssets = new AssetsBean();
			modifyAssets.modify(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), jTextField6.getText(), jTextField7.getText(), jTextField8.getText());
			modifyAssets.search(jTextField1.getText());
			s = modifyAssets.search(id_str);

			jTextField2.setText(s[0]);
			jTextField3.setText(s[1]);
			jTextField4.setText(s[2]);
			jTextField5.setText(s[3]);
			jTextField6.setText(s[4]);
			jTextField7.setText(s[5]);
			jTextField8.setText(s[6]);
		}
		else if (obj == clearInfo) { //清空
			setNull();
			jTextField1.setText("请查询编号");
			jComboBox1.setEnabled(false);
		}
		else if (obj == searchInfo) { //编号查询
			ModifyAssetsSearch modify_search = new ModifyAssetsSearch(this);
			modify_search.pack();
			modify_search.setVisible(true);
			try{
				id_str = modify_search.getID();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "没有查找到该编号！"); 
			}
	
			AssetsBean searchA = new AssetsBean();
			s = searchA.search(id_str);
			if(s == null){
				JOptionPane.showMessageDialog(null, "记录不存在！");
				jTextField1.setText("请查询资产编号");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				jTextField7.setText("");
				jTextField8.setText("");
				
				jTextField1.setEditable(false);
				jTextField2.setEditable(false);
				jTextField3.setEditable(false);
				jTextField4.setEditable(false);
				jTextField5.setEditable(false);
				jTextField6.setEditable(false);
				jTextField7.setEditable(false);
				jTextField8.setEnabled(false);
				jComboBox1.setEnabled(false);
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

				jTextField2.setEditable(true);
				jTextField3.setEditable(false);
				jTextField4.setEditable(true);
				jTextField5.setEditable(true);
				jTextField6.setEditable(true);
				jTextField7.setEditable(false);
				jTextField8.setEditable(true);
				jComboBox1.setEnabled(true);
				modifyInfo.setEnabled(true);
			}
		}
	}

	/**
	 * 下拉菜单事件处理
	 */
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){		
			String tempStr = "" +e.getItem();
			int i = tempStr.indexOf("-");
			jTextField3.setText(tempStr.substring(0,i));
		}
	}
}