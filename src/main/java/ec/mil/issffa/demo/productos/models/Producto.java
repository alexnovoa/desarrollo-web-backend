package ec.mil.issffa.demo.productos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ec.mil.issffa.demo.proveedores.models.Proveedor;
import lombok.Data;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "proveedor")
    private Proveedor proveedor;
    private double precio;
}
