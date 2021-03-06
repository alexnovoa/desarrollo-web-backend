package ec.mil.issffa.demo.pedido.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ec.mil.issffa.demo.productos.models.Producto;
import lombok.Data;

@Entity
@Data
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "pedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;
    private int cantidad;
    private double precio;
}
