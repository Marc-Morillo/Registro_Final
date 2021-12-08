package bean;

//variables que tendra cada usuario que tambien estan en la base de datos
public class Usuario {
	private String idUser;
	private String UserName;
	private String Nombre;
	private String Apellido; 
	private String Telefono;
	private String Email;
	private String Password;
	
	//Constructor por defecto
	public Usuario(String idUser, String username, String nombre, String apellido, String telefono, String email,
			String password) {
		this.idUser = idUser;
		UserName = username;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		Email = email;
		Password = password;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	//Metodos getters y setters
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String username) {
		UserName = username;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}
