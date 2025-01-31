import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * �ʲ���Ϣ����ģ��
 * �����ʲ���Ų�ѯ�ʲ���Ϣ���Թ��������޸Ļ�ɾ��
 */
public class ModifyAssetsSearch extends JDialog implements ActionListener{
	Container contentPane;
	String[] s;
	//��ܵĴ�С
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JComboBox selectID;
	JButton searchInfo = new JButton();

	
	public ModifyAssetsSearch(JFrame frame) {
		super(frame, true);
		this.setTitle("�ʲ���Ų�ѯ");
		this.setResizable(false);
		try {
			Init();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 +45);

	}
	
	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("���������ѡ���ʲ����:");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);

		AssetsBean getId = new AssetsBean();
		s = getId.getAllId();

		selectID = new JComboBox(s);

		selectID.setEditable(true);
		selectID.setFont(new Font("Dialog",0,12));
		contentPane.add(selectID);

		searchInfo.setText("��ѯ");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);

	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == selectID) { //�˳�
			this.dispose();
		}
		else if (obj == searchInfo) { //�޸�
			this.dispose();
		}
	}

	/**
	 * ����ѡ��ı��
	 */
	public String getID(){
		return (String)this.selectID.getSelectedItem();
	}
}
