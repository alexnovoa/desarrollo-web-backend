package ec.mil.issffa.demo.dtos;

import lombok.Data;

@Data
public class DetallePedidoDto {
   
    private long producto;
    private int cantidad;
    private double precio;
}
