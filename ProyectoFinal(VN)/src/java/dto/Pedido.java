package dto;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class Pedido{

	private int pedidoId;
	private int usuarioId;
	private String fecha;
	private double total;

	public Pedido(){
		;
	}

	public void setPedidoId(int pedidoId){
		this.pedidoId = pedidoId;
	}

	public int getPedidoId(){
		return this.pedidoId;
	}

	public void setUsuarioId(int usuarioId){
		this.usuarioId = usuarioId;
	}

	public int getUsuarioId(){
		return this.usuarioId;
	}

	public void setFecha(String fecha){
		this.fecha = fecha;
	}

	public String getFecha(){
		return this.fecha;
	}

	public void setTotal(double total){
		this.total = total;
	}

	public double getTotal(){
		return this.total;
	}

}

