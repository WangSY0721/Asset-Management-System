import javax.swing.UIManager;
import java.awt.*;

/**
 * 资产管理系统运行主类
 */
public class AssetsMS {
	boolean packFrame = false;

	/**
	 * 构造函数
	 */
	public AssetsMS() {
		AssetsMain frame = new AssetsMain();

		if (packFrame) {
			frame.pack();
		}
		else {
			frame.validate();
		}

		//设置运行时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//设置运行风格
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		new AssetsMS();
	}
}