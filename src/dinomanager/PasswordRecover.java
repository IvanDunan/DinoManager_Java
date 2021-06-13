package dinomanager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class PasswordRecover extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordRecover frame = new PasswordRecover();
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
	public PasswordRecover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new java.awt.Color(220, 234, 236));
		Toolkit MyScreen = Toolkit.getDefaultToolkit(); //Necesario para poder adaptar la ventana a la resolución de diferentes pantallas
		Dimension ScreenSize= MyScreen.getScreenSize(); //Almacenamos el tamaño de la pantalla (Resolución) en la cual el programa se está ejecutando
		int HeightScreen = ScreenSize.height; //Guardo en variables el alto y ancho de la pantalla
		int WidthScreen = ScreenSize.width;
		setBounds(WidthScreen/4, HeightScreen/4, WidthScreen/2, HeightScreen/2);
		
		JLabel lblNewLabel = new JLabel("Correo: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		
		//JLabel lblImage = new JLabel("");
		//lblImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png")).getImage().getScaledInstance(470, 500, Image.SCALE_SMOOTH)));
		
		JButton btnNewButton = new JButton("Enviar email");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ACCION BOTÓN ENVIAR
				
				//propiedades para la conexión a nuestra cuenta
				try {
				Properties props = new Properties();
				props.setProperty("mail.smtp.host", "smtp.gmail.com");
				props.setProperty("mail.smtp.starttls.enable", "true");
				props.setProperty("mail.smtp.port", "587");
				props.setProperty("mail.smtp.auth", "true");
				
				Session session = Session.getDefaultInstance(props);
				
				String correoRemitente = "dinomanager.emails@gmail.com";
				String passwordRemitente = "Dinomanager0317014";
				String correoReceptor = txtCorreo.getText();
				String asunto = "HOLAAAAA";
				String mensaje = "Este es un correo de prueba :D";
				
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(correoRemitente));
				
				message.addRecipient(Message.RecipientType.TO, new InternetAddress (correoRemitente));
				message.setSubject(asunto);
				message.setText(mensaje);
				
				Transport t = session.getTransport("smtp");
				t.connect(correoRemitente, passwordRemitente);
				t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
				t.close();
				
				JOptionPane.showMessageDialog(null, "Correo electrónico enviado");
				
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Si ha olvidado su contrase\u00F1a escribanos su email aqu\u00ED, en caso de ser correcta recivir\u00E1 su contrase\u00F1a via mail.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("");
		//lblNewLabel_2.setIcon(new ImageIcon(PasswordRecover.class.getResource("/images/Settings_transparencia.png")));
		lblNewLabel_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Settings_transparencia.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u00A9 2021 - DinoManager");
		
		JButton btnNewButton_1 = new JButton("\u2190 Volver al login");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		
		//JLabel lblImage = new JLabel("");
				//lblImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Settings_transparencia.png")).getImage().getScaledInstance(470, 500, Image.SCALE_SMOOTH)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(59)
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
											.addGap(28)
											.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(189)
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
											.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
											.addGap(39)))))))
					.addGap(92))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(146)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1)))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

