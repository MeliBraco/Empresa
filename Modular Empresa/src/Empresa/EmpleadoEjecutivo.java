package Empresa;

import Excepciónes.*;

public class EmpleadoEjecutivo extends Empleado{

	@SuppressWarnings("unused")
	private double bono;
	private boolean bonoValido = true;


	public EmpleadoEjecutivo(String nombre, String dni,String cuil)throws cuilInvalido {
		super(nombre, dni,cuil);
	}

	public void setBono(double bono)throws BonoInvalido {
		this.bono=bono;
		
		if(bonoValido == true){
			super.setSueldoBasico(this.getSueldoBasico()+bono);
			bonoValido = false;
		}else{
			throw new BonoInvalido ("EL BONO YA FUE OTORGADO");
		}
	}

	public double getSueldoBasico() {
		return super.getSueldoBasico();
	}

	public String toString() {
		return super.toString();
	}
		
}
