package dto;

import java.util.ArrayList;
import java.util.List;

public class ContenedorPedido {

    private Pedido pedido;
    private List<DetallePedido> detalle;

    public ContenedorPedido() {
        detalle = new ArrayList<>();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<DetallePedido> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetallePedido> detalle) {
        this.detalle = detalle;
    }

}
