package ec.mil.issffa.demo;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);	

		/** 
		Factura facturaVentas = new Factura();
		facturaVentas.setTotal(20);
		facturaVentas.setFecha(new Date());
		System.out.println(facturaVentas);	
		System.out.println(facturaVentas.calcularImpuesto());

		String condicion;

		if(facturaVentas.calcularImpuesto()>20){
			condicion = "calculado impuesto";
		}
		else{
			condicion = "no calculado";	
		}
		System.out.println(condicion);

		for (int i=0;i<10; i++){
			System.out.println("Paso "+i);
		}
		*/

	}

}

