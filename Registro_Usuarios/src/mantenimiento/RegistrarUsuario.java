package mantenimiento;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Registro_Usuarios.Conexion;
import bean.Usuario;
//logica para insertar usuarios en la base de datos dependiendo de las variables especificadas en la clase producto usando los metodos get

public class RegistrarUsuario {
	
	public int registrar(Usuario usuario)
	{
		int rs = 0;
		
		String sql = "insert into usuarios values(?, ?, ?, ?, ?, ?, ?);";
		try(PreparedStatement ps = Conexion.conectar().prepareStatement(sql))
		{
			ps.setString(1, usuario.getIdUser());
			ps.setString(2, usuario.getUserName());
			ps.setString(3, usuario.getNombre());
			ps.setString(4, usuario.getApellido());
			ps.setString(5, usuario.getTelefono());
			ps.setString(6, usuario.getEmail());
			ps.setString(7, usuario.getPassword());
			
			rs = ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
}

