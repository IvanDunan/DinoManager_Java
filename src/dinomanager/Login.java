package dinomanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_UserName;
	private JTextField textField_Password;
	
	private static final String QUERY = "select user_name,password from users";
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
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
		
		
		JLabel lblUserName = new JLabel("Nombre de usuario:");
		lblUserName.setFont(new Font("Consolas", Font.BOLD, 12));
		
		textField_UserName = new JTextField();
		textField_UserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setFont(new Font("Consolas", Font.BOLD, 12));
		
		textField_Password = new JPasswordField();
		textField_Password.setColumns(10);
		
		JButton btnLogin = new JButton("Iniciar sesi\u00F3n");
		btnLogin.setFont(new Font("Consolas", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField_UserName.getText(); //Guardamos en una variable el usuario introducido en el textfield de nuestra interfaz javaswing
		        String password = textField_Password.getText(); //Guardamos en una variable la contraseña introducida en el textfield de nuestra interfaz javaswing
		        
		        try {
		            final String claveEncriptacion = "secreto!"; //Clave para la encriptación AES (Sin ella nadie puede desencriptar la contraseña guardada en la base de datos).            
		            String datosOriginales = "hola";            
		             
		            AESencryptor encriptador = new AESencryptor();
		            
		             
		            String encriptado = encriptador.encriptar(password, claveEncriptacion);
		            String desencriptado = encriptador.desencriptar(encriptado, claveEncriptacion);
		             
		            
		            System.out.println("Escriptado     : " + encriptado);
		            
		            
		            password = encriptado;
		             
		        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
		            Logger.getLogger(AESencryptor.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        try {
		        	//ESTABLEZCO LA CONEXIÓN A LA BASE DE DATOS
		        	Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dinomanager_database3","root", "root"); 
		        	
		        	//CREO MI OBJETO STATEMENT Y EJECUTO LA QUERY
	                PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select user_name, password from users where user_name=? and password=?"); //Se comprueban todos los usuarios y sus contraseñas
		            
		            st.setString(1, userName);
		            st.setString(2, password);
		            
		            
		            ResultSet rs = st.executeQuery();
		            if (userName.equals("") && userName.equals("")) { //En caso de que ambos campos estén vacíos se exigirá que se rellenen.
		            	JOptionPane.showMessageDialog(btnLogin, "Por favor, introduzca algún valor en los campos.");
		            	
		            	System.out.println("Ambos campos están vacíos");
		            }
		            else if (password.equals("")) { //En caso de que el campo de la contraseña esté vacío se exigirá que se añada.
		            	JOptionPane.showMessageDialog(btnLogin, "Por favor introduzca una contraseña");
		            	System.out.println("El campo contraseña está vacío");
		            }
		            else if (userName.equals("")) { //En caso de que el campo de la contraseña esté vacío se exigirá que se añada.
		            	JOptionPane.showMessageDialog(btnLogin, "Por favor introduzca un usuario");
		            	System.out.println("El campo usuario está vacío");
		            }
		            else if (rs.next()) { //En caso de haber información en los dos campos se procederá a comprobar si es correcta
		                dispose();
		                Teacher_Home ah = new Teacher_Home(userName);
		                ah.setTitle("Bienvenido ");
		                ah.setVisible(true);
		                JOptionPane.showMessageDialog(btnLogin, "Bienvenido "+ userName +", se ha iniciado sesión correctamente");
		                System.out.println("Se ha iniciado sesión correctamente");
		            } else { //En caso de que la información no coincida con la base de datos
		                JOptionPane.showMessageDialog(btnLogin, "Contraseña o usuario incorrecto");
		            	System.out.println("Contraseña o usuario erroneos");
		            }
		        } catch (SQLException sqlException) { //Gracias a este bloque catch se cierra la conexión a la base de datos correctamente
		            sqlException.printStackTrace();
		            sqlException.getCause();
		        }
			}
		});
		
		JButton btnRegister = new JButton("Registrarse");
		btnRegister.setFont(new Font("Consolas", Font.BOLD, 14));
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        System.out.println("Se ha pulsado el botón de registro");
		        Register obj = new Register();
                obj.setTitle("Registro");
                obj.setVisible(true);
			}
		});
		
		JLabel lblImage = new JLabel("");
		//lblImage.setIcon(new ImageIcon(Login.class.getResource("/images/Icono64px.png")));
		lblImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pet1_Dinomanager_noborder.png")).getImage().getScaledInstance(470, 500, Image.SCALE_SMOOTH)));
		
		JLabel lblImageLogo = new JLabel("");
		lblImageLogo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_transparencia.png")).getImage().getScaledInstance(350, 100, Image.SCALE_SMOOTH)));
		
		JLabel lblNewLabel = new JLabel("\u00BFHas olvidado tu contrase\u00F1a?");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("Recuperar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se ha pulsado el botón de recuperación de contraseña");
		        PasswordRecover obj = new PasswordRecover();
                obj.setTitle("Registro");
                obj.setVisible(true);
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u00A9 2021 - DinoManager");
		 
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImage)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUserName)
										.addComponent(lblPassword))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_Password, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
										.addComponent(btnLogin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
										.addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
										.addComponent(textField_UserName, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
									.addGap(158))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblImageLogo, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(btnNewButton)))
							.addGap(156))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImage)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(lblImageLogo)
							.addGap(66)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUserName)
								.addComponent(textField_UserName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_Password, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword))
							.addGap(36)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		 
	}
}
