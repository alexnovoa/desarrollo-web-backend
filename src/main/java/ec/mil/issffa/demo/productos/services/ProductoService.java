package ec.mil.issffa.demo.productos.services;

import ec.mil.issffa.demo.productos.dtos.ProductoDto;
import ec.mil.issffa.demo.proveedores.models.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.mil.issffa.demo.productos.models.Producto;
import ec.mil.issffa.demo.productos.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    public Optional<Producto> getById(long idProdcuto){
        return productoRepository.findById(idProdcuto);
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto actualizar(long idProducto, ProductoDto productoActualizado){
        Producto producto = productoRepository.getById(idProducto);
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setPrecio(productoActualizado.getPrecio());
        Proveedor proveedor = new Proveedor();
        proveedor.setId(productoActualizado.getProveedor());
        producto.setProveedor(proveedor);
        return productoRepository.save(producto);
    }

    public void eliminar(Producto producto){
        productoRepository.delete(producto);
    }

}
