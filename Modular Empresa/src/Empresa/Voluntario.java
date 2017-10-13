package Empresa;

import Excepciónes.cuilInvalido;

public class Voluntario extends Trabajador{

	public Voluntario(String nombre, String dni,String cuil)throws cuilInvalido{
		super(nombre, dni,cuil);
	}
	
	public double getSueldoBasico(){
		return 0.0;
	}
}
