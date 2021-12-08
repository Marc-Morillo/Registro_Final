package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Producto;
import bean.Usuario;
import mantenimiento.RegistrarUsuario;
import mantenimiento.RegistrarProducto;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmRegistroProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JComboBox cb_Categoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistroProducto frame = new frmRegistroProducto();
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
	public frmRegistroProducto() {
		setTitle("Registrar producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Producto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(164, 11, 154, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(84, 55, 78, 14);
		contentPane.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMarca.setBounds(95, 80, 63, 14);
		contentPane.add(lblMarca);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategoria.setBounds(73, 105, 73, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(95, 130, 48, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel(" Cantidad Disponible:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(10, 155, 152, 17);
		contentPane.add(lblCantidad);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(143, 53, 186, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMarca.setBounds(143, 78, 186, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		cb_Categoria = new JComboBox();
		cb_Categoria.setModel(new DefaultComboBoxModel(new String[] {"Carnes", "Lacteos", "Bebidas", "Vestimenta", "Electronicos"}));
		cb_Categoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_Categoria.setBounds(143, 102, 186, 22);
		contentPane.add(cb_Categoria);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrecio.setBounds(143, 130, 186, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad.setBounds(143, 152, 186, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registarProducto();
			}
		});
		btnGuardar.setBackground(new Color(0, 128, 0));
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(164, 186, 154, 37);
		contentPane.add(btnGuardar);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adios();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1.setBounds(164, 231, 154, 23);
		contentPane.add(btnNewButton_1);
	}
	
	protected void registarProducto()
	{
		//Consiguiendo los valores ingresados en la interfaz
		String nombre = txtNombre.getText().toString();
		String marca = txtMarca.getText().toString();
		String categoria = cb_Categoria.getSelectedItem().toString();
		double precio = Double.parseDouble(txtPrecio.getText().toString());
		int stock = Integer.parseInt(txtCantidad.getText().toString());
		
		//Guardan los valores
		Producto producto = new Producto();
		producto.setNombreProducto(nombre);
		producto.setMarcaProducto(marca);
		producto.setCategoriaProducto(categoria);
		producto.setPrecioProducto(precio);
		producto.setStockProducto(stock);
		
		//Revisando si todos los campos estan llenos
		if(txtNombre.getText().isEmpty() || txtMarca.getText().isEmpty() || cb_Categoria.getSelectedItem().toString().isEmpty() || txtPrecio.getText().isEmpty() || txtCantidad.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(contentPane, "Favor llenar todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			RegistrarProducto registro = new RegistrarProducto();
			int ok = registro.registrar(producto);
			
			if(ok > 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Producto Registrado");
				Adios();
			}
			else
			{
				JOptionPane.showMessageDialog(contentPane, "No se registro el producto", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	protected void Adios()
	{
		//Ir a el formulario que contiene la tabla productos
		this.dispose();
		frmTablaProductos nuevo = new frmTablaProductos();
		nuevo.setVisible(true);
	}
}
