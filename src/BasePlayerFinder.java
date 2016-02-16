import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;


public class BasePlayerFinder extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox yearBox;
	private JTextField param1Value;
	private JTextField param2Value;
	private JTextField param3Value;
	private JComboBox param1Compare;
	private JComboBox param2Compare;
	private JComboBox param3Compare;
	private JComboBox param1Index;
	private JComboBox param2Index;
	private JComboBox param3Index;
	public float[] paramValues = {3000, 0, 1, 0, 0, 1, 0, 0, 1, 0};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasePlayerFinder frame = new BasePlayerFinder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		int action = Integer.parseInt(e.getActionCommand());
		switch (action) {
			case 0: //Year Value
				JComboBox cb = (JComboBox) e.getSource();
				int newSelection = cb.getSelectedIndex();
				if (newSelection == 0) {
					paramValues[action] = 3000;
				}
				else {
					paramValues[action] = (newSelection+1994);
				}
				break;
			case 1: //Parameter 1 index
				JComboBox cb1 = (JComboBox) e.getSource();
				int newSelection1 = cb1.getSelectedIndex();
			    paramValues[action] = (newSelection1);
				break;
			case 2: //Parameter 1 operator
				JComboBox cb2 = (JComboBox) e.getSource();
				int newSelection2 = cb2.getSelectedIndex();
			    paramValues[action] = (newSelection2);
				break;
			case 3://Parameter 2 index
				JComboBox cb3 = (JComboBox) e.getSource();
				int newSelection3 = cb3.getSelectedIndex();
			    paramValues[action] = (newSelection3);
				break;
			case 4: //Parameter 2 operator
				JComboBox cb4 = (JComboBox) e.getSource();
				int newSelection4 = cb4.getSelectedIndex();
			    paramValues[action] = (newSelection4);
				break;
			case 5: //Parameter 3 index
				JComboBox cb5 = (JComboBox) e.getSource();
				int newSelection5 = cb5.getSelectedIndex();
			    paramValues[action] = (newSelection5);
				break;
			case 6: //Parameter 3 operator
				JComboBox cb6 = (JComboBox) e.getSource();
				int newSelection6 = cb6.getSelectedIndex();
			    paramValues[action] = (newSelection6);
				break;
			case 7:
				float value1 = Float.valueOf(param1Value.getText());
				float value2 = Float.valueOf(param2Value.getText());
				float value3 = Float.valueOf(param3Value.getText());
				paramValues[3] = value1;
				paramValues[6] = value2;
				paramValues[9] = value3;
				BaseballList tableStats = new BaseballList();
				tableStats.readFile();
				tableStats.readStats(String.valueOf((int) paramValues[0]));
				LinkedList<String[]> foundPlayers = new LinkedList<String[]>();
				foundPlayers = tableStats.findPlayers(paramValues);
				PlayersTable tableWindow = new PlayersTable(foundPlayers);
				tableWindow.openPT(foundPlayers);
				
				break;
		}
	}
	/**
	 * Create the frame.
	 */
	public BasePlayerFinder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectYear = new JLabel("Select Year");
		lblSelectYear.setBounds(35, 30, 69, 14);
		contentPane.add(lblSelectYear);
		
		String[] yearList = {"Career", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014"};
		JComboBox<String> yearBox = new JComboBox<String>(yearList);
		yearBox.addActionListener(this);
		yearBox.setActionCommand("0");
		

		//yearBox.setModel(new DefaultComboBoxModel(new String[] {));
		yearBox.setBounds(101, 27, 112, 20);
		contentPane.add(yearBox);
		
		JLabel lblParameter = new JLabel("Parameter 1");
		lblParameter.setBounds(35, 82, 89, 14);
		contentPane.add(lblParameter);
		
		JLabel lblStat = new JLabel("Stat");
		lblStat.setBounds(45, 107, 46, 14);
		contentPane.add(lblStat);
		
		String[] statNames = {"Games", "At Bats", "Runs", "Hits", "Doubles", "Triples", "HR", "RBI", "SB", "CS", "BB", "SO", "IBB", "HBP", "SH", "SF", "GIDP", "BA", "SLG"};
		String[] operators = {"<=", ">="};
		
		JComboBox<String> param1Index = new JComboBox<String>(statNames);
		param1Index.addActionListener(this);
		param1Index.setActionCommand("1");
		param1Index.setBounds(101, 107, 89, 20);
		contentPane.add(param1Index);
		
		JComboBox<String> param1Compare = new JComboBox<String>(operators);
		param1Compare.addActionListener(this);
		param1Compare.setActionCommand("2");
		param1Compare.setBounds(219, 107, 46, 20);
		contentPane.add(param1Compare);
		
		param1Value = new JTextField("0");
		param1Value.setBounds(289, 107, 86, 20);
		contentPane.add(param1Value);
		param1Value.setColumns(10);
		
		JLabel label = new JLabel("Stat");
		label.setBounds(45, 163, 46, 14);
		contentPane.add(label);
		
		JComboBox<String> param2Index = new JComboBox<String>(statNames);
		param2Index.addActionListener(this);
		param2Index.setActionCommand("3");
		param2Index.setBounds(101, 163, 89, 20);
		contentPane.add(param2Index);
		
		JComboBox<String> param2Compare = new JComboBox<String>(operators);
		param2Compare.addActionListener(this);
		param2Compare.setActionCommand("4");
		param2Compare.setBounds(219, 163, 46, 20);
		contentPane.add(param2Compare);
		
		param2Value = new JTextField("0");
		param2Value.setColumns(10);
		param2Value.setBounds(289, 163, 86, 20);
		contentPane.add(param2Value);
		
		JLabel lblParameter_1 = new JLabel("Parameter 2");
		lblParameter_1.setBounds(35, 138, 89, 14);
		contentPane.add(lblParameter_1);
		
		JLabel label_2 = new JLabel("Stat");
		label_2.setBounds(45, 219, 46, 14);
		contentPane.add(label_2);
		
		JComboBox<String> param3Index = new JComboBox<String>(statNames);
		param3Index.addActionListener(this);
		param3Index.setActionCommand("5");
		param3Index.setBounds(101, 219, 89, 20);
		contentPane.add(param3Index);
		
		JComboBox<String> param3Compare = new JComboBox<String>(operators);param3Compare.addActionListener(this);
		param3Compare.setActionCommand("6");
		param3Compare.setBounds(219, 219, 46, 20);
		contentPane.add(param3Compare);
		
		param3Value = new JTextField("0");
		param3Value.setColumns(10);
		param3Value.setBounds(289, 219, 86, 20);
		contentPane.add(param3Value);
		
		JLabel lblParameter_2 = new JLabel("Parameter 3");
		lblParameter_2.setBounds(35, 194, 89, 14);
		contentPane.add(lblParameter_2);
		
		JButton generateButton = new JButton("Find Players");
		generateButton.addActionListener(this);
		generateButton.setActionCommand("7");
		generateButton.setBounds(176, 285, 112, 23);
		contentPane.add(generateButton);

	}
}
