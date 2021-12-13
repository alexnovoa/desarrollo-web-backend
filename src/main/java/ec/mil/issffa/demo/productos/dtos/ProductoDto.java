package ec.mil.issffa.demo.productos.dtos;

import ec.mil.issffa.demo.proveedores.models.Proveedor;
import lombok.Data;


@Data
public final class ProductoDto {
    private long id;
    private String descripcion;
    private long proveedor;
    private double precio;
}
