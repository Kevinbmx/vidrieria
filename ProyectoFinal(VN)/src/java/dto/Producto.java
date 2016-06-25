package dto;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class Producto{

	private int productoId;
	private String nombre;
	private String descripcion;
	private double precio;
	private int categoriaId;
	private String imagen;

	public Producto(){
		;
	}

	public void setProductoId(int productoId){
		this.productoId = productoId;
	}

	public int getProductoId(){
		return this.productoId;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

	public String getDescripcion(){
		return this.descripcion;
	}

	public void setPrecio(double precio){
		this.precio = precio;
	}

	public double getPrecio(){
		return this.precio;
	}

	public void setCategoriaId(int categoriaId){
		this.categoriaId = categoriaId;
	}

	public int getCategoriaId(){
		return this.categoriaId;
	}

	public void setImagen(String imagen){
		this.imagen = imagen;
	}

	public String getImagen(){
		return this.imagen;
	}

}

