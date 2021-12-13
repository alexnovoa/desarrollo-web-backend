package ec.mil.issffa.demo.productos.mappers;

import ec.mil.issffa.demo.productos.dtos.ProductoDto;
import ec.mil.issffa.demo.productos.models.Producto;
import ec.mil.issffa.demo.proveedores.models.Proveedor;
import org.springframework.stereotype.Component;

@Component
public final class ProductoMapper {

    public Producto convetToEntity(ProductoDto productoDto){
        Producto producto = new Producto();
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        Proveedor proveedor = new Proveedor();
        producto.setId(productoDto.getProveedor());
        producto.setProveedor(proveedor);
        return producto;
    }

    public ProductoDto convetToDto(Producto producto){
        ProductoDto productoDto = new ProductoDto();
        productoDto.setDescripcion(producto.getDescripcion());
        productoDto.setPrecio(producto.getPrecio());
        productoDto.setProveedor(producto.getProveedor().getId());
        return productoDto;
    }
}
