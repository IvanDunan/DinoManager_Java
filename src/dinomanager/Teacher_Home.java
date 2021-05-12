package dinomanager;

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
        });
    }

    /**
     * Create the frame.
     */
    public Teacher_Home(String userSes) {

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
                //Teacher_Home obj = new Teacher_Home(userSes);

                //obj.setTitle("Student-Login");
                //obj.setVisible(true);
        	}
        });
        
        JButton btnChangePassword = new JButton("Cambiar contrase\u00F1a");
        btnChangePassword.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);
        	}
        });
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(729, Short.MAX_VALUE)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(lblNewLabel)
        				.addComponent(btnLogout, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        				.addComponent(btnChangePassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(22))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(61)
        			.addComponent(lblNewLabel)
        			.addGap(18)
        			.addComponent(btnLogout)
        			.addGap(18)
        			.addComponent(btnChangePassword)
        			.addGap(311))
        );
        
        JButton btnTeacherReport = new JButton("|Consultar informe de alumnos|");
        btnTeacherReport.setFont(new Font("Consolas", Font.BOLD, 14));
        btnTeacherReport.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Se ha pulsado el botón de informe");
		        Table obj = new Table();
                //obj.setTitle("Registro");
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

