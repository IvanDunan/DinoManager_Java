package dinomanager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTable;

public class Table extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
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
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit MyScreen = Toolkit.getDefaultToolkit(); //Necesario para poder adaptar la ventana a la resolución de diferentes pantallas
  		Dimension ScreenSize= MyScreen.getScreenSize(); //Almacenamos el tamaño de la pantalla (Resolución) en la cual el programa se está ejecutando
  		int HeightScreen = ScreenSize.height; //Guardo en variables el alto y ancho de la pantalla
  		int WidthScreen = ScreenSize.width;
  		setBounds(WidthScreen/4, HeightScreen/4, WidthScreen/2, HeightScreen/2); // (ANCHO VENTANA, ALTO VENTANA, CORDENADA X, CORDENADA Y)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//===========
		
		
		int Size=0;
        String [] header={"Nombre","Nombre de usuario","Apellidos","Edad","Email"};
         //El
        try {
        	Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dinomanager_database3",
                    "root", "root");
        	PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select user_name from users");
        	ResultSet rs = st.executeQuery();
        	
        	while(rs.next()) {
            	Size++;
            }
        	System.out.println(Size);
        	
        }
        catch (SQLException sqlException) {
        	sqlException.printStackTrace();
        	
        }
        String [][] data= new String[Size][5]; 
        try {
        	Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dinomanager_database3",
                    "root", "root");

                PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select user_name, name, surnames, age, email from users");
                ResultSet rs = st.executeQuery();
                String userName;
                String name;
                String surnames;
                String age;
                String email;
                int linea=0;
                int columna=0;
                
                while(rs.next()) {
                	name = rs.getString("name");
                    userName = rs.getString("user_name");
                    surnames = rs.getString("surnames");
                    age = rs.getString("age");
                    email = rs.getString("email");
                    data[linea][columna]=name;
                    data[linea][columna+1]=userName;
                    data[linea][columna+2]=surnames;
                    data[linea][columna+3]=age;
                    data[linea][columna+4]=email;
                    linea++;
                	System.out.println(name+" "+userName+" "+data.length);
                }
        }
        catch(SQLException sqlException) {
        	sqlException.printStackTrace();
        };
		

        
		
		
	}
}
