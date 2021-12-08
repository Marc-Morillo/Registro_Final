package Registro_Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Esta es la conexion a la base de datos
public class Conexion {
	private static final String controlador = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://db4free.net:3306/almacenitlafinal";
	private static final String usuario = "estuditlafinal";
	private static final String clave = "itla123.";
	
	static
	{
		try
		{
			Class.forName(controlador);	
		} catch (ClassNotFoundException e)
		{
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
		
	}
	
	public static Connection conectar(){
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Conexion, ok!");
			}
			catch(SQLException e) {
				System.out.println("Error en la conexion");
				e.printStackTrace();
			}
		return conexion;
	}
}
