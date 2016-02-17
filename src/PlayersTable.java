import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class PlayersTable extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	public LinkedList<String[]> tableStats;

	public LinkedList<String[]> getTableStats() {
		return tableStats;
	}

	public void setTableStats(LinkedList<String[]> tableStats) {
		this.tableStats = tableStats;
	}

	/**
	 * Launch the application.
	 */
	public void openPT(LinkedList<String[]> list) {
		final LinkedList<String[]> passList = list;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayersTable frame = new PlayersTable(passList);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
//	public PlayersTable() {
		
//	}
	public PlayersTable(LinkedList<String[]> list) {
		LinkedList<String[]> players = new LinkedList<String[]>();
		players = list;
		this.tableStats = list;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 964, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		LinkedList<String[]> tablePlayers = new LinkedList<String[]>();
		for (int i = 0; i< list.size(); i++) {
			tablePlayers.add(list.get(i));
		}
		//Create TableModel
		String[] col1 = {"First", "Last", "playerID","yearID","stint","Team","lgID","G","AB","R","H","2B","3B","HR","RBI","SB","CS","BB","SO","IBB","HBP","SH","SF","GIDP","BA","SLG"};
		DefaultTableModel nrTable = new DefaultTableModel(col1,0);
		String [] tempString;
		String [] findName;
		BaseballList tableStats = new BaseballList();
		tableStats.readFile();
		int tableSize = tablePlayers.size();
		for (int i=0; i<tableSize; i++) {
			String[] workingArray = new String[26];
			findName = tableStats.findPlayer(tablePlayers.get(i)[0]);
			System.arraycopy(findName, 0, workingArray, 0, 2);
			System.arraycopy(tablePlayers.get(i), 0, workingArray, 2, 24);
			tempString = workingArray;
			
			Object[] obj = tempString;
			nrTable.addRow(obj);
		}
		contentPane.setLayout(null);
		

		
		JTable table1 = new JTable(nrTable);
		table1.setAutoCreateRowSorter(true);
		table1.removeColumn(table1.getColumnModel().getColumn(2));
		table1.removeColumn(table1.getColumnModel().getColumn(2));
		table1.removeColumn(table1.getColumnModel().getColumn(2));
		table1.removeColumn(table1.getColumnModel().getColumn(3));
		table1.getColumnModel().getColumn(0).setPreferredWidth(100);
		table1.getColumnModel().getColumn(1).setPreferredWidth(150);
		table1.setFont(new Font("Arial", Font.PLAIN, 10));
		table1.setBackground(new Color(255, 255, 255));
		JScrollPane tableContainer = new JScrollPane(table1);
		tableContainer.setBounds(10, 23, 928, 599);
		contentPane.add(tableContainer);
	}

}
