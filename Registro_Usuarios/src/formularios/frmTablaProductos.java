package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Registro_Usuarios.Conexion;

import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmTablaProductos extends JFrame {

	private JPanel contentPane;
	JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTablaProductos frame = new frmTablaProductos();
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
	public frmTablaProductos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		setTitle("Tabla de Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
				
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 mostrar();
			}
		});
		contentPane.add(table, BorderLayout.CENTER);
		
		JButton btnCerrar = new JButton("Cerrar Seccion");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opciones();
			}
		});
		btnCerrar.setForeground(new Color(255, 255, 255));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.setBackground(new Color(0, 0, 0));
		contentPane.add(btnCerrar, BorderLayout.SOUTH);
		
		JButton btnNuevo = new JButton("+ Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuevo();
			}
		});
		btnNuevo.setBackground(new Color(0, 128, 0));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNuevo, BorderLayout.NORTH);
	}
	
	public void opciones()
	{
		//Ir a el formularios con las opciones GestionUsuario o GestionProducto
		this.dispose();
		frmOpciones opcion = new frmOpciones();
		opcion.setVisible(true);
	}
	
	protected void Nuevo()
	{
		//Ir a el formularios de para registar usuario
		this.dispose();
		frmRegistroProducto registro = new frmRegistroProducto();
		registro.setVisible(true);
	}
	
	void ShowData()
	{
		//Mostrar todas las columna/datos en nuestra tabla productos
		Connection con = Conexion.conectar();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("idProducto");
		model.addColumn("NombreProducto");
		model.addColumn("MarcaProducto");
		model.addColumn("CategoriaProducto");
		model.addColumn("PrecioProducto");
		model.addColumn("StockProducto");
		
		try
		{
			//consulta para llamar en Mysql y conseguir todos los datos de la tabla
			String sql = "Select * from productos";
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("idProducto"),
						rs.getString("NombreProducto"),
						rs.getString("MarcaProducto"),
						rs.getString("CategoriaProducto"),
						rs.getString("PrecioProducto"),
						rs.getString("StockProducto"),
						
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

		}
		catch(Exception e)
		{
			System.out.println("Error: "+ e);
		}
	}
	
	protected void mostrar()
	{
		frmEditarProducto editar = new frmEditarProducto();
		
		//Conseguir los datos almacenados en las variables de la tabla

		int index = table.getSelectedRow();
		TableModel model = table.getModel();
		String idProducto = model.getValueAt(index, 0).toString();
		String Nombre = model.getValueAt(index, 1).toString();
		String Marca = model.getValueAt(index, 2).toString();
		String Categoria = model.getValueAt(index, 3).toString();
		String Precio = model.getValueAt(index, 4).toString();
		String Stock = model.getValueAt(index, 5).toString();
		
		//Mostrar formulario con los datos guardados arriba
		editar.setVisible(true);
		editar.setBounds(5, 32, 428, 300);
		editar.setLocationRelativeTo(null);
		editar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		editar.txtId.setText(idProducto);
		editar.txtNombre.setText(Nombre);
		editar.txtMarca.setText(Marca);
		editar.txtCategoria.setText(Categoria);
		editar.txtPrecio.setText(Precio);
		editar.txtCantidad.setText(Stock);
	}
	
}
