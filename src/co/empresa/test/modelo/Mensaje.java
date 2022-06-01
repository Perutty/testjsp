package co.empresa.test.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String email;
	private String asunto;
	private String mensaje;
	
	
}
