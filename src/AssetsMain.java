import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

/**
 * �ʲ�����ϵͳ������
 */
public class AssetsMain extends JFrame implements ActionListener{
	//��ܵĴ�С
	Dimension faceSize = new Dimension(600, 450);
	//����ͼ��
	Image icon;

	//�����˵���
	JMenuBar mainMenu = new JMenuBar();
	//������ϵͳ�����˵���
	JMenu menuSystem=new JMenu();
	JMenuItem itemTypeMan=new JMenuItem();
	JMenuItem itemExit=new JMenuItem();
	//�������ʲ���Ϣ�����˵���
	JMenu menuAssets=new JMenu();
	JMenuItem itemAddAssets=new JMenuItem();
	JMenuItem itemModifyAssets=new JMenuItem();
	JMenuItem itemDeleteAssets=new JMenuItem();
	JMenu itemSelectAssets=new JMenu();
	JMenuItem itemSelectAssetsAll = new JMenuItem();
	JMenuItem itemSelectAssetsID=new JMenuItem();
	//��������Ա��Ϣ�����˵���
	JMenu menuPerson=new JMenu();
	JMenuItem itemAddPerson=new JMenuItem();
	JMenuItem itemModifyPerson=new JMenuItem();
	JMenuItem itemDeletePerson=new JMenuItem();
	JMenu itemSelectPerson=new JMenu();
	JMenuItem itemSelectPersonAll = new JMenuItem();
	JMenuItem itemSelectPersonID=new JMenuItem();
	//�������ʲ����á��˵���
	JMenu menuUsing=new JMenu();
	JMenuItem itemUsing=new JMenuItem();
	JMenuItem itemSelectUsing=new JMenuItem();
	//�������ʲ��黹���˵���
	JMenu menuBack=new JMenu();
	JMenuItem itemBack=new JMenuItem();
	JMenuItem itemSelectBack=new JMenuItem();
	//�������ʲ����ϡ��˵���
	JMenu menuInvalid=new JMenu();
	JMenuItem itemInvalid=new JMenuItem();
	JMenuItem itemSelectInvalid=new JMenuItem();

	/**
	 * �����ʼ������
	 */
	 public AssetsMain() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);

		//��ӿ�ܵĹر��¼�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		//���ÿ�ܵĴ�С
		this.setSize(faceSize);
		//���ñ���
		this.setTitle("�ʲ�����ϵͳ");
		//����ͼ��
		icon = getImage("icon.gif");
		this.setIconImage(icon); //���ó���ͼ��

		try {
			Init();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����ʼ������
	 */
	private void Init() throws Exception {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		//��Ӳ˵���
		menuSystem.setText("ϵͳ����");
		menuSystem.setFont(new Font("Dialog", 0, 12));
		menuAssets.setText("�ʲ���Ϣ����");
		menuAssets.setFont(new Font("Dialog", 0, 12));
		menuPerson.setText("��Ա��Ϣ����");
		menuPerson.setFont(new Font("Dialog", 0, 12));
		menuUsing.setText("�ʲ�����") ;
		menuUsing.setFont(new Font("Dialog", 0, 12));
		menuBack.setText("�ʲ��黹");
		menuBack.setFont(new Font("Dialog", 0, 12));
		menuInvalid.setText("�ʲ�����");
		menuInvalid.setFont(new Font("Dialog", 0, 12));


		//���ɡ�ϵͳ�����˵����ѡ��
		itemTypeMan.setText("������");
		itemTypeMan.setFont(new Font("Dialog",0,12));
		itemExit.setText("�˳�");
		itemExit.setFont(new Font("Dialog",0,12));
		//���ɡ��ʲ���Ϣ�����˵����ѡ��
		itemAddAssets.setText("����");
		itemAddAssets.setFont(new Font("Dialog",0,12));
		itemModifyAssets.setText("�޸�");
		itemModifyAssets.setFont(new Font("Dialog",0,12));
		itemDeleteAssets.setText("ɾ��");
		itemDeleteAssets.setFont(new Font("Dialog",0,12));
		itemSelectAssets.setText("��ѯ");
		itemSelectAssets.setFont(new Font("Dialog",0,12));
		itemSelectAssetsAll.setText("��ѯ����");
		itemSelectAssetsAll.setFont(new Font("Dialog",0,12));
		itemSelectAssetsID.setText("����Ų�ѯ");
		itemSelectAssetsID.setFont(new Font("Dialog",0,12));
		//���ɡ���Ա��Ϣ�����˵����ѡ��
		itemAddPerson.setText("��Ա��Ϣ����");
		itemAddPerson.setFont(new Font("Dialog",0,12));
		itemModifyPerson.setText("��Ա��Ϣ�޸�");
		itemModifyPerson.setFont(new Font("Dialog",0,12));
		itemDeletePerson.setText("��Ա��Ϣɾ��");
		itemDeletePerson.setFont(new Font("Dialog",0,12));
		itemSelectPerson.setText("��ѯ��Ա��Ϣ");
		itemSelectPerson.setFont(new Font("Dialog",0,12));
		itemSelectPersonAll.setText("��ѯ����");
		itemSelectPersonAll.setFont(new Font("Dialog",0,12));
		itemSelectPersonID.setText("����Ų�ѯ");
		itemSelectPersonID.setFont(new Font("Dialog",0,12));
		//���ɡ��ʲ����á��˵����ѡ��
		itemUsing.setText("�ʲ����ù���");
		itemUsing.setFont(new Font("Dialog",0,12));
		itemSelectUsing.setText("������Ϣ��ѯ");
		itemSelectUsing.setFont(new Font("Dialog",0,12));
		//���ɡ��ʲ��黹���˵����ѡ��
		itemBack.setText("�ʲ��黹����");
		itemBack.setFont(new Font("Dialog",0,12));
		itemSelectBack.setText("�黹��Ϣ��ѯ");
		itemSelectBack.setFont(new Font("Dialog",0,12));
		//���ɡ��ʲ����ϡ��˵����ѡ��
		itemInvalid.setText("�ʲ����Ϲ���");
		itemInvalid.setFont(new Font("Dialog",0,12));
		itemSelectInvalid.setText("������Ϣ��ѯ");
		itemSelectInvalid.setFont(new Font("Dialog",0,12));

		//��ӡ�ϵͳ�����˵���
		menuSystem.add(itemTypeMan);
		menuSystem.add(itemExit);
		//��ӡ��ʲ���Ϣ�����˵���
		menuAssets.add(itemAddAssets);
		menuAssets.add(itemModifyAssets);
		menuAssets.add(itemDeleteAssets);
		menuAssets.addSeparator();
		menuAssets.add(itemSelectAssets);
		itemSelectAssets.add(itemSelectAssetsAll);
		itemSelectAssets.add(itemSelectAssetsID);
		//��ӡ���Ա��Ϣ�����˵���
		menuPerson.add(itemAddPerson);
		menuPerson.add(itemModifyPerson);
		menuPerson.add(itemDeletePerson);
		menuPerson.addSeparator();
		menuPerson.add(itemSelectPerson);
		itemSelectPerson.add(itemSelectPersonAll);
		itemSelectPerson.add(itemSelectPersonID);
		//��ӡ��ʲ����á��˵���
		menuUsing.add(itemUsing);
		menuUsing.add(itemSelectUsing);
		//��ӡ��ʲ��黹���˵���
		menuBack.add(itemBack);
		menuBack.add(itemSelectBack);
		//��ӡ��ʲ����ϡ��˵���
		menuInvalid.add(itemInvalid);
		menuInvalid.add(itemSelectInvalid);

		//������еĲ˵���
		mainMenu.add(menuSystem);
		mainMenu.add(menuAssets);
		mainMenu.add(menuPerson);
		mainMenu.add(menuUsing);
		mainMenu.add(menuBack);
		mainMenu.add(menuInvalid);
		this.setJMenuBar(mainMenu);

		//����¼�����
		itemTypeMan.addActionListener(this);
		itemExit.addActionListener(this);
		itemAddAssets.addActionListener(this);
		itemModifyAssets.addActionListener(this);
		itemDeleteAssets.addActionListener(this);
		itemSelectAssetsAll.addActionListener(this);
		itemSelectAssetsID.addActionListener(this);
		itemAddPerson.addActionListener(this);
		itemModifyPerson.addActionListener(this);
		itemDeletePerson.addActionListener(this);
		itemSelectPersonAll.addActionListener(this);
		itemSelectPersonID.addActionListener(this);
		itemUsing.addActionListener(this);
		itemSelectUsing.addActionListener(this);
		itemBack.addActionListener(this);
		itemSelectBack.addActionListener(this);
		itemInvalid.addActionListener(this);
		itemSelectInvalid.addActionListener(this);


		//�رճ���ʱ�Ĳ���
		this.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			}
		);
	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == itemExit) { //�˳�
			System.exit(0);
		}
		else if (obj == itemTypeMan) { //�ʲ�������
			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);
		}
		else if (obj == itemAddAssets) { //�����ʲ���Ϣ
			AddAssets add = new AddAssets();
			add.downInit();
			add.pack();
			add.setVisible(true);
		}
		else if (obj == itemModifyAssets) { //�޸��ʲ���Ϣ
			ModifyAssets modify = new ModifyAssets();
			modify.downInit();
			modify.pack();
			modify.setVisible(true);
		}
		else if (obj == itemDeleteAssets) { //ɾ���ʲ���Ϣ
			DeleteAssets delete = new DeleteAssets();
			delete.downInit();
			delete.pack();
			delete.setVisible(true);
		}
		else if (obj == itemSelectAssetsAll) { //��ѯ�����ʲ���Ϣ
			ResultInfo result = new ResultInfo();
			result.resultAssetsAll();
		}
		else if (obj == itemSelectAssetsID) { //�Ա�Ų�ѯ�ʲ���Ϣ
			SearchIDInfo info = new SearchIDInfo("Assets");
			info.pack();
			info.setVisible(true);
		}
		else if (obj == itemAddPerson) { //������Ա��Ϣ
			AddPerson add = new AddPerson();
			add.downInit();
			add.pack();
			add.setVisible(true);
		}
		else if (obj == itemModifyPerson) { //�޸���Ա��Ϣ
			ModifyPerson modify = new ModifyPerson();
			modify.downInit();
			modify.pack();
			modify.setVisible(true);
		}
		else if (obj == itemDeletePerson) { //�޸���Ա��Ϣ
			DeletePerson delete = new DeletePerson();
			delete.downInit();
			delete.pack();
			delete.setVisible(true);
		}
		else if (obj == itemSelectPersonAll) { //��ѯ������Ա��Ϣ
			ResultInfo result = new ResultInfo();
			result.resultPersonAll();
		}
		else if (obj == itemSelectPersonID) { //�Ա�Ų�ѯ��Ա��Ϣ
			SearchIDInfo info = new SearchIDInfo("Person");
			info.pack();
			info.setVisible(true);
		}
		else if (obj == itemUsing) { //�ʲ�����
			UseAssets use = new UseAssets();
			use.pack();
			use.setVisible(true);
		}
		else if (obj == itemSelectUsing) { //�ʲ����ò�ѯ
			ResultInfo result = new ResultInfo();
			result.resultUseAll();
		}
		else if (obj == itemBack) { //�ʲ��黹
			BackAssets back = new BackAssets();
			back.pack();
			back.setVisible(true);
		}
		else if (obj == itemSelectBack) { //�ʲ��黹��ѯ
			ResultInfo result = new ResultInfo();
			result.resultBackAll();
		}
		else if (obj == itemInvalid) { //�ʲ�����
			InvalidAssets invalid = new InvalidAssets();
			invalid.pack();
			invalid.setVisible(true);
		}
		else if (obj == itemSelectInvalid) { //�ʲ����ϲ�ѯ
			ResultInfo result = new ResultInfo();
			result.resultInvalidAll();
		}
	}

	/**
	 * ͨ���������ļ������ͼ��
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

