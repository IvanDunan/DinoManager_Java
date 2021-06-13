package dinomanager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.User;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class Table extends JFrame  {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table(null);
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
	public Table(User myUser) {
		//PROPIEDADES DE ESTE JFRAME:
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Comportamiento del programa al cerrar ventana: El programase cierra si cerramos esta ventana
			Toolkit MyScreen = Toolkit.getDefaultToolkit(); //Necesario para poder adaptar la ventana a la resolución de diferentes pantallas
			Dimension ScreenSize= MyScreen.getScreenSize(); //Almacenamos el tamaño de la pantalla (Resolución) en la cual el programa se está ejecutando
			int HeightScreen = ScreenSize.height; //Guardo en variables el alto y ancho de la pantalla
			int WidthScreen = ScreenSize.width;
			setBounds(WidthScreen/4, HeightScreen/4, WidthScreen/2, HeightScreen/2); // (ANCHO VENTANA, ALTO VENTANA, CORDENADA X, CORDENADA Y)
			//De esta menra consigo que sea cual sea la resolución, 1080p, 4k... La ventana siempre esté centrada en la pantalla al inciar el programa.
			setTitle("DinoManager Login"); //Titulo de mi ventana
			Image myIcon= MyScreen.getImage("src/images/Icono64px.png");//Icono de mi ventana
			setIconImage(myIcon);
			setResizable(false);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			getContentPane().setBackground(new java.awt.Color(220, 234, 236)); //COLOR DE FONDO DEL PANEL
			//-----------------------------
			System.out.println("SE HA INICIADO SESION CORRECTAMENTE CON LOS DATOS:" + myUser);
			try {
				Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dinomanager_database3", "root", "root");
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		JTable jt;
		int Size = 0;
		String[] header = { "Nombre", "Nombre de usuario", "Apellidos", "Edad", "Email" };
		// El
		try {
			Connection connection = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/dinomanager_database3", "root", "root");
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select user_name from users where id_institution=? and id_type=2 and id_subject=?");
			int institution = (int) myUser.getId_institution();
			int subject = (int) myUser.getId_subject();
			st.setInt(1, institution);
			st.setInt(2, subject);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Size++;
			}
			System.out.println(Size);
			
			st.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();

		}
		String[][] data = new String[Size][5];
		try {
			Connection connection = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/dinomanager_database3", "root", "root");

			PreparedStatement st = (PreparedStatement) connection
					.prepareStatement("SELECT user_name, name, surnames, age, email from users WHERE id_institution=? and id_type=2 and id_subject=?");
			int institution = (int) myUser.getId_institution();
			int subject = (int) myUser.getId_subject();
			st.setInt(1, institution);
			st.setInt(2, subject);
			System.out.println("Institucion a la que pertenece: "+ institution);
			System.out.println("Asignatura a la que pertenece: "+ subject);
			ResultSet rs = st.executeQuery();
			String userName;
			String name;
			String surnames;
			String age;
			String email;
			int linea = 0;
			int columna = 0;
			
			

			while (rs.next()) {
				name = rs.getString("name");
				userName = rs.getString("user_name");
				surnames = rs.getString("surnames");
				age = rs.getString("age");
				email = rs.getString("email");
				data[linea][columna] = name;
				data[linea][columna + 1] = userName;
				data[linea][columna + 2] = surnames;
				data[linea][columna + 3] = age;
				data[linea][columna + 4] = email;
				linea++;
				// System.out.println(nombre+" "+nombreUsuario+" "+data.length);
			}
			
			st.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		;

		DefaultTableModel model = new DefaultTableModel(data, header);

		JTable table_Teacher = new JTable(model);

		table_Teacher.setPreferredScrollableViewportSize(new Dimension(750, 350));
		table_Teacher.setFillsViewportHeight(true);

		JScrollPane js = new JScrollPane(table_Teacher);
		js.setVisible(true);

		JButton btnPrint = new JButton("Imprimir/Descargar");
		btnPrint.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JButton btnBack = new JButton("Volver a inicio");
		
		JLabel lblInfoTeacher = new JLabel("Profesor: "+ myUser.getName()+" "+ myUser.getSurnames());
		lblInfoTeacher.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblInfoSubject = new JLabel("Asignatura: ");
		lblInfoSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero de alumnos: "+ data.length);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u00A9 2021 - DinoManager");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblInfoTeacher, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
									.addGap(193))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblInfoSubject)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPrint, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
						.addComponent(js, GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(js, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(lblInfoTeacher, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPrint)
						.addComponent(lblInfoSubject, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1_1)
					.addGap(39))
		);
		contentPane.setLayout(gl_contentPane);

		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					table_Teacher.print();
				} catch (Exception e2) {

				}
			}
		});

	}
}
