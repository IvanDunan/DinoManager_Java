package dinomanager;

import model.User;
import dao.*;
import dao.mysql.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class Teacher_Home extends JFrame {
	

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        }
        );
    }

    /**
     * Create the frame.
     */
    public Teacher_Home(User myUser) {

    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Comportamiento del programa al cerrar ventana: El programase cierra si cerramos esta ventana
		Toolkit MyScreen = Toolkit.getDefaultToolkit(); //Necesario para poder adaptar la ventana a la resolución de diferentes pantallas
		Dimension ScreenSize= MyScreen.getScreenSize(); //Almacenamos el tamaño de la pantalla (Resolución) en la cual el programa se está ejecutando
		int HeightScreen = ScreenSize.height; //Guardo en variables el alto y ancho de la pantalla
		int WidthScreen = ScreenSize.width;
		setBounds(WidthScreen/4, HeightScreen/4, WidthScreen/2, HeightScreen/2); // (ANCHO VENTANA, ALTO VENTANA, CORDENADA X, CORDENADA Y)
		//De esta menra consigo que sea cual sea la resolución, 1080p, 4k... La ventana siempre esté centrada en la pantalla al inciar el programa.
        setResizable(false);
        Image myIcon= MyScreen.getImage("src/images/Icono64px.png");
		setIconImage(myIcon);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        getContentPane().setBackground(new java.awt.Color(220, 234, 236));
        
        JToolBar toolBar = new JToolBar();
        
        JLabel lblNewLabel = new JLabel("Opciones sobre tu cuenta");
        lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 14));
        
        JButton btnChangePassword = new JButton("Cambiar contrase\u00F1a");
        btnChangePassword.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//ChangePassword bo = new ChangePassword(userSes);
                //bo.setTitle("Change Password");
                //bo.setVisible(true);
        	}
        });
        
        JButton btnInformation = new JButton("Consultar informaci\u00F3n");
        btnInformation.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        JButton btnModify = new JButton("Modificar datos");
        btnModify.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                Info_Modify obj = new Info_Modify(myUser);
                obj.setTitle("Modificación de datos");
                obj.setVisible(true);
        	}
        });
        
        
        
        JButton btnTeacherRegisterStudent = new JButton("Registrar un alumno");
        
        JLabel lblNewLabel_1 = new JLabel("\u00A9 2021 - DinoManager");
        
        System.out.println("SE HA INICIADO SESION CORRECTAMENTE CON LOS DATOS:" + myUser);
        System.out.println();
        
        JLabel lblNewLabel_2 = new JLabel("Usuario: "+ myUser.getName()+" "+ myUser.getSurnames());
        
        JLabel lblImage = new JLabel("");
          lblImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dinosaurio_Bienvenida_transparency.png")).getImage().getScaledInstance(475, 410, Image.SCALE_SMOOTH)));
        
        JButton btnLogout = new JButton("Cerrar sesi\u00F3n");
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int a = JOptionPane.showConfirmDialog(btnLogout, "¿Estás seguro de querer cerrar sesión?");
                JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    Login obj = new Login();
                    obj.setTitle("Login");
                    obj.setVisible(true);
                }
                dispose();
        	}
        });
        
        JLabel lblNewLabel_1_1 = new JLabel("\u00A9 2021 - DinoManager");
        
        //lblImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pet1_Dinomanager_noborder.png")).getImage().getScaledInstance(470, 500, Image.SCALE_SMOOTH)));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(796)
        			.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(28)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(34)
        					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
        							.addGroup(gl_contentPane.createSequentialGroup()
        								.addComponent(btnChangePassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addPreferredGap(ComponentPlacement.RELATED))
        							.addGroup(gl_contentPane.createSequentialGroup()
        								.addComponent(btnTeacherRegisterStudent, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        								.addPreferredGap(ComponentPlacement.RELATED))
        							.addGroup(gl_contentPane.createSequentialGroup()
        								.addComponent(btnModify, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        								.addPreferredGap(ComponentPlacement.RELATED))
        							.addGroup(gl_contentPane.createSequentialGroup()
        								.addComponent(btnInformation, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        								.addPreferredGap(ComponentPlacement.RELATED))
        							.addGroup(gl_contentPane.createSequentialGroup()
        								.addComponent(lblNewLabel)
        								.addGap(22)))
        						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
        							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
        					.addGap(10))
        				.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(lblNewLabel_2)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(30)
        					.addComponent(lblNewLabel)
        					.addGap(18)
        					.addComponent(btnInformation)
        					.addGap(18)
        					.addComponent(btnModify)
        					.addGap(18)
        					.addComponent(btnTeacherRegisterStudent)
        					.addGap(18)
        					.addComponent(btnChangePassword)
        					.addGap(131)
        					.addComponent(btnLogout)
        					.addGap(47)
        					.addComponent(lblNewLabel_1_1)
        					.addGap(2574)
        					.addComponent(lblNewLabel_1))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE))))
        );
        
        JButton btnTeacherReport = new JButton("|Consultar informe de alumnos|");
        btnTeacherReport.setFont(new Font("Consolas", Font.BOLD, 14));
        btnTeacherReport.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Se ha pulsado el botón de informe");
        		
		        Table obj = new Table(myUser);
                obj.setTitle("Reporte de alumnos");
                obj.setVisible(true);
        	}
        });
        toolBar.add(btnTeacherReport);
        
        JButton btnNewButton_2 = new JButton("|Enviar mensaje conjunto|");
        btnNewButton_2.setFont(new Font("Consolas", Font.BOLD, 14));
        toolBar.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("|Generar contrase\u00F1as seguras|");
        btnNewButton_3.setFont(new Font("Consolas", Font.BOLD, 14));
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        toolBar.add(btnNewButton_3);
        contentPane.setLayout(gl_contentPane);
    }
}

