import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * 信息查询模块
 * 根据编号查询信息
 */
public class SearchIDInfo extends JFrame implements ActionListener{
	Container contentPane;
	//框架的大小
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JTextField jTextField = new JTextField(4);
	JButton searchInfo = new JButton();
	String tablename = null;
	
	public SearchIDInfo(String str) {
		//设置标题
		this.setTitle("按编号查询");
		this.setResizable(false);
		//设置程序图标
		this.setIconImage(getImage("icon.gif")); 

		this.tablename = str;

		try {
			Init();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 100) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
	}
	
	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("请输入编号: ");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);

		jTextField.setText(null);
		jTextField.setFont(new Font("Dialog",0,12));
		contentPane.add(jTextField);

		searchInfo.setText("确定");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) { //查询
			if(tablename == "Assets" ){
				ResultInfo result = new ResultInfo();
				result.resultAssetsID(jTextField.getText());
				this.dispose();
			}
			else if(tablename == "Person" ){
				ResultInfo result = new ResultInfo();
				result.resultPersonID(jTextField.getText());
				this.dispose();
			}
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
