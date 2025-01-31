import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * 人员信息综合管理类
 * 提供主界面，供其他类继承
 */
public class PersonInfo extends JFrame implements ActionListener{
	Container contentPane;
	JPanel centerPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel downPanel = new JPanel();

	//框架的大小
	Dimension faceSize = new Dimension(800, 500);
	
	//定义图形界面元素
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();
	JLabel jLabel8 = new JLabel();
	JLabel jLabel9 = new JLabel();
	
	JTextField jTextField1 = new JTextField(15);  
	JTextField jTextField2 = new JTextField(15);
	JTextField jTextField3 = new JTextField(15);
	JTextField jTextField4 = new JTextField(15);
	JTextField jTextField5 = new JTextField(15);
	JTextField jTextField6 = new JTextField(15);
	JTextField jTextField7 = new JTextField(15);
	JTextField jTextField8 = new JTextField(15);
	JTextField jTextField9 = new JTextField(46);

	JButton searchInfo = new JButton();
	JButton addInfo = new JButton();
	JButton modifyInfo = new JButton();
	JButton deleteInfo = new JButton();
	JButton clearInfo = new JButton();
	JButton saveInfo = new JButton();
	JButton eixtInfo = new JButton();

	JButton jBSee = new JButton();
	JButton jBSearch = new JButton();
	JButton jBExit = new JButton();
	JButton jBSum = new JButton();
	JButton jBGrade = new JButton();

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;

	public PersonInfo() {
		//设置框架的大小
		this.setSize(faceSize);
		//设置标题
		this.setTitle("人员综合信息管理"); 
		this.setResizable(false);
		//设置程序图标
		this.setIconImage(getImage("icon.gif")); 

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
		centerPanel.setLayout(girdBag);

		jLabel1.setText("编        号：");
		jLabel1.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel1,girdBagCon);
		centerPanel.add(jLabel1);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,1,10,15);
		girdBag.setConstraints(jTextField1,girdBagCon);
		centerPanel.add(jTextField1);

		jLabel2.setText("姓        名：");
		jLabel2.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel2,girdBagCon);
		centerPanel.add(jLabel2);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,1,10,10);
		girdBag.setConstraints(jTextField2,girdBagCon);
		centerPanel.add(jTextField2);

		jLabel3.setText("性        别：");
		jLabel3.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel3,girdBagCon);
		centerPanel.add(jLabel3);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,1,10,15);
		girdBag.setConstraints(jTextField3,girdBagCon);
		centerPanel.add(jTextField3);

		jLabel4.setText("部        门：");
		jLabel4.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel4,girdBagCon);
		centerPanel.add(jLabel4);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,1,10,10);
		girdBag.setConstraints(jTextField4,girdBagCon);
		centerPanel.add(jTextField4);

		jLabel5.setText("职        位：");
		jLabel5.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel5,girdBagCon);
		centerPanel.add(jLabel5);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,1,10,15);
		girdBag.setConstraints(jTextField5,girdBagCon);
		centerPanel.add(jTextField5);

		jLabel6.setText("其        他：");
		jLabel6.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel6,girdBagCon);
		centerPanel.add(jLabel6);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.insets = new Insets(10,1,10,10);
		girdBag.setConstraints(jTextField6,girdBagCon);
		centerPanel.add(jTextField6);



		contentPane.add(centerPanel,BorderLayout.CENTER);

		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
	}
	
	/**
	 * 下部面板的布局
	 */
	public void downInit(){
		searchInfo.setText("查询");
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
		saveInfo.setText("保存");
		saveInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(saveInfo);
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
		saveInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		saveInfo.setEnabled(false);
		clearInfo.setEnabled(false);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) { //查询
		}
		else if (obj == addInfo) { //增加
		}
		else if (obj == modifyInfo) { //修改
		}
		else if (obj == deleteInfo) { //删除
		}
		else if (obj == saveInfo) { //保存
		}
		else if (obj == clearInfo) { //清空
			setNull();
		}
		else if (obj == eixtInfo) { //退出
			this.dispose();
		}
	}

	/**
	 * 将文本框清空
	 */
	void setNull(){
		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField4.setText(null);
		jTextField5.setText(null);
		jTextField6.setText(null);
		jTextField7.setText(null);
		jTextField8.setText(null);
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