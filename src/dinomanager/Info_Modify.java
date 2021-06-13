package dinomanager;

import java.awt.BorderLayout;
import model.*;
import dao.*;
import dao.mysql.*;
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Info_Modify extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JLabel lblNewLabel_1;
	private JTextField txtSurnames;
	private JLabel lblNewLabel_2;
	private JTextField txtEmail;
	private JLabel lblNewLabel_3;
	private JTextField textUser_Name;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info_Modify frame = new Info_Modify(null);
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
	public Info_Modify(User myUser) {
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
				getContentPane().setBackground(new java.awt.Color(220, 234, 236));
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setFont(new Font("Consolas", Font.BOLD, 14));
				
				JLabel lblNewLabel = new JLabel("");
				//lblNewLabel.setIcon(new ImageIcon(Info_User.class.getResource("/images/Dinosaurio_Settins_transparecia.png")));
				lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dinosaurio_Settins_transparecia.png")).getImage().getScaledInstance(470, 500, Image.SCALE_SMOOTH)));
				
				textFieldName = new JTextField();
				textFieldName.setText(myUser.getName());
				textFieldName.setColumns(10);
				
				lblNewLabel_1 = new JLabel("Apellidos:");
				lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 14));
				
				txtSurnames = new JTextField();
				txtSurnames.setText(myUser.getSurnames());
				txtSurnames.setColumns(10);
				
				lblNewLabel_2 = new JLabel("Email:");
				lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));
				
				txtEmail = new JTextField();
				txtEmail.setText(myUser.getEmail());
				txtEmail.setColumns(10);
				
				lblNewLabel_3 = new JLabel("Nombre de usuario:");
				lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD, 14));
				
				textUser_Name = new JTextField(myUser.getUser_name());
				textUser_Name.setColumns(10);
				
				JButton btnNewButton = new JButton("Sobreescribir datos de susario");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myUser.setName(textFieldName.getText());
						myUser.setSurnames(txtSurnames.getText());
						myUser.setEmail(txtEmail.getText());
						myUser.setUser_name(textUser_Name.getText());
						try {
							Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dinomanager_database3", "root", "root");
							//conn = (Connection) DriverManager.getConnection("UPDATE users SET user_name = ?, surnames = ?, name = ?, email = ? WHERE (id = ?)");
							PreparedStatement st = (PreparedStatement) conn.prepareStatement("UPDATE users SET user_name = ?, surnames = ?, name = ?, email = ? WHERE (id = ?)");
							//UserDAO dao = new MySQLUserDAO(conn);
							//dao.modify(myUser);
							
							st.setString(1, myUser.getUser_name());
							st.setString(2, myUser.getSurnames());
							st.setString(3, myUser.getName());
							st.setString(4, myUser.getEmail());
							st.setLong(5, myUser.getId());
							
							
							ResultSet rs = st.executeQuery();
							st.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				
				
				JButton btnNewButton_1 = new JButton("Volver");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						Teacher_Home obj = new Teacher_Home(myUser);
						obj.setVisible(true);
						
					}
				});
				
				lblNewLabel_4 = new JLabel("\u00A9 2021 - DinoManager");
				
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(166)
												.addComponent(btnNewButton))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(45)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
															.addComponent(lblNewLabel_3)
															.addComponent(lblNewLabel_1)
															.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
														.addGap(16))
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(textFieldName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
													.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
													.addComponent(txtSurnames)
													.addComponent(textUser_Name, Alignment.TRAILING))))
										.addContainerGap())
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnNewButton_1)
										.addGap(179)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGap(34))))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNewLabel))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(81)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addGap(30)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1)
										.addComponent(txtSurnames, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(41)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2))
									.addGap(42)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(textUser_Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(58)
									.addComponent(btnNewButton)
									.addGap(31)
									.addComponent(btnNewButton_1)
									.addGap(68)
									.addComponent(lblNewLabel_4)))
							.addContainerGap(20, Short.MAX_VALUE))
				);
				contentPane.setLayout(gl_contentPane);
				//-----------------------------
	}
}
