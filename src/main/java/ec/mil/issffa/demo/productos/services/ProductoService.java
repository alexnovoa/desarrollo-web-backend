package ec.mil.issffa.demo.productos.services;

import ec.mil.issffa.demo.productos.dtos.ProductoDto;
import ec.mil.issffa.demo.productos.mappers.ProductoMapper;
import ec.mil.issffa.demo.proveedores.models.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import ec.mil.issffa.demo.productos.models.Producto;
import ec.mil.issffa.demo.productos.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductoDto> getAll(){
        List<Producto> productos =  productoRepository.findAll();
        List<ProductoDto> productoDtos =
                productos.stream().map (tmp->{
                    return productoMapper.convetToDto(tmp);
                }).collect(Collectors.toList());
        return productoDtos;
    }

    public Optional<Producto> getById(long idProdcuto){
        return productoRepository.findById(idProdcuto);
    }

    public Producto guardar(ProductoDto productoDto){
       /* Producto producto = new Producto();
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        Proveedor proveedor = new Proveedor();
        producto.setId(productoDto.getProveedor());
        producto.setProveedor(proveedor);
        */

        Producto producto = productoMapper.convetToEntity(productoDto);

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
