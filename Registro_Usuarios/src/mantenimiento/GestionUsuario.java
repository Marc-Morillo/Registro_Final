package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Registro_Usuarios.Conexion;
import bean.Usuario;

//Logica para conectar o ingresar a la base de datos usando el UserName y Password
public class GestionUsuario
{
	public Usuario obtenerUsuario(Usuario usu)
	{
		Usuario usuario = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = Conexion.conectar();
			String sql = "Select * from usuarios where UserName = ? and Password = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, usu.getUserName());
			pst.setString(2, usu.getPassword());
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al obtener usuario");
		}
		return usuario;		
		
	}
}
