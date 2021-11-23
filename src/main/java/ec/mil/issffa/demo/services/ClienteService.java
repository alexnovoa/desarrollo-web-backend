package ec.mil.issffa.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.mil.issffa.demo.models.Cliente;
import ec.mil.issffa.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> getById(long idCliente){
        return clienteRepository.findById(idCliente);
    }

    public Cliente guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Cliente cliente, Cliente clienteActualizado){
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setTelefono(clienteActualizado.getTelefono());
        cliente.setCedula(clienteActualizado.getCedula());
        return clienteRepository.save(cliente);
    }

    public void eliminar (Cliente cliente){
        clienteRepository.delete(cliente);
    }

}
