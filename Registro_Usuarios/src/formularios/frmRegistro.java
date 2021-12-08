package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimiento.RegistrarUsuario;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JPasswordField txtPassword;
	private JPasswordField txtConPassword;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistro frame = new frmRegistro();
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
	public frmRegistro() {
		setTitle("Registrar usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registrar Usuario:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(141, 11, 153, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de Usuario:");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreUsuario.setBounds(10, 48, 133, 14);
		contentPane.add(lblNombreUsuario);
		
		txtNomUsuario = new JTextField();
		txtNomUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNomUsuario.setBounds(141, 46, 143, 20);
		contentPane.add(txtNomUsuario);
		txtNomUsuario.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(72, 73, 59, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(141, 73, 143, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtApellido.setBounds(141, 104, 143, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTelefono.setBounds(141, 135, 143, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCorreo.setBounds(141, 167, 143, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guardar();
			}
		});
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(0, 128, 0));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(322, 106, 89, 79);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adios();
			}
		});
		btnCancelar.setBackground(new Color(220, 20, 60));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(322, 196, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(72, 106, 59, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(72, 137, 71, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCorreo.setBounds(72, 170, 48, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblContrasena = new JLabel("Clave:");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasena.setBounds(83, 199, 48, 14);
		contentPane.add(lblContrasena);
		
		JLabel lblConContrasena = new JLabel("Confirmar clave:");
		lblConContrasena.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConContrasena.setBounds(22, 221, 109, 34);
		contentPane.add(lblConContrasena);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(141, 198, 143, 20);
		contentPane.add(txtPassword);
		
		txtConPassword = new JPasswordField();
		txtConPassword.setBounds(141, 229, 143, 20);
		contentPane.add(txtConPassword);
	}
	protected void Guardar()
	{
		//Consiguiendo los valores ingresados en la interfaz
		String nombreUsuario = txtNomUsuario.getText().toString();
		String nombre = txtNombre.getText().toString();
		String apellido = txtApellido.getText().toString();
		String telefono = txtTelefono.getText().toString();
		String correo = txtCorreo.getText().toString();
		String contraseña = String.valueOf(txtPassword.getPassword());
		String concontraseña = String.valueOf(txtConPassword.getPassword());
		
		//Guardan los valores
		Usuario usuario = new Usuario();
		usuario.setUserName(nombreUsuario);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setTelefono(telefono);
		usuario.setEmail(correo);
		usuario.setPassword(contraseña);
		
		//Revisando si todos los campos estan llenos
		if(txtNomUsuario.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() || String.valueOf(txtPassword.getPassword()).isEmpty() || String.valueOf(txtConPassword.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Favor no dejar campos vacios");
		}
		else {
		
			//Revisando si los campos contraseña y confirmar contraseña son iguales
		if(contraseña.equals(concontraseña))
		{
			RegistrarUsuario registro = new RegistrarUsuario();
			int ok = registro.registrar(usuario);
			
			if(ok > 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Usuario Registrado");
				Adios();
			}
			else
			{
				JOptionPane.showMessageDialog(contentPane, "No se registro el usuario", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(contentPane, "Contraseñas diferentes", "Error", JOptionPane.ERROR_MESSAGE);
			Adios1();
		}
		}
	}
	
	protected void Adios()
	{
		//Ir a el formularios de iniciar sesion
		this.dispose();
		frmLogin log = new frmLogin();
		log.setVisible(true);
	}
	
	protected void Adios1()
	{
		this.dispose();
		//Ir al formulacion para registrar
		frmRegistro datos = new frmRegistro();
		datos.setVisible(true);
	}
}
