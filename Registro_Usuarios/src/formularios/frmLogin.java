package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimiento.GestionUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre de Usuario:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(39, 55, 134, 46);
		contentPane.add(lblNombre);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasena.setBounds(80, 113, 78, 26);
		contentPane.add(lblContrasena);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(183, 68, 146, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingresar();
			}
		});
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(0, 128, 0));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setBounds(156, 172, 98, 31);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar();
			}
		});
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBackground(new Color(0, 0, 128));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBounds(156, 214, 98, 26);
		contentPane.add(btnRegistrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salir();
			}
		});
		btnSalir.setBackground(new Color(220, 20, 60));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalir.setBounds(356, 11, 72, 23);
		contentPane.add(btnSalir);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(183, 117, 146, 20);
		contentPane.add(txtPassword);
	}
	
	protected void Ingresar()
	{
		//Tomando los valores ingresados en la interfaz (text)
		String usuario = txtNombre.getText();
		String contraseña = String.valueOf(txtPassword.getPassword());
		GestionUsuario Gestion = new GestionUsuario();
		Usuario usux = new Usuario();
		
		//Guardando los valores 
		usux.setUserName(usuario);
		usux.setPassword(contraseña);
		
		//Verificando si los valores estan ya en la base de datos
		Usuario usu = Gestion.obtenerUsuario(usux);
		if(usu != null)
		{
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			this.dispose();
			frmOpciones opcion = new frmOpciones();
			opcion.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(contentPane, "“debe ingresar su usuario\r\n"
					+ "y contraseña, si no está registrado debe registrarse”", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	protected void Registrar()
	{
		//Llamando a formularios para registrar usuarios
		this.dispose();
		frmRegistro datos = new frmRegistro();
		datos.setVisible(true);
	}
	
	protected void Salir() {
		//Salir de la aplicacion
		System.exit(0);
	}
}
