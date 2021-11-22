package ec.mil.issffa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.mil.issffa.demo.models.Proveedor;
import ec.mil.issffa.demo.repositories.ProveedorRepository;

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor guardar(Proveedor proveedor){
            return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizar(Proveedor proveedor, Proveedor proveedoNuevo){
        proveedor.setNombre(proveedoNuevo.getNombre());
        proveedor.setRuc(proveedoNuevo.getRuc());
        proveedor.setTelefono(proveedoNuevo.getTelefono());
        return proveedorRepository.save(proveedor);
    }

    public void eliminar(Proveedor proveedor){
        proveedorRepository.delete(proveedor);
    }

}
