package mantenimiento;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Registro_Usuarios.Conexion;
import bean.Producto;

//logica para insertar productos en la base de datos dependiendo de las variables especificadas en la clase producto usando los metodos get
public class RegistrarProducto {

	public int registrar(Producto producto)
	{
		int rs = 0;
		
		String sql = "insert into productos values(?, ?, ?, ?, ?, ?);";
		try(PreparedStatement ps = Conexion.conectar().prepareStatement(sql))
		{
			ps.setString(1, producto.getIdProducto());
			ps.setString(2, producto.getNombreProducto());
			ps.setString(3, producto.getMarcaProducto());
			ps.setString(4, producto.getCategoriaProducto());
			ps.setDouble(5, producto.getPrecioProducto());
			ps.setInt(6, producto.getStockProducto());
			
			rs = ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
}
