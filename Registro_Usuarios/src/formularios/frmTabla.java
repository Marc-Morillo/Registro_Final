package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Registro_Usuarios.Conexion;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class frmTabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTabla frame = new frmTabla();
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
	public frmTabla() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		setTitle("Tabla de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(5, 5, 428, 27);
		contentPane.add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane.setRightComponent(splitPane_1);
		
		btnEliminar = new JButton("- Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar();
			}
		});
		btnEliminar.setBackground(new Color(220, 20, 60));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane_1.setLeftComponent(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actualizar();
			}
		});
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setBackground(new Color(128, 128, 0));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane_1.setRightComponent(btnActualizar);
		
		btnNuevo = new JButton("+ Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adios1();
			}
		});
		btnNuevo.setBackground(new Color(0, 128, 0));
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane.setLeftComponent(btnNuevo);
		
		JButton btnCerrar = new JButton("Cerrar Seccion");
		btnCerrar.setBounds(5, 237, 428, 23);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opciones();
			}
		});
		btnCerrar.setBackground(new Color(0, 0, 0));
		btnCerrar.setForeground(new Color(255, 255, 255));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnCerrar);
		
		table = new JTable();
		table.setBounds(5, 32, 428, 205);
		contentPane.add(table);
	}
	
	protected void salir()
	{
		//Ir a el formularios de iniciar sesion
		this.dispose();
		frmLogin salir = new frmLogin();
		salir.setVisible(true);
	}
	
	private void ShowData()
	{
		//Mostrar todas las columna/datos en nuestra tabla usuarios
		Connection con = Conexion.conectar();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("idUser");
		model.addColumn("UserName");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Telefono");
		model.addColumn("Email");
		model.addColumn("Password");
		
		try
		{
			//consulta para llamar en Mysql y conseguir todos los datos de la tabla
			String sql = "Select * from usuarios";
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("idUser"),
						rs.getString("UserName"),
						rs.getString("Nombre"),
						rs.getString("Apellido"),
						rs.getString("Telefono"),
						rs.getString("Email"),
						rs.getString("Password"),
						
				});
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setPreferredWidth(60);
			table.getColumnModel().getColumn(3).setPreferredWidth(60);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.getColumnModel().getColumn(5).setPreferredWidth(80);
			table.getColumnModel().getColumn(6).setPreferredWidth(60);

		}
		catch(Exception e)
		{
			System.out.println("Error: "+ e);
		}
	}

	protected void Adios1()
	{
		//Ir a el formularios de para registar usuario
		this.dispose();
		frmRegistro datos = new frmRegistro();
		datos.setVisible(true);
	}
	
	public void opciones()
	{
		//Ir a el formularios con las opciones GestionUsuario o GestionProducto
		this.dispose();
		frmOpciones opcion = new frmOpciones();
		opcion.setVisible(true);
	}
	
	protected void Eliminar()
	{
		//Consiguiendo la posicion de la fila que queremos eliminar
		int fila = table.getSelectedRow();
		String valor = table.getValueAt(fila, 0).toString();
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		
		//consulta para llamar a MySQL que borrara la fila
		String sql = "Delete From usuarios Where idUser = '" + valor+"'";
		try
		{
			PreparedStatement eliminar = con.prepareStatement(sql);
			eliminar.executeUpdate();
			ShowData();
		}catch(Exception es)
		{
			JOptionPane.showMessageDialog(null, es + "No se logro generar el registro");
		}
	}
	
	protected void Actualizar()
	{
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		
		//Consiguiendo la posicion de la fila que queremos editar
		int fila = table.getSelectedRow();
		int id = Integer.parseInt((String) this.table.getValueAt(fila, 0).toString());
		String nombreUsuario = table.getValueAt(fila, 1).toString();
		String nombre = table.getValueAt(fila, 2).toString();
		String apellido = table.getValueAt(fila, 3).toString();
		String telefono = table.getValueAt(fila, 4).toString();
		String correo = table.getValueAt(fila, 5).toString();
		String contraseña = table.getValueAt(fila, 6).toString();
		
		//consulta para llamar a MySQL que editar la fila
		String sql = "Update usuarios Set UserName = '" + nombreUsuario + "', Nombre = '" + nombre + "', Apellido = '"+apellido+"', Telefono = '"+telefono+"', Email = '"+correo+"', Password = '"+contraseña+"' Where idUser = '"+id+"'";
		
		try
		{
			PreparedStatement actualizar = con.prepareStatement(sql);
			actualizar.executeUpdate();
			ShowData();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e + "No se pudieron editar los datos");
		}
	}
}
