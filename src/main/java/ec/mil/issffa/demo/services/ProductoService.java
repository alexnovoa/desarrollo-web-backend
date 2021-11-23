package ec.mil.issffa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.mil.issffa.demo.models.Producto;
import ec.mil.issffa.demo.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto actualizar(Producto producto, Producto productoActualizado){
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setProveedor(productoActualizado.getProveedor());
        return productoRepository.save(producto);
    }

    public void eliminar(Producto producto){
        productoRepository.delete(producto);
    }
    
}
