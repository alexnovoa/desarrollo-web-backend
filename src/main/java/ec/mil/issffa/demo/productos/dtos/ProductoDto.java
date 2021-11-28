package ec.mil.issffa.demo.productos.dtos;

import lombok.Data;


@Data
public final class ProductoDto {
    private long id;
    private String descripcion;
    private long proveedor;
    private double precio;
}
