package Empresa;

import Excepciónes.cuilInvalido;

public abstract class Empleado extends Trabajador{

	
	public Empleado(String nombre, String dni,String cuil)throws cuilInvalido{
		super(nombre, dni, cuil);	
	}
}
