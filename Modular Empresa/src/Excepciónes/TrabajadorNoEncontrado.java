package Excepciónes;

@SuppressWarnings("serial")
public class TrabajadorNoEncontrado extends Exception{
	
	public TrabajadorNoEncontrado(String mensaje){
		super(mensaje);
	}
}
