package ec.mil.issffa.demo.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ec.mil.issffa.demo.mappers.ClienteMapper;
import ec.mil.issffa.demo.models.Cliente;

@Component
public class ClienteDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente getById(long id){
        String query = "SELECT id, nombre FROM Cliente where id="+id;
        Cliente cliente =  jdbcTemplate.queryForObject(query, new ClienteMapper());
        return cliente;
    }

}
