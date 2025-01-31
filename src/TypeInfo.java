import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.event.*;

/**
 * 资产类别信息综合管理类
 */
public class TypeInfo extends JFrame implements ActionListener,ListSelectionListener{
	Container contentPane;
	//定义所用的面板
	JPanel upPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel downPanel = new JPanel();

	//框架的大小
	Dimension faceSize = new Dimension(400,400);
	
	//定义图形界面元素
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	
	JTextField jTextField1 = new JTextField(15);  
	JTextField jTextField2 = new JTextField(15);
	JTextField jTextField3 = new JTextField(15);

	JButton searchInfo = new JButton();
	JButton addInfo = new JButton();
	JButton modifyInfo = new JButton();
	JButton deleteInfo = new JButton();
	JButton clearInfo = new JButton();
	JButton saveInfo = new JButton();
	JButton eixtInfo = new JButton();
	
	//定义表格
	JScrollPane jScrollPane1;
	JTable jTable;
	ListSelectionModel listSelectionModel = null;
    String[] colName = {"资产类别编号","资产大类","资产小类"};
	String[][] colValue;

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;

	public TypeInfo() {
		//设置框架的大小
		this.setSize(faceSize);
		//设置标题
		this.setTitle("资产类别管理"); 
		this.setResizable(true);
		//设置程序图标
		this.setIconImage(getImage("icon.gif")); 

		//设置运行时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
		try	{
			Init();
		}
		catch(Exception	e) {
			e.printStackTrace();
		}
	}

	public void Init() throws Exception {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		//中部面板的布局
		TypeBean bean = new TypeBean();
		try {
			colValue = bean.searchAll();
			jTable = new JTable(colValue,colName);
			jTable.setPreferredScrollableViewportSize(new Dimension(400,300));
			listSelectionModel = jTable.getSelectionModel();
			listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listSelectionModel.addListSelectionListener(this);
			jScrollPane1 = new JScrollPane(jTable);
			jScrollPane1.setPreferredSize(new Dimension(400,300));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		upPanel.add(jScrollPane1);
		contentPane.add(upPanel,BorderLayout.NORTH);

		jLabel1.setText("编号");
		jLabel1.setFont(new Font("Dialog",0,12));
		centerPanel.add(jLabel1);
		centerPanel.add(jTextField1);

		jLabel2.setText("大类");
		jLabel2.setFont(new Font("Dialog",0,12));
		centerPanel.add(jLabel2);
		centerPanel.add(jTextField2);

		jLabel3.setText("小类");
		jLabel3.setFont(new Font("Dialog",0,12));
		centerPanel.add(jLabel3);
		centerPanel.add(jTextField3);
		contentPane.add(centerPanel,BorderLayout.CENTER);

		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
	}
	
	/**
	 * 下部面板的布局
	 */
	public void downInit(){
		searchInfo.setText("获取新编号");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		addInfo.setText("增加");
		addInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(addInfo);
		modifyInfo.setText("修改");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		deleteInfo.setText("删除");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		contentPane.add(downPanel,BorderLayout.SOUTH);

		//添加事件侦听
		searchInfo.addActionListener(this);
		addInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);
		
		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		clearInfo.setEnabled(true);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) { //获取新编号
			setNull();
			TypeBean bean = new TypeBean();
			jTextField1.setText(""+bean.getId());
			jTextField2.setEditable(true);
			jTextField3.setEditable(true);

			addInfo.setEnabled(true);
			modifyInfo.setEnabled(false);
			deleteInfo.setEnabled(false);

		}
		else if (obj == addInfo) { //增加
			TypeBean bean = new TypeBean();
			bean.add(jTextField1.getText(),jTextField2.getText(),jTextField3.getText());
			this.dispose();

			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);
		}
		else if (obj == modifyInfo) { //修改
			TypeBean bean = new TypeBean();
			bean.modify(jTextField1.getText(),jTextField2.getText(),jTextField3.getText());
			this.dispose();

			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);
		}
		else if (obj == deleteInfo) { //删除
			TypeBean bean = new TypeBean();
			bean.delete(jTextField1.getText());
			this.dispose();

			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);

		}
		else if (obj == clearInfo) { //清空
			setNull();
		}
		else if (obj == eixtInfo) { //退出
			this.dispose();
		}
		jTable.revalidate();
	}

	/**
	 * 将文本框清空
	 */
	void setNull(){
		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		clearInfo.setEnabled(true);
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
				jTextField1.setText(colValue[selectedRow[i]][0]);
				jTextField2.setText(colValue[selectedRow[i]][1]);
				jTextField3.setText(colValue[selectedRow[i]][2]);
			}
		}
		//设置是否可操作
		jTextField2.setEditable(true);
		jTextField3.setEditable(true);
		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(true);
		deleteInfo.setEnabled(true);
		clearInfo.setEnabled(true);
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