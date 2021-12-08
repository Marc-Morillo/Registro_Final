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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class frmEditarProducto extends JFrame {
	JTextField txtMarca;
	JTextField txtPrecio;
	JTextField txtCantidad;
	JTextField txtNombre;
	JPanel contentPane;
	JTextField txtCategoria;
	 JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEditarProducto frame = new frmEditarProducto();
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
	public frmEditarProducto() {
		setTitle("Editar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Editar Producto:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(176, 11, 128, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(103, 56, 89, 14);
		contentPane.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMarca.setBounds(115, 81, 89, 14);
		contentPane.add(lblMarca);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategoria.setBounds(90, 106, 89, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(115, 135, 89, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad disponible:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(30, 160, 135, 14);
		contentPane.add(lblCantidad);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(165, 54, 163, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMarca.setBounds(165, 79, 163, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrecio.setBounds(165, 133, 163, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad.setBounds(165, 158, 163, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actualizar();
			}
		});
		btnActualizar.setBackground(new Color(128, 128, 0));
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnActualizar.setBounds(186, 189, 128, 35);
		contentPane.add(btnActualizar);
		
		JButton btnBorrar = new JButton("- Eliminar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar();
			}
		});
		btnBorrar.setBackground(new Color(220, 20, 60));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrar.setBounds(187, 231, 127, 23);
		contentPane.add(btnBorrar);
		
		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCategoria.setBounds(165, 106, 163, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblid = new JLabel("idProducto");
		lblid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblid.setBounds(62, 35, 117, 14);
		contentPane.add(lblid);
		
		txtId = new JTextField();
		txtId.setBounds(165, 33, 163, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
	}
	protected void Eliminar()
	{
		frmTablaProductos producto = new frmTablaProductos();
	
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		//consulta para llamar en MySQL usando el idUser guardado para borrar la fila
		String sql = "Delete From productos Where idProducto = '" +txtId.getText()+"'";
		try
		{
			PreparedStatement eliminar = con.prepareStatement(sql);
			eliminar.executeUpdate();
			Adios();
		}catch(Exception es)
		{
			JOptionPane.showMessageDialog(null, es + "No se logro eliminar el registro");
		}
	}
	
	protected void Actualizar()
	{
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		frmTablaProductos prod = new frmTablaProductos();
		
		//consulta para llamar en MySQL usando el idUser y los demas datos guardados para editar la fila
        String sql = "Update productos Set NombreProducto = '" + txtNombre.getText().toString() + "', MarcaProducto = '" + txtMarca.getText() + "', CategoriaProducto = '"+txtCategoria.getText()+"', PrecioProducto = '"+txtPrecio.getText()+"', StockProducto = '"+txtCantidad.getText()+"'Where idProducto = '"+txtId.getText()+"'";
   		
   		try
   		{
   			PreparedStatement actualizar = con.prepareStatement(sql);
   			actualizar.executeUpdate();
   			prod.ShowData();
   			Adios();
   			
   		}
   		catch(Exception ex)
   		{
   			JOptionPane.showMessageDialog(null, ex + "No se pudieron editar los datos");
   		}
		
	}
	
	protected void Adios()
	{
		//Ir a el formularios que contiene la tabla con los productos
		this.dispose();
		frmTablaProductos producto = new frmTablaProductos();
		producto.setVisible(true);
	}
}
