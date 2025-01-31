import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.event.*;
import java.util.*;
import java.text.*;

/**
 * 资产归还
 */
public class BackAssets extends JFrame implements ActionListener,ListSelectionListener,ItemListener{
	Container contentPane;
	//定义所用的面板
	JPanel mainPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel downPanel = new JPanel();
	
	//定义图形界面元素
	JLabel jLabel = new JLabel();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	
	String JourNo = "1";
	String FromAcc = "设备归还";    //操作类型
	String AssetsID = null;  //资产编号
	JComboBox jComboBox1 = null;   //领用人
	String PersonID = "1";
	JTextField jTextField1 = new JTextField(15);  //资产名称
	JTextField jTextField2 = new JTextField(15);  //用途
	JTextField jTextField3 = new JTextField(15);  //备注

	JButton modifyInfo = new JButton();
	JButton clearInfo = new JButton();

	//定义表格
	JScrollPane jScrollPane1;
	JTable jTable;
	ListSelectionModel listSelectionModel = null;
    String[] colName = {"资产编号","名称","类别","型号","价格"};
	String[][] colValue;

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;

	public BackAssets() {
		this.setLayout(new BorderLayout());
		this.setTitle("资产归还管理");
		//设置程序图标
		this.setIconImage(getImage("icon.gif")); 
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 500) / 2 + 45);
		try	{
			Init();  //上部面板布局
			makeFrame(); //生成主界面
			addListener();
		}
		catch(Exception	e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上部面板的布局
	 */
	public void Init() throws Exception {
		AssetsBean bean = new AssetsBean();
		upPanel.setLayout(girdBag);
		
		try {
			jLabel.setText("资产归还管理");
			jLabel.setFont(new Font("Dialog",0,16));
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 0;
			girdBagCon.gridy = 0;
			girdBagCon.gridwidth  = 4;
			girdBagCon.gridheight  = 1;
			girdBagCon.insets = new Insets(0,10,0,10);
			girdBag.setConstraints(jLabel,girdBagCon);
			upPanel.add(jLabel);
			
			colValue = bean.searchAllForBack();
			jTable = new JTable(colValue,colName);
			jTable.setPreferredScrollableViewportSize(new Dimension(450,280));
			listSelectionModel = jTable.getSelectionModel();
			listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listSelectionModel.addListSelectionListener(this);
			jScrollPane1 = new JScrollPane(jTable);
			jScrollPane1.setPreferredSize(new Dimension(450,280));

			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 0;
			girdBagCon.gridy = 1;
			girdBagCon.gridwidth  = 4;
			girdBagCon.gridheight  = 1;
			girdBagCon.insets = new Insets(0,0,10,0);
			girdBag.setConstraints(jScrollPane1,girdBagCon);
			upPanel.add(jScrollPane1);

			jLabel1.setText("资产名称：");
			jLabel1.setFont(new Font("Dialog",0,12));
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 0;
			girdBagCon.gridy = 2;
			girdBagCon.insets = new Insets(10,20,10,1);
			girdBag.setConstraints(jLabel1,girdBagCon);
			upPanel.add(jLabel1);

			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 1;
			girdBagCon.gridy = 2;
			girdBagCon.insets = new Insets(10,1,10,20);
			girdBag.setConstraints(jTextField1,girdBagCon);
			upPanel.add(jTextField1);

			jLabel2.setText("操作人员：");
			jLabel2.setFont(new Font("Dialog",0,12));
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 2;
			girdBagCon.gridy = 2;
			girdBagCon.insets = new Insets(10,20,10,1);
			girdBag.setConstraints(jLabel2,girdBagCon);
			upPanel.add(jLabel2);

			PersonBean pbean = new PersonBean();
			String[] allType = pbean.searchAllName();
			jComboBox1 = new JComboBox(allType);
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 3;
			girdBagCon.gridy = 2;
			girdBagCon.insets = new Insets(10,1,10,20);
			girdBag.setConstraints(jComboBox1,girdBagCon);
			upPanel.add(jComboBox1);

			jLabel3.setText("归还原因：");
			jLabel3.setFont(new Font("Dialog",0,12));
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 0;
			girdBagCon.gridy = 3;
			girdBagCon.insets = new Insets(10,20,10,1);
			girdBag.setConstraints(jLabel3,girdBagCon);
			upPanel.add(jLabel3);

			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 1;
			girdBagCon.gridy = 3;
			girdBagCon.insets = new Insets(10,1,10,20);
			girdBag.setConstraints(jTextField2,girdBagCon);
			upPanel.add(jTextField2);

			jLabel4.setText("备        注：");
			jLabel4.setFont(new Font("Dialog",0,12));
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 2;
			girdBagCon.gridy = 3;
			girdBagCon.insets = new Insets(10,20,10,1);
			girdBag.setConstraints(jLabel4,girdBagCon);
			upPanel.add(jLabel4);

			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 3;
			girdBagCon.gridy = 3;
			girdBagCon.insets = new Insets(10,1,10,20);
			girdBag.setConstraints(jTextField3,girdBagCon);
			upPanel.add(jTextField3);

			modifyInfo.setText("归还");
			modifyInfo.setFont(new Font("Dialog",0,12));
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 0;
			girdBagCon.gridy = 4;
			girdBagCon.gridwidth  = 2;
			girdBagCon.gridheight  = 1;
			girdBagCon.insets = new Insets(10,80,10,20);
			girdBag.setConstraints(modifyInfo,girdBagCon);
			upPanel.add(modifyInfo);

			clearInfo.setText("清空");
			clearInfo.setFont(new Font("Dialog",0,12));
			girdBagCon = new GridBagConstraints();
			girdBagCon.gridx = 2;
			girdBagCon.gridy = 4;
			girdBagCon.gridwidth  = 2;
			girdBagCon.gridheight  = 1;
			girdBagCon.insets = new Insets(10,20,10,80);
			girdBag.setConstraints(clearInfo,girdBagCon);
			upPanel.add(clearInfo);
		
			jTextField1.setEnabled(false);
			jTextField2.setEnabled(false);
			jTextField3.setEnabled(false);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		//添加上部面板
		//mainPanel.add(upPanel,BorderLayout.NORTH);
	}

	/**
	 * 生成主界面
	 */
	public void makeFrame() throws Exception{
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(upPanel,BorderLayout.SOUTH);
	}

	/**
	 * 将文本框清空
	 */
	void setNull(){
		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField1.setEnabled(false);
		jTextField2.setEnabled(false);
		jTextField3.setEnabled(false);
	}

	/**
	 * 添加事件侦听
	 */
	public void addListener() throws Exception {
		//添加事件侦听
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);

		jComboBox1.addItemListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == modifyInfo) { //修改
			AssetsBean bean = new AssetsBean();
			bean.updateStatus(AssetsID,"在库");

			AssetsTrjnBean atbean = new AssetsTrjnBean();
			JourNo = ""+atbean.getId();//取得ID
			java.util.Date now = new java.util.Date();
			DateFormat date = DateFormat.getDateTimeInstance();
			String f4 = ""+date.format(now);
			atbean.add(JourNo,"设备归还",AssetsID,f4,PersonID,jTextField2.getText(),jTextField2.getText());
			//重新生成界面
			this.dispose();

			BackAssets backAssets = new BackAssets();
			backAssets.pack();
			backAssets.setVisible(true);
		}
		else if (obj == clearInfo) { //清空
			setNull();
		}
		jTable.revalidate();
	}

	/**
	 * 当表格被选中时的操作
	 */
	public void valueChanged(ListSelectionEvent lse){
		int[] selectedRow = jTable.getSelectedRows();
		int[] selectedCol = jTable.getSelectedColumns();
		//定义文本框的显示内容
		for (int i=0; i<selectedRow.length; i++){
			for (int j=0; j<selectedCol.length; j++){
				jTextField1.setText(colValue[selectedRow[i]][1]);//名称
				AssetsID = colValue[selectedRow[i]][0];//资产编号
			}
		}
		//设置是否可操作
		jTextField2.setEnabled(true);
		jTextField3.setEnabled(true);
		modifyInfo.setEnabled(true);
		clearInfo.setEnabled(true);
	}

	/**
	 * 下拉菜单事件处理
	 */
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			String tempStr = "" +e.getItem();
			int i = tempStr.indexOf("-");
			PersonID = tempStr.substring(0,i);
		}
	}

	/**
	 * 通过给定的文件名获得图像
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