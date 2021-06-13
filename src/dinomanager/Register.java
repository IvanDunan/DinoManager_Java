package dinomanager;

import model.User;
import dao.UserDAO;
import dao.mysql.MySQLUserDAO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Surnames;
	private JTextField textField_UserName;
	private JTextField textField_Age;
	private JLabel lblSex;
	private JTextField textField_Email;
	private JTextField textField_Institution;
	private JTextField textField_Signature;
	private JLabel lblImage2;
	private JButton btnRegisterTeacher;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		// PROPIEDADES DE ESTE JFRAME:
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Comportamiento del programa al cerrar ventana: El
															// programase cierra si cerramos esta ventana
		Toolkit MyScreen = Toolkit.getDefaultToolkit(); // Necesario para poder adaptar la ventana a la resolución de
														// diferentes pantallas
		Dimension ScreenSize = MyScreen.getScreenSize(); // Almacenamos el tamaño de la pantalla (Resolución) en la cual
															// el programa se está ejecutando
		int HeightScreen = ScreenSize.height; // Guardo en variables el alto y ancho de la pantalla
		int WidthScreen = ScreenSize.width;
		setBounds(WidthScreen / 4, HeightScreen / 4, WidthScreen / 2, HeightScreen / 2); // (ANCHO VENTANA,
																										// ALTO VENTANA,
																										// CORDENADA X,
																										// CORDENADA Y)
		// De esta menra consigo que sea cual sea la resolución, 1080p, 4k... La ventana
		// siempre esté centrada en la pantalla al inciar el programa.
		setTitle("DinoManager Login"); // Titulo de mi ventana
		Image myIcon = MyScreen.getImage("src/images/Icono64px.png");// Icono de mi ventana
		setIconImage(myIcon);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new java.awt.Color(220, 234, 236)); // COLOR DE FONDO DEL PANEL
		// -----------------------------

		JLabel lblName = new JLabel("Nombre:");
		lblName.setFont(new Font("Consolas", Font.BOLD, 14));

		textField_Name = new JTextField();
		textField_Name.setColumns(10);

		JLabel lblSurnames = new JLabel("Apellidos:");
		lblSurnames.setFont(new Font("Consolas", Font.BOLD, 14));

		textField_Surnames = new JTextField();
		textField_Surnames.setColumns(10);

		JLabel lblUserName = new JLabel("Nombre de usuario:");
		lblUserName.setFont(new Font("Consolas", Font.BOLD, 14));

		textField_UserName = new JTextField();
		textField_UserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);

		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setFont(new Font("Consolas", Font.BOLD, 14));

		JLabel lblAge = new JLabel("Edad:");
		lblAge.setFont(new Font("Consolas", Font.BOLD, 14));

		textField_Age = new JTextField();
		textField_Age.setColumns(10);

		lblSex = new JLabel("Sexo:");
		lblSex.setFont(new Font("Consolas", Font.BOLD, 14));

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Consolas", Font.BOLD, 14));

		textField_Email = new JTextField();
		textField_Email.setColumns(10);

		textField_Institution = new JTextField();
		textField_Institution.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Centro:");
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 14));

		textField_Signature = new JTextField();
		textField_Signature.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Asignatura:");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 14));

		JCheckBox chckbxTeacher = new JCheckBox("Profesor");

		JCheckBox chckbxStudent = new JCheckBox("Alumno");
		
		JCheckBox chckbxMale = new JCheckBox("Hombre");
		
		JCheckBox chckbxFemale = new JCheckBox("Mujer");
		
		if (chckbxTeacher.isSelected()) {
			chckbxStudent.setEnabled(false);
		}
		if (chckbxStudent.isSelected()) {
			chckbxTeacher.setEnabled(false);
		}
		
		if (chckbxMale.isSelected()) {
			chckbxFemale.setEnabled(false);
		}
		
		if (chckbxFemale.isSelected()) {
			chckbxMale.setEnabled(false);
		}
		
		/**
		 * while (chckbxTeacher.isSelected()) { chckbxStudent.setSelected(false); }
		 **/

		JLabel lblNewLabel_3 = new JLabel("Rol:");
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD, 14));

		lblImage2 = new JLabel("");
		lblImage2.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DinoManager2_voltered.png"))
						.getImage().getScaledInstance(450, 460, Image.SCALE_SMOOTH)));

		btnRegisterTeacher = new JButton("Registrar");
		
		
		
		btnRegisterTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Recogemos todos los datos de nuestros textfield
				
				String Name = textField_Name.getText();
				String Surnames = textField_Surnames.getText();
				String UserName = textField_UserName.getText();
				String Password = passwordField.getText();
				String Age = textField_Age.getText();
				int AgeInteger=0;
				boolean isNumeric =  Age.matches("[+-]?\\d*(\\.\\d+)?");
				try {
					//System.out.println(isNumeric(Age));
					
					AgeInteger = Integer.parseInt(Age);
					
				}
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(btnRegisterTeacher, "La edad debe intoducirse en valores numéricos");
		        }
				
				
				String Email = textField_Email.getText();
				String Institution = textField_Institution.getText();
				String Signature = textField_Signature.getText();
				String Sex = "f";
				int UserType=1;
				
				if(chckbxTeacher.isSelected()) //Compruebo si el checkbox del profesor está marcado
				{
					UserType=1;
				}
				else if (chckbxStudent.isSelected()) //Si ese usuario no es profesor entoces es alumno
				{
					UserType=2;
				}
				
				if(chckbxMale.isSelected()) //Compruebo si el checkbox del profesor está marcado
				{
					Sex="m";
				}
				else if (chckbxFemale.isSelected()) //Si ese usuario no es profesor entoces es alumno
				{
					Sex="f";
				}
				
				try {
		            final String claveEncriptacion = "secreto!";            
		            String datosOriginales = Password;            
		             
		            AESencryptor encriptador = new AESencryptor();
		            
		            
		             
		            String encriptado = encriptador.encriptar(datosOriginales, claveEncriptacion);
		            String desencriptado = encriptador.desencriptar(encriptado, claveEncriptacion);
		            
		            Password = encriptado;
		             
		        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
		            Logger.getLogger(AESencryptor.class.getName()).log(Level.SEVERE, null, ex);
		        }
				
				if ((Name.equals(""))||(Surnames.equals(""))||(UserName.equals(""))||(Password.equals(""))
						||(Age.equals(""))||(Email.equals(""))) {// EN CASO DE ALGÚN CAMPO VACÍO
					JOptionPane.showMessageDialog(btnRegisterTeacher, "Por favor, rellene todos los campos");
					System.out.println("No se han rellenado todos los datos para el registro.");
				}
				else if (Age.length() > 2) { //EN CASO DE EDAD INCORRECTA
					JOptionPane.showMessageDialog(btnRegisterTeacher, "Por favor, introduce una edad correcta");
				}
				else {
					try {
						Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dinomanager_database3", "root", "root");
						UserDAO dao = new MySQLUserDAO(conn);
						User myUser = new User(0,UserName,Password,Name,Surnames,Sex,AgeInteger,Email,1,UserType,1);
						System.out.println("Contraseña cifrada correctamente: "+Password);
						dao.insert(myUser);
						System.out.println(myUser);
						
						JOptionPane.showMessageDialog(btnRegisterTeacher,"Bienvenido, " + Name + " tu cuanta ha sido creada correctamente");
						Teacher_Home ah = new Teacher_Home(myUser);
						
		                ah.setTitle("Bienvenido: "+ myUser.getName() + " "+ myUser.getSurnames());
		                ah.setVisible(true);
		                dispose();
						//EmailSenderService m=new EmailSenderService("config/configuracion.prop");
						
						conn.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
		}}
			);
		btnRegisterTeacher.setFont(new Font("Consolas", Font.BOLD, 14));

		lblNewLabel = new JLabel("\u00A9 2021 - DinoManager");
		
		JButton btnBack = new JButton("\u2190 Volver al login");
		btnBack.setBackground(SystemColor.activeCaptionBorder);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login obj = new Login();
				obj.setTitle("Login");
				obj.setVisible(true);
                
                
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("\u00BFYa est\u00E1s registrado?");
		lblNewLabel_4.setForeground(Color.RED);
		

		
		
		
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblName)
								.addComponent(lblSurnames)
								.addComponent(lblPassword)
								.addComponent(lblAge)
								.addComponent(lblSex)
								.addComponent(lblEmail)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblUserName)
								.addComponent(lblNewLabel_4))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBack))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(31)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(chckbxMale)
											.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
											.addComponent(chckbxFemale, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addComponent(chckbxTeacher)
											.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
											.addComponent(chckbxStudent, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField_Signature, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addComponent(textField_Institution, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addComponent(textField_Email, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addComponent(textField_Age, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addComponent(textField_UserName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addComponent(textField_Name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addComponent(textField_Surnames, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRegisterTeacher, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(lblImage2, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(862, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblImage2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 503, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBack)
								.addComponent(lblNewLabel_4))
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(textField_Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSurnames)
								.addComponent(textField_Surnames, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUserName)
								.addComponent(textField_UserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(passwordField, 0, 0, Short.MAX_VALUE)
								.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAge)
								.addComponent(textField_Age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSex)
								.addComponent(chckbxMale)
								.addComponent(chckbxFemale))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(textField_Institution, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_Signature, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(chckbxTeacher)
									.addComponent(chckbxStudent)))
							.addGap(28)
							.addComponent(btnRegisterTeacher, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(16))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
