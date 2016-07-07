package dto;

public class DetallePedido {

    private int pedidoId;
    private int productoId;
    private int cantidad;
    private double precio;
    private double subtotal;

    public DetallePedido() {
        ;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getPedidoId() {
        return this.pedidoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getProductoId() {
        return this.productoId;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return this.subtotal;
    }

}
