package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmOpciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmOpciones frame = new frmOpciones();
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
	public frmOpciones() {
		setTitle("Opciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarios();
			}
		});
		btnUsuarios.setForeground(new Color(255, 255, 255));
		btnUsuarios.setBackground(new Color(65, 105, 225));
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUsuarios.setBounds(45, 65, 148, 146);
		contentPane.add(btnUsuarios);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productos();
			}
		});
		btnProductos.setForeground(new Color(255, 255, 255));
		btnProductos.setBackground(new Color(106, 90, 205));
		btnProductos.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProductos.setBounds(243, 65, 148, 146);
		contentPane.add(btnProductos);
		
		JButton btnNewButton_2 = new JButton("Cerrar seccion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(146, 11, 138, 23);
		contentPane.add(btnNewButton_2);
	}
	
	protected void productos()
	{
		//Ir a la tabla/gestion de productos
		this.dispose();
		frmTablaProductos tabla = new frmTablaProductos();
		tabla.setVisible(true);
	}
	
	protected void usuarios()
	{
		//Ir a la tabla/gestion de usuarios
		this.dispose();
		frmTabla tabla = new frmTabla();
		tabla.setVisible(true);
	}
	
	protected void salir()
	{
		//Ir al formularios de iniciar sesion
		this.dispose();
		frmLogin salir = new frmLogin();
		salir.setVisible(true);
	}
	
	
}
