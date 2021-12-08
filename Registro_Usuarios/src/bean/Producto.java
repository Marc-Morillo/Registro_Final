package bean;

public class Producto {
	//variables que tendra cada producto que tambien estan en la base de datos

	private String idProducto;
	private String NombreProducto;
	private String MarcaProducto;
	private String CategoriaProducto;
	private double PrecioProducto;
	private int StockProducto;
	
	//Metodos getters y setters

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return NombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}

	public String getMarcaProducto() {
		return MarcaProducto;
	}

	public void setMarcaProducto(String marcaProducto) {
		MarcaProducto = marcaProducto;
	}

	public String getCategoriaProducto() {
		return CategoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		CategoriaProducto = categoriaProducto;
	}

	public double getPrecioProducto() {
		return PrecioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		PrecioProducto = precioProducto;
	}

	public int getStockProducto() {
		return StockProducto;
	}

	public void setStockProducto(int stockProducto) {
		StockProducto = stockProducto;
	}

}
