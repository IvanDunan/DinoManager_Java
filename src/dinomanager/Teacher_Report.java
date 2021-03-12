package dinomanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

public class Teacher_Report extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private String [] header= {"Columna 1", "Columna 2", "Columna 3"};
	private Object [] [] data={
		
		{"puesto 1,1","Puesto 1.2","Puesto 1.3"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"},
		{"puesto 2.1","Puesto 2.2","Puesto 3.1"}
		
	};
	private JTable table_1;
	
	//Jtable dateTable= new Jtable (rowData,columnName);
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_Report frame = new Teacher_Report();
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
	public Teacher_Report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		DefaultTableModel model = new DefaultTableModel(data,header);

        JTable table = new JTable(model);
		//add(new JScrollPane(table_1), BorderLayout.CENTER);
		
		contentPane.add(table_1);
	}
}
