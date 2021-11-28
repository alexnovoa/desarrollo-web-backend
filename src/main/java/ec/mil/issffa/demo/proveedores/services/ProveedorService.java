package ec.mil.issffa.demo.proveedores.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.mil.issffa.demo.proveedores.models.Proveedor;
import ec.mil.issffa.demo.proveedores.repositories.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getAll(){
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> getById(long idProveedor){
        return proveedorRepository.findById(idProveedor);
    }

    public Proveedor guardar(Proveedor proveedor){
            return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizar(long idProveedor, Proveedor proveedoNuevo){
        Proveedor proveedor = proveedorRepository.getById(idProveedor);
        proveedor.setNombre(proveedoNuevo.getNombre());
        proveedor.setRuc(proveedoNuevo.getRuc());
        proveedor.setTelefono(proveedoNuevo.getTelefono());
        return proveedorRepository.save(proveedor);
    }

    public void eliminar(Proveedor proveedor){
        proveedorRepository.delete(proveedor);
    }

}
