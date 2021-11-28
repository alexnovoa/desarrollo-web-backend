package ec.mil.issffa.demo.clientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.mil.issffa.demo.clientes.models.Cliente;
import ec.mil.issffa.demo.clientes.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }


    public Optional<Cliente> getById(long idCliente){
        return clienteRepository.findById(idCliente);
    }


    public Cliente guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(long idCliente, Cliente clienteActualizado){
        Cliente clienteExistente = clienteRepository.getById(idCliente);
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setCedula(clienteActualizado.getCedula());
        return clienteRepository.save(clienteExistente);
    }

    public void eliminar (Cliente cliente){
        clienteRepository.delete(cliente);
    }

}
