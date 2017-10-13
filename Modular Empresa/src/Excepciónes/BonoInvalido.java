package Excepciónes;

@SuppressWarnings("serial")
public class BonoInvalido extends Exception{

	public BonoInvalido (String mensaje){
		super(mensaje);
	}
}
